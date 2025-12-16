package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FangyuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangyuanxinxiView;


/**
 * 房源信息
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface FangyuanxinxiService extends IService<FangyuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanxinxiView> selectListView(QueryWrapper<FangyuanxinxiEntity> wrapper);
   	
   	FangyuanxinxiView selectView(@Param("ew") QueryWrapper<FangyuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<FangyuanxinxiEntity> wrapper);
   	

}

