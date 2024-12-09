<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="no">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Deltagerliste</title>
</head>

<body>
    <div class="content-container">
        <div class="container">
            <p>Innlogget som: ${brukernavn} / ${deltager.fornavn} ${deltager.etternavn}</p>
            <h2>Deltagerliste</h2>

            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Kjønn</th>
                            <th align="left">Navn</th>
                            <th align="left">Mobil</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${deltagerListe}" var="deltagere">
                            <c:choose>
                                <c:when test="${deltagere.tlf == deltager.tlf}">
                                    <tr class="highlight">
                                        <td align="center">
                                            <c:choose>
                                                <c:when test="${deltagere.kjonn == 'mann'}">&#9794;</c:when>
                                                <c:when test="${deltagere.kjonn == 'kvinne'}">&#9792;</c:when>
                                            </c:choose>
                                        </td>
                                        <td>${deltagere.fornavn} ${deltagere.etternavn}</td>
                                        <td>${deltagere.tlf}</td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td align="center">
                                            <c:choose>
                                                <c:when test="${deltagere.kjonn == 'mann'}">&#9794;</c:when>
                                                <c:when test="${deltagere.kjonn == 'kvinne'}">&#9792;</c:when>
                                            </c:choose>
                                        </td>
                                        <td>${deltagere.fornavn} ${deltagere.etternavn}</td>
                                        <td>${deltagere.tlf}</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <br>
            <form action="utlogging" method="post">
                <button type="submit" class="logout-button">Logg ut</button>
            </form>
        </div>
    </div>
</body>

</html>
