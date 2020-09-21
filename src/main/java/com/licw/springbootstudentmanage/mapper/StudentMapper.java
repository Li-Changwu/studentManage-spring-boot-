package com.licw.springbootstudentmanage.mapper;

import com.licw.springbootstudentmanage.beans.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
        @Select("select * from student")
        List<Student> findAll();

        @Select("select * from student where studentNo=#{studentNo}")
        List<Student> findById(@Param("studentNo") String studentNo);

        @Select("select * from student where name=#{name}")
        List<Student> findByName(@Param("name") String name);

        @Select("select * from student where studentNo=#{studentNo} and name=#{name}")
        List<Student> findByIdAndName(@Param("studentNo") String studentNo,@Param("name") String name);

        @Insert("insert into student(name,age,sex,studentNo,major) values(#{name},#{age},#{sex},#{studentNo},#{major})")
        int insertStudent(Student student);

        @Delete("delete from student where studentNo=#{studentNo}")
        int deleteById(@Param("studentNo") String studentNo);

        @Update("update student set Name=#{name},age=#{age},sex=#{sex},major=#{major} where studentNo=#{studentNo};")
        int updateStudent(Student student);
}
