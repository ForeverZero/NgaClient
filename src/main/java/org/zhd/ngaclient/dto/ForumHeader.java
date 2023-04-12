package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumHeader {
    private String title;
    @JSONField(name = "opentype")
    private Integer openType;
    @JSONField(name = "opendata")
    private String openData;
}
