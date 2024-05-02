<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>

<%
    String cod = request.getParameter("ID");
    
    String oldName = request.getParameter("NAME");
    String oldGender = request.getParameter("GENDER");
    String oldAge = request.getParameter("AGE");

    int id = Integer.parseInt(cod);
    Pet pet = new Pet(id);
    ControllerPet controller = new ControllerPet();
    pet = (Pet) controller.fetch(pet);
    String pbusca = request.getParameter("PBUSCA");
    

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - PET</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR PET</h1>
        <form name="updatePet" action="validateUpdatePet.jsp" method="post">
            Nome: <input type="text" name="NAME" value="<%=oldName%>"> <br/>
                          
            <input type="radio" id="male" name="GENDER" value="Male" <% if (oldGender.equals("Male")) { %> checked <% } %>/>
            <label for="male" style="margin-right: 20px;">Macho</label>
           
            <input type="radio" id="female" name="GENDER" value="Female" <% if (oldGender.equals("Female")) { %> checked <% } %>/>
            <label for="female">Fêmea</label> <br/> <br/>
            
            Idade: <input type="number" min="0" max="50" name="AGE" value="<%=oldAge%>"> <br>

            <input type="HIDDEN" name="ID" value="<%=pet.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="SEND" value="OK">
        </form>
        <div>
    </body>
</html>