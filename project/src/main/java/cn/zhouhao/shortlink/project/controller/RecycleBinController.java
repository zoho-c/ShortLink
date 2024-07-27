//package cn.zhouhao.shortlink.project.controller;
//
//import cn.zhouhao.shortlink.project.common.convention.result.Result;
//import cn.zhouhao.shortlink.project.common.convention.result.Results;
//import cn.zhouhao.shortlink.project.dto.req.RecycleBinSaveReqDTO;
//import cn.zhouhao.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
//import cn.zhouhao.shortlink.project.dto.resp.ShortLinkPageRespDTO;
//import cn.zhouhao.shortlink.project.service.RecycleBinService;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 回收站管理控制层
// *
// * @author hiroshi
// * @version 1.0
// */
//@RestController
//@RequiredArgsConstructor
//public class RecycleBinController {
//    private final RecycleBinService recycleBinService;
//
//    @PostMapping("/api/short-link/v1/recycle-bin/save")
//    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
//        recycleBinService.saveRecycleBin(requestParam);
//        return Results.success();
//    }
//
//    /**
//     * 分页查询回收站短链接
//     */
//    @GetMapping("/api/short-link/v1/recycle-bin/page")
//    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
//        return Results.success(recycleBinService.pageShortLink(requestParam));
//    }
//}
