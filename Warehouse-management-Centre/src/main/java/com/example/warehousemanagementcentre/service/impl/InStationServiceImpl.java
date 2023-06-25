package com.example.warehousemanagementcentre.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.warehousemanagementcentre.entity.InStation;
import com.example.warehousemanagementcentre.mapper.InStationMapper;
import com.example.warehousemanagementcentre.service.InStationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 库房出库 服务实现类
 * </p>
 *
 * @author hzn
 * @since 2023-06-21
 */
@Service
public class InStationServiceImpl extends ServiceImpl<InStationMapper, InStation> implements InStationService {


    @Autowired
    private InStationMapper inStationMapper;

    @Override
    public PageInfo getInStation(Map<String, Object> map) {
        PageHelper.startPage(Integer.valueOf((String)map.get("pageNum")),
                Integer.valueOf((String)map.get("pageSize")));
        QueryWrapper<InStation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","9");
        List<InStation> res= inStationMapper.selectList(queryWrapper);
        PageInfo pageInfo = new PageInfo(res);
        return pageInfo;
    }
}