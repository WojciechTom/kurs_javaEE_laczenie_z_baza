<%@ page import="data.City" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista</title>
</head>
<body>
<h2>Lista Miast</h2>
<table style="width:50%" border="black" >
    <tr>
        <th> Nazwa </th>
        <th> Populacja </th>
    </tr>
    <%
        List<City> cityList = (List<City>)request.getAttribute("cityList");
        if(cityList != null){
            for (City c: cityList) {
    %>

    <tr>
        <td> <%= c.getName() %> </td>
        <td> <%= c.getPopulation() %> </td>
    </tr>

    <%
            }
        }
    %>
</table>


</body>
</html>
