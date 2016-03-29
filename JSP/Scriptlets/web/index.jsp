<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! public static final int UPPER = 5;%>
        <% for (int i = 0; i < UPPER; i++) {%>
        <%= i %> * <%= i %> = <%= i*i %>,&nbsp;&nbsp;&nbsp;  
        <% } %>
    </body>
</html>
