package com.cl.dao;

import com.cl.entity.FangwuzulinEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuzulinView;


/**
 * 房屋租赁
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangwuzulinDao extends BaseMapper<FangwuzulinEntity> {
	
	List<FangwuzulinView> selectListView(@Param("ew") QueryWrapper<FangwuzulinEntity> wrapper);

	List<FangwuzulinView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FangwuzulinEntity> wrapper);
	
	FangwuzulinView selectView(@Param("ew") QueryWrapper<FangwuzulinEntity> wrapper);


}
