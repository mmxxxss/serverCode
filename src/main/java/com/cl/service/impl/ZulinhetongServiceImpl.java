package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ZulinhetongDao;
import com.cl.entity.ZulinhetongEntity;
import com.cl.service.ZulinhetongService;
import com.cl.entity.view.ZulinhetongView;

@Service("zulinhetongService")
public class ZulinhetongServiceImpl extends ServiceImpl<ZulinhetongDao, ZulinhetongEntity> implements ZulinhetongService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZulinhetongEntity> page = baseMapper.selectPage(new Query<ZulinhetongEntity>(params).getPage(),new QueryWrapper<ZulinhetongEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ZulinhetongEntity> wrapper) {
        Page<ZulinhetongEntity> page = baseMapper.selectPage(new Query<ZulinhetongEntity>(params).getPage(),wrapper);
        Page<ZulinhetongView> pageVo = (Page<ZulinhetongView>)page.convert(ZulinhetongView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ZulinhetongView> selectListView(QueryWrapper<ZulinhetongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZulinhetongView selectView(QueryWrapper<ZulinhetongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
