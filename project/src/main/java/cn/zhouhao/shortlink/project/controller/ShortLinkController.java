package cn.zhouhao.shortlink.project.controller;

import cn.zhouhao.shortlink.project.common.convention.result.Result;
import cn.zhouhao.shortlink.project.common.convention.result.Results;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkPageReqDTO;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import cn.zhouhao.shortlink.project.service.ShortLinkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hiroshi
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return Results.success(shortLinkService.createShortLink(requestParam));
    }

    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }


    @GetMapping("/api/short-link/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam) {
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }

}
