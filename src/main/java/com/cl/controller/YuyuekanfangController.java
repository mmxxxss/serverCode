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

import com.cl.entity.YuyuekanfangEntity;
import com.cl.entity.view.YuyuekanfangView;

import com.cl.service.YuyuekanfangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约看房
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/yuyuekanfang")
public class YuyuekanfangController {
    @Autowired
    private YuyuekanfangService yuyuekanfangService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuekanfangEntity yuyuekanfang,
                                                                                                                                    @RequestParam(required = false) Double zulinjiageStart,
                    @RequestParam(required = false) Double zulinjiageEnd,
                                                                                                                                            HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                                                                                                                    if(tableName.equals("fangdong")) {
                    yuyuekanfang.setFangdong((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                            if(tableName.equals("zuke")) {
                    yuyuekanfang.setZukeming((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                                                                            QueryWrapper<YuyuekanfangEntity> ew = new QueryWrapper<YuyuekanfangEntity>();
                                                                                                                                                                                                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                    if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);
                                                                                                                                                                                                                        
        //authTable:是
        
        
        PageUtils page = yuyuekanfangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuekanfang), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuekanfangEntity yuyuekanfang,
                @RequestParam(required = false) Double zulinjiageStart,
                @RequestParam(required = false) Double zulinjiageEnd,
		HttpServletRequest request){
        QueryWrapper<YuyuekanfangEntity> ew = new QueryWrapper<YuyuekanfangEntity>();
                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);

		PageUtils page = yuyuekanfangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuekanfang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuekanfangEntity yuyuekanfang){
       	QueryWrapper<YuyuekanfangEntity> ew = new QueryWrapper<YuyuekanfangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuekanfang, "yuyuekanfang"));
        return R.ok().put("data", yuyuekanfangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuekanfangEntity yuyuekanfang){
        QueryWrapper< YuyuekanfangEntity> ew = new QueryWrapper< YuyuekanfangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuekanfang, "yuyuekanfang"));
		YuyuekanfangView yuyuekanfangView =  yuyuekanfangService.selectView(ew);
		return R.ok("查询预约看房成功").put("data", yuyuekanfangView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuekanfangEntity yuyuekanfang = yuyuekanfangService.getById(id);
		yuyuekanfang = yuyuekanfangService.selectView(new QueryWrapper<YuyuekanfangEntity>().eq("id", id));
        return R.ok().put("data", yuyuekanfang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuekanfangEntity yuyuekanfang = yuyuekanfangService.getById(id);
		yuyuekanfang = yuyuekanfangService.selectView(new QueryWrapper<YuyuekanfangEntity>().eq("id", id));
        return R.ok().put("data", yuyuekanfang);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuekanfang);
        yuyuekanfangService.save(yuyuekanfang);
        return R.ok().put("data",yuyuekanfang.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuyuekanfang);
        yuyuekanfangService.save(yuyuekanfang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuekanfangEntity yuyuekanfang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuekanfang);
        yuyuekanfangService.updateById(yuyuekanfang);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuyuekanfangEntity> list = new ArrayList<YuyuekanfangEntity>();
        for(Long id : ids) {
            YuyuekanfangEntity yuyuekanfang = yuyuekanfangService.getById(id);
            yuyuekanfang.setSfsh(sfsh);
            yuyuekanfang.setShhf(shhf);
            list.add(yuyuekanfang);
        }
        yuyuekanfangService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuekanfangService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
