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

import com.cl.entity.ZukeEntity;
import com.cl.entity.view.ZukeView;

import com.cl.service.ZukeService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 租客
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/zuke")
public class ZukeController {
    @Autowired
    private ZukeService zukeService;



	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ZukeEntity u = zukeService.getOne(new QueryWrapper<ZukeEntity>().eq("zukeming", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"zuke",  "租客" );
		return R.ok().put("token", token);
	}



	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZukeEntity zuke){
    	//ValidatorUtils.validateEntity(zuke);
        ZukeEntity u = zukeService.getOne(new QueryWrapper<ZukeEntity>().eq("zukeming", zuke.getZukeming()));
        if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		zuke.setId(uId);
        zukeService.save(zuke);
        return R.ok();
    }


	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}

	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        return R.ok().put("data", zukeService.selectView(new QueryWrapper<ZukeEntity>().eq("id", id)));
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ZukeEntity u = zukeService.getOne(new QueryWrapper<ZukeEntity>().eq("zukeming", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        zukeService.updateById(u);
        return R.ok("密码已重置为：123456");
    }




    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZukeEntity zuke,
                                                                                                                                HttpServletRequest request){
                                    QueryWrapper<ZukeEntity> ew = new QueryWrapper<ZukeEntity>();
                                                                                                                                                                                                    
        //authTable:$authTable
        
        
        PageUtils page = zukeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuke), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZukeEntity zuke,
		HttpServletRequest request){
        QueryWrapper<ZukeEntity> ew = new QueryWrapper<ZukeEntity>();

		PageUtils page = zukeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuke), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZukeEntity zuke){
       	QueryWrapper<ZukeEntity> ew = new QueryWrapper<ZukeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuke, "zuke"));
        return R.ok().put("data", zukeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZukeEntity zuke){
        QueryWrapper< ZukeEntity> ew = new QueryWrapper< ZukeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuke, "zuke"));
		ZukeView zukeView =  zukeService.selectView(ew);
		return R.ok("查询租客成功").put("data", zukeView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZukeEntity zuke = zukeService.getById(id);
		zuke = zukeService.selectView(new QueryWrapper<ZukeEntity>().eq("id", id));
        return R.ok().put("data", zuke);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZukeEntity zuke = zukeService.getById(id);
		zuke = zukeService.selectView(new QueryWrapper<ZukeEntity>().eq("id", id));
        return R.ok().put("data", zuke);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZukeEntity zuke, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zukeService.count(new QueryWrapper<ZukeEntity>().eq("zukeming", zuke.getZukeming()))>0) {
            return R.error("租客名已存在");
        }
        //ValidatorUtils.validateEntity(zuke);
        ZukeEntity u = zukeService.getOne(new QueryWrapper<ZukeEntity>().eq("zukeming", zuke.getZukeming()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	zuke.setId(new Date().getTime()+(long)Math.floor(Math.random()*1000));
		zuke.setId(new Date().getTime());
        zukeService.save(zuke);
        return R.ok().put("data",zuke.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZukeEntity zuke, HttpServletRequest request){
        if(zukeService.count(new QueryWrapper<ZukeEntity>().eq("zukeming", zuke.getZukeming()))>0) {
            return R.error("租客名已存在");
        }
    	zuke.setId(new Date().getTime()+(long)Math.floor(Math.random()*1000));
    	//ValidatorUtils.validateEntity(zuke);
        ZukeEntity u = zukeService.getOne(new QueryWrapper<ZukeEntity>().eq("zukeming", zuke.getZukeming()));
        if(u!=null) {
			return R.error("用户已存在");
		}
		zuke.setId(new Date().getTime());
        zukeService.save(zuke);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZukeEntity zuke, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuke);
        zukeService.updateById(zuke);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zukeService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }











}
