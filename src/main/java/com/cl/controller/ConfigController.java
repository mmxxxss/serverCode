package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import jakarta.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ConfigEntity;
import com.cl.entity.view.ConfigView;

import com.cl.service.ConfigService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 轮播图
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:13
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ConfigEntity config,
                                                                    HttpServletRequest request){
                                    QueryWrapper<ConfigEntity> ew = new QueryWrapper<ConfigEntity>();
                                                                                                
        //authTable:$authTable
        
        
        PageUtils page = configService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, config), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ConfigEntity config,
		HttpServletRequest request){
        QueryWrapper<ConfigEntity> ew = new QueryWrapper<ConfigEntity>();

		PageUtils page = configService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, config), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ConfigEntity config){
       	QueryWrapper<ConfigEntity> ew = new QueryWrapper<ConfigEntity>();
      	ew.allEq(MPUtil.allEQMapPre( config, "config"));
        return R.ok().put("data", configService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ConfigEntity config){
        QueryWrapper< ConfigEntity> ew = new QueryWrapper< ConfigEntity>();
 		ew.allEq(MPUtil.allEQMapPre( config, "config"));
		ConfigView configView =  configService.selectView(ew);
		return R.ok("查询轮播图成功").put("data", configView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ConfigEntity config = configService.getById(id);
		config = configService.selectView(new QueryWrapper<ConfigEntity>().eq("id", id));
        return R.ok().put("data", config);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ConfigEntity config = configService.getById(id);
		config = configService.selectView(new QueryWrapper<ConfigEntity>().eq("id", id));
        return R.ok().put("data", config);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ConfigEntity config, HttpServletRequest request){
        //ValidatorUtils.validateEntity(config);
        configService.save(config);
        return R.ok().put("data",config.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ConfigEntity config, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(config);
        configService.save(config);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ConfigEntity config, HttpServletRequest request){
        //ValidatorUtils.validateEntity(config);
        configService.updateById(config);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        configService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
