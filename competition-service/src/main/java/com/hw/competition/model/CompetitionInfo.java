package com.hw.competition.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.*;
import java.io.Serializable;
import lombok.Data;
/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/
@Data
public class CompetitionInfo implements Serializable{

 /**
 *竞赛唯信息一标识
 **/
    private Long competitionInfoId;
 /**
 *竞赛名称
 **/
    private String competitionName;
 /**
 *竞赛发布者
 **/
    private Long competitionUser;
 /**
 *竞赛的审核状态
 **/
    private String status;
 /**
 *竞赛性质
 **/
    private String nature;
 /**
 *最大的参赛人数
 **/
    private Integer maxnum;
 /**
 *竞赛类型
 **/
    private Long competitionType;


    public Long getCompetitionInfoId(){
        return competitionInfoId;
    }
    public void setCompetitionInfoId(Long competitionInfoId){
        this.competitionInfoId = competitionInfoId;
    }

    public String getCompetitionName(){
        return competitionName;
    }
    public void setCompetitionName(String competitionName){
        this.competitionName = competitionName;
    }

    public Long getCompetitionUser(){
        return competitionUser;
    }
    public void setCompetitionUser(Long competitionUser){
        this.competitionUser = competitionUser;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getNature(){
        return nature;
    }
    public void setNature(String nature){
        this.nature = nature;
    }

    public Integer getMaxnum(){
        return maxnum;
    }
    public void setMaxnum(Integer maxnum){
        this.maxnum = maxnum;
    }

    public Long getCompetitionType(){
        return competitionType;
    }
    public void setCompetitionType(Long competitionType){
        this.competitionType = competitionType;
    }
}
