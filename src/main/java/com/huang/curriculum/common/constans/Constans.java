package com.huang.curriculum.common.constans;

import com.huang.curriculum.common.exception.CurriculumException;

/***
 * 常量类
 *
 * @author Created by Createsequence on 2021/2/15 16:51
 */
public final class Constans {
	
	private Constans() {
		throw new CurriculumException("常量类不允许实例化");
	}
	
	
	// ===================通用===================
	
	/**
	 * null字符串
	 */
	public static final String NULL = "null";
	
	/**
	 * 失败状态
	 */
	public static final String ERROR = "error";
	
	/**
	 * 成功状态
	 */
	public static final String SUCCESS = "success";
	
	// // ===================业务相关===================
	
	/**
	 * 未登录系统时的网页提示
	 */
	public static final String LOGIN_TIP = "请先登录系统";
	
	/**
	 * 密码或用户名为空时的加密结果
	 */
	public static final String EMPTY_ENCODED_KEY = "IA==";
	
	/**
	 * 空考试安排条数，小于5说明无考试安排
	 */
	public static final int EMPTY_EXAM_NUM = 5;
	
	/**
	 * 空课表条数，小于3说明无课表安排
	 */
	public static final int EMPTY_COURSE_NUM = 3;
}
