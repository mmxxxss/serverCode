package com.cl.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


/**
 * 房屋租赁
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-27 16:09:14
 */
@TableName("fangwuzulin")
public class FangwuzulinEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FangwuzulinEntity() {
		
	}
	
	public FangwuzulinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 房屋名称
	 */
					
	private String fangwumingcheng;
	
	/**
	 * 房屋图片
	 */
					
	private String fangwutupian;
	
	/**
	 * 房屋面积/m3
	 */
					
	private String fangwumianji;
	
	/**
	 * 房屋地址
	 */
					
	private String fangwudizhi;
	
	/**
	 * 租赁价格
	 */
					
	private Double zulinjiage;
	
	/**
	 * 户型
	 */
					
	private String huxing;
	
	/**
	 * 房东
	 */
					
	private String fangdong;
	
	/**
	 * 房东姓名
	 */
					
	private String fangdongxingming;
	
	/**
	 * 租客名
	 */
					
	private String zukeming;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 租赁/月
	 */
					
	private Integer zulinshijian;
	
	/**
	 * 租赁人数
	 */
					
	private Integer zulinrenshu;
	
	/**
	 * 租赁金额
	 */
					
	private Double zulinjine;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	

	
	/**
	 * 是否使用
	 */
					
	private String isUsed;
	

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：房屋名称
	 */
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
	/**
	 * 设置：房屋图片
	 */
	public void setFangwutupian(String fangwutupian) {
		this.fangwutupian = fangwutupian;
	}
	/**
	 * 获取：房屋图片
	 */
	public String getFangwutupian() {
		return fangwutupian;
	}
	/**
	 * 设置：房屋面积/m3
	 */
	public void setFangwumianji(String fangwumianji) {
		this.fangwumianji = fangwumianji;
	}
	/**
	 * 获取：房屋面积/m3
	 */
	public String getFangwumianji() {
		return fangwumianji;
	}
	/**
	 * 设置：房屋地址
	 */
	public void setFangwudizhi(String fangwudizhi) {
		this.fangwudizhi = fangwudizhi;
	}
	/**
	 * 获取：房屋地址
	 */
	public String getFangwudizhi() {
		return fangwudizhi;
	}
	/**
	 * 设置：租赁价格
	 */
	public void setZulinjiage(Double zulinjiage) {
		this.zulinjiage = zulinjiage;
	}
	/**
	 * 获取：租赁价格
	 */
	public Double getZulinjiage() {
		return zulinjiage;
	}
	/**
	 * 设置：户型
	 */
	public void setHuxing(String huxing) {
		this.huxing = huxing;
	}
	/**
	 * 获取：户型
	 */
	public String getHuxing() {
		return huxing;
	}
	/**
	 * 设置：房东
	 */
	public void setFangdong(String fangdong) {
		this.fangdong = fangdong;
	}
	/**
	 * 获取：房东
	 */
	public String getFangdong() {
		return fangdong;
	}
	/**
	 * 设置：房东姓名
	 */
	public void setFangdongxingming(String fangdongxingming) {
		this.fangdongxingming = fangdongxingming;
	}
	/**
	 * 获取：房东姓名
	 */
	public String getFangdongxingming() {
		return fangdongxingming;
	}
	/**
	 * 设置：租客名
	 */
	public void setZukeming(String zukeming) {
		this.zukeming = zukeming;
	}
	/**
	 * 获取：租客名
	 */
	public String getZukeming() {
		return zukeming;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：租赁/月
	 */
	public void setZulinshijian(Integer zulinshijian) {
		this.zulinshijian = zulinshijian;
	}
	/**
	 * 获取：租赁/月
	 */
	public Integer getZulinshijian() {
		return zulinshijian;
	}
	/**
	 * 设置：租赁人数
	 */
	public void setZulinrenshu(Integer zulinrenshu) {
		this.zulinrenshu = zulinrenshu;
	}
	/**
	 * 获取：租赁人数
	 */
	public Integer getZulinrenshu() {
		return zulinrenshu;
	}
	/**
	 * 设置：租赁金额
	 */
	public void setZulinjine(Double zulinjine) {
		this.zulinjine = zulinjine;
	}
	/**
	 * 获取：租赁金额
	 */
	public Double getZulinjine() {
		return zulinjine;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
	
	/**
	 * 设置：是否使用
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	/**
	 * 获取：是否使用
	 */
	public String getIsUsed() {
		return isUsed;
	}

}
