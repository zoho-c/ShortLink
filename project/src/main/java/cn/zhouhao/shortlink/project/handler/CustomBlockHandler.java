package cn.zhouhao.shortlink.project.handler;

import cn.zhouhao.shortlink.project.common.convention.result.Result;
import cn.zhouhao.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import cn.zhouhao.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomBlockHandler {
    public static Result<ShortLinkCreateRespDTO> createShortLinkBlockHandlerMethod(ShortLinkCreateReqDTO requestParam, BlockException exception) {
        return new Result<ShortLinkCreateRespDTO>().setCode("B100000").setMessage("当前访问网站人数过多，请稍后再试...");
    }
}
