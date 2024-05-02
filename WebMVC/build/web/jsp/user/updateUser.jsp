<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.controller.ControllerUser"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    User user = new User(id);
    ControllerUser controller = new ControllerUser();
    user = (User) controller.fetch(user);
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR USUÁRIO</h1>
        <form name="updateUser" action="validateUpdateUser.jsp" method="post">
            Login: <input type="text" name="LOGIN" value="<%=user.getLogin()%>"> <br>
            Senha: <input type="password" name="PASSWORD" value="<%=user.getPassword()%>"> <br>
            Status: <input type="text" name="STATUS" value="<%=user.getStatus()%>"> <br>
            Tipo: <input type="text" name="TYPE" value="<%=user.getType()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=user.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="SEND" value="OK">
        </form>
        <div>
    </body>
</html>