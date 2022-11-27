<%-- 
    Document   : findBill.jsp
    Created on : Nov 6, 2022, 5:50:13 PM
    Author     : ducke
--%>

<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Search Bill</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <%
            if(request.getParameter("err")!=null&&request.getParameter("err").equalsIgnoreCase("fail")){
        %> 
        <h4 style="color:red;" > Hóa đơn không tồn tại</h4>
        
        <%}%>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: tomato">
                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/cashierHome.jsp"
                           class="nav-link">Home</a></li>
                </ul>
            </nav>
        </header>
            <%
                User user = (User) session.getAttribute("user");
                if (user == null) {
                    response.sendRedirect("dangnhap.jsp?err=timeout");
                }
            %>
        <h4 class="text-right" > Welcome <%=user.getName()%> </h4>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form name="findbill" action="doFindBill.jsp" method="post">
                        <caption>
                            <h2>
                                Search Bill
                            </h2>
                        </caption>
                    
                        <fieldset class="form-group">
                            <label>Bill ID</label> 
                            <input type="text"  class="form-control" name="billid">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Search</button>
                    </form>
                </div>
            </div>
        </div>     
    </body>
</html>