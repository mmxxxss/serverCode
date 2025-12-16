package com.cl.dao;

import com.cl.entity.FangdongEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangdongView;


/**
 * 房东
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangdongDao extends BaseMapper<FangdongEntity> {
	
	List<FangdongView> selectListView(@Param("ew") QueryWrapper<FangdongEntity> wrapper);

	List<FangdongView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FangdongEntity> wrapper);
	
	FangdongView selectView(@Param("ew") QueryWrapper<FangdongEntity> wrapper);


}
