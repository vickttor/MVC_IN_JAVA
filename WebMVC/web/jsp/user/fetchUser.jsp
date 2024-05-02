<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR USUÁRIO</h1>
       <form name="fetchUser" action="validateFetchUser.jsp" method="post">
           LOGIN <input type="text" name ="LOGIN" value=""> <br>
           <input type="submit" name ="SEND" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
