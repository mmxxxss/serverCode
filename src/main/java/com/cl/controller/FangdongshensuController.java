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

import com.cl.entity.FangdongshensuEntity;
import com.cl.entity.view.FangdongshensuView;

import com.cl.service.FangdongshensuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房东申诉
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/fangdongshensu")
public class FangdongshensuController {
    @Autowired
    private FangdongshensuService fangdongshensuService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangdongshensuEntity fangdongshensu,
                                                                                                                                    @RequestParam(required = false) Double zulinjiageStart,
                    @RequestParam(required = false) Double zulinjiageEnd,
                                                                                                                    HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                                                                                                                    if(tableName.equals("fangdong")) {
                    fangdongshensu.setFangdong((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                            if(tableName.equals("zuke")) {
                    fangdongshensu.setZukeming((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                    QueryWrapper<FangdongshensuEntity> ew = new QueryWrapper<FangdongshensuEntity>();
                                                                                                                                                                                                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                    if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);
                                                                                                                                                                                
        //authTable:是
        
        
        PageUtils page = fangdongshensuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangdongshensu), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangdongshensuEntity fangdongshensu,
                @RequestParam(required = false) Double zulinjiageStart,
                @RequestParam(required = false) Double zulinjiageEnd,
		HttpServletRequest request){
        QueryWrapper<FangdongshensuEntity> ew = new QueryWrapper<FangdongshensuEntity>();
                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);

		PageUtils page = fangdongshensuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangdongshensu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangdongshensuEntity fangdongshensu){
       	QueryWrapper<FangdongshensuEntity> ew = new QueryWrapper<FangdongshensuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangdongshensu, "fangdongshensu"));
        return R.ok().put("data", fangdongshensuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangdongshensuEntity fangdongshensu){
        QueryWrapper< FangdongshensuEntity> ew = new QueryWrapper< FangdongshensuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangdongshensu, "fangdongshensu"));
		FangdongshensuView fangdongshensuView =  fangdongshensuService.selectView(ew);
		return R.ok("查询房东申诉成功").put("data", fangdongshensuView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangdongshensuEntity fangdongshensu = fangdongshensuService.getById(id);
		fangdongshensu = fangdongshensuService.selectView(new QueryWrapper<FangdongshensuEntity>().eq("id", id));
        return R.ok().put("data", fangdongshensu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangdongshensuEntity fangdongshensu = fangdongshensuService.getById(id);
		fangdongshensu = fangdongshensuService.selectView(new QueryWrapper<FangdongshensuEntity>().eq("id", id));
        return R.ok().put("data", fangdongshensu);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangdongshensuEntity fangdongshensu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangdongshensu);
        fangdongshensuService.save(fangdongshensu);
        return R.ok().put("data",fangdongshensu.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangdongshensuEntity fangdongshensu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangdongshensu);
        fangdongshensuService.save(fangdongshensu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangdongshensuEntity fangdongshensu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangdongshensu);
        fangdongshensuService.updateById(fangdongshensu);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangdongshensuService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
