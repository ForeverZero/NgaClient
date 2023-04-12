package org.zhd.ngaclient;

import org.zhd.ngaclient.dto.Forum;
import org.zhd.ngaclient.dto.HomeCategoryV2Response;
import org.zhd.ngaclient.dto.NgaPageResponse;
import org.zhd.ngaclient.dto.SubjectListResponse;
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
     * @return
     * @throws IOException
     * @throws NgaException
     */
    NgaPageResponse<List<Forum>> forumFavor2Get() throws IOException, NgaException;
}
