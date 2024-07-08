package cn.zhouhao.shortlink.admin.controller;

import cn.zhouhao.shortlink.admin.common.convention.result.Result;
import cn.zhouhao.shortlink.admin.common.convention.result.Results;
import cn.zhouhao.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import cn.zhouhao.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import cn.zhouhao.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import cn.zhouhao.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import cn.zhouhao.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hiroshi
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    /**
     * 新增短链接分组
     */
    @PostMapping("/api/short-link/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    @GetMapping("/api/short-link/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    @PutMapping("/api/short-link/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();
    }
    @DeleteMapping("/api/short-link/v1/group")
    public Result<Void> updateGroup(@RequestParam String gid) {
        groupService.deleteGroup(gid);
        return Results.success();
    }

    @PostMapping("/api/short-link/v1/group/sort")
    public Result<Void> sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam){
        groupService.sortGroup(requestParam);
        return Results.success();
    }


}
