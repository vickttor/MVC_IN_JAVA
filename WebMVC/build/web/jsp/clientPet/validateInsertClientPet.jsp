<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.model.bean.ClientPet"%>
<%@page import="padraomvc.controller.ControllerClientPet"%>
<%
    int idC = Integer.parseInt(request.getParameter("ID_CLIENT"));
    int idP = Integer.parseInt(request.getParameter("ID_PET"));
    String obs = request.getParameter("OBS");
    ClientPet clientPet = new ClientPet(idC, idP, obs);
    ControllerClientPet clientPetController = new ControllerClientPet();
    
    clientPetController.insert(clientPet);
    

    String url = "insertClientPet.jsp";
    response.sendRedirect(url);

%>