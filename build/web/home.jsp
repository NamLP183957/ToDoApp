<%-- 
    Document   : home
    Created on : Oct 16, 2020, 9:37:01 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>
            <p> ${NOTIFICATION}</p>
        </div>
        <form action="<%=request.getContextPath()%>/login" method="post">
            
            <div>
                <label>UserName: </label>
                <input type="text" name="firstName">
            </div>
            
            <div> 
                <label>Password: </label>
                <input type="password" name="password">
            </div>
            
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
