package com.gittoy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gittoy.service.MaintainService;

/**
 * ������¼�߼�ɾ�����Ʋ�
 * @author GaoYu
 */
public class LogicalDeleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogicalDeleteOneServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		// ����ҳ���ֵ
		String id = request.getParameter("id");
		// ����serviceҵ�񷽷�
		MaintainService maintainService = new MaintainService();
		maintainService.logicalDeleteOne(id);
		// ���û�һ��ҳ����ת
		request.getRequestDispatcher("/userlist.action").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
