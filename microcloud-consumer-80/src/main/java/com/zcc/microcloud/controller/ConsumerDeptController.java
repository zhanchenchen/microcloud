package com.zcc.microcloud.controller;

import com.zcc.microcloud.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.List;

@RestController
@Slf4j
public class ConsumerDeptController {
    public static final String DEPT_GET_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/get/";
    public static final String DEPT_LIST_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/list";
    public static final String DEPT_ADD_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/add";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders headers;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Object getDept(@PathVariable long id) {
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-DEPT");
        System.err.println("[ServiceInstance]host:"+serviceInstance.getHost()+"、port:"+serviceInstance.getPort()+"、serviceId:"+serviceInstance.getServiceId()+"、instanceId:"+serviceInstance.getInstanceId()+"、url:"+serviceInstance.getUri());
        URI uri=URI.create(String.format("http://%s/dept/get/"+id,serviceInstance.getServiceId()));
        Dept dept = this.restTemplate.exchange(uri, HttpMethod.GET
                , new HttpEntity<Object>(this.headers), Dept.class).getBody();
        return dept;
    }

    @GetMapping(value = "/consumer/dept/list")
    public Object listDept() {
//        List<Dept> depts=this.restTemplate.getForObject(DEPT_LIST_URL,List.class);
        List<Dept> depts = this.restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET
                , new HttpEntity<Object>(this.headers), List.class).getBody();
        return depts;
    }

    @GetMapping(value = "/consumer/dept/add")
    public Object addDept(Dept dept) {
//        Boolean flag = this.restTemplate.postForObject(DEPT_ADD_URL, dept, Boolean.class);
        Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST
                , new HttpEntity<Object>(this.headers), Boolean.class).getBody();
        return flag;

    }
}
