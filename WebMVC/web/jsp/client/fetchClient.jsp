<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - SISTEMA</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR SISTEMA</h1>
       <form name="fetchClient" action="validateFetchClient.jsp" method="post">
           NOME <input type="text" name ="NAME" value=""> <br>
           <input type="submit" name ="SEND" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
