<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>

<%@ page import="java.util.List" %>
<%@ page import="app.model.Department" %>
<%@ page import="app.repository.DepartmentRepository" %><%--<%@ page session="false" pageEncoding="UTF-8" %>--%>
<%----%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Departments</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-green w3-opacity w3-right-align">
    <h1>Edit Departments</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <h2></h2>
        <TABLE  width="100%" align="center">
            <tr  align="center" bgcolor="#228b22" >
                <TD height="50"><H2></H2></TD>
            </tr>
        </TABLE>
    </div>
</div>
</TABLE>
<p>
</p>
<TABLE  width="100%" align="center">
    <tr  align="center">
        <TD><H1>You want edit this Department?</H1></TD>
    </tr>
</TABLE>

<TABLE BORDER width="100%" align="center">
    <tr align="center" bgcolor="#228b22" >
        <TD><H2>Name of Department</H2></TD>
        <TD><H2>Phone</H2></TD>
        <TD><H2>Email</H2></TD>
        <TD><H2>Address of Department</H2></TD>
        <TD><H2>Short Description</H2></TD>
    </tr>
    <form method="post">

        <input type="hidden" value="${department.id}" name="id" />

        <tr>
            <TD><input type="text" value="${department.name}" name="name"/><br/></TD>
            <TD><input type="text" value="${department.phone}" name="phone"/><br/></TD>
            <TD><input type="email" placeholder="E-mail" value="${department.email}" name="email"/><br/></TD>
            <TD><input type="text" value="${department.address}" name="address"/><br/></TD>
            <TD><input type="text" value="${department.description}" name="description"/><br/></TD>

        </tr>
        <TABLE  width="100%" align="center">
            <tr align="center"  >
                <TD><H4><span style="color :red;">

               <c:if test="${error != null}">
                   <c:forEach items="${error}" var="violation">
                       <p>${violation.message}.</p>
                   </c:forEach>
               </c:if>

               </span></H4></TD>
            </tr>
        </TABLE>
        <TABLE  width="100%" align="center">
            <tr align="center" bgcolor="#00ff7f" >
                <TD><button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Yes, EDIT</button></TD>
            </tr>
        </TABLE>
        <p>
    </form>
        </p>
        <TABLE  width="100%" align="center">
            <tr align="center" bgcolor="#00ff7f" >
                <TD> <button class="w3-btn w3-green w3-round-large" onclick="location.href='/departments'">No, back to Departments</button></TD>
            </tr>

        </TABLE>
        <p>


        <TABLE  width="100%" align="center">
            <tr align="center" bgcolor="#00ff7f" >

            </tr>
        </TABLE>


        </p>



</TABLE>
<p>
</p>
<div class="w3-container w3-green w3-opacity w3-right-align w3-padding">
    <div class="w3-container w3-light-green w3-opacity w3-right-align w3-padding">

        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='../..'">Back to main</button>
    </div>
</div>
</body>
</html>


