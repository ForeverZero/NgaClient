package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class NgaPageResponse<T> extends BaseNgaResponse {
    private T result;
    private Integer totalPage;
    private Integer total;
    private Integer currentPage;
    private Integer perPage;
    @JSONField(name = "forumname")
    private String forumName;
}
