<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Sistema"%>
<%@page import="padraomvc.model.bean.PetUsuario"%>
<%@page import="padraomvc.controller.ControllerPetUsuario"%>
<%
    int idU = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idP = Integer.parseInt(request.getParameter("ID_PET"));
    String obs = request.getParameter("OBS");
    PetUsuario usupet = new PetUsuario(idU, idP, obs);
    ControllerPetUsuario usupetcont = new ControllerPetUsuario();
    usupetcont.inserir(usupet);
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoUsuarioPet.jsp";
    response.sendRedirect(url);

%>