package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PostListResponse extends NgaPageResponse<List<ThreadReply>> {
    @JSONField(name = "tsubject")
    private String tSubject;
    @JSONField(name = "tmisc_bit1")
    private Integer tMiscBit1;
    @JSONField(name = "hot_post")
    private List<ThreadReply> hotPost;
    private String attachPrefix;
    @JSONField(name = "tauthorid")
    private Integer tAuthorId;
    @JSONField(name = "tauthor")
    private String tAuthor;
    @JSONField(name = "forum_bit")
    private Integer forumBit;
    @JSONField(name = "is_forum_admin")
    private Boolean isForumAdmin;
    @JSONField(name = "vrows")
    private Integer vRows;
}
