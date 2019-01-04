package com.hw.competition.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.math.*;
import java.io.Serializable;
import lombok.Data;
/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/
@Data
public class Competition implements Serializable{

    private Long competitionId;//竞赛id
    private String competitionName;//竞赛名称
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp enrollDatetimeBegin;//竞赛截止开始报名（发布、新增）时间
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp enrollDatetimeEnd;//竞赛截止报名时间
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp productDatetimeEnd;//作品提交截止时间
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp judgeDatetimeEnd;//作品评定截止时间
    private Long userId;//竞赛管理员


    public Long getCompetitionId(){
        return competitionId;
    }
    public void setCompetitionId(Long competitionId){
        this.competitionId = competitionId;
    }

    public String getCompetitionName(){
        return competitionName;
    }
    public void setCompetitionName(String competitionName){
        this.competitionName = competitionName;
    }

    public Timestamp getEnrollDatetimeBegin(){
        return enrollDatetimeBegin;
    }
    public void setEnrollDatetimeBegin(Timestamp enrollDatetimeBegin){
        this.enrollDatetimeBegin = enrollDatetimeBegin;
    }

    public Timestamp getEnrollDatetimeEnd(){
        return enrollDatetimeEnd;
    }
    public void setEnrollDatetimeEnd(Timestamp enrollDatetimeEnd){
        this.enrollDatetimeEnd = enrollDatetimeEnd;
    }

    public Timestamp getProductDatetimeEnd(){
        return productDatetimeEnd;
    }
    public void setProductDatetimeEnd(Timestamp productDatetimeEnd){
        this.productDatetimeEnd = productDatetimeEnd;
    }

    public Timestamp getJudgeDatetimeEnd(){
        return judgeDatetimeEnd;
    }
    public void setJudgeDatetimeEnd(Timestamp judgeDatetimeEnd){
        this.judgeDatetimeEnd = judgeDatetimeEnd;
    }

    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
}
