package com.gittoy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gittoy.bean.User;
import com.gittoy.dao.UserDao;
import com.gittoy.entity.Page;

/**
 * 用户列表相关的业务功能
 * @author GaoYu
 */
public class UserListService {

	/**
	 * 根据查询条件查询用户列表
	 * 
	 * @param name 姓名
	 * @param mobile 手机
	 * @param email 邮箱
	 * @param idcard 身份证号
	 * @param page 分页信息
	 * @return 查询结果
	 */
	public List<User> getUserList(String name, String mobile, String email, String idcard, Page page) {

		// 组织消息对象
		User user = new User();
		user.setName(name);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setIdcard(idcard);
		UserDao userDao = new UserDao();

		// 根据条件查询条数
		int totalNumber = userDao.count(user);
		// 组织分页查询参数
		page.setTotalNumber(totalNumber);
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("user", user);
		parameter.put("page", page);
		// 分页查询并返回结果
		return userDao.getUserList(parameter);
	}

	/**
	 * 根据查询条件分页查询用户列表
	 * 
	 * @param name 姓名
	 * @param mobile 手机
	 * @param email 邮箱
	 * @param idcard 身份证号
	 * @param page 分页信息
	 * @return 查询结果
	 */
	public List<User> getUserListByPage(String name, String mobile, String email, String idcard, Page page) {

		// 组织消息对象
		User user = new User();
		user.setName(name);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setIdcard(idcard);
		UserDao userDao = new UserDao();

		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("user", user);
		parameter.put("page", page);
		// 分页查询并返回结果
		return userDao.getUserListByPage(parameter);
	}
}
