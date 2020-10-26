<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bungee">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>
<body>
    <c:import url="header.jsp"/>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
