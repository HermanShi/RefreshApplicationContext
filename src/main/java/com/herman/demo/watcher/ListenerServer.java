package com.herman.demo.watcher;
 
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.concurrent.TimeUnit;


/**
 * @author SHI YANG
 */
@Component
public class ListenerServer {

    @Autowired
    private FileWatcher fileWatcher;

    /**
     * @author selfimpr626
     */
    @PostConstruct
    public void executeListener(){
        IOFileFilter directories = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.and(
                FileFilterUtils.fileFileFilter(),
                FileFilterUtils.suffixFileFilter(".properties"));
        IOFileFilter filter = FileFilterUtils.or(directories, files);

        String monitorDir = "src\\main\\resources";
        FileAlterationObserver observer = new FileAlterationObserver(new File(monitorDir), filter);
        observer.addListener(fileWatcher);
        try {
            // 创建文件变化监听器开启监听
            FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor( TimeUnit.SECONDS.toMillis(5), observer);
            fileAlterationMonitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}