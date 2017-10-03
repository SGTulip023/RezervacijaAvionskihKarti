<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            
           <p id="uspeh">${izmenaK}</p>

           <div class="group" id="pregledKorisnika">
                <table class="table table-hover">
                    <thead>
                    <th>Ime</th>
                    <th>Prezime</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Tip</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${korisnici}" var="korisnik">
                            <tr>
                                <td>${korisnik.korIme}</td>
                                <td>${korisnik.korPrezime}</td>
                                <td>${korisnik.korEmail}</td>
                                <td>${korisnik.korPassword}</td>
                                <td>${korisnik.korTip}</td>
                                
                            <form action="izmenaKorisnika" method="POST">
                                <td>
                                    <input type="hidden" value="${korisnik.korId}" name="korId" />
                                    <input type="text" name="korTip" value="${korisnik.korTip}" placeholder="Unesi zeljeni tip" />
                                    <input type="submit" value="Izmeni" />
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
