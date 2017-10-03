
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page="header.jsp" />
    </head>
    <body>
        
        <jsp:include page="navmenu.jsp" />
        
        <div class="wrapper">
            <form action="login" method="POST" >

                <table>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="login"/></td>
                    </tr>
                </table>

            </form>
            
            <p id="greskaReg">${logGreska}</p>
        </div>
    </body>
</html>
