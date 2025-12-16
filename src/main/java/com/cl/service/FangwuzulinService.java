package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangwuzulinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuzulinView;


/**
 * 房屋租赁
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangwuzulinService extends IService<FangwuzulinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuzulinView> selectListView(QueryWrapper<FangwuzulinEntity> wrapper);
   	
   	FangwuzulinView selectView(@Param("ew") QueryWrapper<FangwuzulinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FangwuzulinEntity> wrapper);
   	

}

