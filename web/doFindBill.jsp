<%-- 
    Document   : doFindBill.jsp
    Created on : Nov 6, 2022, 6:53:26 PM
    Author     : ducke
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<% 
    String billID = (String)request.getParameter("billid");
    BillDAO billDAO = new BillDAO();
    Bill bill = billDAO.searchBillByID(billID);
    if(bill.getCashier()!= null){
        session.setAttribute("bill", bill);
        response.sendRedirect("billDetail.jsp");
    }else{
        response.sendRedirect("findBill.jsp?err=fail");
    }
%>

