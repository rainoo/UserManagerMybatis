package com.gittoy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gittoy.bean.User;
import com.gittoy.util.DBAccess;

/**
 * 和USER表相关的数据库操作
 *  
 * @author GaoYu
 */
public class UserDao {

	/**
	 * 根据查询条件查询用户列表
	 * 
	 * @param name 姓名
	 * @param mobile 手机
	 * @param email 邮箱
	 * @param idcard 身份证号
	 * @return 符合条件的用户列表
	 */
	public List<User> getUserList(Map<String, Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<User> userList = new ArrayList<User>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IUser iuser = sqlSession.getMapper(IUser.class);
			userList = iuser.getUserList(parameter);
			// userList = sqlSession.selectList("com.gittoy.mapper.UserMapper.getUserList", user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return userList;
	}

	/**
	 * 根据查询条件查询消息列表的条数
	 * @param user 查询条件对象
	 * @return 查询结果条数
	 */
	public int count(User user) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IUser iuser = sqlSession.getMapper(IUser.class);
			result = iuser.count(user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}

	/**
	 * 根据查询条件分页查询用户列表
	 * 
	 * @param name 姓名
	 * @param mobile 手机
	 * @param email 邮箱
	 * @param idcard 身份证号
	 * @return 符合条件的用户列表
	 */
	public List<User> getUserListByPage(Map<String, Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<User> userList = new ArrayList<User>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IUser iuser = sqlSession.getMapper(IUser.class);
			userList = iuser.getUserListByPage(parameter);
			// userList = sqlSession.selectList("com.gittoy.mapper.UserMapper.getUserList", user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return userList;
	}

	/**
	 * 根据传入ID值对该ID对应记录进行逻辑删除
	 * 
	 * @param id 删除的记录ID
	 */
	public void logicalDeleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.update("com.gittoy.mapper.UserMapper.logicalDeleteOne", id);
			// 提交事务处理
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	/**
	 * 根据传入多条ID值对相关ID对应记录进行逻辑删除
	 * 
	 * @param id 删除的记录ID
	 */
	public void logicalDeleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.update("com.gittoy.mapper.UserMapper.logicalDeleteBatch", ids);
			// 提交事务处理
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
