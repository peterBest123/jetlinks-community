package com.troila.datacoll;

import org.jetlinks.core.config.ConfigKey;

/**
 * @see ConfigKey
 */
public interface ConfigMetadataConstants {

    //字符串相关配置
    ConfigKey<Long> maxLength = ConfigKey.of("maxLength", "字符串最大长度", Long.TYPE);
    ConfigKey<Boolean> isRichText = ConfigKey.of("isRichText", "是否为富文本", Boolean.TYPE);
    ConfigKey<Boolean> isScript = ConfigKey.of("isScript", "是否为脚本", Boolean.TYPE);

    ConfigKey<Boolean> allowInput = ConfigKey.of("allowInput", "允许输入", Boolean.TYPE);
    ConfigKey<Boolean> required = ConfigKey.of("required", "是否必填", Boolean.TYPE);


}