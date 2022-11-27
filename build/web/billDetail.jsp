<%-- 
    Document   : billDetail.jsp
    Created on : Nov 7, 2022, 12:03:40 AM
    Author     : ducke
--%>

<%@page import="dao.BillDAO"%>
<%@page import="model.User"%>
<%@page import="model.PurchasedService"%>
<%@page import="model.PurchasedComponent"%>
<%@page import="model.Bill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Bill Detail</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <%
            Bill bill = (Bill)session.getAttribute("bill");
            
        %>
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
        <br>

        <div class="row">		
            <div class="container">
                <h3 class="text-center">Bill Detail</h3>
                <h4 class="text-left">Customer: <%=bill.getCustomer().getName()%></h4>
                <br>
                <h4 class="text-left">Car: <%=bill.getMaintainCar().getCar().getBrand()%></h4>
                <hr>
                <div class="container text-left">

                    <h3>List Component</h3>
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Amount</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>                      
                        <%
                            float total =0;
                            for(PurchasedComponent pc:bill.getMaintainCar().getListPurchasedComponents()){
                               total+=pc.getAmount()*pc.getComponent().getPrice();
                        %>
                        <tr>
                            <td><%=pc.getComponent().getId()%></td>
                            <td><%=pc.getComponent().getName()%></td>
                            <td><%=pc.getComponent().getPrice()%></td>
                            <td><%=pc.getAmount()%></td>
                            <td><%=pc.getAmount()*pc.getComponent().getPrice()%></td>
                            
                        </tr>
                        <%} %>
                    <!-- } -->
                    </tbody>

                </table>
                    <hr>
                <div class="container text-left">
                    <h3>List Service</h3>
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Amount</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>                      
                        <%
                            
                            for(PurchasedService pc:bill.getMaintainCar().getListPurchasedServices()){
                               total+= pc.getAmount()*pc.getService().getPrice();
                        %>
                        <tr>
                            <td><%=pc.getService().getId()%></td>
                            <td><%=pc.getService().getName()%></td>
                            <td><%=pc.getService().getPrice()%></td>
                            <td><%=pc.getAmount()%></td>
                            <td><%=pc.getAmount()*pc.getService().getPrice()%></td>
                            
                        </tr>
                        <%} %>
                    <!-- } -->
                    </tbody>

                </table>
                    <hr>
                <div class="container text-right">

                    <h3>Total: <%=total%></h3>
                    <%if(!bill.isIsPaid()){%>
                      <button class="btn btn-success" onclick="payBill()">Pay Bill</button>  
                    <%}else{%>
                    <h4>Paid</h4>
                    <%}%>
                </div>
            </div>
        </div>
        <script type="text/javascript">
        function payBill()
        {
            <%
                BillDAO billDAO = new BillDAO();
                billDAO.changePaidStatus(bill.getId(), true);
                %>
            window.location.href='findBill.jsp';
            alert("Bill has been paid successfully!");
        }
    </script>
    </body>
</html>
