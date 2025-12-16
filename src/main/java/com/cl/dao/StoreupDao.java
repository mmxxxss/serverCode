package com.cl.dao;

import com.cl.entity.StoreupEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.StoreupView;


/**
 * 我的收藏
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface StoreupDao extends BaseMapper<StoreupEntity> {
	
	List<StoreupView> selectListView(@Param("ew") QueryWrapper<StoreupEntity> wrapper);

	List<StoreupView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<StoreupEntity> wrapper);
	
	StoreupView selectView(@Param("ew") QueryWrapper<StoreupEntity> wrapper);


}
