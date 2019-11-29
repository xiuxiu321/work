package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Emp {
    private Integer id;
    private String src;
    private String name;
    private double salary;
    private Integer age;
    private Integer departmentId;
    private Department department;
}
