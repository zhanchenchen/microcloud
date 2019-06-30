package com.zcc.microcloud.controller;

import com.zcc.microcloud.Dept;
import com.zcc.service.IDeptClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsumerDeptController {

    @Autowired
    private IDeptClientService deptClientService;   //注入feign客户端

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Object getDept(@PathVariable(name = "id") long id) {
        return deptClientService.get(id);
    }

    @GetMapping(value = "/consumer/dept/list")
    public Object listDept() {
        return deptClientService.list();
    }

    @GetMapping(value = "/consumer/dept/add")
    public Object addDept(Dept dept) {
        return deptClientService.add(dept);

    }
}
