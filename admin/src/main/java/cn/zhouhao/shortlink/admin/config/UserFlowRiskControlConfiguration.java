package cn.zhouhao.shortlink.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "short-link.flow-limit")
public class UserFlowRiskControlConfiguration {
    /**
     * 是否开启用户流量风控验证
     */
    private Boolean enable;

    /**
     * 流量风控时间窗口，单位：秒
     */
    private String timeWindow;

    /**
     * 流量风控时间窗口内可访问次数
     */
    private Long maxAccessCount;
}
