package com.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.amazon.properties.AWSConfig;
import com.springboot.amazon.properties.S3Config;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smani on 2/12/17.
 */
@RestController
@RequestMapping(value="/AWSConfig", produces = MediaType.APPLICATION_JSON_VALUE)
public class AWSConfigController {

    @Autowired
    private S3Config s3Config;

    @Autowired
    private AWSConfig awsConfig;

    @ApiOperation(value = "/", nickname = "AWS Config")
    @RequestMapping(method = RequestMethod.GET, path="/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getAmazonConfig() {
        return awsConfig.toString();
    }


}
