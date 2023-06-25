package com.example.dispatchcentre.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 任务单
 * </p>
 *
 * @author yangfuchao
 * @since 2023-06-25
 */
@Data
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private Long orderId;

    /**
     * 用户名
     */
    private Long customerId;

    /**
     * 用户名
     */
    private String customerName;

    /**
     * 用户名
     */
    private Date taskDate;

    /**
     * 用户名
     */
    private Date deadline;

    /**
     * 用户名
     */
    private String taskType;

    /**
     * 用户名
     */
    private String taskStatus;

    /**
     * 用户名
     */
    private String address;

    /**
     * 用户名
     */
    private String postman;

    /**
     * 用户名
     */
    private String substation;

    /**
     * 用户名
     */
    private Integer printNumber;

    /**
     * 用户名
     */
    private String creater;
    /**
     * 用户名
     */
    private Date end_date;
}