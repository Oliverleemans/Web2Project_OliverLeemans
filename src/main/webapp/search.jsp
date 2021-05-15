<!DOCTYPE html>
<html lang="nl">
<link rel="stylesheet" href="css.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<head>
    <title>Zoek</title>
</head>
<body>
<div class="containerpage">
    <jsp:include page="Header.jsp">
        <jsp:param name="actual" value="Home"/>
    </jsp:include>
    <main>
        <h1>Zoeken</h1>
        <p>Op deze pagina kan je een auto's zoeken op merk.</p>
        <form action="GeneralController?Commando=searchGarage" method = "get">
            <input type = "hidden" name = "Commando" value = "searchGarage">
            <div>
                <label for="searchautomerk">Search by Automerk:</label>
                <input id="searchautomerk" name="automerk" type="text" placeholder="zoek...">
            </div>
            <div>
                <button id="searchSubmit" type="submit" class="bg-blue button-small">
                    <i class="fas fa-search"></i>
                    Search
                </button>
            </div>
        </form>
    </main>
</div>
</body>
</html>