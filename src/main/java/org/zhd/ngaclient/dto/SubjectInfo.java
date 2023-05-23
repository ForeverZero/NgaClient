package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectInfo {
    private Integer tid;
    private Integer fid;
    private String author;
    @JSONField(name = "authorid")
    private Integer authorId;
    private String subject;
    @JSONField(name = "postdate")
    private Long postDate;
    @JSONField(name = "lastpost")
    private Long lastPost;
    @JSONField(name = "lastposter")
    private String lastPoster;
    private Integer replies;
    private String error;
    private Long type;
    @JSONField(name = "forumname")
    private String forumName;
    @JSONField(name = "attachs")
    private List<Attachment> attaches;
    @JSONField(name = "is_set")
    private Boolean setFlag = false;
    @JSONField(name = "is_set_elm")
    private Boolean setElmFlag = false;
    @JSONField(name = "set_elm_parent")
    private Integer setElmParent;
}
