package com.cl.dao;

import com.cl.entity.FangyuanxinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanxinxiView;


/**
 * 房源信息
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangyuanxinxiDao extends BaseMapper<FangyuanxinxiEntity> {
	
	List<FangyuanxinxiView> selectListView(@Param("ew") QueryWrapper<FangyuanxinxiEntity> wrapper);

	List<FangyuanxinxiView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<FangyuanxinxiEntity> wrapper);
	
	FangyuanxinxiView selectView(@Param("ew") QueryWrapper<FangyuanxinxiEntity> wrapper);


}
