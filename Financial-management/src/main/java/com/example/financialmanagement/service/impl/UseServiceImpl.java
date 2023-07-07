package com.example.financialmanagement.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.financialmanagement.common.utils.DateUtil;
import com.example.financialmanagement.entity.Invoice;
import com.example.financialmanagement.entity.Use;
import com.example.financialmanagement.mapper.UseMapper;
import com.example.financialmanagement.service.UseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发票 服务实现类
 * </p>
 *
 * @author yangfuchao
 * @since 2023-06-28
 */
@Service
public class UseServiceImpl extends ServiceImpl<UseMapper, Use> implements UseService {
  @Autowired
  private UseMapper useMapper;

  @Override
  public int addUseInvoice(Use use) {
    int res=useMapper.insert(use);
    return res;
  }

  @Override
  public int changeUseByid(Use use) {
    int res=useMapper.updateById(use);
    return res;
  }

  @Override
  public PageInfo select(Map<String,Object> map) throws ParseException {
    PageHelper.startPage(Integer.valueOf(String.valueOf(map.get("pageNum"))),
        Integer.valueOf(String.valueOf(map.get("pageSize"))));

    QueryWrapper<Use> queryWrapper = new QueryWrapper<>();
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    ZonedDateTime startTime = ZonedDateTime.parse((String) map.get("startTime"), inputFormatter);
    ZonedDateTime endTime = ZonedDateTime.parse((String) map.get("endTime"), inputFormatter);
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String startDate = outputFormatter.format(startTime);
    String endDate = outputFormatter.format(endTime);

    String invoiceNumber=String.valueOf(map.get("invoiceNumber"));
    String useName=String.valueOf(map.get("username"));

    queryWrapper.like(ObjectUtils.isNotEmpty(invoiceNumber), "number", invoiceNumber);
    queryWrapper.like(ObjectUtils.isNotEmpty(useName), "name", useName);
    queryWrapper.between("date",startDate, endDate);
    List<Use> res= useMapper.selectList(queryWrapper);
//    System.out.println(res);
    PageInfo pageInfo = new PageInfo(res);
    return pageInfo;
  }

  @Override
  public Long getNewNumber() {
    QueryWrapper<Use> queryWrapper = new QueryWrapper<>();
    queryWrapper.orderByDesc("date").last("limit 1");
    return this.getOne(queryWrapper).getNumber();
  }

}
