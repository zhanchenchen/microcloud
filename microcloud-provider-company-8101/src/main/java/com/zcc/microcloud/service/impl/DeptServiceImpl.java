package com.zcc.microcloud.service.impl;

import com.zcc.microcloud.dao.IDeptDAO;
import com.zcc.microcloud.service.IDeptService;
import com.zcc.microcloud.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DeptServiceImpl implements IDeptService {
    @Resource
    private IDeptDAO iDeptDAO;
    @Override
    public Dept get(Long id) {
        return this.iDeptDAO.findById(id);
    }

    @Override
    public boolean add(Dept vo) {
        return this.iDeptDAO.doCreate(vo);
    }

    @Override
    public List<Dept> list() {
        return this.iDeptDAO.findAll();
    }
}
