package com.gittoy.dao;

import java.util.List;
import java.util.Map;

import com.gittoy.bean.User;

/**
 * ��User�����ļ����Ӧ�Ľӿ�
 * 
 * @author GaoYu
 */
public interface IUser {
	/**
	 * ���ݲ�ѯ������ѯ�û��б�
	 */
	public List<User> getUserList(Map<String, Object> parameter);
	/**
	 * ���ݲ�ѯ������ѯ�û��б�����
	 */
	public int count(User user);
	/**
	 * ���ݲ�ѯ������ҳ��ѯ�û��б�
	 */
	public List<User> getUserListByPage(Map<String, Object> parameter);
}
