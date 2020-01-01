package com.herman.demo.config;

import com.herman.demo.refresh.Refresh;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 方法注入Bean形式的配置类
 *
 * @author shi yang
 * @since 2020-01-01
 */
@Configuration
public class AnotherBeanConfiguration {

    @Autowired
    private MyConfiguration configuration;

    @Bean
    @Refresh
    public AnotherBeanDefine otherBeanDefine() throws ConfigurationException {
        return new AnotherBeanDefine(configuration.getName());
    }
}
