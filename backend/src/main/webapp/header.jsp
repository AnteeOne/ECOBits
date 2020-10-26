<%@ page import="tech.anteeone.ecobits.repositories.UserRepository" %>
<%@ page import="tech.anteeone.ecobits.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) new UserRepository().getUserFromSession(session.getAttribute("user_session").toString());
%>
<div id="navigation-block">
    <nav class="navbar navbar-light navbar-expand-md">
        <div class="container-fluid"><a class="navbar-brand" style="font-family:Bungee, cursive;" href="#">ecobits</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                    class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="quests">Quests</a></li>
                    <li class="nav-item"><a class="nav-link" href="shop">EcoShop</a></li>
                </ul>
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link active" href="#"><%=user.getBitsCount()%> bits</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><%=user.getUsername()%></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
