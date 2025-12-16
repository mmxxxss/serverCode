package com.cl.dao;

import com.cl.entity.FangwuzixunEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuzixunView;


/**
 * 房屋资讯
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangwuzixunDao extends BaseMapper<FangwuzixunEntity> {
	
	List<FangwuzixunView> selectListView(@Param("ew") QueryWrapper<FangwuzixunEntity> wrapper);

	List<FangwuzixunView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FangwuzixunEntity> wrapper);
	
	FangwuzixunView selectView(@Param("ew") QueryWrapper<FangwuzixunEntity> wrapper);


}
