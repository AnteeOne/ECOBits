<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>EcoQuests</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bungee">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body>
<c:import url="header.jsp"></c:import>
<section style="margin-top: 50px;">
    <div class="container">
        <div class="row">
            <c:forEach var="quest" items="${requestScope.get('questList')}">
            <div class="col-lg-4">
                <div class="card mb-4 box-shadow rounded-0"><img class="card-img-top w-100 d-block rounded-0" src="${pageContext.request.contextPath}/assets/img/quest.jpg">
                    <div class="card-body">
                        <h4 class="card-title">${quest.title}</h4>
                        <h6 class="text-muted card-subtitle mb-2">${quest.description}</h6>
                        <p class="card-text">${quest.bitsReward} bits</p>
                        <a href="login"><button type="button" class="btn btn-primary">Take a quest!</button></a>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>

</html>
