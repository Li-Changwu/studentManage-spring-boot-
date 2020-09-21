package com.licw.springbootstudentmanage.service;

import com.licw.springbootstudentmanage.beans.Student;
import com.licw.springbootstudentmanage.mapper.StudentMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    public List<Student> findById(String studentNo){
        return studentMapper.findById(studentNo);
    }

    public List<Student> findByName(String name) {
        return studentMapper.findByName(name);
    }


    public List<Student> findByIdAndName(String studentNo,String name) {
        return studentMapper.findByIdAndName(studentNo,name);
    }


    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }


    public int deleteById(String studentNo) {
        return studentMapper.deleteById(studentNo);
    }

    public int updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }
}
