package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YuyuekanfangDao;
import com.cl.entity.YuyuekanfangEntity;
import com.cl.service.YuyuekanfangService;
import com.cl.entity.view.YuyuekanfangView;

@Service("yuyuekanfangService")
public class YuyuekanfangServiceImpl extends ServiceImpl<YuyuekanfangDao, YuyuekanfangEntity> implements YuyuekanfangService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuekanfangEntity> page = baseMapper.selectPage(new Query<YuyuekanfangEntity>(params).getPage(),new QueryWrapper<YuyuekanfangEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<YuyuekanfangEntity> wrapper) {
        Page<YuyuekanfangEntity> page = baseMapper.selectPage(new Query<YuyuekanfangEntity>(params).getPage(),wrapper);
        Page<YuyuekanfangView> pageVo = (Page<YuyuekanfangView>)page.convert(YuyuekanfangView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<YuyuekanfangView> selectListView(QueryWrapper<YuyuekanfangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuekanfangView selectView(QueryWrapper<YuyuekanfangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
