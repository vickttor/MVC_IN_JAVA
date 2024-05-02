<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.controller.ControllerUser"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("PASSWORD");
    String status = request.getParameter("STATUS");
    String tipo = request.getParameter("TYPE");
    User usu = new User(login,senha,status,tipo);
    ControllerUser controller = new ControllerUser();
    controller.insert(usu);
    
    String url = "insertUser.jsp";
    response.sendRedirect(url);
%>
