package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FangwuzulinDao;
import com.cl.entity.FangwuzulinEntity;
import com.cl.service.FangwuzulinService;
import com.cl.entity.view.FangwuzulinView;

@Service("fangwuzulinService")
public class FangwuzulinServiceImpl extends ServiceImpl<FangwuzulinDao, FangwuzulinEntity> implements FangwuzulinService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwuzulinEntity> page = baseMapper.selectPage(new Query<FangwuzulinEntity>(params).getPage(),new QueryWrapper<FangwuzulinEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FangwuzulinEntity> wrapper) {
        Page<FangwuzulinEntity> page = baseMapper.selectPage(new Query<FangwuzulinEntity>(params).getPage(),wrapper);
        Page<FangwuzulinView> pageVo = (Page<FangwuzulinView>)page.convert(FangwuzulinView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FangwuzulinView> selectListView(QueryWrapper<FangwuzulinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwuzulinView selectView(QueryWrapper<FangwuzulinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
