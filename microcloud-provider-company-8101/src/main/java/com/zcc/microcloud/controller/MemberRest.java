package com.zcc.microcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zcc.microcloud.Company;
import com.zcc.microcloud.service.IDeptService;
import com.zcc.microcloud.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class MemberRest {
    @HystrixCommand //如果需要性能监控，必须要有此注解turbine
    @RequestMapping(value = "/company/get/{title}",method = RequestMethod.GET)
    public Object get(@PathVariable(value = "title") String title){
        Company vo=new Company(title,"xxx");
        return vo;
    }
}
