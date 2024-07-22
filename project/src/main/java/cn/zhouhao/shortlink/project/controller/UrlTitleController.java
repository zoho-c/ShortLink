package cn.zhouhao.shortlink.project.controller;

import cn.zhouhao.shortlink.project.common.convention.result.Result;
import cn.zhouhao.shortlink.project.common.convention.result.Results;
import cn.zhouhao.shortlink.project.service.UrlTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hiroshi
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {
    private final UrlTitleService urlTitleService;

    @GetMapping("/api/short-link/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return Results.success(urlTitleService.getTitleByUrl(url));
    }
}
