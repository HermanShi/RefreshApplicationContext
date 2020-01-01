package com.herman.demo.watcher;

import com.herman.demo.refresh.BeanRefresher;
import com.herman.demo.util.PropertyLoader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;


/**
 * @author SHI YANG
 */
@Component
@Slf4j
public class FileWatcher extends FileAlterationListenerAdaptor {

    @Autowired
    private BeanRefresher beanRefresher;

    /**
     * 文件修改
     **/
    @Override
    public void onFileChange(File file) {
        Date start = new Date();
        log.info("监听到文件修改事件，开始刷新applicationContext start time：{}", start);
        PropertyLoader.builder.getReloadingController().checkForReloading(null);
        beanRefresher.rebind();
        log.info("刷新applicationContext结束 用时{}ms", System.currentTimeMillis() - start.getTime());
    }
}