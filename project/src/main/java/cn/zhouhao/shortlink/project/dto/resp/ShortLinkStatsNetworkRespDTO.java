package cn.zhouhao.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsNetworkRespDTO {
    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 访问网络
     */
    private String network;

    /**
     * 占比
     */
    private Double ratio;
}
