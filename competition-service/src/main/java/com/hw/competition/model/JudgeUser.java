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
public class JudgeUser implements Serializable{

    private Long judgeUserId;//judge_user_id
    private Long userId;//用户Id
    private Long competitionId;//竞赛Id


    public Long getJudgeUserId(){
        return judgeUserId;
    }
    public void setJudgeUserId(Long judgeUserId){
        this.judgeUserId = judgeUserId;
    }

    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Long getCompetitionId(){
        return competitionId;
    }
    public void setCompetitionId(Long competitionId){
        this.competitionId = competitionId;
    }
}
