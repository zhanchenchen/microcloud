package com.zcc.microcloud;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String loc;
}
