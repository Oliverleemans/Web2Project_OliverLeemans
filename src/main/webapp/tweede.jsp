<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css.css">
    <title>Boeg</title>
</head>
<body>
<jsp:include page="Header.jsp">
    <jsp:param name="actual" value="Home"/>
</jsp:include>
<main>
    <section>
        <h1>Voeg Auto Toe</h1>
        <hr>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul class="errors-view">
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
            <hr>
        </c:if>
        <form action="GeneralController?command=add" novalidate method="post">
            <input type="hidden" value="addGarage" name="Commando">
            <div class="row">
                <div class="column" ${automerkClass} >
                    <label for="merk">Merk:</label>
                    <input type="text" id="merk" name="merk" value="${automerkPreviousValue}" placeholder="Merk...">

                    <label for="model">Model</label>
                    <input type="text" id="model" name="model" value="${modelPreviousValue}" placeholder="Model...">
                </div>
                <div class="column">
                    <label for="nummerplaat">Nummerplaat</label>
                    <input type="text" id="nummerplaat" name="nummerplaat" value="${nummerplaatPreviousValue}"
                           placeholder="Nummerplaat...">
                    <label for="Rating">Rating</label>
                    <select id="Rating" name="rating">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                    <input type="submit">
                </div>
            </div>
        </form>
    </section>

</main>
</body>
</html>
