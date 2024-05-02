<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.ClientPet"%>
<%@page import="padraomvc.controller.ControllerClientPet"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    ClientPet clientPet = new ClientPet(id);
    ControllerClientPet ususisCont = new ControllerClientPet();
    ususisCont.delete(clientPet);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validateFetchClientPet.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>

