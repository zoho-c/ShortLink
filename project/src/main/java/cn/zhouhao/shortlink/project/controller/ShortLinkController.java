package cn.zhouhao.shortlink.project.controller;

import cn.zhouhao.shortlink.project.common.convention.result.Result;
import cn.zhouhao.shortlink.project.common.convention.result.Results;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import cn.zhouhao.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hiroshi
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLinkByLock(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }


}