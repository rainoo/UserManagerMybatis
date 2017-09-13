package com.gittoy.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gittoy.entity.Page;
import com.gittoy.service.UserListService;

/**
 * 用户列表页面初始化控制
 * @author GaoYu
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	// 设置编码
		request.setCharacterEncoding("utf-8");

		// 接受页面的值
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String idcard = request.getParameter("idcard");
		String currentPage = request.getParameter("currentPage");

		// 创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if (currentPage == null || !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}

		// 调用service业务方法
		UserListService userListService = new UserListService();
		// 查询用户列表并传递给页面
		request.setAttribute("userList", userListService.getUserListByPage(name, mobile, email, idcard, page));
		// 向页面传值
		request.setAttribute("name", name);
		request.setAttribute("mobile", mobile);
		request.setAttribute("email", email);
		request.setAttribute("idcard", idcard);
		request.setAttribute("page", page);

		// 向页面跳转
		request.getRequestDispatcher("/WEB-INF/views/userlist.jsp").forward(request, response);;
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
