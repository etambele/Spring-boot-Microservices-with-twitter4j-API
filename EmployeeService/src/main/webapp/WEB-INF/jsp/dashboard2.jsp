<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>First Web Application</title>
</head>
<body>
<script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
 

      
    

<div id="that">
		<c:forEach  var="Value" items="${tweets}" >
		<li><c:out value = "${Value}"/></li>
	    </c:forEach>
	</div>
<br/>

  
    
</body>
</html>