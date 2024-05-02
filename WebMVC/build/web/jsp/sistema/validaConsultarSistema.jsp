
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.model.bean.Sistema"%>
<%@page import="padraomvc.controller.ControllerSistema"%>

<%
    String nome = request.getParameter("NOME");
    Sistema sis = new Sistema(nome);
    ControllerSistema siscont = new ControllerSistema();
    List<Object> listaSistema = siscont.listar(sis);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + sis.getNome()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA SISTEMAS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Servidor">Servidor</th>
                  <th data-field="Status">Status</th>
                  <th data-field="Ip">Ip</th>
                  <th data-field="delete">delete</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaSistema.isEmpty())) { %>    
                <tbody>
                    <% for (Object sisObj : listaSistema) {
                        Sistema sisSaida = (Sistema) sisObj;
                    %>
                    <tr>
                            <td><%=sisSaida.getId()%></td>
                            <td><%=sisSaida.getNome()%></td>
                            <td><%=sisSaida.getServidor()%></td>
                            <td><%=sisSaida.getStatus()%></td>
                            <td><%=sisSaida.getIp()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="deleteSistema.jsp?<%=url + sisSaida.getId()%>">delete</a></td>
                                <td><a href="alterarSistema.jsp?<%=url + sisSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>