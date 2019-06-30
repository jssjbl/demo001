package com.example.demo.entityVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo {
    private Long id;

    private String name;

    private Integer age;

    private String createTime;
}
