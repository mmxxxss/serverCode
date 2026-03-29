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

import com.cl.entity.FangwuzulinEntity;
import com.cl.entity.ZulinhetongEntity;
import com.cl.entity.view.FangwuzulinView;

import com.cl.service.FangwuzulinService;
import com.cl.service.ZulinhetongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房屋租赁
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/fangwuzulin")
public class FangwuzulinController {
    @Autowired
    private FangwuzulinService fangwuzulinService;
    
    @Autowired
    private ZulinhetongService zulinhetongService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangwuzulinEntity fangwuzulin,
                                                                                                                                    @RequestParam(required = false) Double zulinjiageStart,
                    @RequestParam(required = false) Double zulinjiageEnd,
                                                                                                                                            HttpServletRequest request){
                    String tableName = request.getSession().getAttribute("tableName").toString();
                                                                                                                                                                                                                    if(tableName.equals("fangdong")) {
                    fangwuzulin.setFangdong((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                            if(tableName.equals("zuke")) {
                    fangwuzulin.setZukeming((String)request.getSession().getAttribute("username"));
                                    }
                                                                                                                                                                                                            QueryWrapper<FangwuzulinEntity> ew = new QueryWrapper<FangwuzulinEntity>();
                                                                                                                                                                                                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                    if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);
                                                                                                                                                                                                                        
        //authTable:是
        
        
        PageUtils page = fangwuzulinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuzulin), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangwuzulinEntity fangwuzulin,
                @RequestParam(required = false) Double zulinjiageStart,
                @RequestParam(required = false) Double zulinjiageEnd,
		HttpServletRequest request){
        QueryWrapper<FangwuzulinEntity> ew = new QueryWrapper<FangwuzulinEntity>();
                if(zulinjiageStart!=null) ew.ge("zulinjiage", zulinjiageStart);
                if(zulinjiageEnd!=null) ew.le("zulinjiage", zulinjiageEnd);

		PageUtils page = fangwuzulinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuzulin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangwuzulinEntity fangwuzulin){
       	QueryWrapper<FangwuzulinEntity> ew = new QueryWrapper<FangwuzulinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangwuzulin, "fangwuzulin"));
        return R.ok().put("data", fangwuzulinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangwuzulinEntity fangwuzulin){
        QueryWrapper< FangwuzulinEntity> ew = new QueryWrapper< FangwuzulinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangwuzulin, "fangwuzulin"));
		FangwuzulinView fangwuzulinView =  fangwuzulinService.selectView(ew);
		return R.ok("查询房屋租赁成功").put("data", fangwuzulinView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangwuzulinEntity fangwuzulin = fangwuzulinService.getById(id);
		fangwuzulin = fangwuzulinService.selectView(new QueryWrapper<FangwuzulinEntity>().eq("id", id));
        return R.ok().put("data", fangwuzulin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangwuzulinEntity fangwuzulin = fangwuzulinService.getById(id);
		fangwuzulin = fangwuzulinService.selectView(new QueryWrapper<FangwuzulinEntity>().eq("id", id));
        return R.ok().put("data", fangwuzulin);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuzulinEntity fangwuzulin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuzulin);
        fangwuzulinService.save(fangwuzulin);
        return R.ok().put("data",fangwuzulin.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuzulinEntity fangwuzulin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangwuzulin);
        fangwuzulinService.save(fangwuzulin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangwuzulinEntity fangwuzulin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangwuzulin);
        fangwuzulinService.updateById(fangwuzulin);//全部更新
        
        // 如果传入了isUsed字段，则更新关联的租赁合同状态
        if(fangwuzulin.getIsUsed() != null) {
            // 通过其他方式查找关联的租赁合同，这里假设合同ID与房屋租赁记录ID相同
            ZulinhetongEntity zulinhetong = new ZulinhetongEntity();
            zulinhetong.setId(fangwuzulin.getId()); // 假设ID相同
            zulinhetong.setIsUsed(fangwuzulin.getIsUsed());
            zulinhetongService.updateById(zulinhetong);
        }
        
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangwuzulinService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
