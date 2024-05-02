<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>
<%@page import="padraomvc.model.bean.PetUsuario"%>
<%@page import="padraomvc.controller.ControllerPetUsuario"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idU = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idP = Integer.parseInt(request.getParameter("ID_PET"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    PetUsuario usupet = new PetUsuario(id,idU, idP, obs);
    ControllerPetUsuario usupetcont = new ControllerPetUsuario();
    usupetcont.alterar(usupet);
    String url = "validaConsultarRelacaoUsuarioPet.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    