package org.zhd.ngaclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubGroup {
    private Integer id;
    private String name;
    private String info;
    private List<Forum> forums;
}
