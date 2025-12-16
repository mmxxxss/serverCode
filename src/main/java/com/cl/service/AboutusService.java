package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.AboutusEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AboutusView;


/**
 * 发展历程
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:13
 */
public interface AboutusService extends IService<AboutusEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AboutusView> selectListView(QueryWrapper<AboutusEntity> wrapper);
   	
   	AboutusView selectView(@Param("ew") QueryWrapper<AboutusEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<AboutusEntity> wrapper);
   	

}

