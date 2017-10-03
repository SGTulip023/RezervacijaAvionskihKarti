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
            
            <p id="uspeh">${uspesnaIzmenaLeta}</p>
            <p id="uspeh">${brisanje}</p>
            <p id="uspeh">${brisanjeKarte}</p>
            <p id="greskaReg">${postojiRezervacija}</p>

            <div class="group" id="izmenaLeta">
                <table id="myTable">
                    <thead>
                    <th>Kompanija</th>
                    <th>Destinacija</th>
                    <!--<th>Datum</th>-->
                    <th>Cena</th>
                    <th>Kolicina</th>
                    <th>Kapacitet</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${letovi}" var="a">
                        <tr>
                        <form action="izmenaLeta" method="POST">
                            <td>
                                <input type="hidden" value="${a.kompanijaId}" name="kompanijaId" />
                                <input type="text" value="${a.kompanijaId.kompanijaNaziv}" name="kompanijaNaziv" />
                            </td>
                            <td>
                                <input type="hidden" value="${a.destinacijaId}" name="destinacijaId" />
                                <input type="text" value="${a.destinacijaId.destinacijaNaziv}" name="destinacijaNaziv"/>
                            </td>
                            
                            <td>
                                <input type="text" value="${a.letCena}" name="letCena" />
                            </td>
                            <td>
                                <input type="text" value="${a.letKolicina}" name="letKolicina" />
                            </td>
                            <td>
                                <input type="text" value="${a.letKapacitet}" name="letKapacitet" />
                            </td>
                            <td>
                                <input type="submit" value="Izmeni" />
                            </td>
                        </form>
                        <form action="brisanjeLeta" method="POST">
                            <td>
                                <input type="hidden" value="${a.letId}" name="letId" />
                                <input type="submit" value="Izbrisi" />
                            </td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div> 

        </div>

    </body>
</html>
