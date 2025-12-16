package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ConfigDao;
import com.cl.entity.ConfigEntity;
import com.cl.service.ConfigService;
import com.cl.entity.view.ConfigView;

@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ConfigEntity> page = baseMapper.selectPage(new Query<ConfigEntity>(params).getPage(),new QueryWrapper<ConfigEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<ConfigEntity> wrapper) {
        Page<ConfigEntity> page = baseMapper.selectPage(new Query<ConfigEntity>(params).getPage(),wrapper);
        Page<ConfigView> pageVo = (Page<ConfigView>)page.convert(ConfigView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<ConfigView> selectListView(QueryWrapper<ConfigEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ConfigView selectView(QueryWrapper<ConfigEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
