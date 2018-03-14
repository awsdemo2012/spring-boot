package com.springboot.amazon.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.springboot.amazon.properties.S3Config;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class AmazonS3Template {

    private String defaultBucket;


    /**
     * Create a new instance of the {@link AmazonS3Template} with the bucket name and access credentials
     *
     //* @param defaultBucket   is the name of a default bucket from the Amazon S3 provider
     //* @param accessKeyId     is the access key id credential for the specified bucket name
     //* @param accessKeySecret is the access key secret for the specified bucket name
     */
    public AmazonS3Template(S3Config s3Config) {
        this.defaultBucket = s3Config.getDefaultBucket();
    }

    /**
     * Save a file using authenticated session credentials
     *
     * @param key  is the name of the file to save in the bucket
     * @param file is the file that will be saved
     * @return an instance of {@link PutObjectResult} containing the result of the save operation
     */
    public PutObjectResult save(String key, File file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setSSEAlgorithm(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);

        PutObjectRequest putObjectRequest = new PutObjectRequest(defaultBucket, key, file);
        putObjectRequest.setMetadata(objectMetadata);

        return getAmazonS3Client().putObject(putObjectRequest);
    }

    /**
     * Get a file using the authenticated session credentials
     *
     * @param key is the key of the file in the bucket that should be retrieved
     * @return an instance of {@link S3Object} containing the file from S3
     */
    public S3Object get(String key) {
        return getAmazonS3Client().getObject(defaultBucket, key);
    }

    /**
     * Gets an Amazon S3 client from basic session credentials
     *
     * @return an authenticated Amazon S3 client
     */
    public AmazonS3 getAmazonS3Client() {
        return AmazonS3ClientBuilder.defaultClient();
    }
}
