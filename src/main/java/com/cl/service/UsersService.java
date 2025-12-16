package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.UsersEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.UsersView;


/**
 * 管理员
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:13
 */
public interface UsersService extends IService<UsersEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<UsersView> selectListView(QueryWrapper<UsersEntity> wrapper);
   	
   	UsersView selectView(@Param("ew") QueryWrapper<UsersEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<UsersEntity> wrapper);
   	

}

