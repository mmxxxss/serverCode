package com.cl.service.impl;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.dao.TokenDao;
import com.cl.entity.TokenEntity;
import com.cl.entity.TokenEntity;
import com.cl.service.TokenService;
import com.cl.utils.CommonUtil;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


/**
 * token
 */
@Service("tokenService")
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TokenEntity> page = this.page(
                new Query<TokenEntity>(params).getPage(),
                new QueryWrapper<TokenEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<TokenEntity> selectListView(QueryWrapper<TokenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
							   QueryWrapper<TokenEntity> wrapper) {
		Page<TokenEntity> page = this.page(
				new Query<TokenEntity>(params).getPage(),
				wrapper
		);
		return new PageUtils(page);
	}

	@Override
	public String generateToken(Long userid,String username, String tableName, String role) {
		TokenEntity tokenEntity = this.getOne(new QueryWrapper<TokenEntity>().eq("userid", userid).eq("role", role));
		String token = CommonUtil.getRandomString(32);
		Calendar cal = Calendar.getInstance();   
    	cal.setTime(new Date());   
    	cal.add(Calendar.HOUR_OF_DAY, 1);
		if(tokenEntity!=null) {
			tokenEntity.setToken(token);
			tokenEntity.setExpiratedtime(cal.getTime());
			this.updateById(tokenEntity);
		} else {
			this.save(new TokenEntity(userid,username, tableName, role, token, cal.getTime()));
		}
		return token;
	}

	@Override
	public TokenEntity getTokenEntity(String token) {
		TokenEntity tokenEntity = this.getOne(new QueryWrapper<TokenEntity>().eq("token", token));
		if(tokenEntity == null || tokenEntity.getExpiratedtime().getTime()<new Date().getTime()) {
			return null;
		}
		return tokenEntity;
	}
}
