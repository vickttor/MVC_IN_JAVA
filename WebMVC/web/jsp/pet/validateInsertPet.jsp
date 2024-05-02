<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="padraomvc.enums.Gender"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>

<%
    String name = request.getParameter("NAME");
    String sexo = request.getParameter("GENDER");
    Gender gender = sexo.equals("Male") ? Gender.Male : Gender.Female;
    Integer age = Integer.parseInt(request.getParameter("AGE"));
   

    Pet pet = new Pet(name,gender,age);
    ControllerPet controller = new ControllerPet();
    controller.insert(pet);
    

    String url = "insertPet.jsp";
    response.sendRedirect(url);
%>
