<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.wirtz.ecommerce.model.util.Global" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="layout/header.jsp"%>


<H1>Welcome to your Cart:</H1>

<table class="table table-hover">
		<thead>
			<tr>
				<th>Name Product:</th>
				<th>Price:</th>
				<th>Units:</th>
				<th>Total price:</th>
			</tr>
		</thead>
		
		<tbody>
		
	<c:forEach items="${products}" var="cartline">
			<tr>
				<td>${cartline.getProduct().getName()}</td>
				<td>${cartline.getProduct().getPrice()}</td>
				<td>${cartline.getAmount()}</td>	
				<td>${cartline.getAmount()*cartline.getProduct().getPrice()}</td>
				<td><spring:url value="/cart/delete/${cartline.getCartlineId()}"
									var="deleteCartUrl"></spring:url> <a href="${deleteCartUrl}">Delete to Cart</a></td>
			</tr>
			</c:forEach>

		</tbody>
		
	
		
		
	</table>



<%@ include file="layout/footer.jsp"%>