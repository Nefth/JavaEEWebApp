<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.11.2017
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>css.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <% String redirect = "<META HTTP-EQUIV=\"REFRESH\" CONTENT=\"0 URL=\\menu.jsp \">";
        if (request.getSession().getAttribute("email") != null)
            out.print(redirect);
    %>
    <title>$Title$</title>
</head>
<body>
<%
    String msc = (String) request.getSession().getAttribute("message");
    if (msc == null)
        msc = "";
%>
<%=msc
%>
    <div class="wrapped" >
        <nav class="navbar navbar-inverse navbar-left" >
            <div class="container">
                <div class="form-inline">
                    <form method="POST" class="form-inline"  action="/login">
                        <label for="email" style="vertical-align: center"><p  class="text-white" >Email address:  </p></label>
                        <input type="text" class="form-control" id="email" name="email">
                        <label for="pwd"><p class="text-white ">Password:  </p></label>
                        <input type="password" class="form-control" id="pwd" name="pwd">

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>


                </div>

            </div>
        </nav>
    </div>






<div class="row">
    <div class="col-sm-4">
        <form  method="POST" action="/register" class="form-inline">
        <div class="form-group">
            <label for="emailreg">Email address:</label>
            <input type="email" class="form-control" id="emailreg" name="emailreg">
        </div>
        <div class="form-group">
            <label for="pwdreg">Password:</label>
            <input type="password" class="form-control" id="pwdreg" name="pwdreg">
        </div>
        <div class="form-group">
            <label for="name">Name: <br></label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="country">Country: <br></label>
            <input type="text" class="form-control" id="country" name="country">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </div>
    <div class="col-sm-8">.col-sm-8</div>
</div>


<div id="tresc" class="container-fluid">
<div id = "menu" class="container"> a </div>

</div>


</div>


</body>
</html>
