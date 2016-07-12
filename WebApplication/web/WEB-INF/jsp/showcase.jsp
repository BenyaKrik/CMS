<%-- 
    Document   : index
    Created on : Jul 7, 2016, 10:42:50 AM
    Author     : pavel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <table>
            <thead>
            <th>#</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Cost</th>
            <th>Price</th>
            </thead>
            <tbody>
                <c:forEach items="${phoneList}" var="phone">
                <tr>
                    <td>${phone.id}</td>
                    <td>${phone.brand.name}</td>
                    <td>${phone.model}</td>
                    <td><fmt:formatNumber value="${phone.cost}" type="currency" currencySymbol="$" /></td>
                    <td>$${phone.cost + 100}</td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
                
            </tfoot>
        </table>
    </body>
</html>
