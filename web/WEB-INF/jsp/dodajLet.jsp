<%-- 
    Document   : dodajLet
    Created on : Sep 19, 2017, 11:09:36 PM
    Author     : GLAVNI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="header.jsp"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="navmenu.jsp"/>

        <div class="wrapper">
            
            <p id="uspeh">${uspesnoDodavanje}</p>
            <p id="greskaReg">${dodavanjeGreska}</p>
            
            <div class="group" id="dodavanjeLeta">
                <form class="form-horizontal" action="dodajLet" method="POST">
                    <div class="form-group">
                        <label for="kompanijaNaziv" class="col-sm-2 control-label">Naziv kompanije</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="kompanijaNaziv" placeholder="Naziv kompanije" name="kompanijaNaziv">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="destinacijaNaziv" class="col-sm-2 control-label">Destinacija</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="destinacijaNaziv" placeholder="Destinacija" name="destinacijaNaziv">
                        </div>
                    </div>
                    <!--
                    <div class="form-group">
                        <label for="letDatum" class="col-sm-2 control-label">Datum leta</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="letDatum" placeholder="YYYY-MM-DD HH:mm" name="letDatum">
                        </div>
                    </div>
                    -->
                    <div class="form-group">
                        <label for="letCena" class="col-sm-2 control-label">Cena leta</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="letCena" placeholder="Cena leta" name="letCena">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="letKapacitet" class="col-sm-2 control-label">Kapacitet</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="letKapacitet" placeholder="Kolicina" name="letKapacitet">
                        </div>
                    </div>                   
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Dodaj novi let</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
