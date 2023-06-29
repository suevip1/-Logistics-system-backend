package com.example.financialmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.financialmanagement.entity.Invoice;
import com.example.financialmanagement.entity.Use;
import com.github.pagehelper.PageInfo;
import java.text.ParseException;
import java.util.Map;

/**
 * <p>
 * 发票 服务类
 * </p>
 *
 * @author yangfuchao
 * @since 2023-06-28
 */
public interface UseService extends IService<Use> {
  //领用
  int addInvoice(Use use);
  //退回 、.发票作废、丢失
  int changeUseByid(Use use);

  //查询
  PageInfo select(Map<String,Object> map) throws ParseException;;
}
