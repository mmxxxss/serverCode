package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FangdongshensuDao;
import com.cl.entity.FangdongshensuEntity;
import com.cl.service.FangdongshensuService;
import com.cl.entity.view.FangdongshensuView;

@Service("fangdongshensuService")
public class FangdongshensuServiceImpl extends ServiceImpl<FangdongshensuDao, FangdongshensuEntity> implements FangdongshensuService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangdongshensuEntity> page = baseMapper.selectPage(new Query<FangdongshensuEntity>(params).getPage(),new QueryWrapper<FangdongshensuEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FangdongshensuEntity> wrapper) {
        Page<FangdongshensuEntity> page = baseMapper.selectPage(new Query<FangdongshensuEntity>(params).getPage(),wrapper);
        Page<FangdongshensuView> pageVo = (Page<FangdongshensuView>)page.convert(FangdongshensuView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FangdongshensuView> selectListView(QueryWrapper<FangdongshensuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangdongshensuView selectView(QueryWrapper<FangdongshensuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
