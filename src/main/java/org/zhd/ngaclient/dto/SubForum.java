package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubForum {
    @JSONField(name = "0")
    private String key0;
    @JSONField(name = "1")
    private String key1;
    @JSONField(name = "2")
    private String key2;
    @JSONField(name = "3")
    private String key3;
    private Integer id;
    private String name;
    private String info;
    private Boolean checked;
    @JSONField(name = "allow_checked")
    private Boolean allowChecked;
    @JSONField(name = "sub_type")
    private Integer subType;
    private Integer tid;
}
