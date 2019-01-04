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
public class Judge implements Serializable{

    private Long judgeId;//作品评定表
    private Long judgeUser;//评定人员
    private Long judgeProduct;//评定作品
    private String judgeResult;//评定结果


    public Long getJudgeId(){
        return judgeId;
    }
    public void setJudgeId(Long judgeId){
        this.judgeId = judgeId;
    }

    public Long getJudgeUser(){
        return judgeUser;
    }
    public void setJudgeUser(Long judgeUser){
        this.judgeUser = judgeUser;
    }

    public Long getJudgeProduct(){
        return judgeProduct;
    }
    public void setJudgeProduct(Long judgeProduct){
        this.judgeProduct = judgeProduct;
    }

    public String getJudgeResult(){
        return judgeResult;
    }
    public void setJudgeResult(String judgeResult){
        this.judgeResult = judgeResult;
    }
}
