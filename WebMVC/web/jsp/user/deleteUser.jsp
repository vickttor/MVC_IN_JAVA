<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.User"%>
<%@page import="padraomvc.controller.ControllerUser"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    User user = new User(id);
    ControllerUser controller = new ControllerUser();
    
    controller.delete(user);
    
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validateFetchUser.jsp?LOGIN=" + pbusca;
    response.sendRedirect(url);
%>