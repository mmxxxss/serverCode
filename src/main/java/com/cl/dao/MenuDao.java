package com.cl.dao;

import com.cl.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MenuView;


/**
 * 菜单
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:13
 */
public interface MenuDao extends BaseMapper<MenuEntity> {
	
	List<MenuView> selectListView(@Param("ew") QueryWrapper<MenuEntity> wrapper);

	List<MenuView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<MenuEntity> wrapper);
	
	MenuView selectView(@Param("ew") QueryWrapper<MenuEntity> wrapper);


}
