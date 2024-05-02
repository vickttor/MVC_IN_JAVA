<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - USUÁRIO</title>
    <body>
       <div class="container"/>
        <h1>INSERIR USUÁRIO</h1>
        <form name="insertUser" action="validateInsertUser.jsp" method="post">
            Login: <input type="text" name="LOGIN" value=""> <br>
            Senha: <input type="password" name="PASSWORD" value=""> <br>
            Status: <input type="text" name="STATUS" value=""> <br>
            Tipo: <input type="text" name="TYPE" value=""> <br>
            <input type="submit" name="SEND" value="OK">
        </form>
        </div>
    </body>
</html>
