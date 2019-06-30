package com.zcc.service.fallback;

import com.zcc.microcloud.Dept;
import com.zcc.service.IDeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class IDeptClientServiceFallBackFactory implements FallbackFactory<IDeptClientService> {
    @Override
    public IDeptClientService create(Throwable throwable) {
        return new IDeptClientService() {
            @Override
            public Object get(long id) {
                Dept vo=new Dept();
                vo.setDeptno(8888L);
                vo.setDname("[Error]Feign-Hystrix"+id);
                vo.setLoc("consumer-provide");
                return vo;
            }

            @Override
            public Object add(Dept dept) {
                return null;
            }

            @Override
            public Object list() {
                return null;
            }
        };
    }
}
