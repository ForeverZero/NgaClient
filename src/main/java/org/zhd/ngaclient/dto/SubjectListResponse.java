package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectListResponse {
    private String attachPrefix;
    private List<SubForum> subForum;
    @JSONField(name = "topic_key")
    private String topicKey;
    private String sessionPrivilege;
    private List<SubjectInfo> data;
    private ForumHeader header;
}
