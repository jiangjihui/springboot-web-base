package com.jjh.common.util;

import jodd.util.StringTemplateParser;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * ParseUtils
 *
 * @author jiangjihui
 * @date 2023/02/23
 **/
public class ParseUtils {

    public static String parse(String template, Map valueMap) {
        if (StringUtils.isBlank(template)) {
            return null;
        }
        return StringTemplateParser.ofMap(valueMap).apply(template);
    }

}
