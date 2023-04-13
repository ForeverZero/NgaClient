package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreadReply {
    private Object address; // TODO
    private Author author;
    @JSONField(name = "is_user_quote")
    private Boolean userQuote;
    private Integer tid;
    private Integer follow;
    @JSONField(name = "postdatetimestamp")
    private Long postDateTimestamp;
    private Integer fid;
    @JSONField(name = "attachs")
    private List<Attachment> attaches;
    private String subject;
    private Long type;
    @JSONField(name = "vote_bad")
    private Integer voteBad;
    @JSONField(name = "from_client")
    private String fromClient;
    @JSONField(name = "postdate")
    private String postDate;
    private String vote;
    private Integer lou;
    private Integer pid;
    @JSONField(name = "vote_good")
    private Integer voteGood;
    @JSONField(name = "isTieTiao")
    private Boolean tieTiao;
    private List<ThreadReply> comments;
    @JSONField(name = "comment_to_id")
    private Integer commentToId;
    private String content;
    @JSONField(name = "alterinfo")
    private String alterInfo;
}
