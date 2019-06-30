package com.example.demo.dao;

import com.example.demo.entity.Student;
import com.example.demo.entityVo.StudentVo;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    List<Student> getAll();
}