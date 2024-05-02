<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.controller.ControllerUser"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("PASSWORD");
    String status = request.getParameter("STATUS");
    String tipo = request.getParameter("TYPE");
    String pbusca = request.getParameter("PBUSCA");

    User usu = new User(id,login,senha,status,tipo);
    ControllerUser controller = new ControllerUser();
    controller.update(usu);
    
  
    String url = "validateFetchUser.jsp?LOGIN=" + pbusca;
    response.sendRedirect(url);
%>