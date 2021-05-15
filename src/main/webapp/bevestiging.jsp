<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css.css">
</head>
<nav><li><a href="GeneralController?Commando=home">Home</a><div class="active"></div></li>
    <li><a href="GeneralController?Commando=tweede">Voeg toe</a></li>
    <li><a href="GeneralController?Commando=overzicht">Overzicht</a></li>
    <li><a href="GeneralController?Commando=search">zoek</a></li>
</nav>
<body>
<div>
    <main>
        <h1>Bevestig</h1>
        <p>
            Ben je zeker dat je ${nummerplaat} wilt verwijderen?
        </p>
        <form class="conf" action="GeneralController?Commando=removeGarage&nummerplaat=${nummerplaat}" method="POST">
            <button type="submit" value="yes">Bevestig</button>
            <button class="noButton" value="no"><a href="GeneralController?Commando=overzicht">Annuleer</a></button>
        </form>
    </main>
</div>

</body>
</html>
