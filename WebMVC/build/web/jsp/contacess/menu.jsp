<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usuEntrada = new Usuario(login,senha);
    ControllerUsuario usucont = new ControllerUsuario();
    Usuario usuSaida = usucont.validarWeb(usuEntrada);
    session.setAttribute("UsuarioLogado",usuSaida);
%>


<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA </title>
    <body>
        <% if (usuSaida != null) { %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Usuário</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Sistema</a> 
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Pet</a>  
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Usuário Sistema</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown5'>Manter Usuário Pet</a>
            
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> InseriUsuario </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> ConsultaUsuario </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> ConsultaUsuario </a></li>
                </ul>
            <% } %>
            
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../sistema/inserirSistema.jsp"> InseriSistema </a></li>
                    <li><a href="../sistema/consultarSistema.jsp"> ConsultaSistema </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../sistema/consultarSistema.jsp"> ConsultaSistema </a></li>
                </ul>
            <% } %>
            
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../pet/inserirPet.jsp"> InserirPet </a></li>
                    <li><a href="../pet/consultarPet.jsp"> ConsultaPet </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../pet/consultarPet.jsp"> ConsultaPet </a></li>
                </ul>
            <% } %>
            
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown4 Structure -->
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../ususis/inserirRelacaoUsuarioSistema.jsp"> InseriUsuarioSistema </a></li>
                    <li><a href="../ususis/consultarRelacaoUsuarioSistema.jsp"> ConsultaUsuarioSistema </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../ususis/consultarRelacaoUsuarioSistema.jsp"> ConsultaUsuarioSistema </a></li>
                </ul>
            <% } %>
            
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown5 Structure -->
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../usupet/inserirRelacaoUsuarioPet.jsp"> InseriUsuárioPet </a></li>
                    <li><a href="../usupet/consultarRelacaoUsuarioPet.jsp"> ConsultaUsuárioPet </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../usupet/consultarRelacaoUsuarioPet.jsp"> ConsultaUsuárioPet </a></li>
                </ul>
            <% } %>
    
        <% } else { %>
            <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>