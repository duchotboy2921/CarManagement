<%-- 
    Document   : cashierHome.jsp
    Created on : Nov 6, 2022, 5:41:38 PM
    Author     : ducke
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cashier Home</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
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
        <h2 class="text-center"> Cashier Home </h2>
        <div class="container text-center">
           <button class="btn btn-success" onclick="openPage('findBill.jsp')">Find Bill</button> 
        </div>
        

    </body>
    <script type="text/javascript">
        function openPage(pageURL)
        {
            window.location.href = pageURL;
        }
    </script>
</html>
