<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - PET</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR PET</h1>
       <form name="fetchPet" action="validateFetchPet.jsp" method="post">
           NOME <input type="text" name ="NAME" value=""> <br>
           <input type="submit" name ="SEND" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
