<%--
  Created by IntelliJ IDEA.
  User: Przemek
  Date: 10.12.2017
  Time: 01:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% String redirect = "<META HTTP-EQUIV=\"REFRESH\" CONTENT=\"0 URL=\\index.jsp \">";
    if (request.getSession().getAttribute("email") == null)
        out.print(redirect);
%>


<head>
    <title>Title</title>
</head>
<body>

<div class="wrapped">
    <nav class="navbar navbar-inverse navbar-left">
        <div class="container">
            <%
                out.println("Witaj " + session.getAttribute("email") + "");
            %> <br>

        </div>
    </nav>
</div>


<div class="row">
    <div class="col-sm-4">

    </div>
    <div class="col-sm-8">.col-sm-8</div>
</div>

menu menu
</body>
</html>
