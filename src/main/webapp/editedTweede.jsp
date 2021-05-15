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
<h1>Bewererken</h1>
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
<form action="GeneralController?Commando=editGarage&oldNummerplaat=${nummerplaat}" method="post">

    <div class="row">
        <div class="column">
            <label for="merk">Merk</label>
            <input type="text" id="merk" name="merk" placeholder="Merk..."
                   value="${garage.getAutomerk()}">

            <label for="model">Model</label>
            <input type="text" id="model" name="model" placeholder="Model..."
                   value="${garage.getModel()}">
        </div>
        <div class="column">
            <label for="nummerplaat">Nummerplaat</label>
            <input type="text" id="nummerplaat" name="nummerplaat" placeholder="Nummerplaat..."
                   value="${garage.getNummerplaat()}">
            <label for="Rating">Rating</label>
            <select id="Rating" name="rating">
                <option value="1" ${garage.getRating() eq '1'?"selected":""}>1</option>
                <option value="2" ${garage.getRating() eq '2'?"selected":""}>2</option>
                <option value="3" ${garage.getRating() eq '3'?"selected":""}>3</option>
                <option value="4" ${garage.getRating() eq '4'?"selected":""}>4</option>
                <option value="5" ${garage.getRating() eq '5'?"selected":""}>5</option>
                <option value="6" ${garage.getRating() eq '6'?"selected":""}>6</option>
                <option value="7" ${garage.getRating() eq '7'?"selected":""}>7</option>
                <option value="8" ${garage.getRating() eq '8'?"selected":""}>8</option>
                <option value="9" ${garage.getRating() eq '9'?"selected":""}>9</option>
                <option value="10" ${garage.getRating() eq '10'?"selected":""}>10</option>
            </select>
            <input type="submit">
        </div>
    </div>
</form>
</body>
</html>
