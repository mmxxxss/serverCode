package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FangdongDao;
import com.cl.entity.FangdongEntity;
import com.cl.service.FangdongService;
import com.cl.entity.view.FangdongView;

@Service("fangdongService")
public class FangdongServiceImpl extends ServiceImpl<FangdongDao, FangdongEntity> implements FangdongService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangdongEntity> page = baseMapper.selectPage(new Query<FangdongEntity>(params).getPage(),new QueryWrapper<FangdongEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<FangdongEntity> wrapper) {
        Page<FangdongEntity> page = baseMapper.selectPage(new Query<FangdongEntity>(params).getPage(),wrapper);
        Page<FangdongView> pageVo = (Page<FangdongView>)page.convert(FangdongView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<FangdongView> selectListView(QueryWrapper<FangdongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangdongView selectView(QueryWrapper<FangdongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
