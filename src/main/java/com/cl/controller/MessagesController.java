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

import com.cl.entity.MessagesEntity;
import com.cl.entity.view.MessagesView;

import com.cl.service.MessagesService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 留言板
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MessagesEntity messages,
                                                                                                HttpServletRequest request){
                                    QueryWrapper<MessagesEntity> ew = new QueryWrapper<MessagesEntity>();
                                                                                                                                                    
        //authTable:$authTable
        
        
        PageUtils page = messagesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, messages), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MessagesEntity messages,
		HttpServletRequest request){
        QueryWrapper<MessagesEntity> ew = new QueryWrapper<MessagesEntity>();

		PageUtils page = messagesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, messages), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MessagesEntity messages){
       	QueryWrapper<MessagesEntity> ew = new QueryWrapper<MessagesEntity>();
      	ew.allEq(MPUtil.allEQMapPre( messages, "messages"));
        return R.ok().put("data", messagesService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MessagesEntity messages){
        QueryWrapper< MessagesEntity> ew = new QueryWrapper< MessagesEntity>();
 		ew.allEq(MPUtil.allEQMapPre( messages, "messages"));
		MessagesView messagesView =  messagesService.selectView(ew);
		return R.ok("查询留言板成功").put("data", messagesView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MessagesEntity messages = messagesService.getById(id);
		messages = messagesService.selectView(new QueryWrapper<MessagesEntity>().eq("id", id));
        return R.ok().put("data", messages);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MessagesEntity messages = messagesService.getById(id);
		messages = messagesService.selectView(new QueryWrapper<MessagesEntity>().eq("id", id));
        return R.ok().put("data", messages);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MessagesEntity messages, HttpServletRequest request){
        //ValidatorUtils.validateEntity(messages);
        messagesService.save(messages);
        return R.ok().put("data",messages.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MessagesEntity messages, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(messages);
        messagesService.save(messages);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MessagesEntity messages, HttpServletRequest request){
        //ValidatorUtils.validateEntity(messages);
        messagesService.updateById(messages);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        messagesService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
