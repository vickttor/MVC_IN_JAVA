<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.controller.ControllerClient"%>

<%
    String name = request.getParameter("NAME");
    String cpf = request.getParameter("CPF");
    String tel = request.getParameter("TEL");
    String address = request.getParameter("ADDRESS");
    
    Client sis = new Client(name, cpf, tel, address);
    
    ControllerClient controller = new ControllerClient();
    controller.insert(sis);

    String url = "insertClient.jsp";
    response.sendRedirect(url);
%>

