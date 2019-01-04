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
public class Product implements Serializable{

    private Long productId;//作品ID
    private String productName;//作品名称
    private Long productTeam;//作品所属队伍
    private Long productMaterial;//作品相关材料


    public Long getProductId(){
        return productId;
    }
    public void setProductId(Long productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }

    public Long getProductTeam(){
        return productTeam;
    }
    public void setProductTeam(Long productTeam){
        this.productTeam = productTeam;
    }

    public Long getProductMaterial(){
        return productMaterial;
    }
    public void setProductMaterial(Long productMaterial){
        this.productMaterial = productMaterial;
    }
}
