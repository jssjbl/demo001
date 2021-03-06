package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Student {
    private Long id;

    private String name;

    private Integer age;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createtime) {
        this.createTime = createtime;
    }
}