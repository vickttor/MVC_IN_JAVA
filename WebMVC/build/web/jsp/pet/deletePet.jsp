<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    
    Pet pet = new Pet(id);
    ControllerPet controller = new ControllerPet();
    controller.delete(pet);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validateFetchPet.jsp?NAME=" + pbusca;
    response.sendRedirect(url);
%>