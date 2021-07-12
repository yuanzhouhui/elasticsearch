package com.peach.elasticsearch.entity.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
@ApiModel(value = "搜索药品缓存")
@Document(indexName = "medicine")
public class MedicineCache {

    @Id
    @ApiModelProperty(value = "主键")
    private String keyID;

    @Field(type = FieldType.Keyword, analyzer = "ik_max_word")
    @ApiModelProperty(value = "药品名", example = "三七血伤宁胶囊")
    private String medicineName;

    @Field(type = FieldType.Keyword, analyzer = "ik_max_word")
    @ApiModelProperty(value = "显示名", example = "三七血伤宁胶囊")
    private String displayName;

    @Field(type = FieldType.Keyword, analyzer = "ik_max_word")
    @ApiModelProperty(value = "适应症", example = "感冒、咳嗽")
    private String treatment;
    @ApiModelProperty(value = "规格", example = "0.4g*30粒")
    private String productSpec;
    @ApiModelProperty(value = "药品单位", example = "粒")
    private String productUnit;
    @ApiModelProperty(value = "是否处方药", example = "1")
    private Byte otcType;
    @ApiModelProperty(value = "是否医保药", example = "1")
    private Byte isInsurance;
    @ApiModelProperty(value = "主治疾病", example = "高血压")
    private String sickness;
    @ApiModelProperty(value = "品牌")
    private String productBrand;
    @ApiModelProperty(value = "商品ID")
    private String goodsID;

    @Field(type = FieldType.Double)
    @ApiModelProperty(value = "价格", example = "4922.01")
    private String price;
    @ApiModelProperty(value = "划线价格")
    private BigDecimal linePrice;
    @ApiModelProperty(value = "图片地址", example = "http://")
    private String imgUrl;
    @ApiModelProperty(value = "生产厂家")
    private String productFactory;
    @ApiModelProperty(value = "三方商品ID")
    private String thirdGoodsID;
}
