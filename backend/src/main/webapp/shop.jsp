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
                <%for (int i = 0; i < 10 ; i++) {%>

                <div class="col-sm-6 col-md-4 item"><a href="#"><img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/order.jpg"></a>
                    <h3 class="name">Eco sweatshirt</h3>
                    <p class="description">Cool sweatshirt , that was made of a lot of trash and garbage</p>
                    <p class="description"><strong>47 bits</strong></p><a class="action" href="#"><i class="fa fa-arrow-circle-right"></i></a></div>
                <%}%>
            </div>
        </div>
    </div>
    <c:import url="components/scripts.jsp"></c:import>
</body>
</html>
