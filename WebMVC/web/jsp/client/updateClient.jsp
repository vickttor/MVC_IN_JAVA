<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.controller.ControllerClient"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Client client = new Client(id);
    ControllerClient controller = new ControllerClient();
    client = (Client) controller.fetch(client);
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - SISTEMA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR SISTEMA</h1>
        <form name="updateClient" action="validateUpdateClient.jsp" method="post">
            Nome: <input type="text" name="NAME" value="<%=client.getName()%>"> <br>
            CPF: <input type="text" name="CPF" value="<%=client.getCpf()%>"> <br>
            TEL: <input type="text" name="TEL" value="<%=client.getTel()%>"> <br>
            ADDRESS: <input type="text" name="ADDRESS" value="<%=client.getAddress()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=client.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="SEND" value="OK">
        </form>
        <div>
    </body>
</html>