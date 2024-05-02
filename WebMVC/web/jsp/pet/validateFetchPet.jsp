
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Pet"%>
<%@page import="padraomvc.controller.ControllerPet"%>
<%@page import="padraomvc.model.bean.User"%>

<%
    String name = request.getParameter("NAME");
    Pet pet = new Pet(name);
    ControllerPet petcont = new ControllerPet();
    List<Object> listPet = petcont.list(pet);
    User loggedUser = (User) session.getAttribute("LOGGED_USER");
    String url = "PBUSCA=" + pet.getName()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA PETS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Name">Nome</th>
                  <th data-field="Gender">Sexo</th>
                  <th data-field="Age">Idade</th>
                  <th data-field="Delete">Excluir</th>
                  <th data-field="Update">Alterar</th>
              </tr>
            </thead>
            <% if (!(listPet.isEmpty())) { %>    
                <tbody>
                    <% for (Object petObj : listPet) {
                        Pet petOutput = (Pet) petObj;
                    %>
                    <tr>
                            <td><%=petOutput.getId()%></td>
                            <td><%=petOutput.getName()%></td>
                            <td><%=petOutput.getGender()%></td>
                            <td><%=petOutput.getAge()%></td>
                            <% if (loggedUser.getType().equals("ADM")) { %>
                                <td><a href="deletePet.jsp?<%=url + petOutput.getId()%>">Excluir</a></td>
                                <td><a href="updatePet.jsp?<%=url + petOutput.getId() + "&NAME=" + petOutput.getName() + "&GENDER=" + petOutput.getGender() + "&AGE=" + petOutput.getAge() %>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>