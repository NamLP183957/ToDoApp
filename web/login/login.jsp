<%-- 
    Document   : login
    Created on : Nov 15, 2020, 3:06:38 PM
    Author     : NAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../common/header.jsp"></jsp:include>
        
        <div>
            <h2>LOGIN_FORM</h2>
            
            <form action="<%= request.getContextPath()%>/login" method="post">
            
             <label for="uname">User Name:</label> <input type="text" id="username" placeholder="User Name" name="username" required><br>
             <label for="uname">Password: </label> <input type="password" id="password" placeholder="password" name="password" required>
             
             <button type="submit">LOGIN</button>
            </form>
        </div>
    </body>
</html>
