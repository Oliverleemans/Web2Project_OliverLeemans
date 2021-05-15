<%--
  Created by IntelliJ IDEA.
  User: leema
  Date: 12/05/2021
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav>
        <ul>
            <li ${param.actual eq 'home'?"id = actual":""}><a href="GeneralController?Commando=home">Home</a><div class="active"></div></li>
            <li ${param.actual eq 'Voeg Toe'?"id = actual":""}><a href="GeneralController?Commando=tweede">Voeg toe</a></li>
            <li ${param.actual eq 'Overzicht'?"id = actual":""}><a href="GeneralController?Commando=overzicht">Overzicht</a></li>
            <li ${param.actual eq 'zoek'?"id = actual":""}><a href="GeneralController?Commando=search">zoek</a></li>
        </ul>
    </nav>
</header>
