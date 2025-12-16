package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.SystemintroDao;
import com.cl.entity.SystemintroEntity;
import com.cl.service.SystemintroService;
import com.cl.entity.view.SystemintroView;

@Service("systemintroService")
public class SystemintroServiceImpl extends ServiceImpl<SystemintroDao, SystemintroEntity> implements SystemintroService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SystemintroEntity> page = baseMapper.selectPage(new Query<SystemintroEntity>(params).getPage(),new QueryWrapper<SystemintroEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<SystemintroEntity> wrapper) {
        Page<SystemintroEntity> page = baseMapper.selectPage(new Query<SystemintroEntity>(params).getPage(),wrapper);
        Page<SystemintroView> pageVo = (Page<SystemintroView>)page.convert(SystemintroView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<SystemintroView> selectListView(QueryWrapper<SystemintroEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SystemintroView selectView(QueryWrapper<SystemintroEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
