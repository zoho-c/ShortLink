package cn.zhouhao.shortlink.project.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
@Builder
public class ShortLinkBatchCreateRespDTO {
    /**
     * 成功数量
     */
    private Integer total;

    /**
     * 批量创建返回参数
     */
    private List<ShortLinkBaseInfoRespDTO> baseLinkInfos;
}
