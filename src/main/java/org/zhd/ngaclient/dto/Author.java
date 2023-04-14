package org.zhd.ngaclient.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @JSONField(name = "regdate")
    private Long regDate;
    @JSONField(name = "bit_data")
    private Long bitData;
    private Integer money;
    private String site;
    private String nickname;
    @JSONField(name = "mute_time")
    private Long muteTime;
    @JSONField(name = "postnum")
    private Integer postNum;
    @JSONField(name = "memberid")
    private Integer memberId;
    @JSONField(name = "groupid")
    private Integer groupId;
    private String member;
    private List<Object> medal;
    private String reputation;
    private String signature;
    private List<Objects> buffs;
    private Short gender;
    private Integer uid;
    private Integer yz;
    private String avatar;
    @JSONField(name = "thisvisit")
    private Long thisVisit;
    private Long credit;
    @JSONField(name = "mute_status")
    private Integer muteStatus;
    private Object honor;
    private String username;
}
