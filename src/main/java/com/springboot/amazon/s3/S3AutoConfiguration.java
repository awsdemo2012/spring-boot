package com.springboot.amazon.s3;

import com.springboot.amazon.properties.AWSConfig;
import com.springboot.amazon.properties.S3Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnMissingBean(AmazonS3Template.class)
@EnableConfigurationProperties(S3Config.class)
public class S3AutoConfiguration {

    @Autowired
    private S3Config s3Config;

    @Bean
    public AmazonS3Template amazonS3Template() {
        return new AmazonS3Template(s3Config);
    }


}
