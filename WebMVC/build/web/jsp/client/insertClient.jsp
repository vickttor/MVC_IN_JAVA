<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - SISTEMA</title>
    <body>
       <div class="container"/>
        <h1>INSERIR SISTEMA</h1>
        <form name="insertClient" action="validateInsertClient.jsp" method="post">
            Nome: <input type="text" name="NAME" value=""> <br>
            CPF: <input type="text" name="CPF" value=""> <br>
            TEL: <input type="text" name="TEL" value=""> <br>
            ADDRESS: <input type="text" name="ADDRESS" value=""> <br>
            <input type="submit" name="SEND" value="OK">
        </form>
        </div>
    </body>
</html>

