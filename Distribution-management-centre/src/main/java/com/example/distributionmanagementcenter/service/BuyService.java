package com.example.distributionmanagementcenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.distributionmanagementcenter.entity.Buy;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.Map;

/**
 * <p>
 * 进货单 服务类
 * </p>
 *
 * @author Jason_Cai
 * @since 2023-06-20
 */
public interface BuyService extends IService<Buy> {
   PageInfo  getListByDateSupply(Map<String, Object> map) throws ParseException;
}
