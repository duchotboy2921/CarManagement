<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<%
    String username = (String) request.getParameter("username");
    String password = (String) request.getParameter("password");
    System.out.println(username + password);
    UserDAO dao = new UserDAO();
    User user = new User(username, password);
    boolean kq = dao.checkLogin(user);
    System.out.println(kq);
    if (kq && (user.getRole().equalsIgnoreCase("cashier"))) {
        session.setAttribute("user", user);
        response.sendRedirect("cashierHome.jsp");
    } else {
        response.sendRedirect("login.jsp?err=fail");
    }
%>