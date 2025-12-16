package com.cl.dao;

import com.cl.entity.AboutusEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.AboutusView;


/**
 * 发展历程
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:13
 */
public interface AboutusDao extends BaseMapper<AboutusEntity> {
	
	List<AboutusView> selectListView(@Param("ew") QueryWrapper<AboutusEntity> wrapper);

	List<AboutusView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<AboutusEntity> wrapper);
	
	AboutusView selectView(@Param("ew") QueryWrapper<AboutusEntity> wrapper);


}
