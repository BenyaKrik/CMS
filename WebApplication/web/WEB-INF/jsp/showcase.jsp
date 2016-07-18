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

        <%@include file="/WEB-INF/jspf/css.jspf" %>
    </head>
    <body>
        <div class="container">
            <h1>My little Shop!</h1>
            <a href="${pageContext.servletContext.contextPath}/phone/add " class="btn btn-secondary btn-lg active" role="button"><i class="fa fa-fw fa-plus"> add new </i></a>
            <div class="row">
                <div class="col-md-3">
                    <c:forEach items="${brandList}" var="brand">

                        <a href="${pageContext.servletContext.contextPath}/?brand_id=${brand.id}">
                            ${brand.name}
                        </a> </br>

                    </c:forEach>

                </div>
                <div class="col-md-9"> 
                    <table class="table table-striped table-hover">
                        <thead>
                        <th>#</th>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>Cost</th>
                        <th>Price</th>
                        <th style="width: 1%;"></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${phoneList}" var="phone">
                                <tr>
                                    <td>${phone.id}</td>
                                    <td>${phone.brand.name}</td>
                                    <td>${phone.model}</td>
                                    <td><fmt:formatNumber value="${phone.cost}" type="currency" currencySymbol="$" /></td>
                                    <td>$${phone.cost + 100}</td>
                                    <td nowrap>
                                        <a href="${pageContext.servletContext.contextPath}/phone/edit?id=${phone.id}" class="btn btn-xs btn-warning">
                                            <i class="fa fa-fw fa-edit"></i>
                                        </a>
                                        <a href="${pageContext.servletContext.contextPath}/phone/remove?id=${phone.id}" class="btn btn-xs btn-danger"
                                           onclick="return confirm('Do you really want remove \'${phone.brand.name} ${phone.model}\' phone?');">
                                            <i class="fa fa-fw fa-trash"></i>
                                        </a>

                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot>

                        </tfoot>
                    </table>
                </div>
            </div>
            <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
