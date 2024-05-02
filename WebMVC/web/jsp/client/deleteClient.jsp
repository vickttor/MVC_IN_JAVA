<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Client"%>
<%@page import="padraomvc.controller.ControllerClient"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Client client = new Client(id);
    ControllerClient usuCont = new ControllerClient();
    usuCont.delete(client);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validateFetchClient.jsp?NAME=" + pbusca;
    response.sendRedirect(url);
%>