package com.example.distributionmanagementcenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 中心库房货物
 * </p>
 *
 * @author Jason
 * @since 2023-06-27
 */
@TableName("stock_central_station")
@Data
public class CentralStation implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("good_class_id")
    private Integer goodClassId;

    @TableField("good_subclass_id")
    private Integer goodSubclassId;

    @TableField("good_name")
    private String goodName;

    private Long stock;

    private Long withdrawal;

    private Long waitAllo;

    private Long doneAllo;

    private Long warn;

    private Long max;

    @TableField("good_price")
    private Double goodPrice;

    @TableField("good_sale")
    private Double goodSale;

    @TableField("good_cost")
    private Double goodCost;


    private String goodUnit;


    private Integer supplyId;


    @TableField("sell_date")
    private Integer sellDate;

    private Byte isReturn;

    private Byte isChange;

    private String remark;


}
