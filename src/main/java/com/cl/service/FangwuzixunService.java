package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangwuzixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuzixunView;


/**
 * 房屋资讯
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangwuzixunService extends IService<FangwuzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuzixunView> selectListView(QueryWrapper<FangwuzixunEntity> wrapper);
   	
   	FangwuzixunView selectView(@Param("ew") QueryWrapper<FangwuzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FangwuzixunEntity> wrapper);
   	

}

