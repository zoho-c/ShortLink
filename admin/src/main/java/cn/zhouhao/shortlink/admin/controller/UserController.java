package cn.zhouhao.shortlink.admin.controller;

import cn.zhouhao.shortlink.admin.common.convention.result.Result;
import cn.zhouhao.shortlink.admin.common.convention.result.Results;
import cn.zhouhao.shortlink.admin.common.enums.UserErrorCodeEnum;
import cn.zhouhao.shortlink.admin.dto.resp.UserRespDTO;
import cn.zhouhao.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hiroshi
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUserName(username));
    }
}
