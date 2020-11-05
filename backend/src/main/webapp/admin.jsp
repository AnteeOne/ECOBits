<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="components/styles.jsp"></c:import>
</head>
<body>
    <c:import url="components/header.jsp"></c:import>

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
                            <p class="secondary-text">${quest.bitsReward} bits</p>
                            <form name="deletequest" action="admin?type=deletequest&questid=${quest.id}" method="post">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div style="text-align:center;">
            <h2 class="divider-style"><span>Add Quest</span></h2>
        </div>

        <div class="create-form" style="padding: 50px">
            <form action="admin?type=addquest" name="addquest" method="post">
                <div class="form-group">
                    <label for="quest_title">Title</label>
                    <input type="text" class="form-control" id="quest_title" name="quest_title" placeholder="Enter title">
                </div>
                <div class="form-group">
                    <label for="quest_text">Text</label>
                    <input type="text" class="form-control" id="quest_text" name="quest_text" placeholder="Enter text">
                </div>
                <div class="form-group">
                    <label for="quest_bits">Bits Reward</label>
                    <input type="number" class="form-control" id="quest_bits" name="quest_bits" placeholder="Enter bits reward">
                </div>

                <button type="submit" class="btn btn-primary" style="align-content: center">Submit</button>
            </form>
        </div>
        <div style="text-align:center;">
            <h2 class="divider-style"><span>Shop Orders</span></h2>
        </div>

        <div class="row articles">
            <c:forEach var="order" items="${requestScope.get('orderList')}">

                <div class="col-sm-6 col-md-4 item"><a href="#"><img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/order.jpg"></a>
                    <h4 class="card-title">${order.title}</h4>
                    <p class="description">${order.description}</p>
                    <form action="admin?type=deleteorder&orderid=${order.id}" name="deleteorder" method="post">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>

            </c:forEach>
        </div>

        <div style="text-align:center;">
            <h2 class="divider-style"><span>Add Order</span></h2>
        </div>

        <div class="create-form" style="padding: 50px">
            <form action="admin?type=addorder" name="addorder" method="post">
                <div class="form-group">
                    <label for="quest_title">Title</label>
                    <input type="text" class="form-control" id="order_title" name="order_title" placeholder="Enter title">
                </div>
                <div class="form-group">
                    <label for="quest_text">Text</label>
                    <input type="text" class="form-control" id="order_text" name="order_text" placeholder="Enter text">
                </div>
                <div class="form-group">
                    <label for="quest_bits">Bits Reward</label>
                    <input type="number" class="form-control" id="order_bits" name="order_bits" placeholder="Enter price in bits">
                </div>

                <button type="submit" class="btn btn-primary" style="align-content: center">Submit</button>
            </form>
        </div>

        <div style="text-align:center;">
            <h2 class="divider-style"><span>Active Volunteers</span></h2>
        </div>

        <div class="row">
            <c:forEach var="user" items="${requestScope.get('usersList')}">
            <div class="card w-50" style="margin-bottom: 5px">
                <div class="card-body">
                    <h5 class="card-title">user.username</h5>
                    <a href="#" class="btn btn-primary">Give Bits</a>
                </div>
            </div>
            </c:forEach>

        </div>


    </div>

    <c:import url="components/scripts.jsp"></c:import>
</body>
</html>
