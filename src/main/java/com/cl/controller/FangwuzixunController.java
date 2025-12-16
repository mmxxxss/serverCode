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

import com.cl.entity.FangwuzixunEntity;
import com.cl.entity.view.FangwuzixunView;

import com.cl.service.FangwuzixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房屋资讯
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/fangwuzixun")
public class FangwuzixunController {
    @Autowired
    private FangwuzixunService fangwuzixunService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuzixunEntity fangwuzixun,
                                                                                                                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianStart,
                    @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianEnd,
                                HttpServletRequest request){
                                    QueryWrapper<FangwuzixunEntity> ew = new QueryWrapper<FangwuzixunEntity>();
                                                                                                                                                                    if(fabushijianStart!=null) ew.ge("fabushijian", fabushijianStart);
                    if(fabushijianEnd!=null) ew.le("fabushijian", fabushijianEnd);
                                    
        //authTable:$authTable
        
        
        PageUtils page = fangwuzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuzixun), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuzixunEntity fangwuzixun,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianStart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianEnd,
		HttpServletRequest request){
        QueryWrapper<FangwuzixunEntity> ew = new QueryWrapper<FangwuzixunEntity>();
                if(fabushijianStart!=null) ew.ge("fabushijian", fabushijianStart);
                if(fabushijianEnd!=null) ew.le("fabushijian", fabushijianEnd);

		PageUtils page = fangwuzixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuzixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuzixunEntity fangwuzixun){
       	QueryWrapper<FangwuzixunEntity> ew = new QueryWrapper<FangwuzixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuzixun, "fangwuzixun"));
        return R.ok().put("data", fangwuzixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuzixunEntity fangwuzixun){
        QueryWrapper< FangwuzixunEntity> ew = new QueryWrapper< FangwuzixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuzixun, "fangwuzixun"));
		FangwuzixunView fangwuzixunView =  fangwuzixunService.selectView(ew);
		return R.ok("查询房屋资讯成功").put("data", fangwuzixunView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuzixunEntity fangwuzixun = fangwuzixunService.getById(id);
		fangwuzixun = fangwuzixunService.selectView(new QueryWrapper<FangwuzixunEntity>().eq("id", id));
        return R.ok().put("data", fangwuzixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuzixunEntity fangwuzixun = fangwuzixunService.getById(id);
		fangwuzixun = fangwuzixunService.selectView(new QueryWrapper<FangwuzixunEntity>().eq("id", id));
        return R.ok().put("data", fangwuzixun);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuzixunEntity fangwuzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuzixun);
        fangwuzixunService.save(fangwuzixun);
        return R.ok().put("data",fangwuzixun.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuzixunEntity fangwuzixun, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwuzixun);
        fangwuzixunService.save(fangwuzixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangwuzixunEntity fangwuzixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuzixun);
        fangwuzixunService.updateById(fangwuzixun);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangwuzixunService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
