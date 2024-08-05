package cn.zhouhao.shortlink.admin.remote.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author hiroshi
 * @version 1.0
 */
@Data
public class ShortLinkUpdateReqDTO {
    private String originUrl;

    private String fullShortUrl;

    private String originGid;

    private String gid;

    /**
     * 有效期类型: 0标识永久有效，1标识自定义有效期
     */
    private Integer validDateType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    private String describe;

}
