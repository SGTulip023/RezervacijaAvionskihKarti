<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="header.jsp"/>
    </head>

    <body>

        <jsp:include page="navmenu.jsp" />

        <div class="wrapper">
            
           <div class="group" id="pregledRezervacija">
                <table class="table table-hover">
                    <thead>
                        <th>Kompanija</th>
                        <th>Destinacija</th>
                        <th>Datum leta i vreme</th>
                        <th>Korisnik</th>
                        <th>Kolicina</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${karte}" var="karta" varStatus="status">

                            <tr>
                                <td>${karta.letId.kompanijaId.kompanijaNaziv}</td>
                                <td>${karta.letId.destinacijaId.destinacijaNaziv}</td>
                                <td>
                                    <fmt:formatDate pattern="dd-MM-yyyy" value="${karta.letId.letDatum}" />
                                    <fmt:formatDate pattern="HH:mm" value="${karta.letId.letDatum}" />
                                </td>
                                <td>
                                    ${karta.korId.korIme} ${karta.korId.korPrezime}
                                </td>
                                <td>${karta.karKolicina}</td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>

    </body>
</html>
