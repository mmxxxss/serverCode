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

import com.cl.entity.DiscussfangyuanxinxiEntity;
import com.cl.entity.view.DiscussfangyuanxinxiView;

import com.cl.service.DiscussfangyuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房源信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@RestController
@RequestMapping("/discussfangyuanxinxi")
public class DiscussfangyuanxinxiController {
    @Autowired
    private DiscussfangyuanxinxiService discussfangyuanxinxiService;







    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussfangyuanxinxiEntity discussfangyuanxinxi,
                                                                                                                            HttpServletRequest request){
                                    QueryWrapper<DiscussfangyuanxinxiEntity> ew = new QueryWrapper<DiscussfangyuanxinxiEntity>();
                                                                                                                                                                                        
        //authTable:$authTable
        
        
        PageUtils page = discussfangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanxinxi), params), params));
        return R.ok().put("data", page);
    }







    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussfangyuanxinxiEntity discussfangyuanxinxi,
		HttpServletRequest request){
        QueryWrapper<DiscussfangyuanxinxiEntity> ew = new QueryWrapper<DiscussfangyuanxinxiEntity>();

		PageUtils page = discussfangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussfangyuanxinxiEntity discussfangyuanxinxi){
       	QueryWrapper<DiscussfangyuanxinxiEntity> ew = new QueryWrapper<DiscussfangyuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussfangyuanxinxi, "discussfangyuanxinxi"));
        return R.ok().put("data", discussfangyuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussfangyuanxinxiEntity discussfangyuanxinxi){
        QueryWrapper< DiscussfangyuanxinxiEntity> ew = new QueryWrapper< DiscussfangyuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussfangyuanxinxi, "discussfangyuanxinxi"));
		DiscussfangyuanxinxiView discussfangyuanxinxiView =  discussfangyuanxinxiService.selectView(ew);
		return R.ok("查询房源信息评论表成功").put("data", discussfangyuanxinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussfangyuanxinxiEntity discussfangyuanxinxi = discussfangyuanxinxiService.getById(id);
		discussfangyuanxinxi = discussfangyuanxinxiService.selectView(new QueryWrapper<DiscussfangyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussfangyuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussfangyuanxinxiEntity discussfangyuanxinxi = discussfangyuanxinxiService.getById(id);
		discussfangyuanxinxi = discussfangyuanxinxiService.selectView(new QueryWrapper<DiscussfangyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", discussfangyuanxinxi);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussfangyuanxinxiEntity discussfangyuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussfangyuanxinxi);
        discussfangyuanxinxiService.save(discussfangyuanxinxi);
        return R.ok().put("data",discussfangyuanxinxi.getId());
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussfangyuanxinxiEntity discussfangyuanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussfangyuanxinxi);
        discussfangyuanxinxiService.save(discussfangyuanxinxi);
        return R.ok();
    }

     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussfangyuanxinxiEntity discussfangyuanxinxi = discussfangyuanxinxiService.getOne(new QueryWrapper<DiscussfangyuanxinxiEntity>().eq("", username));
        return R.ok().put("data", discussfangyuanxinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussfangyuanxinxiEntity discussfangyuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussfangyuanxinxi);
        discussfangyuanxinxiService.updateById(discussfangyuanxinxi);//全部更新
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussfangyuanxinxiService.removeBatchByIds(Arrays.asList(ids));
        return R.ok();
    }


	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussfangyuanxinxiEntity discussfangyuanxinxi, HttpServletRequest request,String pre){
        QueryWrapper<DiscussfangyuanxinxiEntity> ew = new QueryWrapper<DiscussfangyuanxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussfangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanxinxi), params), params));
        return R.ok().put("data", page);
    }









}
