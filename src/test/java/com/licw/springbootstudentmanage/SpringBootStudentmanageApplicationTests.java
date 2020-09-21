package com.licw.springbootstudentmanage;

import com.licw.springbootstudentmanage.beans.Student;
import com.licw.springbootstudentmanage.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStudentmanageApplicationTests {
    private final static Logger log = LoggerFactory.getLogger(SpringBootStudentmanageApplicationTests.class);
    @Test
    void contextLoads() {
        log.trace("trace");
        log.debug("trace");
        log.info("info");
        log.warn("warn");
        log.error("error");
        //System.out.println(studentMapper.insertStudent(new Student("1","2","3", "4", "5")));
    }

}
