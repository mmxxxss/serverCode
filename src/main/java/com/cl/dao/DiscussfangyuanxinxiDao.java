package com.cl.dao;

import com.cl.entity.DiscussfangyuanxinxiEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanxinxiView;


/**
 * 房源信息评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface DiscussfangyuanxinxiDao extends BaseMapper<DiscussfangyuanxinxiEntity> {
	
	List<DiscussfangyuanxinxiView> selectListView(@Param("ew") QueryWrapper<DiscussfangyuanxinxiEntity> wrapper);

	List<DiscussfangyuanxinxiView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<DiscussfangyuanxinxiEntity> wrapper);
	
	DiscussfangyuanxinxiView selectView(@Param("ew") QueryWrapper<DiscussfangyuanxinxiEntity> wrapper);


}
