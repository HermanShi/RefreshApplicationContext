package com.herman.demo.config;

import com.herman.demo.refresh.Refresh;
import lombok.Data;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Component注入bean形式的配置类
 * @author SHI YANG
 */
@Component
@Data
@Refresh
public class OneBeanConfiguration {
    private MyConfiguration configuration;
    private String beanName;

    @Autowired
    public OneBeanConfiguration(MyConfiguration configuration) throws ConfigurationException {
        this.configuration = configuration;
        this.beanName = configuration.getName();
    }
}
