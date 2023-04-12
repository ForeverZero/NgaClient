package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forum {
    private Integer fid;
    private String name;
    private String info;
    private Integer id;
    @JSONField(name = "is_forumlist")
    private Boolean isForumList;
    private String icon;
}
