package com.licw.springbootstudentmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.licw.springbootstudentmanage.mapper")
@SpringBootApplication
public class SpringBootStudentmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudentmanageApplication.class, args);
    }

}
