package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MessagesEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MessagesView;


/**
 * 留言板
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface MessagesService extends IService<MessagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MessagesView> selectListView(QueryWrapper<MessagesEntity> wrapper);
   	
   	MessagesView selectView(@Param("ew") QueryWrapper<MessagesEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<MessagesEntity> wrapper);
   	

}

