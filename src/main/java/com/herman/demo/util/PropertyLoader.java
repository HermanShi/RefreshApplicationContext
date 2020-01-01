package com.herman.demo.util;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

/**
 * 加载Properties文件的类
 *
 * @author SHI YANG
 */
public class PropertyLoader {

    public static ReloadingFileBasedConfigurationBuilder<FileBasedConfiguration> builder;

    static {
        Parameters parameters = new Parameters();
        File file = new File("src\\main\\resources\\application.properties");
        builder = new ReloadingFileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(parameters.fileBased()
                                .setFile(file));
    }

    public static String getString(String key) throws ConfigurationException {
        return (String) builder.getConfiguration().getProperty(key);
    }
}
