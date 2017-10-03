<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid" id="top">
    <h1>AirMare</h1>
    <h3>Sigurno letenje, jos sigurnije sletanje! XD</h3>
    <p id="ph">Hodor! Hodor hodor, hodor hodor; hodor hodor?! Hodor, hodor hodor hodor; hodor hodor hodor hodor... Hodor hodor hodor, hodor, hodor hodor. Hodor! Hodor hodor, hodor... Hodor hodor hodor - hodor. Hodor. Hodor! Hodor hodor, hodor; hodor HODOR hodor, hodor hodor, hodor, hodor hodor. Hodor hodor - hodor hodor; hodor hodor? Hodor hodor - hodor; hodor hodor, hodor. Hodor hodor, hodor. Hodor hodor. Hodor, hodor. Hodor. Hodor, hodor - hodor? Hodor, hodor hodor hodor; hodor hodor hodor? Hodor, hodor - hodor hodor hodor, hodor, hodor hodor. </p>
</div>

<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
    <div class="wrapper">
        <ul class="nav navbar-nav">
            <li class="active"><a href="index">Basic Topnav</a></li>
            <li><a href="index">Home</a></li>
            <li><a href="avioLetovi">Lista avio letova</a></li>
        </ul>

        <!-- ukoliko korisnik nije ulogovan ne moze da ima dostupno logout, 
        u slucaju da je admin dodatno mu se pojavljuje administracija --> 
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${not empty sessionScope.korisnik.korEmail}">
                <li><a id="ulogovan" href="#">Dobrodosao/la ${sessionScope.korisnik.korIme}</a></li>
            </c:if>
            <c:choose>
                <c:when test="${empty sessionScope.korisnik.korEmail}">
                    <li><a href="registracija">Registracija</a></li>
                    <li><a href="login">Login</a></li>
                </c:when>
                <c:otherwise>  
                    <c:if test="${sessionScope.korisnik.korTip eq 'admin'}">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administracija
                            <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="dodajLet">Dodavanje novog leta</a></li>
                                <li><a href="izmenaLeta">Izmena postojeceg leta</a></li>
                                <li><a href="pregledRezervacija">Pregled rezervacija</a></li>
                                <li><a href="izmenaKorisnika">Pregled korisnika</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <li><a href="logout">Logout</a></li>
                    </c:otherwise>
            </c:choose>

        </ul>
    </div>
</nav>