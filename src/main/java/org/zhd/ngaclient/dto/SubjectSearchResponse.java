package org.zhd.ngaclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectSearchResponse {
    private List<SubjectInfo> data;
    private String msg;
    private List<List<String>> table;
}
