<%-- 
    Document   : login
    Author     : Benjamin Alexander
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class='container'>
    <c:if test="${not empty loginError}" >
        <div class="alert alert-danger" role="alert">
            <p>Erreur des informations d'identification. Essayez encore.</p>
        </div>
    </c:if> 
</div>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem; background-color: #f2f2f2;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img
                                src="/ProjetIntraJSP2/ressource/images/pexels-ricardo-esquivel-1926988.jpg"                                
                                alt="login form"
                                class="img-fluid" style="border-radius: 1rem 0 0 1rem;"
                                />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form name='loginForm' action="<c:url value='/Login/login' />" method='POST'>

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                        <img src="/ProjetIntraJSP2/ressource/images/java.png" alt="java (Source : Freepik)" class="d-flex rounded mx-auto m-3">
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Connexion à votre compte</h5>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="username" name="username" class="form-control form-control-lg" />
                                        <label class="form-label" for="username">Nom d'usager</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" id="password" name="password" class="form-control form-control-lg" />
                                        <label class="form-label" for="password">Mot de passe</label>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-primary btn-lg btn-block" type="submit">Connexion</button>
                                    </div>
                                    <p class="mb-5 pb-lg-2" style="color: #393f81;">Vous n'avez pas de compte? <a href="${cheminregister}" style="color: #393f81;">Inscrivez-vous</a></p>
                                    <c:if test="${not empty _csrf}">
                                        <input type="hidden" name="${_csrf.parameterName}"
                                               value="${_csrf.token}"/>
                                    </c:if>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    $(function () {
        $('#username').focus();
    })
</script>  
<%@include file="footer.jsp" %>

