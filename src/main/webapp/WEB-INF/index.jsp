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
	<title>Save Travels</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<div class="top-section">
			<h1>Save Travels</h1>
			<table>
				<thead>
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="travel" items="${travels}">
						<tr>
							<td><c:out value="${travel.expense}"/></td>
							<td><c:out value="${travel.vendor}"/></td>
							<td>$<c:out value="${travel.amount}"/></td>
							<td class="editDelete">
								<a href="/expenses/edit/${travel.id}">edit</a>
								<!-- To delete we need to put the button (input) in <form> and method in <form> is POST -->
								<!-- We also need another <input> with the details as below!!! -->	
								<form method="POST" action="/expenses/delete/${travel.id}">
									<input type="hidden" name="_method" value="DELETE"/>
									<input class="dltBtn" type="submit" value="delete"/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="adding-section">
			<h2>Add an expense :</h2>
			<form:form class="form" action="" method="post" modelAttribute="travel">
				<div class="expense-input">
					<div class="frontSection">
						<form:label path="expense">Expense Name : </form:label>
						<form:errors path="expense" class="text-danger"/>
					</div>
				<form:input path="expense"></form:input>
				</div>
				<div class="vendor-input">
					<div class="frontSection">
						<form:label path="vendor">Vendor : </form:label>
						<form:errors path="vendor" class="text-danger"/>
					</div>
				<form:input path="vendor"></form:input>
				</div>
				<div class="amount-input">
					<div class="frontSection">
						<form:label path="amount">Amount : </form:label>
						<form:errors path="amount" class="text-danger"/>
					</div>
				<form:input type="number" step="0.01" path="amount"></form:input>
				</div>
				<div class="description-input">
					<div class="frontSection">
						<form:label path="description">Description : </form:label>
						<form:errors path="description" class="text-danger"/>
					</div>
				<form:textarea class="tarea" path="description" rows="5" cols="50"></form:textarea>
				</div>
				<input type="submit" class="submit" value="Submit"/>
			</form:form>
		</div>
	</div>

</body>
</html>