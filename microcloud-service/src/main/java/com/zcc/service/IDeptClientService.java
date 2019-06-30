package com.zcc.service;

import com.zcc.microcloud.Dept;
import com.zcc.common.config.FeignClientConfig;
import com.zcc.service.fallback.IDeptClientServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * feign客戶端，调用microcloud-provider-dept实例中的接口方法
 * FeignClientConfig为feign客户端进行实例验证的类，此类中配置验证信息（账号和密码）
 * value:服务标识
 * configuration：feign调用的认证配置
 * fallbackFactory：失败回调工厂类（包含失败回调的方法，当服务不可用时就会调用）
 */
@FeignClient(value = "microcloud-provider-dept", configuration = FeignClientConfig.class,fallbackFactory = IDeptClientServiceFallBackFactory.class)
public interface IDeptClientService {
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable long id);

    @PostMapping(value = "/dept/add")
    public Object add(@RequestBody Dept dept);

    @GetMapping(value = "/dept/list")
    public Object list();
}
