package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SystemintroEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SystemintroView;


/**
 * 网站介绍
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface SystemintroService extends IService<SystemintroEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SystemintroView> selectListView(QueryWrapper<SystemintroEntity> wrapper);
   	
   	SystemintroView selectView(@Param("ew") QueryWrapper<SystemintroEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<SystemintroEntity> wrapper);
   	

}

