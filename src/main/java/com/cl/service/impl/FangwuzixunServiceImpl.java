package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FangwuzixunDao;
import com.cl.entity.FangwuzixunEntity;
import com.cl.service.FangwuzixunService;
import com.cl.entity.view.FangwuzixunView;

@Service("fangwuzixunService")
public class FangwuzixunServiceImpl extends ServiceImpl<FangwuzixunDao, FangwuzixunEntity> implements FangwuzixunService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwuzixunEntity> page = baseMapper.selectPage(new Query<FangwuzixunEntity>(params).getPage(),new QueryWrapper<FangwuzixunEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FangwuzixunEntity> wrapper) {
        Page<FangwuzixunEntity> page = baseMapper.selectPage(new Query<FangwuzixunEntity>(params).getPage(),wrapper);
        Page<FangwuzixunView> pageVo = (Page<FangwuzixunView>)page.convert(FangwuzixunView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FangwuzixunView> selectListView(QueryWrapper<FangwuzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwuzixunView selectView(QueryWrapper<FangwuzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
