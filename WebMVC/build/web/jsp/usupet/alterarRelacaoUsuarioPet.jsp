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
    
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);

    PetUsuario usupet = new PetUsuario(id);
    ControllerPetUsuario usupetcont = new ControllerPetUsuario();
    usupet = (PetUsuario) usupetcont.buscar(usupet);
    
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - PET USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - PET USUÁRIO</h1>
        <form name="alterarUsuarioPet" action="validaAlterarRelacaoUsuarioPet.jsp" method="post">
            <table>
                    <tr>
                        <td>Pet</td>
                        <td>
                            <select NAME ="ID_PET" class="browser-default">
                               <% for (Object petObj : listaPet) {
                                    Pet petOutput = (Pet) petObj;
                               %>
                                   <% if( usupet.getIdP() == petOutput.getId()) { %>
                                        <option selected value="<%=petOutput.getId()%>"><%=petOutput.getName()%></option>
                                   <% } else { %>
                                        <option value="<%=petOutput.getId()%>"><%=petOutput.getName()%></option>
                                   <% } %>
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
                                    <% if( usupet.getIdU()== usuSaida.getId()) { %>
                                        <option selected value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                    <% } else { %>
                                        <option value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                    <% } %>

                               <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=usupet.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=usupet.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>