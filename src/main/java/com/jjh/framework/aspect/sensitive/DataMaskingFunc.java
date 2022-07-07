package com.jjh.framework.aspect.sensitive;

import org.springframework.util.StringUtils;

/**
 * 脱敏转换器
 */
public enum DataMaskingFunc {

    NO_MARK((str, maskChar) ->{
        return str;
    }),
    ALL_MARK((str, maskChar) -> {
        if (StringUtils.hasLength(str)) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                builder.append(StringUtils.hasLength(maskChar) ? maskChar : DataMaskingOperation.MASK_CHAR);
            }
            return builder.toString();
        }
        else {
            return str;
        }
    });

    private final DataMaskingOperation operation;

    DataMaskingFunc(DataMaskingOperation o) {
        this.operation = o;
    }

    public DataMaskingOperation operation() {
        return this.operation;
    }
}
