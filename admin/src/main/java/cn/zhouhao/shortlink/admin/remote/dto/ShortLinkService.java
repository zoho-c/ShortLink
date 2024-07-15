package cn.zhouhao.shortlink.admin.remote.dto;

import cn.hutool.Hutool;
import cn.hutool.http.HttpUtil;
import cn.zhouhao.shortlink.admin.common.convention.result.Result;
import cn.zhouhao.shortlink.admin.common.convention.result.Results;
import cn.zhouhao.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import cn.zhouhao.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import cn.zhouhao.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import cn.zhouhao.shortlink.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import cn.zhouhao.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author hiroshi
 * @version 1.0
 */

public interface ShortLinkService {
    /**
     * 创建短链接
     *
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建响应
     */
    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam) {
        String resultBodyStr = HttpUtil.post("127.0.0.1:8001/api/short-link/v1/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }

    default Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        HashMap<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("gid", requestParam.getGid());
        requestBody.put("current", requestParam.getCurrent());
        requestBody.put("size", requestParam.getSize());
        String resultBodyStr = HttpUtil.get("127.0.0.1:8001/api/short-link/v1/page", requestBody);
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }

    default Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam) {
        HashMap<String, Object> requestMap = new HashMap<>();
        requestMap.put("requestParam", requestParam);
        String resultBodyStr = HttpUtil.get("127.0.0.1:8001/api/short-link/v1/count", requestMap);

        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }
}
