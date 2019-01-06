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
public class ProductMaterial implements Serializable{

    private Long productMaterialId;//参赛材料唯一标识
    private Long productId;//材料所属产品ID
    private Long dictId;//材料字典id
    private String productFile;//材料文件
    private Long competitionId;//所属竞赛


    public Long getProductMaterialId(){
        return productMaterialId;
    }
    public void setProductMaterialId(Long productMaterialId){
        this.productMaterialId = productMaterialId;
    }

    public Long getProductId(){
        return productId;
    }
    public void setProductId(Long productId){
        this.productId = productId;
    }

    public Long getDictId(){
        return dictId;
    }
    public void setDictId(Long dictId){
        this.dictId = dictId;
    }

    public String getProductFile(){
        return productFile;
    }
    public void setProductFile(String productFile){
        this.productFile = productFile;
    }

    public Long getCompetitionId(){
        return competitionId;
    }
    public void setCompetitionId(Long competitionId){
        this.competitionId = competitionId;
    }
}
