package com.herman.demo.refresh;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 刷新Bean的实现
 * @author SHI YANG
 */
@Component
public class BeanRefresher implements ApplicationContextAware {
    private Set<String> beans = new HashSet<>();
    private ApplicationContext applicationContext;

    public void rebind() {
        for (String name : beans) {
            rebind(name);
        }
    }

    private void rebind(String name) {
        Object bean = applicationContext.getBean(name);
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        beanFactory.destroySingletons();
        beanFactory.initializeBean(bean, name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Refresh.class);
        beans.addAll(beansWithAnnotation.keySet());
    }
}
