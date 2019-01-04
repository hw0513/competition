package com.hw.competition.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.*;
import java.io.Serializable;
import lombok.Data;
/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/
@Data
public class Student implements Serializable{

    private Long studentId;//student_id
    private String idNumber;//身份证号
    private String className;//班级
    private String schoolNumber;//学号


    public Long getStudentId(){
        return studentId;
    }
    public void setStudentId(Long studentId){
        this.studentId = studentId;
    }

    public String getIdNumber(){
        return idNumber;
    }
    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public String getClassName(){
        return className;
    }
    public void setClassName(String className){
        this.className = className;
    }

    public String getSchoolNumber(){
        return schoolNumber;
    }
    public void setSchoolNumber(String schoolNumber){
        this.schoolNumber = schoolNumber;
    }
}
