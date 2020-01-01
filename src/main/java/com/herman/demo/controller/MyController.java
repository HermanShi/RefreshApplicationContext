package com.herman.demo.controller;

import com.herman.demo.config.AnotherBeanDefine;
import com.herman.demo.config.MyConfiguration;
import com.herman.demo.config.OneBeanConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SHI YANG
 */
@RestController
@RequestMapping("my")
public class MyController {

    @Autowired
    private MyConfiguration configuration;

    @Autowired
    private OneBeanConfiguration beanConfiguration;

    @Autowired
    private AnotherBeanDefine anotherBean;

    @GetMapping("name")
    private String myName() throws ConfigurationException {
        return configuration.getName();
    }

    @GetMapping("beanName")
    private String beanName() {
        return beanConfiguration.getBeanName();
    }

    @GetMapping("otherName")
    private String otherName(){
        return anotherBean.getName();
    }

}
