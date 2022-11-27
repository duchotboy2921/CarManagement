<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Garage Management</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form name="login" action="doLogin.jsp" method="post">
                        <caption>
                            <h2>
                                Login
                            </h2>
                        </caption>
                        <fieldset class="form-group">
                            <label>UserName</label> <input type="text"
                                                              class="form-control" name="username">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Password</label> 
                            <input type="text"  class="form-control" name="password">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>