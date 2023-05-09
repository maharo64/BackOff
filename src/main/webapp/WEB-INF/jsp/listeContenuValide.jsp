<%@page import="com.aina.spring_mvc.model.Contenu"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/fonts/ionicons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/css/Footer-Basic.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/css/Lista-Productos-Canito.css">
    <% 
           List<Contenu> list = (List<Contenu>) request.getAttribute("contenuvalide");
    %>
</head>

<body id="page-top" data-bs-spy="scroll" data-bs-target="#mainNav" data-bs-offset="54">
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark" id="mainNav">
        <div class="container"><a class="navbar-brand" href="#page-top"><i class="fa fa-braille"></i>&nbsp;IA TECH&nbsp;</a><button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" class="navbar-toggler navbar-toggler-right" type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto text-uppercase">
                    <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/IntelligenceArtificielle/ContenuValidePage">Liste Contenu Valide</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/IntelligenceArtificielle/ContenuNonValidePage">Liste Contenu non valide</a></li>
                    <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/IntelligenceArtificielle/AjoutContenuPage">ajout contenu</a></li>
                    <li class="nav-item"></li>
                    <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/IntelligenceArtificielle/LogOut">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
                       
    <div style="margin-top: 200px;">
        <h1 style="color: black; margin-left: 500px; margin-top: -50px">Liste Contenu Valide</h1> 
        <div class="container">
            <div class="row">
                <div class="col-md-12"><table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Titre</th>
                <th>Date</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
           
            <tr>
                <%for(int i =0; i< list.size(); i++){
                    %>
                <td><%= list.get(i).getId()%></td>
                <td><%= list.get(i).getTitre()%></td>
                <td><%= list.get(i).getDaty()%></td>
               <td><img style="height: 100px; width: 100px" src="<%= request.getContextPath()%><%=list.get(i).getImage()%>"/></td>
                    <td style="width: 250px">
                        <a href="<%= request.getContextPath()%>/IntelligenceArtificielle/Supprimer/<%=list.get(i).getId()%>">Non valider</a>
                        <a href="<%= request.getContextPath()%>/IntelligenceArtificielle/pageModif/<%=list.get(i).getId()%>">Modifier</a>
                        <a href="<%= request.getContextPath()%>/IntelligenceArtificielle/detail/<%=list.get(i).getId()%>">Detail</a>
                    </td>  
            </tr>
            <%}%>
        </tbody>
    </table></div>
            </div>
        </div>
    </div>
    <div style="margin-top: 100px;">
        <footer class="footer-basic">
            <div class="social"><a href="#"><i class="icon ion-social-instagram"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-facebook"></i></a></div>
            <p class="copyright">Company Name © 2023</p>
        </footer>
    </div>
    <script src="<%=request.getContextPath()%>/resources/theme/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/theme/js/agency.js"></script>
</body>

</html>