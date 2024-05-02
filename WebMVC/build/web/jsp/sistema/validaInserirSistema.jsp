<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Sistema"%>
<%@page import="padraomvc.controller.ControllerSistema"%>

<%
    String nome = request.getParameter("NOME");
    String servidor = request.getParameter("SERVIDOR");
    String status = request.getParameter("STATUS");
    String ip = request.getParameter("IP");
    Sistema sis = new Sistema(nome, servidor, status, ip);
    ControllerSistema siscont = new ControllerSistema();
    siscont.inserir(sis);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirSistema.jsp";
    response.sendRedirect(url);
%>

