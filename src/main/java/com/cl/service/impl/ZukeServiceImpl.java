package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZukeDao;
import com.cl.entity.ZukeEntity;
import com.cl.service.ZukeService;
import com.cl.entity.view.ZukeView;

@Service("zukeService")
public class ZukeServiceImpl extends ServiceImpl<ZukeDao, ZukeEntity> implements ZukeService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZukeEntity> page = baseMapper.selectPage(new Query<ZukeEntity>(params).getPage(),new QueryWrapper<ZukeEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ZukeEntity> wrapper) {
        Page<ZukeEntity> page = baseMapper.selectPage(new Query<ZukeEntity>(params).getPage(),wrapper);
        Page<ZukeView> pageVo = (Page<ZukeView>)page.convert(ZukeView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ZukeView> selectListView(QueryWrapper<ZukeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZukeView selectView(QueryWrapper<ZukeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
