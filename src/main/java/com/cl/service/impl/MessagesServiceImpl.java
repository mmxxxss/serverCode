package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.MessagesDao;
import com.cl.entity.MessagesEntity;
import com.cl.service.MessagesService;
import com.cl.entity.view.MessagesView;

@Service("messagesService")
public class MessagesServiceImpl extends ServiceImpl<MessagesDao, MessagesEntity> implements MessagesService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MessagesEntity> page = baseMapper.selectPage(new Query<MessagesEntity>(params).getPage(),new QueryWrapper<MessagesEntity>());
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, QueryWrapper<MessagesEntity> wrapper) {
        Page<MessagesEntity> page = baseMapper.selectPage(new Query<MessagesEntity>(params).getPage(),wrapper);
        Page<MessagesView> pageVo = (Page<MessagesView>)page.convert(MessagesView::new);
	    return new PageUtils(pageVo);
 	}
    
	@Override
	public List<MessagesView> selectListView(QueryWrapper<MessagesEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MessagesView selectView(QueryWrapper<MessagesEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
