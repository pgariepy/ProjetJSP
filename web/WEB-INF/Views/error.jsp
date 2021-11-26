<%-- 
    Document   : error
    Created on : 26 nov. 2021, 14 h 00 min 28 s
    Author     : Pamela Gariepy
--%>

<%@include file="header.jsp"%>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur</title>
    </head>
    <body>
        <h1 class="alert alert-danger text-center" role="alert">Attention! Une erreur est survenue! <img alt="Image" widht="80" height="80" src="<c:url value='/resources/close.png'/>"/></h1>
        <div class="container">
            <h2>Détails de l'erreur:</h2>
             <table class="table table-striped table-bordered">
                <theah>
                    <tr>
                        <th>Code</th>
                        <th>Description</th>
                        <th>Contrôleur problématique</th>
                    </tr>                  
                </theah>
                <tbody>
                    <tr>
                        <td>${pageContext.errorData.statusCode}</td>
                        <td><%= exception.getMessage() %></td>
                        <td><%= exception.getStackTrace()[0].getClassName()%></td>
                    </tr>                
                </tbody>
            </table>
        </div>    
    </body>
<%@include file="footer.jsp"%>  
