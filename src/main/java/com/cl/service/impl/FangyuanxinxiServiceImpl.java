package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FangyuanxinxiDao;
import com.cl.entity.FangyuanxinxiEntity;
import com.cl.service.FangyuanxinxiService;
import com.cl.entity.view.FangyuanxinxiView;

@Service("fangyuanxinxiService")
public class FangyuanxinxiServiceImpl extends ServiceImpl<FangyuanxinxiDao, FangyuanxinxiEntity> implements FangyuanxinxiService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangyuanxinxiEntity> page = baseMapper.selectPage(new Query<FangyuanxinxiEntity>(params).getPage(),new QueryWrapper<FangyuanxinxiEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FangyuanxinxiEntity> wrapper) {
        Page<FangyuanxinxiEntity> page = baseMapper.selectPage(new Query<FangyuanxinxiEntity>(params).getPage(),wrapper);
        Page<FangyuanxinxiView> pageVo = (Page<FangyuanxinxiView>)page.convert(FangyuanxinxiView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FangyuanxinxiView> selectListView(QueryWrapper<FangyuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangyuanxinxiView selectView(QueryWrapper<FangyuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
