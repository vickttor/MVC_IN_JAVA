<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.controller.ControllerClient"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>
<%@page import="padraomvc.model.bean.ClientPet"%>
<%@page import="padraomvc.controller.ControllerClientPet"%>

<%
    ControllerPet petController = new ControllerPet();
    Pet pet = new Pet("");
    List<Object> petList = petController.list(pet);

    ControllerClient clientController = new ControllerClient();
    Client client = new Client("");
    List<Object> clientList = clientController.list(client);
    
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);

    ClientPet clientPet = new ClientPet(id);
    ControllerClientPet clientPetController = new ControllerClientPet();
    clientPet = (ClientPet) clientPetController.fetch(clientPet);
    
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - PET do Cliente</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - PET do Cliente</h1>
        <form name="updateClientPet" action="validateUpdateClientPet.jsp" method="post">
            <table>
                    <tr>
                        <td>Pet: </td>
                        <td>
                            <select NAME ="ID_PET" class="browser-default">
                               <% for (Object petObj : petList) {
                                    Pet petItem = (Pet) petObj;
                               %>
                                   <% if( clientPet.getIdP() == petItem.getId()) { %>
                                        <option selected value="<%=petItem.getId()%>"><%=petItem.getName()%></option>
                                   <% } else { %>
                                        <option value="<%=petItem.getId()%>"><%=petItem.getName()%></option>
                                   <% } %>
                               <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Usuario: </td>
                        <td>
                            <select NAME="ID_CLIENT" class="browser-default">
                               <% for (Object clientObj : clientList) {
                                    Client clientItem = (Client) clientObj;
                               %>
                                    <% if( clientPet.getIdC()== clientItem.getId()) { %>
                                        <option selected value="<%=clientItem.getId()%>"><%=clientItem.getName()%> | <%=clientItem.getCpf()%></option>
                                    <% } else { %>
                                        <option value="<%=clientItem.getId()%>"><%=clientItem.getName()%></option>
                                    <% } %>

                               <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=clientPet.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=clientPet.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="SEND" value="OK">
        </form>
        <div>
    </body>
</html>