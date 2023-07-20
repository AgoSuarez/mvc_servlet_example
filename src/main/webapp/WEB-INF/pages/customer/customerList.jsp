<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<section id="customer">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Customer List</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Balance</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="customer" items="${customers}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${customer.nombre} ${customer.apellido}</td>
                                    <td><fmt:formatNumber value="${customer.saldo}" type="currency"> </fmt:formatNumber></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ServletController?action=edit&idCustomer=${customer.idCliente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Edit
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Total balance</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${totalBalance}" type="currency"></fmt:formatNumber>
                            </h4>
                        </div>
                    </div>
                    <div class="card text-center bg-success text-white mb-3">
                        <div class="card-body">
                            <h3>Total Customers</h3>
                            <h4 class="display-4">
                                <i class="fas fa-users"></i>
                                <c:out value="${totalCustomers}" ></c:out>
                             </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
                                <jsp:include  page="/WEB-INF/pages/customer/addCustomer.jsp" />