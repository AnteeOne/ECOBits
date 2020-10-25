<%@ page import="tech.anteeone.ecobits.repositories.UserRepository" %>
<%@ page import="tech.anteeone.ecobits.models.User" %>
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
    <%
        User user = (User) new UserRepository().getUserFromSession(session.getAttribute("user_session").toString());
    %>
</head>

<body>
<div id="navigation-block">
    <nav class="navbar navbar-light navbar-expand-md">
        <div class="container-fluid"><a class="navbar-brand" style="font-family:Bungee, cursive;" href="#">ecobits</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                    class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Quests</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">EcoShop</a></li>
                </ul>
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link active" href="#"><%=user.getBitsCount()%> bits</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><%=user.getUsername()%></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<section style="margin-top: 50px;">
    <div class="container">
        <div class="row">
            <c:forEach var="quest" items="${requestScope.get('questList')}">
            <div class="col-lg-4">
                <div class="card mb-4 box-shadow rounded-0"><img class="card-img-top w-100 d-block rounded-0" src="${pageContext.request.contextPath}/assets/img/quest.jpg">
                    <div class="card-body">
                        <h4 class="card-title">${quest.title}</h4>
                        <h6 class="text-muted card-subtitle mb-2">${quest.description}</h6>
                        <p class="card-text">${quest.bitsReward} bits</p><a class="card-link" href="#">Link</a></div>
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
