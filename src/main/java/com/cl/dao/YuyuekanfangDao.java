package com.cl.dao;

import com.cl.entity.YuyuekanfangEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuekanfangView;


/**
 * 预约看房
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface YuyuekanfangDao extends BaseMapper<YuyuekanfangEntity> {
	
	List<YuyuekanfangView> selectListView(@Param("ew") QueryWrapper<YuyuekanfangEntity> wrapper);

	List<YuyuekanfangView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<YuyuekanfangEntity> wrapper);
	
	YuyuekanfangView selectView(@Param("ew") QueryWrapper<YuyuekanfangEntity> wrapper);


}
