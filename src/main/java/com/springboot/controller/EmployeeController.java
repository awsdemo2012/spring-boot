package com.springboot.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.Employee;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 
@RestController
@RequestMapping(value="/Employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
 
    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();
 
    @ApiOperation(value = "/", nickname = "getEmployee")
    @RequestMapping(method = RequestMethod.GET, path="/", produces = "application/json")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Saravanaraj")
      })
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    public Employee getEmployee(@RequestParam(value="name", defaultValue="Saravanaraj") String name) {
        return new Employee(counter.incrementAndGet(),
                String.format(template, name), "Mani");
    }

    @RequestMapping(method = RequestMethod.GET, path="/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEmployeeName(){
        return "STRIG";
    }
}