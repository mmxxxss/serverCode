package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussfangyuanxinxiDao;
import com.cl.entity.DiscussfangyuanxinxiEntity;
import com.cl.service.DiscussfangyuanxinxiService;
import com.cl.entity.view.DiscussfangyuanxinxiView;

@Service("discussfangyuanxinxiService")
public class DiscussfangyuanxinxiServiceImpl extends ServiceImpl<DiscussfangyuanxinxiDao, DiscussfangyuanxinxiEntity> implements DiscussfangyuanxinxiService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfangyuanxinxiEntity> page = baseMapper.selectPage(new Query<DiscussfangyuanxinxiEntity>(params).getPage(),new QueryWrapper<DiscussfangyuanxinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<DiscussfangyuanxinxiEntity> wrapper) {
        Page<DiscussfangyuanxinxiEntity> page = baseMapper.selectPage(new Query<DiscussfangyuanxinxiEntity>(params).getPage(),wrapper);
        Page<DiscussfangyuanxinxiView> pageVo = (Page<DiscussfangyuanxinxiView>)page.convert(DiscussfangyuanxinxiView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<DiscussfangyuanxinxiView> selectListView(QueryWrapper<DiscussfangyuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfangyuanxinxiView selectView(QueryWrapper<DiscussfangyuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
