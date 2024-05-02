<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.controller.ControllerUser"%>

<%
    String login = request.getParameter("LOGIN");
    String password = request.getParameter("PASSWORD");
    User usuEntrada = new User(login,password);
    ControllerUser controller = new ControllerUser();
    User user = controller.validateWeb(usuEntrada);
    session.setAttribute("LOGGED_USER",user);
%>


<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Clínica Veterinária</title>
    <body>
        <% if (user != null) { %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Usuário</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Cliente</a> 
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Pet</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Pet do Cliente</a>
            
            <% if (user.getType().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../user/insertUser.jsp"> Inserir </a></li>
                    <li><a href="../user/fetchUser.jsp"> Consultar </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../user/fetchUser.jsp"> Consultar </a></li>
                </ul>
            <% } %>
            
            <% if (user.getType().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../client/insertClient.jsp"> Inserir </a></li>
                    <li><a href="../client/fetchClient.jsp"> Consultar </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../client/fetchClient.jsp"> Consultar </a></li>
                </ul>
            <% } %>
            
            <% if (user.getType().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../pet/insertPet.jsp"> Inserir </a></li>
                    <li><a href="../pet/fetchPet.jsp"> Consultar </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../pet/fetchPet.jsp"> Consultar </a></li>
                </ul>
            <% } %>
            
            <% if (user.getType().equals("ADM")) { %>
                <!-- Dropdown4 Structure -->
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../clientPet/insertClientPet.jsp"> Inserir </a></li>
                    <li><a href="../clientPet/fetchClientPet.jsp"> Consultar </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../clientPet/fetchClientPet.jsp"> Consultar </a></li>
                </ul>
            <% } %>
            
        <% } else { %>
            <h1 style="width:100%; text-align:center; margin-top:120px;">USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>