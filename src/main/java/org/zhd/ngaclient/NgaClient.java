package org.zhd.ngaclient;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.zhd.ngaclient.common.NgaConst;
import org.zhd.ngaclient.common.NgaResponseCode;
import org.zhd.ngaclient.common.NgaUrl;
import org.zhd.ngaclient.dto.*;
import org.zhd.ngaclient.exception.InvalidSignException;
import org.zhd.ngaclient.exception.NgaException;
import org.zhd.ngaclient.util.SignUtil;
import org.zhd.ngaclient.util.TimeUtil;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
public class NgaClient implements INgaClient {

    private final CloseableHttpClient httpClient;
    private final String accessToken;
    private final String accessUid;
    private final String appId;
    private final String secret;

    public NgaClient(String accessToken, String accessUid, String appId, String secret, Long connectTimeout, Long readTimeout) {
        log.info("NgaClient使用参数: token: {}, uid: {}, appId: {}, secret: {}", accessToken, accessUid, appId, secret);
        this.accessToken = accessToken;
        this.accessUid = accessUid;
        this.appId = appId;
        this.secret = secret;

        httpClient = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
            .setConnectionRequestTimeout(connectTimeout, TimeUnit.SECONDS)
            .setResponseTimeout(readTimeout, TimeUnit.SECONDS)
            .build())
            .build();
    }

    public NgaClient(String accessToken, String accessUid, String appId, String secret) {
        this(accessToken, accessUid, appId, secret, 5L, 30L);
    }

    public NgaClient(String accessToken, String accessUid) {
        this(accessToken, accessUid, NgaConst.APP_ID, NgaConst.SECRET, 5L, 30L);
    }

    public NgaPageResponse<SubjectListResponse> subjectList(int forumId, int page) throws IOException, NgaException {
        var time = TimeUtil.getTimeStr();
        String sign = SignUtil.sign(appId, accessUid, accessToken, forumId + "", time, secret);
        final var url = NgaUrl.builder().api(NgaUrl.Api.APP_API).library(NgaUrl.Library.SUBJECT).action(NgaUrl.Action.LIST).build();
        HashMap<String, String> paramMap = buildBaseAccessParamMap();
        paramMap.put("t", time);
        paramMap.put("fid", forumId + "");
        paramMap.put("sign", sign);
        paramMap.put("page", page + "");
        return doPost(url, paramMap, classicHttpResponse -> {
            byte[] bytes = classicHttpResponse.getEntity().getContent().readAllBytes();
            return JSON.parseObject(new String(bytes), new TypeReference<>() {});
        });
    }

    @Override
    public HomeCategoryV2Response homeCategoryV2() throws IOException, NgaException {
        final var url = NgaUrl.builder().api(NgaUrl.Api.APP_API).library(NgaUrl.Library.HOME).action(NgaUrl.Action.CATEGORY).version("2").build();
        return doPost(url, null, classicHttpResponse -> {
            byte[] bytes = classicHttpResponse.getEntity().getContent().readAllBytes();
            return JSON.parseObject(new String(bytes), new TypeReference<>() {});
        });
    }

    @Override
    public NgaPageResponse<List<Forum>> forumFavor2Get() throws IOException, NgaException {
        final var output = "12";
        var time = TimeUtil.getTimeStr();
        String sign = SignUtil.sign(appId, accessUid, accessToken, output, time, secret);
        final var url = NgaUrl.builder().api(NgaUrl.Api.NUKE).library(NgaUrl.Library.FORUM_FAVOR_2).action(NgaUrl.Action.GET).build();
        var paramMap = buildBaseAccessParamMap();
        paramMap.put("t", time);
        paramMap.put("__output", output);
        paramMap.put("sign", sign);
        return doPost(url, paramMap, classicHttpResponse -> {
            byte[] bytes = classicHttpResponse.getEntity().getContent().readAllBytes();
            return JSON.parseObject(new String(bytes), new TypeReference<>() {});
        });
    }

    @Override
    public NgaPageResponse<SubjectSearchResponse> subjectSearch(Integer forumId, String key, int page) throws IOException, NgaException {
        key = URLEncoder.encode(key, StandardCharsets.UTF_8);
        var time = TimeUtil.getTimeStr();
        String sign = SignUtil.sign(appId, accessUid, accessToken, key, time, secret);
        final var url = NgaUrl.builder().api(NgaUrl.Api.APP_API).library(NgaUrl.Library.SUBJECT).action(NgaUrl.Action.SEARCH).build();
        var paramMap = buildBaseAccessParamMap();
        Optional.ofNullable(forumId).ifPresent(it -> paramMap.put("fid", it + ""));
        paramMap.put("key", key);
        paramMap.put("t", time);
        paramMap.put("sign", sign);
        return doPost(url, paramMap, classicHttpResponse -> {
            byte[] bytes = classicHttpResponse.getEntity().getContent().readAllBytes();
            return JSON.parseObject(new String(bytes), new TypeReference<>() {});
        });
    }

    private HashMap<String, String> buildBaseAccessParamMap() {
        var paramMap = new HashMap<String, String>();
        paramMap.put("access_token", accessToken);
        paramMap.put("access_uid", accessUid);
        paramMap.put("app_id", appId);
        return paramMap;
    }

    private <T extends BaseNgaResponse> T doPost(String url, Map<String, String> paramMap, HttpClientResponseHandler<T> handler) throws IOException, NgaException {
        log.debug("post url: {}", url);
        final var httpPost = new HttpPost(url);
        final var params = new ArrayList<NameValuePair>();
        Optional.ofNullable(paramMap).ifPresent(it -> it.forEach((k, v) -> {
            log.debug("param: {}, value: {}", k, v);
            params.add(new BasicNameValuePair(k, v));
        }));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        var ngaResponse = httpClient.execute(httpPost, handler);
        if (log.isDebugEnabled()) {
            log.debug("return: {}", JSON.toJSONString(ngaResponse));
        }
        checkResponse(ngaResponse);
        return ngaResponse;
    }

    private void checkResponse(BaseNgaResponse baseNgaResponse) throws NgaException {
        int code = baseNgaResponse.getCode();
        String msg = baseNgaResponse.getMsg();

        switch (code) {
            case NgaResponseCode.SUCCESS -> {}
            case NgaResponseCode.SIGN_ERROR -> throw new InvalidSignException(msg, code);
            default -> throw new NgaException(msg, code);
        }
    }
}
