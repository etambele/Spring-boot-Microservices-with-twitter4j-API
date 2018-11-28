<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>First Web Application</title>
</head>
<body>
<script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
 

      
    <table style="width:100%">
  <tr>
  	<th>Emp ID</th>
    <th>Firstname</th>
    <th>Lastname</th> 
    <th>Status</th>
    <th>Current Performance</th>
    <th>Over all Rating</th>
  </tr>
  
  <c:forEach  var="listValue" items="${employees}" >
	<tr>
	<td align="center"> <a href= "/emp/${listValue.empid}"><c:out value = "${listValue.empid}"/></a></td>
	<td align="center"><c:out value = "${listValue.firstname}"/></td>
    <td align="center"><c:out value = "${listValue.lastname}"/></td>
    <td align="center"><c:out value = "${listValue.status}"/></td>
    <td align="center"><c:out value = "${listValue.currentrating}"/></td>
    <td align="center"><c:out value = "${listValue.oaRating}"/></td>
    </tr>
    </c:forEach>
  
  
 
</table>

<div id="that">
		<c:forEach  var="Value" items="${tweets}" >
		<li><c:out value = "${Value}"/></li>
	    </c:forEach>
	</div>
<br/>
    <button type="button" onclick="chk()">get Tweets</button>
    <script language="javascript" type="text/javascript">
  
 function chk(){
	  var xhttp = new XMLHttpRequest();
	p("http://localhost:8200/gettweets")
	  p("http://localhost:8100/tweet");
	  $("#that").load("http://localhost:8200/dashboard2");
	  }
 
	  function p(x){
		  var xhttp = new XMLHttpRequest();
		  xhttp.open("GET", x,true);
		  xhttp.send();
	  }
  
 
 
  </script>
  
    
</body>
</html>