package com.gittoy.dao;

import java.util.List;
import java.util.Map;

import com.gittoy.bean.User;

/**
 * 与User配置文件相对应的接口
 * 
 * @author GaoYu
 */
public interface IUser {
	/**
	 * 根据查询条件查询用户列表
	 */
	public List<User> getUserList(Map<String, Object> parameter);
	/**
	 * 根据查询条件查询用户列表条数
	 */
	public int count(User user);
	/**
	 * 根据查询条件分页查询用户列表
	 */
	public List<User> getUserListByPage(Map<String, Object> parameter);
}
