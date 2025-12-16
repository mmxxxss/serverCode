package com.cl.entity.view;

import com.cl.entity.FangdongshensuEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 房东申诉
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@TableName("fangdongshensu")
public class FangdongshensuView  extends FangdongshensuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FangdongshensuView(){
	}
 
 	public FangdongshensuView(FangdongshensuEntity fangdongshensuEntity){
 	try {
			BeanUtils.copyProperties(this, fangdongshensuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}



}
