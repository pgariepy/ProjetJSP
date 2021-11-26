<%-- 
    Document   : footer
    Author     : Benjamin Alexander - 1933317
--%>

<%@include file="header.jsp" %>
<% String dateDuJour = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDateTime.now()); %>
<footer id="sticky-footer" class="bg-dark text-white-50 mt-5" style="bottom: 0;height: 100px;width: 100%;overflow: hidden; "> <!-- style="position: absolute;left: 0;bottom: 0;height: 100px;width: 100%;overflow: hidden; " -->
    <div class="container text-center p-2">
        <p>© 2021 Benjamin Alexander, Paméla Gariépy, Cédrick Lavelle<br>
            <%=dateDuJour%><br>
        <a class="badge badge-warning" href="mailto:1933317@cegepoutaouais.qc.ca">Nous contacter</a></p>
    </div>
</footer>
</body>
</html>
