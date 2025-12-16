package com.cl.dao;

import com.cl.entity.ZulinhetongEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZulinhetongView;


/**
 * 租赁合同
 * 
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface ZulinhetongDao extends BaseMapper<ZulinhetongEntity> {
	
	List<ZulinhetongView> selectListView(@Param("ew") QueryWrapper<ZulinhetongEntity> wrapper);

	List<ZulinhetongView> selectListView(@Param("page")Page page,@Param("ew") QueryWrapper<ZulinhetongEntity> wrapper);
	
	ZulinhetongView selectView(@Param("ew") QueryWrapper<ZulinhetongEntity> wrapper);


}
