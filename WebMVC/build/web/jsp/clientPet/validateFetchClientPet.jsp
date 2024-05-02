<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.controller.ControllerClient"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>
<%@page import="padraomvc.model.bean.ClientPet"%>
<%@page import="padraomvc.controller.ControllerClientPet"%>

<%
    String obs = request.getParameter("OBS");
    ClientPet clientPet = new ClientPet(obs);
    ControllerClientPet clientPetController = new ControllerClientPet();
    List<Object> clientPetList = clientPetController.list(clientPet);
    
    User loggedUser = (User) session.getAttribute("LOGGED_USER");
    String url = "PBUSCA=" + clientPet.getObs()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA PETS de Clientes</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdClientPet">Id</th>
                  <th data-field="IdC">Id Cliente</th>
                  <th data-field="Login">Login</th>
                  <th data-field="IdP">Id Pet</th>
                  <th data-field="Name">Nome</th>
                  <th data-field="Observation">Observação</th>
                  <th data-field="Delete">Excluir</th>
                  <th data-field="Update">Alterar</th>
              </tr>
            </thead>
            <% if (!(clientPetList.isEmpty())) { %>    
                <tbody>
                    <% for (Object clientPetObj : clientPetList) { 
                        ClientPet clientPetItem = (ClientPet) clientPetObj;
                        Client clientItem = (Client) clientPetItem.getClient();
                        Pet petItem = (Pet) clientPetItem.getPet();
                        %>
                        <tr>
                            <td><%=clientPetItem.getId()%></td>
                            <td><%=clientPetItem.getIdC()%></td>
                            <td><%=clientItem.getName()%></td>
                            <td><%=clientPetItem.getIdP()%></td>
                            <td><%=petItem.getName()%></td>
                            <td><%=clientPetItem.getObs()%></td>
                            <% if (loggedUser.getType().equals("ADM")) { %>
                                <td><a href="deleteClientPet.jsp?<%=url + clientPetItem.getId()%>">Excluir</a></td>
                                <td><a href="updateClientPet.jsp?<%=url + clientPetItem.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>