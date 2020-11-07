<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="components/styles.jsp"></c:import>
</head>
<body>
    <c:import url="components/header.jsp"></c:import>

    <section style="margin-top: 50px;">
        <div class="container">

            <c:if test= "${requestScope.get('activeQuest') != null}">
            <div class="card text-center" style="margin-top: 30px">
                <div class="card-header">
                    <h2>Active Quest</h2>
                </div>
                
                <div class="card-body">
                    <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/1081590/header.jpg?t=1557946900" class="card-img-top" alt="quest" style="width: auto;margin-bottom: 5px">
                    <h5 class="card-title">${requestScope.get("activeQuest").title}</h5>
                    <p class="card-text">${requestScope.get("activeQuest").description}</p>
                </div>

                <div class="card-footer text-muted">
                        ${requestScope.get("activeQuest").bitsReward} bits
                </div>

            </div>
            </c:if>


            <div class="card text-center" style="margin-top: 30px;margin-bottom: 50px">

                <div class="card-header">
                    <h2>My Skills</h2>
                </div>

                <div class="card-body">
                    <div class="progress" style="height: 20px;margin-top: 10px">
                        <div class="progress-bar bg-warning progress-bar-striped progress-bar-animated" role="progressbar" style="width: ${requestScope.get("").completedQuestsCount}%">Quests Completed</div>
                    </div>

                    <div class="progress" style="height: 20px;margin-top: 10px">
                    <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" role="progressbar" style="width: 10%">Eco Level</div>
                </div>

                <div class="progress" style="height: 20px;margin-top: 10px">
                    <div class="progress-bar bg-info progress-bar-striped progress-bar-animated" role="progressbar" style="width: 75%">Support Level</div>
                    </div>
                 </div>
            </div>

            <div class="card text-center" style="margin-top: 30px;margin-bottom: 50px">

                <div class="card-header">
                    <h2>My Achievements</h2>
                </div>

                    <div class="card-body" style="display: flex;justify-content: center">
                        <c:forEach var="achieve" items="${requestScope.get('achievementsList')}">
                        <div class="card w-50" style="margin: 2px">
                            <div class="card-body">
                                <h5 class="card-title">${achieve.title}</h5>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
            </div>


        </div>

    </section>

    <c:import url="components/scripts.jsp"></c:import>
</body>
</html>
