package com.cl.dao;

import com.cl.entity.FangdongshensuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangdongshensuView;


/**
 * 房东申诉
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangdongshensuDao extends BaseMapper<FangdongshensuEntity> {
	
	List<FangdongshensuView> selectListView(@Param("ew") QueryWrapper<FangdongshensuEntity> wrapper);

	List<FangdongshensuView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FangdongshensuEntity> wrapper);
	
	FangdongshensuView selectView(@Param("ew") QueryWrapper<FangdongshensuEntity> wrapper);


}
