package com.gittoy.service;

import java.util.ArrayList;
import java.util.List;

import com.gittoy.dao.UserDao;
import com.gittoy.util.StringUtil;

/**
 * ά����ص�ҵ����
 * @author GaoYu
 */
public class MaintainService {

	/**
	 * ������¼�߼�ɾ��
	 * @param id ��ɾ����¼��ID
	 */
	public void logicalDeleteOne(String id) {

		// �ж�ҳ��õ���IDֵ�Ƿ�Ϊ��
		if (StringUtil.isNotNullOrEmpty(id)){
			UserDao userDao = new UserDao();
			userDao.logicalDeleteOne(Integer.valueOf(id));
		}
	}

	/**
	 * ������¼�߼�ɾ��
	 * @param ids ��ɾ����¼��ID
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
