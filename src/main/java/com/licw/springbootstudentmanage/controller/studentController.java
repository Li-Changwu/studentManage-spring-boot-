package com.licw.springbootstudentmanage.controller;

import com.licw.springbootstudentmanage.Exception.KeyConflictException;
import com.licw.springbootstudentmanage.beans.Student;
import com.licw.springbootstudentmanage.mapper.StudentMapper;
import com.licw.springbootstudentmanage.service.StudentService;
import com.licw.springbootstudentmanage.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class studentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/search")
    public ResultBean searchStudent(String stdNumber, String name){

        List<Student> students = null;
        if(!name.isEmpty() && !stdNumber.isEmpty()){
            students = studentService.findByIdAndName(stdNumber, name);
            return ResultBean.success(students);
        }
        else if(!name.isEmpty()){
            students = studentService.findByName(name);
            return ResultBean.success(students);
        }
        else if (!stdNumber.isEmpty()){
            students = studentService.findById(stdNumber);
            return ResultBean.success(students);
        }
        else {
            return ResultBean.error(-5,"未填写查询信息");
        }

    }

    @PostMapping("/add")
    public ResultBean addStudent(String name, String gender, String age, String stdNumber, String major) throws KeyConflictException {
        Student student = new Student(name, gender, age, stdNumber, major);

        //判断该学生是否存在
        if(studentService.findById(stdNumber).isEmpty()){
            //学号不存在
            studentService.insertStudent(student);
            return ResultBean.success();
        }else{
            //学号已经存在
            throw new KeyConflictException();
        }

    }

    @GetMapping("/delete")
    public ResultBean deleteById(String stdNumber){

        int result = studentService.deleteById(stdNumber);
        if(result == 0){
            return ResultBean.error(-1,"该用户不存在");
        }else if (result == 1){
            return ResultBean.success();
        }else {
            return ResultBean.error(-99,"删除失败，未知错误");
        }
    }

    @PostMapping("/modify")
    public ResultBean modifyStudent(String name, String gender, String age, String stdNumber, String major){
        Student student = new Student(name, gender, age, stdNumber, major);

        //判断该学生是否存在
        if(studentService.findById(stdNumber).isEmpty()){
            return ResultBean.error(-1,"该学生不存在");
        }else{
            if (studentService.updateStudent(student) == 1){
                return ResultBean.success();
            }else{
                return ResultBean.error(-99,"更新失败,未知错误");
            }
        }
    }
}
