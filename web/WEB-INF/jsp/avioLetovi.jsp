
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avio Letovi</title>

        <jsp:include page="header.jsp"/>

    </head>

    <body>

        <jsp:include page="navmenu.jsp" />
        <div class="wrapper">

            <h1>Prikaz aktuelnih avio letova</h1>

            <table id="myTable">
                <thead>
                    <th>Destinacija</th>
                    <th>Datum polaska</th>
                    <th>Vreme polaska</th>
                    <th>Cena</th>

                    <c:if test ="${not empty sessionScope.korisnik}">
                        <th>Preostalo mesta</th>
                        <th>Narucbina</th>
                    </c:if>
                </thead>
                <c:forEach items="${avioLetovi}" var="a" >

                    <tr>
                        <td>${a.destinacijaId.destinacijaNaziv}</td>
                        <td><fmt:formatDate pattern = "dd-MM-yyyy"  value = "${a.letDatum}" /></td>
                        <td><fmt:formatDate pattern = "HH:mm"  value = "${a.letDatum}" /></td>
                        <td>${a.letCena}</td>
                        <c:if test ="${not empty sessionScope.korisnik}">
                            <c:set var="preostaloKarata" value="${a.letKapacitet - a.letKolicina}" />
                            <td>${preostaloKarata}</td>
                            <!-- max kopovine karata je 25 ili manje u zavisnosti od raspolozive kolicine -->

                            <c:choose>
                                <c:when test="${preostaloKarata lt 25}">
                                    <c:set var="brojKarata" value="${preostaloKarata}" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="brojKarata" value="25" />
                                </c:otherwise> 
                            </c:choose>

                            <c:choose>
                                <c:when test="${brojKarata gt 0}">
                                    <form action="potvrda" method="GET">
                                        <td>
                                            <select name="kolicina">
                                                <c:forEach begin="1" end="${brojKarata}" varStatus="dostupanBroj">
                                                    <option value="${dostupanBroj.index}">${dostupanBroj.index}</option>          
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                            <input type="hidden" value="${a.letId}" name="letId" />
                                            <input type="submit" value="Rezervisi" />                                 
                                        </td>
                                    </form>
                                </c:when>
                                <c:otherwise>                         
                                    <td><img src="${pageContext.request.contextPath}/resources/img/soldout.png" /></td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>                      
                    </tr>
                </c:forEach>
            </table>

        </div>

    </body>
</html>
