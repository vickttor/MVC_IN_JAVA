<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LOGIN - Clínica Veterinária</title>
    <body>
        <div class="container"/>
            <h1>LOGIN</h1>
            <form name="FORMLOGIN" action="menu.jsp" method="post">
                LOGIN: <input type="text" name ="LOGIN"> <br>
                SENHA: <input type="password" name ="PASSWORD"> <br>
                <input type="submit" name="SEND" value="ENVIAR">
            </form>
        </div>
    </body>
</html>
