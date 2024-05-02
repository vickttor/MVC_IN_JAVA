<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - PET do Cliente</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR Pet do Cliente</h1>
       <form name="fetchClientPet" action="validateFetchClientPet.jsp" method="post">
           Observação: <input type="text" name ="OBS" value=""> <br>
           <input type="submit" name ="SEND" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
