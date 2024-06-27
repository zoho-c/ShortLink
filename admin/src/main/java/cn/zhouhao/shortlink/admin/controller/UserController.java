package cn.zhouhao.shortlink.admin.controller;

import cn.zhouhao.shortlink.admin.common.convention.result.Result;
import cn.zhouhao.shortlink.admin.common.convention.result.Results;
import cn.zhouhao.shortlink.admin.common.enums.UserErrorCodeEnum;
import cn.zhouhao.shortlink.admin.dto.req.UserRegisterReqDTO;
import cn.zhouhao.shortlink.admin.dto.resp.UserRespDTO;
import cn.zhouhao.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author hiroshi
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUserName(username));
    }

    @GetMapping("/api/short-link/v1/user/has-username")
    public Result<Boolean> hasUserName(@RequestParam("username") String username) {
        return Results.success(userService.hasUserName(username));
    }

    @PostMapping("/api/short-link/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {
        userService.register(userRegisterReqDTO);
        return Results.success();
    }
}
