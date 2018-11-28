<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>First Web Application</title>
</head>
<body>
hiooo
${tweet}
    <c:forEach  var="listValue" items="${tweet}" >
	<li><c:out value = "${listValue}"/></li>
    </c:forEach>
</body>
</html>