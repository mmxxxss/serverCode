package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.AboutusDao;
import com.cl.entity.AboutusEntity;
import com.cl.service.AboutusService;
import com.cl.entity.view.AboutusView;

@Service("aboutusService")
public class AboutusServiceImpl extends ServiceImpl<AboutusDao, AboutusEntity> implements AboutusService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AboutusEntity> page = baseMapper.selectPage(new Query<AboutusEntity>(params).getPage(),new QueryWrapper<AboutusEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<AboutusEntity> wrapper) {
        Page<AboutusEntity> page = baseMapper.selectPage(new Query<AboutusEntity>(params).getPage(),wrapper);
        Page<AboutusView> pageVo = (Page<AboutusView>)page.convert(AboutusView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<AboutusView> selectListView(QueryWrapper<AboutusEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AboutusView selectView(QueryWrapper<AboutusEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
