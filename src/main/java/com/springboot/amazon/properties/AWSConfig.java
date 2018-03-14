package com.springboot.amazon.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by smani on 2/26/17.
 */
@Configuration
@ConfigurationProperties(prefix = "amazon.aws")
public class AWSConfig {

    private String accessKeyId;

    private String accessKeySecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    @Override
    public String toString() {
        return "AWSConfig{" + "accessKeyId='" + accessKeyId + '\'' + ", accessKeySecret='" + accessKeySecret + '\''
                        + '}';
    }
}
