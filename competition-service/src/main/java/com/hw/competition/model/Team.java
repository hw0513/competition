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
public class Team implements Serializable{

    private Long teamId;//team_id
    private String teamName;//队伍名称
    private Long studentId;//队伍成员
    private Long competitionId;//竞赛Id


    public Long getTeamId(){
        return teamId;
    }
    public void setTeamId(Long teamId){
        this.teamId = teamId;
    }

    public String getTeamName(){
        return teamName;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public Long getStudentId(){
        return studentId;
    }
    public void setStudentId(Long studentId){
        this.studentId = studentId;
    }

    public Long getCompetitionId(){
        return competitionId;
    }
    public void setCompetitionId(Long competitionId){
        this.competitionId = competitionId;
    }
}
