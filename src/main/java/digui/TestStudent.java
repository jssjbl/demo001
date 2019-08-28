package digui;

import com.example.demo.entity.Student;

public class TestStudent {
    public static void main(String[] args) {
        Student student=new Student();
        student.setAge(28);
        Student student1;
        student1=student;
        student.setAge(29);
        Student student2=new Student();
        student2.setAge(30);
        student=student2;
        System.out.println(student.toString()+"--------------------"+student1.toString());
    }
}
