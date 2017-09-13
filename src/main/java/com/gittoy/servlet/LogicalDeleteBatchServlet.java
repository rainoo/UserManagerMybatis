package com.gittoy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gittoy.service.MaintainService;

/**
 * 批量记录逻辑删除控制层
 * @author GaoYu
 */
public class LogicalDeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicalDeleteBatchServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		// 接受页面的值
		String[] ids = request.getParameterValues("id");
		// 调用service业务方法
		MaintainService maintainService = new MaintainService();
		maintainService.logicalDeleteBatch(ids);
		// 向用户一览页面跳转
		request.getRequestDispatcher("/userlist.action").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
