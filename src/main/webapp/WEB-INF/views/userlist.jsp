<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>用户管理列表页面</title>
		<link href="css/all.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery-1.8.0.min.js"></script>
		<script src="js/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%= basePath %>userlist.action" id="mainForm" method="post">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">用户管理</a> &gt; 用户列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删 除</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">姓名：</td>
								<td>
									<input name="name" type="text" class="allInput" value="${name}"/>
								</td>
								<td width="90" align="right">手机：</td>
								<td>
									<input name="mobile" type="text" class="allInput" value="${mobile}"/>
								</td>
								<td width="90" align="right">邮箱：</td>
								<td>
									<input name="email" type="text" class="allInput" value="${email}"/>
								</td>
								<td width="90" align="right">身份证号：</td>
								<td>
									<input name="idcard" type="text" class="allInput" value="${idcard}"/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick="#"/></th>
								    <th>序号</th>
								    <th>用户名</th>
								    <th>密码</th>
									<th>姓名</th>
								    <th>手机</th>
									<th>电子邮箱</th>
								    <th>身份证号</th>
								    <th>操作</th>
								</tr>
								<c:forEach items="${userList}" var="user" varStatus="status">
									<tr <c:if test="${status.index % 2 != 0}">style="background-color:#ECF6EE;"</c:if>>
										<td><input type="checkbox" name="id" value="${user.id}" /></td>
										<td>${status.index+1}</td>
										<td>${user.username}</td>
										<td>${user.password}</td>
										<td>${user.name}</td>
										<td>${user.mobile}</td>
										<td>${user.email}</td>
										<td>${user.idcard}</td>
										<td>
											<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
											<a href="${basePath}deleteone.action?id=${user.id}">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>${page.totalNumber}</b> 条
							<c:if test="${page.currentPage != 1}">
								<a href="javascript:changeCurrentPage('1')" class='first'>首页</a>
								<a href="javascript:changeCurrentPage('${page.currentPage-1}')"
									class='pre'>上一页</a>
							</c:if>
							当前第<span>${page.currentPage}/${page.totalPage}</span>页
							<c:if test="${page.currentPage != page.totalPage}">
								<a href="javascript:changeCurrentPage('${page.currentPage+1}')"
									class='next'>下一页</a>
								<a href="javascript:changeCurrentPage('${page.totalPage}')"
									class='last'>末页</a>
							</c:if>
							跳至&nbsp;<input id="currentPageText" type='text'
								value='${page.currentPage}' class='allInput w28' />&nbsp;页&nbsp; <a
								href="javascript:changeCurrentPage($('#currentPageText').val())"
								class='go'>GO</a>
					</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>