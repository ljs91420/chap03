<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("fruit", "사과");
	session.setAttribute("fruit", "포도");
	application.setAttribute("fruit", "사과");
	pageContext.setAttribute("fruit", "참외");
	
	request.getRequestDispatcher("/attribute/index.jsp").forward(request, response);
%>