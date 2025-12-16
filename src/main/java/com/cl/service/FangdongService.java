package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangdongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangdongView;


/**
 * 房东
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangdongService extends IService<FangdongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangdongView> selectListView(QueryWrapper<FangdongEntity> wrapper);
   	
   	FangdongView selectView(@Param("ew") QueryWrapper<FangdongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FangdongEntity> wrapper);
   	

}

