<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - PET</title>
    <body>
       <div class="container"/>
        <h1>INSERIR PET</h1>
        <form name="insertPet" action="validateInsertPet.jsp" method="post">
            Nome: <input type="text" name="NAME" value=""> <br/>
                          
            <input type="radio" id="male" name="GENDER" value="Male" checked>
            <label for="male" style="margin-right: 20px;">Macho</label>
           
            <input type="radio" id="female" name="GENDER" value="Female">
            <label for="female">Fêmea</label> <br/> <br/>
            
            Idade: <input type="number" min="0" max="50" name="AGE" value=""> <br>
            <input type="submit" name="SEND" value="OK">
        </form>
        </div>
    </body>
</html>
