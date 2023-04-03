<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL -->
<!-- c: -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Form/Submit workflows -->
<!-- form: -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- The 'isErrorPage' attribute indicates that the current JSP can be used as the error page for another JSP. -->
<%@ page isErrorPage="true" %>
<!-- The **errorPage** attribute tells the JSP engine which page to display if there is an error while the current page runs. The value of the errorPage attribute is a relative URL. -->
<%@ page errorPage = "MyErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Expense</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<div class="toppart">
			<h1>Expense Details</h1>
			<a href="/expenses">Go Back</a>
		</div>
		<table class="details">
			<tr>
				<td class="detailTable">Expense Name:</td>
				<td class="detailTable"><c:out value="${travel.expense}"/></td>
			</tr>
			<tr>
				<td class="detailTable">Expense Description:</td>
				<td class="detailTable"><c:out value="${travel.description}"/></td>
			</tr>
			<tr>
				<td class="detailTable">Vendor</td>
				<td class="detailTable"><c:out value="${travel.vendor}"/></td>
			</tr>
			<tr>
				<td class="detailTable">Amount</td>
				<td class="detailTable">$<c:out value="${travel.amount}"/></td>
			</tr>
		
		</table>
		
	</div>

</body>
</html>