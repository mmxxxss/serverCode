package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfangyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfangyuanxinxiView;


/**
 * 房源信息评论表
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface DiscussfangyuanxinxiService extends IService<DiscussfangyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangyuanxinxiView> selectListView(QueryWrapper<DiscussfangyuanxinxiEntity> wrapper);
   	
   	DiscussfangyuanxinxiView selectView(@Param("ew") QueryWrapper<DiscussfangyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<DiscussfangyuanxinxiEntity> wrapper);
   	

}

