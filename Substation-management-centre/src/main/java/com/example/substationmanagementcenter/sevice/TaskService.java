package com.example.substationmanagementcenter.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.substationmanagementcenter.entity.Task;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.Map;

/**
 * <p>
 * 任务单 服务类
 * </p>
 *
 * @author hzn
 * @since 2023-06-19
 */
public interface TaskService extends IService<Task> {
    PageInfo getTaskListByCriteria(Map<String,Object> map) throws ParseException;

    int updatebyId(Task task);

    PageInfo getTaskToDistribute(Map<String,Object> map) throws ParseException;

    PageInfo getTaskToReceipt(Map<String,Object> map) throws ParseException;

}
