package cn.zhouhao.shortlink.admin.dto.req;

import lombok.Data;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
public class UserLoginReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
