<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.PetUsuario"%>
<%@page import="padraomvc.controller.ControllerPetUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    PetUsuario usupet = new PetUsuario(id);
    ControllerPetUsuario ususisCont = new ControllerPetUsuario();
    ususisCont.delete(usupet);
    String pbusca = request.getParameter("PBUSCA");
    String url = "validaConsultarRelacaoUsuarioPet.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>

