package com.jjh.framework.aspect.sensitive;

public interface DataMaskingOperation {
    String MASK_CHAR = "*";

    String mask(String content, String maskChar);

}
