package com.springboot.config;

/**
 * Created by smani on 2/26/17.
 */

import com.springboot.amazon.properties.AWSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
public class AppRunner implements ApplicationRunner {

    @Autowired
    private AWSConfig awsConfig;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println(awsConfig.getAccessKeyId());
    }

}