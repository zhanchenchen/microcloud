package com.zcc.microcloud.controller;

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
    private final IDeptService deptService;

    public DeptRest(IDeptService deptService) {
        this.deptService = deptService;
    }
    @Autowired
    private DiscoveryClient client;
    /*
    * dicovery content:
    * {"discoveryClients":[{"services":["provider-dept-8001"],"order":0},{"services":[],"order":0}],"services":["provider-dept-8001"],"order":0}
    * */
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        return this.client;
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Object get(@PathVariable(value = "id") long id){
        return this.deptService.get(id);
    }
    @PostMapping(value = "/dept/add")
    public Object add(@RequestBody Dept dept){
        return this.deptService.add(dept);
    }
    @GetMapping(value = "/dept/list")
    public Object list(){
        return this.deptService.list();
    }

    @GetMapping(value = "/dept/sessionId")
    public Object id(HttpServletRequest request){
//        log.debug("******ServerHttpRequest.getRemoteAddress()*******"+request1.getRemoteAddress());
//        log.debug("******ServerHttpRequest.getHeaders()*******"+request1.getHeaders());
//        log.debug("******ServerHttpRequest.getURI()*******"+request1.getURI());
//        log.debug("******ServerHttpRequest.getPrincipal()*******"+request1.getPrincipal());
//        log.debug("******ServerHttpRequest.getMethodValue()*******"+request1.getMethodValue());
//        log.debug("******ServerHttpRequest.getMethod()*******"+request1.getMethod());
//        log.debug("******ServerHttpRequest.getLocalAddress()*******"+request1.getLocalAddress());
//        log.debug("******reactive.getId()*******"+request2.getId());
//        log.debug("******reactive.getCookies()*******"+request2.getCookies());
//        log.debug("******reactive.getPath()*******"+request2.getPath());
//        log.debug("******reactive.getSslInfo()*******"+request2.getSslInfo());
//        log.debug("******reactive.getRemoteAddress()*******"+request2.getRemoteAddress());
//        log.debug("******reactive.getHeaders()*******"+request2.getHeaders());
//        log.debug("******reactive.getURI()*******"+request2.getURI());
//        log.debug("******reactive.getQueryParams()*******"+request2.getQueryParams());
        return request.getSession().getId();
    }
}
