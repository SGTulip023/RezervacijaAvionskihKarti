<%-- 
    Document   : registracija
    Created on : Aug 13, 2017, 12:40:57 PM
    Author     : GLAVNI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page="header.jsp" />
    </head>
    <body>

        <jsp:include page="navmenu.jsp" />
        <div class="wrapper"> 
            <div class="alert alert-info" role="alert">Registration</div>

            <div class="container">
                <form class="form-horizontal" method="post" action="registracija">
                    
                    <div class="form-group">
                        <label for="inputName" class="col-sm-2 control-label">Name:</label>
                        <div class="col-sm-6">
                            <input type="name" class="form-control" id="inputName" placeholder="Name" name="korIme" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputSurname" class="col-sm-2 control-label">Surname:</label>
                        <div class="col-sm-6">
                            <input type="name" class="form-control" id="inputSurname" placeholder="Surname" name="korPrezime" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label">Email:</label>
                        <div class="col-sm-6">
                            <input type="email" class="form-control" id="inputEmail" placeholder="Mail" name="korEmail" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label">Password:</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="korPassword" />
                        </div>
                    </div>
                    <div class="form-group">
                    <div class="col-sm-offset-7 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>

                </form>  
                
                <p id="greskaReg">${greska}</p>

            </div>
        </div>
        
    </body>
</html>
