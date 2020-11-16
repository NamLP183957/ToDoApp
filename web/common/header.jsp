<%-- 
    Document   : header
    Created on : Nov 15, 2020, 2:58:04 PM
    Author     : Nam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <nav style="background-color: tomato">
        
        <div>
            <h3>TODO-APP</h3>
        </div>
        
        <div>
            <ul>
                <li><a href="<%= request.getContextPath()%>/login">LOGIN</a></li>
                <li><a href="<%= request.getContextPath()%>/login">REGISTER</a></li>
            </ul>
        </div>
    </nav>
            
</header>
