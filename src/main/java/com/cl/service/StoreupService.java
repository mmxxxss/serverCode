package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.StoreupEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.StoreupView;


/**
 * 我的收藏
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface StoreupService extends IService<StoreupEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<StoreupView> selectListView(QueryWrapper<StoreupEntity> wrapper);
   	
   	StoreupView selectView(@Param("ew") QueryWrapper<StoreupEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<StoreupEntity> wrapper);
   	

}

