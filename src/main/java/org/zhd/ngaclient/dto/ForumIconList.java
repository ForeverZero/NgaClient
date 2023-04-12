package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumIconList {
    private String f;
    private String s;
    private Map<String, String> h;
    private Map<String, String> n;
    private String c;
    @JSONField(name = "f_px_l")
    private String fPxL;
    @JSONField(name = "s_px_l")
    private String sPxL;
    @JSONField(name = "c_px_l")
    private String cPxL;
    @JSONField(name = "h_px_l")
    private String hPxL;
    @JSONField(name = "f_sx_l")
    private String fSxL;
    @JSONField(name = "s_sx_l")
    private String sSxL;
    @JSONField(name = "c_sx_l")
    private String cSxL;
    @JSONField(name = "f_px_s")
    private String fPxS;
    @JSONField(name = "s_px_s")
    private String sPxS;
    @JSONField(name = "f_sx_s")
    private String fSxS;
    @JSONField(name = "s_sx_s")
    private String sSxS;
}
