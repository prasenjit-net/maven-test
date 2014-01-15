<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="webApp">
<head>
<jsp:include page="WEB-INF/jsp/head.jsp" />
</head>
<body>
	<div ng-view></div>
</body>
</html>