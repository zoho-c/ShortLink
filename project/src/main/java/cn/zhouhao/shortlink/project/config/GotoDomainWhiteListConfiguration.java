package cn.zhouhao.shortlink.project.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "short-link.goto-domain.white-list")
public class GotoDomainWhiteListConfiguration {
    /**
     * whether enable goto domain white list
     */
    private Boolean enable;

    /**
     * the set of the names of the domains to be allowed
     */
    private String names;

    /**
     * the set of the details of the domains to be allowed
     */
    private List<String> details;
}
