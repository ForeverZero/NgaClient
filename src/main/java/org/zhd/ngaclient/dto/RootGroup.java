package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootGroup {
    private Integer id;
    @JSONField(name = "_id")
    private String id2;
    private String name;
    private List<SubGroup> groups;
}
