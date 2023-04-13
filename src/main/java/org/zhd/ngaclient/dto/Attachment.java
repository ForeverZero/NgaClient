package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    @JSONField(name = "url_utf8_org_name")
    private String urlUtf8OrgName;
    private String ext;
    @JSONField(name = "subid")
    private String subId;
    private Long size;
    private String dscp;
    private String thumb;
    private String type;
    private String path;
    @JSONField(name = "attachurl")
    private String attachUrl;
    private String name;
}
