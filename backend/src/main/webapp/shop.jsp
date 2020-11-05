<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="components/styles.jsp"></c:import>
</head>
<body>
    <c:import url="components/header.jsp"/>
    <div style="text-align:center;">
        <h2 class="divider-style"><span>ECOShop</span></h2>
    </div>
    <div class="article-list">
        <div class="container">
            <div class="intro">
                <h2 class="text-center">Latest products</h2>
                <p class="text-center">Here you can choose goods for u bits c:</p>
            </div>
            <div class="row articles">
                <c:forEach var="order" items="${requestScope.get('orderList')}">

                    <div class="col-sm-6 col-md-4 item"><a href="#"><img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/order.jpg"></a>
                        <h4 class="card-title">${order.title}</h4>
                        <p class="description">${order.description}</p>
                        <button class="btn btn-info" style="margin-top:10px">${order.bitsPrice} bits</button>
                    </div>

                </c:forEach>
            </div>
        </div>
    </div>
    <c:import url="components/scripts.jsp"></c:import>
</body>
</html>
