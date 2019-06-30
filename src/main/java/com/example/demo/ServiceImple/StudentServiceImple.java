package com.example.demo.ServiceImple;

import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.entityVo.StudentVo;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class StudentServiceImple implements StudentService {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private StudentMapper studentMapper;
    Logger logger = LoggerFactory.getLogger(StudentServiceImple.class);
    @Override
  /*  public List<Student> findAllStudent() {
        //字符创的序列化器,将key序列化，值不需序列化
        RedisSerializer redisSerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        //查询缓存
        List<Student> list= (List<Student>) redisTemplate.opsForValue().get("allStudents");
        //双重检测
        if(null==list){
            synchronized (this){
                //再查训一次
                list= (List<Student>) redisTemplate.opsForValue().get("allStudents");
                if(null==list){
                    System.out.println("查询的是mysql数据库");
                    //缓存为空，查询数据库
                    List<Student> students = studentMapper.allStudent();
                    //把查询出来的数据放进redis
                    redisTemplate.opsForValue().set("allStudents",students);
                }else{
                    System.out.println("查询的是缓存");
                }

            }

        }else{
            System.out.println("查询的是缓存");
        }
        return list;
    }
*/
//    public List<Student> findAllStudent() {
//        //字符创的序列化器,将key序列化，值不需序列化
//        RedisSerializer redisSerializer=new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        //查询缓存
//        List<Student> list= (List<Student>) redisTemplate.opsForValue().get("allStudents");
//        if(null==list){
//                    System.out.println("查询的是mysql数据库");
//                    //缓存为空，查询数据库
//                    List<Student> students = studentMapper.allStudent();
//                    //把查询出来的数据放进redis
//                    redisTemplate.opsForValue().set("allStudents",students);
//        }else{
//            System.out.println("查询的是缓存");
//        }
//        logger.info("就是想打印一下");
//        return list;
//    }

//    不使用redis
//    public List<Student> findAllStudent() {
//        return  studentMapper.allStudents();
//    }

//    @Override
    public Student insert(Student student) {
        int insert = studentMapper.insert(student);
        Student student1 = studentMapper.selectByPrimaryKey(student.getId());
        return student1;
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentVo> getAll() {

        List<Student> all = studentMapper.getAll();
        List<StudentVo> list=new ArrayList<>();
        if(!CollectionUtils.isEmpty(all)){
            for (int i = 0; i < all.size(); i++) {
                StudentVo studentVo=new StudentVo();
                BeanUtils.copyProperties(all.get(i),studentVo);
                String res;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(all.get(i).getCreateTime().toString());
                res = simpleDateFormat.format(date);
                studentVo.setCreateTime(res);
                list.add(studentVo);
            }
        }
        return list;
    }


}
