package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entityVo.StudentVo;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    private StudentService service;
//    @GetMapping("student/allStudents")
//    public List<Student> allStudents(){

        //多线程测试一下缓存穿透问题
//        ExecutorService executorService = Executors.newFixedThreadPool(25);
//        for(int i=0;i<10000;i++){
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    service.findAllStudent();
//                }
//            });
//        }
//        List<Student> allStudent = service.findAllStudent();
//        return  service.findAllStudent();
//    }
    @GetMapping("student/findById")
    public Student findById(Long id){
        Student byId = service.findById((long) 1);
        return byId;


    }
    @GetMapping("student/allStudents")
    public List<StudentVo> getAlla(){
        List<StudentVo> all = service.getAll();
        return all;
    }
    @PostMapping("student/AddStudent")
    public  Student addStudent(@RequestBody Student student){
        Student insert = service.insert(student);
        return insert;
    }

}
