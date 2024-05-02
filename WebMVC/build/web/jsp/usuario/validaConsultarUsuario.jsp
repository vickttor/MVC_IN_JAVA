
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    Usuario  usu = new Usuario(login);
    ControllerUsuario usucont = new ControllerUsuario();
    List<Object> listaUsuario = usucont.listar(usu);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usu.getLogin()+"&ID=" ;
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
                  <th data-field="Senha">Senha</th>
                  <th data-field="Status">Status</th>
                  <th data-field="Tipo">Tipo</th>
                  <th data-field="delete">delete</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaUsuario.isEmpty())) { %>    
                <tbody>
                    <% for (Object usuObj : listaUsuario) {
                        Usuario usuSaida = (Usuario) usuObj;
                    %>
                    <tr>
                            <td><%=usuSaida.getId()%></td>
                            <td><%=usuSaida.getLogin()%></td>
                            <td><%=usuSaida.getSenha()%></td>
                            <td><%=usuSaida.getStatus()%></td>
                            <td><%=usuSaida.getTipo()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="deleteUsuario.jsp?<%=url + usuSaida.getId()%>">delete</a></td>
                                <td><a href="alterarUsuario.jsp?<%=url + usuSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>