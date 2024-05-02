
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.controller.ControllerClient"%>

<%
    String name = request.getParameter("NAME");
    Client client = new Client(name);
    ControllerClient controller = new ControllerClient();
    List<Object> clientList = controller.list(client);
    
    User loggedUser = (User) session.getAttribute("LOGGED_USER");
    String url = "PBUSCA=" + client.getName()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA SISTEMAS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Name">Nome</th>
                  <th data-field="Cpf">CPF</th>
                  <th data-field="Tel">TEL</th>
                  <th data-field="Address">ENDEREÇO</th>
                  <th data-field="Delete">Excluir</th>
                  <th data-field="Update">Alterar</th>
              </tr>
            </thead>
            <% if (!(clientList.isEmpty())) { %>    
                <tbody>
                    <% for (Object clientObj : clientList) {
                        Client clientItem = (Client) clientObj;
                    %>
                    <tr>
                            <td><%=clientItem.getId()%></td>
                            <td><%=clientItem.getName()%></td>
                            <td><%=clientItem.getCpf()%></td>
                            <td><%=clientItem.getTel()%></td>
                            <td><%=clientItem.getAddress()%></td>
                            <% if (loggedUser.getType().equals("ADM")) { %>
                                <td><a href="deleteClient.jsp?<%=url + clientItem.getId()%>">Excluir</a></td>
                                <td><a href="updateClient.jsp?<%=url + clientItem.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>