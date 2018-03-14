package com.springboot.amazon.properties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration property group for Amazon S3 and AWS
 *
 * @author kbastani
 */
@Configuration
@ConfigurationProperties(prefix = "amazon.s3")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class S3Config {

    @JsonProperty("defaultBucket")
    private String defaultBucket;

    public String getDefaultBucket() {
        return defaultBucket;
    }

    public void setDefaultBucket(String defaultBucket) {
        this.defaultBucket = defaultBucket;
    }

    @Override public String toString() {
        return "S3Properties{" + "defaultBucket='" + defaultBucket + '\'' + '}';
    }
}
