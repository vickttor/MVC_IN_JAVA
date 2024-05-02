<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>
<%@page import="padraomvc.model.bean.PetUsuario"%>
<%@page import="padraomvc.controller.ControllerPetUsuario"%>

<%
    ControllerPet petCont = new ControllerPet();
    Pet pet = new Pet("");
    List<Object> listaPet = petCont.listar(pet);

    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Object> listaUsuario = usuCont.listar(usuEnt);
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR USUARIO PET</title>
    <body>
        <div class="container"/>
            <h1>Inserir Pet Usuário</h1>
            <form name="inseriUsuarioPet" action="validaRelacaoUsuarioPet.jsp" method="POST">
                <table>
                    <tr>
                        <td>Pet:</td>
                        <td>
                            <select NAME ="ID_PET" class="browser-default">
                               <% for (Object petObj : listaPet) {
                                    Pet petOutput = (Pet) petObj;
                                %>
                                    <option value="<%=petOutput.getId()%>"><%=petOutput.getName()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                               <% for (Object usuObj : listaUsuario) {
                                    Usuario usuSaida = (Usuario) usuObj;
                                %>
                                    <option value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
