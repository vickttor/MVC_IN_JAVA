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
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR Pet do Cliente</title>
    <body>
        <div class="container"/>
            <h1>Inserir Pet do Cliente</h1>
            <form name="insertClientPet" action="validateInsertClientPet.jsp" method="POST">
                <table>
                    <tr>
                        <td>Pet: </td>
                        <td>
                            <select NAME ="ID_PET" class="browser-default">
                               <% for (Object petObj : petList) {
                                    Pet petItem = (Pet) petObj;
                                %>
                                    <option value="<%=petItem.getId()%>"><%=petItem.getName()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Cliente: </td>
                        <td>
                            <select NAME="ID_CLIENT" class="browser-default">
                               <% for (Object clientObj : clientList) {
                                    Client clientItem = (Client) clientObj;
                                %>
                                    <option value="<%=clientItem.getId()%>"><%=clientItem.getName()%> | <%=clientItem.getCpf()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="SEND" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
