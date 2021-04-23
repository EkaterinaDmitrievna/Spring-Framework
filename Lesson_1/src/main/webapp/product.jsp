<%--
  Created by IntelliJ IDEA.
  User: Kate
  Date: 20.04.2021
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Product list</h2>
<form >
    <table>
        <tr>
            <td>Id</td>
            <td>Specification</td>
            <td>Price</td>
        </tr>

        <tr>
            <td> <div><input type ="number" name="id"/>  </div> </td>
            <td><div><input type ="text" name="title"/>  </div> </td>
            <td><div><input type ="number" name="cost"/>  </div> </td>
        </tr>

    </table>

    <button type =”submit”> Добавить </button>
</form>

</body>

</html>
