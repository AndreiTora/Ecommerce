
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wirtz.ecommerce.model.util.Global" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="layout/header.jsp"%>
<h2>Products search</h2>

<c:set var="pageCount" value="${Global.PAGE_SIZE }"/>
<spring:url value="/products/search/0/${pageCount}" var="productsSearchUrl"></spring:url>

<h2>Producto details</h2>

	<table class="table table-hover">
		<thead>
			<tr>

				<th>Name</th>
				<th>Price</th>
				<th>Stock</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.stock}</td>
				
			</tr>

		</tbody>
		
		
	</table>


