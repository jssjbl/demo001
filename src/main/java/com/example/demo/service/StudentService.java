package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entityVo.StudentVo;

import java.util.List;

public interface StudentService {
//     List<Student> findAllStudent();
     Student insert(Student student);
     Student findById(Long id);
     List<StudentVo> getAll();
}
