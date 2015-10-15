<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="pessoa" modelAttribute="pessoa">
	
	    <c:if test="${!empty sucesso }">
	       <c:out value="${sucesso }"/>
    	       <br/>
	    </c:if>
	    
	    <c:if test="${!empty erro }">
	       <c:out value="${erro }"/>
	       <br/>
	    </c:if>
	    
	    
        id: 
        <form:input type="text" path="codigo" id="codigo"/>
		
        nome: 
        <form:input type="text" path="nome" id="nome"/>
        
        e-mail: 
        <form:input type="text" path="email" id="email"/>
        
        idade: 
        <form:input type="text" path="idade" id="idade"/>
        
        <form:errors path="*"/>
        
        <input type="submit" value="Enviar"/>
        
		
	</form:form>
</body>
</html>