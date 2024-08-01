package cn.zhouhao.shortlink.project.controller;

import cn.zhouhao.shortlink.project.common.convention.result.Result;
import cn.zhouhao.shortlink.project.common.convention.result.Results;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import cn.zhouhao.shortlink.project.service.ShortLinkService;
import cn.zhouhao.shortlink.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hiroshi
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {
    private final ShortLinkStatsService shortLinkStatsService;

    @GetMapping("/api/short-link/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }
}
