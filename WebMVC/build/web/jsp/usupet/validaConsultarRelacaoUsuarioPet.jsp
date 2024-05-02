<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>
<%@page import="padraomvc.model.bean.PetUsuario"%>
<%@page import="padraomvc.controller.ControllerPetUsuario"%>

<%
    String obs = request.getParameter("OBS");
    PetUsuario usupet = new PetUsuario(obs);
    ControllerPetUsuario usuPetCont = new ControllerPetUsuario();
    List<Object> listausupet = usuPetCont.listar(usupet);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usupet.getObs()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS - PETS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdUsuSist">Id</th>
                  <th data-field="IdU">IdUsuario</th>
                  <th data-field="Login">Login</th>
                  <th data-field="IdS">IdPet</th>
                  <th data-field="NomeSistema">Nome</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="delete">delete</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listausupet.isEmpty())) { %>    
                <tbody>
                    <% for (Object objUsuPet : listausupet) { 
                        PetUsuario usuPetOutput = (PetUsuario) objUsuPet;
                        Usuario usuOutput = (Usuario) usuPetOutput.getUsu();
                        Pet petOutput = (Pet) usuPetOutput.getPet();
                        %>
                        <tr>
                            <td><%=usuPetOutput.getId()%></td>
                            <td><%=usuPetOutput.getIdU()%></td>
                            <td><%=usuOutput.getLogin()%></td>
                            <td><%=usuPetOutput.getIdP()%></td>
                            <td><%=petOutput.getName()%></td>
                            <td><%=usuPetOutput.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="deleteRelacaoUsuarioPet.jsp?<%=url + usuPetOutput.getId()%>">delete</a></td>
                                <td><a href="alterarRelacaoUsuarioPet.jsp?<%=url + usuPetOutput.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>