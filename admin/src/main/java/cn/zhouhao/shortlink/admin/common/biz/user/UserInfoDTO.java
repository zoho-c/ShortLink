package cn.zhouhao.shortlink.admin.common.biz.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO {
    // TODO: change json id
    private String userId;
    private String username;
    private String realName;
}
