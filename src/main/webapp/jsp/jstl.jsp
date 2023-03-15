<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试Beta</title>
</head>
<body>


<%
    String myname = (String) request.getAttribute("name");
%>

<h1><%=myname%>
</h1>

<h2><c:out value="${name}"></c:out></h2>

<h3>${name}</h3>


</body>
</html>
