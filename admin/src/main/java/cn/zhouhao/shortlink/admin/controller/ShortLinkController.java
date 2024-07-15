package cn.zhouhao.shortlink.admin.controller;

import cn.zhouhao.shortlink.admin.common.convention.result.Result;
import cn.zhouhao.shortlink.admin.remote.dto.ShortLinkService;
import cn.zhouhao.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import cn.zhouhao.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import cn.zhouhao.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import cn.zhouhao.shortlink.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import cn.zhouhao.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
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
    private final ShortLinkService shortLinkService = new ShortLinkService() {
    };

    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkService.createShortLink(requestParam);
    }

    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkService.pageShortLink(requestParam);
    }

}
