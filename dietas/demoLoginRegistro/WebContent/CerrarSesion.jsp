<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  HttpSession sesion = request.getSession();
	sesion.invalidate();
	response.sendRedirect("index.jsp");
%>