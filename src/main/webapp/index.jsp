<%--
  Created by IntelliJ IDEA.
  User: leema
  Date: 08/03/2021
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="nl">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <title>Mijn Auto Garage</title>
</head>

<body>
<div>
    <jsp:include page="Header.jsp">
        <jsp:param name="actual" value="Home"/>
    </jsp:include>
</div>
<header>
    <h1>Mijn Auto Garage</h1>
</header>
<main>
    <hr>
    <p>Hier kan je te weten komen welke auto's ik momenteel in bezit heb met de nodige informatie.
        Op de pagina overzicht kunt u het overzicht zien van alle auto's en mijn persoonlijke rating
    </p>
    <p>Momenteel is de hoogste gerate wagen: <strong>${HighestRated.getAutomerk()}</strong></p>
    <p>U hebt deze pagina <strong>${visitCount}</strong> keer bezocht.</p>
</main>
</body>

</html>


