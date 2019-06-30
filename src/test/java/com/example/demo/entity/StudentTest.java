package com.example.demo.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot的单元测试
 * springboottest标注这是一个springboot单元测试
 * 可以在测试期间类似编码一样的自动注入
 * runwith表示这个单元测试用springboot的单元测试驱动来跑，而不是Junit
 */
@SpringBootTest
@RunWith(SpringRunner.class)

public class StudentTest {
    @Autowired
    private Student student;
    @Autowired
    Dept dept;
    @Test
    public void showStudentInfo(){
        System.out.println(student);
    }
    @Test
    public void showDeptTest(){
        System.out.println(dept);
    }
}
