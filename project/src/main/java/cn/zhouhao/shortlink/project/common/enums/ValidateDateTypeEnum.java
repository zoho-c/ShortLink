package cn.zhouhao.shortlink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author hiroshi
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum ValidateDateTypeEnum {
    /**
     * 永久有效期
     */
    PERMANENT(0),
    /**
     * 自定义有效期
     */
    CUSTOM(1);

    private final int type;
}
