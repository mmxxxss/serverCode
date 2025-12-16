package com.cl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZulinhetongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZulinhetongView;


/**
 * 租赁合同
 *
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
public interface ZulinhetongService extends IService<ZulinhetongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZulinhetongView> selectListView(QueryWrapper<ZulinhetongEntity> wrapper);
   	
   	ZulinhetongView selectView(@Param("ew") QueryWrapper<ZulinhetongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,QueryWrapper<ZulinhetongEntity> wrapper);
   	

}

