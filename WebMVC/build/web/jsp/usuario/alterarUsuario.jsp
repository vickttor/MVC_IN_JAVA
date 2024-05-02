<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id);
    ControllerUsuario usuCont = new ControllerUsuario();
    usu = (Usuario) usuCont.buscar(usu);
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR USUÁRIO</h1>
        <form name="alterarUsuario" action="validaAlterarUsuario.jsp" method="post">
            Login: <input type="text" name="LOGIN" value="<%=usu.getLogin()%>"> <br>
            Senha: <input type="password" name="SENHA" value="<%=usu.getSenha()%>"> <br>
            Status: <input type="text" name="STATUS" value="<%=usu.getStatus()%>"> <br>
            Tipo: <input type="text" name="TIPO" value="<%=usu.getTipo()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=usu.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>