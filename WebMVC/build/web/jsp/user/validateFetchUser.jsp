
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.controller.ControllerUser"%>

<%
    String login = request.getParameter("LOGIN");
    User user = new User(login);
    ControllerUser controller = new ControllerUser();
    List<Object> userList = controller.list(user);
    User loggedUser = (User) session.getAttribute("LOGGED_USER");
    String url = "PBUSCA=" + user.getLogin()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Login">Login</th>
                  <th data-field="Password">Senha</th>
                  <th data-field="Status">Status</th>
                  <th data-field="Type">Tipo</th>
                  <th data-field="Delete">Excluir</th>
                  <th data-field="Update">Alterar</th>
              </tr>
            </thead>
            <% if (!(userList.isEmpty())) { %>    
                <tbody>
                    <% for (Object userObj : userList) {
                        User userItem = (User) userObj;
                    %>
                    <tr>
                            <td><%=userItem.getId()%></td>
                            <td><%=userItem.getLogin()%></td>
                            <td><%=userItem.getPassword()%></td>
                            <td><%=userItem.getStatus()%></td>
                            <td><%=userItem.getType()%></td>
                            <% if (loggedUser.getType().equals("ADM")) { %>
                                <td><a href="deleteUser.jsp?<%=url + userItem.getId()%>">Excluir</a></td>
                                <td><a href="updateUser.jsp?<%=url + userItem.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>