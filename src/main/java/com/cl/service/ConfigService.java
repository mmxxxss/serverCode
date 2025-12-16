package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ConfigEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ConfigView;


/**
 * 轮播图
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:13
 */
public interface ConfigService extends IService<ConfigEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ConfigView> selectListView(QueryWrapper<ConfigEntity> wrapper);
   	
   	ConfigView selectView(@Param("ew") QueryWrapper<ConfigEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ConfigEntity> wrapper);
   	

}

