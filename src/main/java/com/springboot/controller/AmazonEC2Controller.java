package com.springboot.controller;

import com.amazonaws.util.EC2MetadataUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ec2")
public class AmazonEC2Controller {

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> getPublicIp() {
        Map<String, String> result = new HashMap<String, String>();

        // resolve (first/primary) private ip
        result.put("publicIP" ,EC2MetadataUtils.getNetworkInterfaces().get(0).getPublicIPv4s().get(0));
        result.put("privatIP" ,EC2MetadataUtils.getInstanceInfo().getPrivateIp());
        result.put("AZ"       ,EC2MetadataUtils.getInstanceInfo().getAvailabilityZone());
        return result;
    }
}


