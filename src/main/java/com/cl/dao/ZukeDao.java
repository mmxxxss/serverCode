package com.cl.dao;

import com.cl.entity.ZukeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZukeView;


/**
 * 租客
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface ZukeDao extends BaseMapper<ZukeEntity> {
	
	List<ZukeView> selectListView(@Param("ew") QueryWrapper<ZukeEntity> wrapper);

	List<ZukeView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ZukeEntity> wrapper);
	
	ZukeView selectView(@Param("ew") QueryWrapper<ZukeEntity> wrapper);


}
