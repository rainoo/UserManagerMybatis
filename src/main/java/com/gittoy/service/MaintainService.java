package com.gittoy.service;

import java.util.ArrayList;
import java.util.List;

import com.gittoy.dao.UserDao;
import com.gittoy.util.StringUtil;

/**
 * 维护相关的业务功能
 * @author GaoYu
 */
public class MaintainService {

	/**
	 * 单条记录逻辑删除
	 * @param id 欲删除记录的ID
	 */
	public void logicalDeleteOne(String id) {

		// 判断页面得到的ID值是否为空
		if (StringUtil.isNotNullOrEmpty(id)){
			UserDao userDao = new UserDao();
			userDao.logicalDeleteOne(Integer.valueOf(id));
		}
	}

	/**
	 * 批量记录逻辑删除
	 * @param ids 欲删除记录的ID
	 */
	public void logicalDeleteBatch(String[] ids) {

		UserDao userDao = new UserDao();
		List<Integer> idList = new ArrayList<Integer>();
		if (ids != null && ids.length !=0) {
			for (String id : ids) {
				idList.add(Integer.valueOf(id));
			}
			userDao.logicalDeleteBatch(idList);
		}
	}
}
