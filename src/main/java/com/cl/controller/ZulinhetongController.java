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

import com.cl.entity.ZulinhetongEntity;
import com.cl.entity.view.ZulinhetongView;

import com.cl.service.ZulinhetongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 租赁合同
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/zulinhetong")
public class ZulinhetongController {
    @Autowired
    private ZulinhetongService zulinhetongService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZulinhetongEntity zulinhetong,
                                                                                                                                    @RequestParam(required = false) Double zulinjiageStart,
                    @RequestParam(required = false) Double zulinjiageEnd,
                                                                                                                                            HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                                                                                                                    if(tableName.equals("fangdong")) {
                    zulinhetong.setFangdong((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                            if(tableName.equals("zuke")) {
                    zulinhetong.setZukeming((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                                                                            QueryWrapper<ZulinhetongEntity> ew = new QueryWrapper<ZulinhetongEntity>();
                                                                                                                                                                                                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                    if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);
                                                                                                                                                                                                                        
        //authTable:是
        
        
        PageUtils page = zulinhetongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zulinhetong), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZulinhetongEntity zulinhetong,
                @RequestParam(required = false) Double zulinjiageStart,
                @RequestParam(required = false) Double zulinjiageEnd,
		HttpServletRequest request){
        QueryWrapper<ZulinhetongEntity> ew = new QueryWrapper<ZulinhetongEntity>();
                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);

		PageUtils page = zulinhetongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zulinhetong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZulinhetongEntity zulinhetong){
       	QueryWrapper<ZulinhetongEntity> ew = new QueryWrapper<ZulinhetongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zulinhetong, "zulinhetong"));
        return R.ok().put("data", zulinhetongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZulinhetongEntity zulinhetong){
        QueryWrapper< ZulinhetongEntity> ew = new QueryWrapper< ZulinhetongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zulinhetong, "zulinhetong"));
		ZulinhetongView zulinhetongView =  zulinhetongService.selectView(ew);
		return R.ok("查询租赁合同成功").put("data", zulinhetongView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZulinhetongEntity zulinhetong = zulinhetongService.getById(id);
		zulinhetong = zulinhetongService.selectView(new QueryWrapper<ZulinhetongEntity>().eq("id", id));
        return R.ok().put("data", zulinhetong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZulinhetongEntity zulinhetong = zulinhetongService.getById(id);
		zulinhetong = zulinhetongService.selectView(new QueryWrapper<ZulinhetongEntity>().eq("id", id));
        return R.ok().put("data", zulinhetong);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zulinhetong);
        zulinhetongService.save(zulinhetong);
        return R.ok().put("data",zulinhetong.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zulinhetong);
        zulinhetongService.save(zulinhetong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zulinhetong);
        zulinhetongService.updateById(zulinhetong);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zulinhetongService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
