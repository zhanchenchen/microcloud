package com.zcc.microcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class DeptRest {
    @Autowired
    private IDeptService deptService;

    @HystrixCommand(fallbackMethod = "getFallBack")//如果当前出错将会调用getFallBack方法
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Object get(@PathVariable(value = "id") long id){
        Dept dept = this.deptService.get(id);
        if(dept==null){
            throw new RuntimeException("数据不存在！");
        }
        return dept;
    }

    public Object getFallBack(@PathVariable(value = "id") long id){//参数与get一致
        Dept vo=new Dept();
        vo.setDeptno(9999L);
        vo.setDname("[Error]Hystrix-provider-"+id);
        vo.setLoc("dept-provider");
        return vo;
    }


}
