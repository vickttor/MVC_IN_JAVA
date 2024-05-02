<%@page import="padraomvc.enums.Gender"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    
    String name = request.getParameter("NAME");
    String sexo = request.getParameter("GENDER");
    Gender gender = sexo.equals("Male") ? Gender.Male : Gender.Female;
    Integer age = Integer.parseInt(request.getParameter("AGE"));
    String pbusca = request.getParameter("PBUSCA");
    
    Pet pet = new Pet(id,name,gender,age);
    ControllerPet controller = new ControllerPet();
    controller.update(pet);
    
    String url = "validateFetchPet.jsp?NAME=" + pbusca;
    response.sendRedirect(url);
%>