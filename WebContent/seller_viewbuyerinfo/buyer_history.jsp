<%@page import="com.vo.BuyerInfo"%>
<%@page import="com.vo.Merchandise"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../seller_login/navigation.jsp" %>
<%@include file="../checklogin.jsp" %>
<link rel="stylesheet"  type="text/css" href="<%= basePath %>css/seller_check_interface.css">
<body>
		<table>
                <tr >
                    <td>商品名称</td>
                    <td>购买地址</td>
                </tr>
<%
		ArrayList<Orders> ao = (ArrayList<Orders>)session.getAttribute("orders");
		Iterator<Orders> io = ao.iterator();
		while(io.hasNext()){
			Orders o = io.next();
			Merchandise m = o.getMerchandise();
			BuyerInfo bi = o.getBuyerInfo();
			%>
		<tr>
        	<td><%= m.getM_name()%></td>
            <td><%= bi.getBuyerAddress().get(0) %></td>
        </tr>
			<% 
		}
%>
        </table>
</body>
</html>