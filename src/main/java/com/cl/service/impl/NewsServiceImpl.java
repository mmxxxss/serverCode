package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.NewsDao;
import com.cl.entity.NewsEntity;
import com.cl.service.NewsService;
import com.cl.entity.view.NewsView;

@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NewsEntity> page = baseMapper.selectPage(new Query<NewsEntity>(params).getPage(),new QueryWrapper<NewsEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<NewsEntity> wrapper) {
        Page<NewsEntity> page = baseMapper.selectPage(new Query<NewsEntity>(params).getPage(),wrapper);
        Page<NewsView> pageVo = (Page<NewsView>)page.convert(NewsView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<NewsView> selectListView(QueryWrapper<NewsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NewsView selectView(QueryWrapper<NewsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
