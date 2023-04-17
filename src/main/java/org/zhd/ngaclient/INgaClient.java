package org.zhd.ngaclient;

import org.zhd.ngaclient.dto.*;
import org.zhd.ngaclient.exception.NgaException;

import java.io.IOException;
import java.util.List;

public interface INgaClient {
    /**
     * 获取指定板块的主题列表
     *
     * @param forumId 板块ID
     * @param page    页数
     * @return {@link SubjectListResponse}
     * @throws IOException  网络异常
     * @throws NgaException 返回码不为{@link org.zhd.ngaclient.common.NgaResponseCode#SUCCESS}时抛出
     */
    NgaPageResponse<SubjectListResponse> subjectList(int forumId, int page) throws IOException, NgaException;

    /**
     * 获取所有板块信息
     *
     * @return {@link HomeCategoryV2Response}
     * @throws IOException  网络异常
     * @throws NgaException 返回码不为{@link org.zhd.ngaclient.common.NgaResponseCode#SUCCESS}时抛出
     */
    HomeCategoryV2Response homeCategoryV2() throws IOException, NgaException;

    /**
     * 获取收藏的板块
     *
     * @return {@link Forum}
     * @throws IOException  网络异常
     * @throws NgaException 返回码不为{@link org.zhd.ngaclient.common.NgaResponseCode#SUCCESS}时抛出
     */
    NgaPageResponse<List<Forum>> forumFavor2Get() throws IOException, NgaException;

    /**
     * 按关键词搜索主题, 中文搜不出来, 待解决
     *
     * @param forumId 板块ID，为Null是搜索所有板块
     * @param key     关键词
     * @param page    页码
     * @return {@link SubjectInfo}
     * @throws IOException  网络异常
     * @throws NgaException 返回码不为{@link org.zhd.ngaclient.common.NgaResponseCode#SUCCESS}时抛出
     */
    NgaPageResponse<SubjectSearchResponse> subjectSearch(Integer forumId, String key, int page) throws IOException, NgaException;

    /**
     * 获取主题下的回复, 第一条为主题的内容
     *
     * @param tid 主题ID
     * @param page 页码
     * @return {@link PostListResponse}
     * @throws IOException  网络异常
     * @throws NgaException 返回码不为{@link org.zhd.ngaclient.common.NgaResponseCode#SUCCESS}时抛出
     */
    PostListResponse postList(int tid, int page) throws IOException, NgaException;
}
