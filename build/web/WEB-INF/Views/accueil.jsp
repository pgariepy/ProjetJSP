<%-- 
    Document   : accueil
    Created on : 26 nov. 2021, 14 h 00 min 33 s
    Author     : Pamela Gariepy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
     
        <div class="text-center m-3">
            <div class='card'>
                <h1>Gestion des stages</h1>        
            </div>
        </div>
            <div class='container mt-2'>
               <div class="row">
                    <div class="col align-items-center">
                       <div class="card" style="width: 18rem;">
                            <img alt="Image" src="<c:url value='/resources/computer.png'/>"/>  
                            <div class="card-body">
                              <h5 class="card-title">Romans</h5>
                              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div>
                      </div>                     
                    </div>
                    <div class="col align-items-center">
                        <div class="col">
                          <div class="card" style="width: 18rem;">
                            <img alt="Image" src="<c:url value='/resources/work.png'/>"/>  
                            <div class="card-body">
                                <h5 class="card-title">Livres</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div>
                         </div>
                   
                    </div>
                    </div>
                     <div class="col align-items-center">
                        <div class="card" style="width: 18rem;">
                            <img alt="Image" src="<c:url value='/resources/computer.png'/>"/>  
                            <div class="card-body">
                                <h5 class="card-title">Dictionnaires</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                            </div>
                        </div>
                    </div>
                </div>                               
            </div>      
            <div>            
                <card class="card m-3">
                <div class="card-title text-center">
                   <h2 class='mt-2'>Par Pamela Gariepy</h2>   
                </div>
                <div class="card-body">
                    <p class="justify-content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                    Volutpat consequat mauris nunc congue. Ipsum dolor sit amet consectetur adipiscing. Vitae justo eget magna fermentum iaculis eu non. Non pulvinar 
                    neque laoreet suspendisse interdum consectetur libero id. Imperdiet proin fermentum leo vel. Turpis egestas sed tempus urna et pharetra pharetra massa 
                    massa. Quis ipsum suspendisse ultrices gravida dictum fusce. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Velit aliquet sagittis id 
                    consectetur. Sem fringilla ut morbi tincidunt augue. Volutpat est velit egestas dui id ornare arcu. Viverra accumsan in nisl nisi scelerisque eu 
                    ultrices vitae. Fusce id velit ut tortor. Amet luctus venenatis lectus magna. Velit sed ullamcorper morbi tincidunt ornare. Ac ut consequat 
                    semper viverra nam libero justo laoreet. At elementum eu facilisis sed odio morbi quis commodo.
                </p>  
                </div>
                </card>              
            </div>
                                              
    </body>
<%@include file="footer.jsp"%>  
