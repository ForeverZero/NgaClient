package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class HomeCategoryV2Response extends BaseNgaResponse{
    @JSONField(name = "forum_icon_pre")
    private String forumIconPre;
    @JSONField(name = "forum_recommend_lastmodify")
    private Long forumRecommendLastModify;
    @JSONField(name = "forum_recommend")
    private RootGroup forumRecommend;
    private List<RootGroup> result;
    @JSONField(name = "forum_icon_list")
    private ForumIconList forumIconList;
}
