<%-- 
    Document   : todo_form
    Created on : Nov 16, 2020, 10:34:20 AM
    Author     : NAM
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TODO_FORM</title>
    </head>
    <body>
        <header>
            <nav style="background-color: tomato">
                <div>
                    <h3>TODO_FORM</h3>
                </div>
                
                <div>
                    <ul>
                        <li><a href="<%= request.getContextPath()%>/logout">LOGOUT</a></li>
                    </ul>
                </div>
            </nav>
        </header>
                    
        <div>
            <c:if test="${todo != null}">
                <form action="update" method="post"> 
            </c:if>
             
            <c:if test="${todo == null}">
                <form action="insert" method="post">       
            </c:if>
                    
                    <caption>
                        <h2>
                            <c:if test="${todo != null}">
                                EDIT TODO
                            </c:if>
                            <c:if test="${todo == null}">
                                ADD NEW TODO
                            </c:if>    
                        </h2>
                    </caption>
                <c:if test="${todo != null}">
                     <input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
                </c:if>
                    
                    <fieldset>
                        <label>Todo Title</label>
                        <input type="text" name="title" value="<c:out value='${todo.title}'/>" placeholder="title" required>
                    </fieldset>
                    
                    <fieldset>
                        <label>Todo Description</label>
                        <input type="text" name="description" value="<c:out value='${todo.description}'/>" placeholder="dexcription" required>
                    </fieldset>
                    
                    <fieldset>
                        <label>Todo Status</label>
                        <select name="is_done">
                            <option value="false">In progress</option>
                            <option value="true">Complete</option>
                        </select>
                    </fieldset>
                    
                    <fieldset>
                        <label>Target Date</label>
                        <input type="date" name="target_date" value="<c:out value='${todo.targetDate}'/>" required>
                    </fieldset>
                    
                    <button type="submit">Save</button>
                
                    
        </div>
    </body>
</html>