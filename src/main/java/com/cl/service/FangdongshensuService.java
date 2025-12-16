package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangdongshensuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangdongshensuView;


/**
 * 房东申诉
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangdongshensuService extends IService<FangdongshensuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangdongshensuView> selectListView(QueryWrapper<FangdongshensuEntity> wrapper);
   	
   	FangdongshensuView selectView(@Param("ew") QueryWrapper<FangdongshensuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FangdongshensuEntity> wrapper);
   	

}

