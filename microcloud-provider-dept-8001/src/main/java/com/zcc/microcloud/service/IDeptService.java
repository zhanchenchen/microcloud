package com.zcc.microcloud.service;

import com.zcc.microcloud.Dept;

import java.util.List;

public interface IDeptService {
    public Dept get(Long id);
    public boolean add(Dept vo);
    public List<Dept> list();
}
