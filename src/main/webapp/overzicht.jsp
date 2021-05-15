<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <title>Pagina 2</title>
</head>
<jsp:include page="Header.jsp">
    <jsp:param name="actual" value="Home"/>
</jsp:include>
<h1>Bekijk de garage-Inhoud</h1>

<table>
    <thead>
    <tr>
        <th>Automerk:</th>
        <th>Model:</th>
        <th>Nummerplaat:</th>
        <th>Rating:</th>
        <th>Pas aan:</th>
        <th>Verwijder:</th>
    </tr>
    </thead>

    <tbody>

    <c:if test="${not empty garages}">
        <c:forEach items="${garages}" var="garage">
            <tr>

                <td>${garage.getAutomerk()}
                </td>
                <td>${garage.getModel()}
                </td>
                <td>${garage.getNummerplaat()}
                </td>
                <td>${garage.getRating()}
                </td>
                <td>
                    <a href="GeneralController?Commando=editPage&oldNummerplaat=${garage.getNummerplaat()}">
                        Pas aan
                    </a>
                </td>
                <td>
                    <a href="GeneralController?Commando=bevestiging&nummerplaat=${garage.getNummerplaat()}">
                        verwijder
                    </a>
                </td>
            </tr>
        </c:forEach>
    </c:if>


    </tbody>

</table>
</html>
