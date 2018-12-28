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
public class CompetitionProduction implements Serializable{

 /**
 *竞赛作品唯一标识
 **/
    private Long productionId;
 /**
 *作品名字
 **/
    private String productionName;
 /**
 *作品最终得分
 **/
    private Integer productionSorce;
 /**
 *作品所属队伍
 **/
    private String playerInfo;


    public Long getProductionId(){
        return productionId;
    }
    public void setProductionId(Long productionId){
        this.productionId = productionId;
    }

    public String getProductionName(){
        return productionName;
    }
    public void setProductionName(String productionName){
        this.productionName = productionName;
    }

    public Integer getProductionSorce(){
        return productionSorce;
    }
    public void setProductionSorce(Integer productionSorce){
        this.productionSorce = productionSorce;
    }

    public String getPlayerInfo(){
        return playerInfo;
    }
    public void setPlayerInfo(String playerInfo){
        this.playerInfo = playerInfo;
    }
}
