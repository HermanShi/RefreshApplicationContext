package com.herman.demo.config;

import com.herman.demo.util.PropertyLoader;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.context.annotation.Configuration;

/**
 * 直接调用ConfigurationLoader形式的配置类
 * @author SHI YANG
 */
@Configuration
public class MyConfiguration {

    public String getName() throws ConfigurationException {
        return PropertyLoader.getString("my.name");
    }
}
