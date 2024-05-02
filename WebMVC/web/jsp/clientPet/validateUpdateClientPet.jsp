<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.ClientPet"%>
<%@page import="padraomvc.controller.ControllerClientPet"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idC = Integer.parseInt(request.getParameter("ID_CLIENT"));
    int idP = Integer.parseInt(request.getParameter("ID_PET"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    
    ClientPet clientPet = new ClientPet(id,idC, idP, obs);
    
    ControllerClientPet clientPetController = new ControllerClientPet();
    clientPetController.update(clientPet);
    
    String url = "validateFetchClientPet.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    