<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>EcoQuests</title>
    <c:import url="components/styles.jsp"></c:import>
</head>

<body>
<c:import url="components/header.jsp"></c:import>
<section style="margin-top: 50px;">
    <div class="container">
        <div style="text-align:center;">
            <h2 class="divider-style"><span>Quests</span></h2>
        </div>
        <div class="row">
            <c:forEach var="quest" items="${requestScope.get('questList')}">


            <div class="col-lg-4">
                <div class="card mb-4 box-shadow rounded-0"><img class="card-img-top w-100 d-block rounded-0" src="${pageContext.request.contextPath}/assets/img/quest.jpg">
                    <div class="card-body">
                        <h4 class="card-title">${quest.title}</h4>
                        <h6 class="text-muted card-subtitle mb-2">${quest.description}</h6>
                        <p class="card-text">${quest.bitsReward} bits</p>
                        <form action="quests?type=choosequest&questid=${quest.id}" method="post">
                            <a href="login"><button type="submit" class="btn btn-primary">Choose a quest!</button></a>
                        </form>
                    </div>
                </div>
            </div>

            </c:forEach>

        </div>
    </div>
</section>
<c:import url="components/scripts.jsp"></c:import>
</body>

</html>
