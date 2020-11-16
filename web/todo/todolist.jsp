<%-- 
    Document   : todolist
    Created on : Nov 15, 2020, 3:27:58 PM
    Author     : NAM
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo List</title>
    </head>
    <body>
        <header>
            <nav style="background-color: tomato">
                <div>
                    <h2>Todo_list</h2>
                </div>
                
                <div>
                    <ul>
                        <li><a href="<%= request.getContextPath()%>/logout">Logout</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        
        <div>
            <h2>List of Todo</h2>
            <hr>
            <div>
                <a href="<%= request.getContextPath()%>/new">Add Todo</a>
            </div>
            
            <table border='2' >
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Target date</th>
                        <th>Todo status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                
                <tbody>
                    
                    <c:forEach var="todo" items="${listTodo}">
                        <tr>
                            <td><c:out value="${todo.title}" /></td>
                            <td><c:out value="${todo.targetDate}" /></td>
                            <td><c:out value="${todo.isDone}" /></td>
                            <td><a href="edit?id=<c:out value='${todo.id}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="delete?id=<c:out value='${todo.id}' />">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
