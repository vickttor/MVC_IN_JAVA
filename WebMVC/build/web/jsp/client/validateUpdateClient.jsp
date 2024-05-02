<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.controller.ControllerClient"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String name = request.getParameter("NAME");
    String cpf = request.getParameter("CPF");
    String tel = request.getParameter("TEL");
    String address = request.getParameter("ADDRESS");
    
    Client client = new Client(id, name, cpf, tel, address);
    ControllerClient controller = new ControllerClient();
    
    controller.update(client);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validateFetchClient.jsp?NAME=" + pbusca;
    response.sendRedirect(url);
%>