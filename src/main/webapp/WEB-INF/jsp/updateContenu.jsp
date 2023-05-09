<%@page import="com.aina.spring_mvc.model.Contenu"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/fonts/ionicons.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/css/Footer-Basic.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/css/Lista-Productos-Canito.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/ckeditor/skins/moono-lisa/editor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/ckeditor/content.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/ckeditor/styles.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/theme/ckediktor/samples/css">
        <%
            Contenu contenu = new Contenu();
            contenu = (Contenu) request.getAttribute("contenu");
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
                    <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath()%>/IntelligenceArtificielle/LoginPage">Login</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div style="margin-top: 100px;">
        <section class="register-photo">
            <div class="form-container">
                <form action="<%=request.getContextPath()%>/IntelligenceArtificielle/modifier/<%=contenu.getId()%>" method="post" enctype="multipart/form-data">
                    <h2 class="text-center">Modifier Contenu</h2>
                    <div class="mb-3"><input class="form-control" type="titre" name="titre" value="<%=contenu.getTitre()%>"></div>
                    <div class="mb-3"><textarea class="ckeditor form-control" id="contenu" name="contenu" cols="50" rows="5"><%=contenu.getContenu()%></textarea></div>
                    <div class="mb-3"><button class="btn btn-primary d-block w-100" type="submit" style="background: rgb(35,33,33);">Modifier</button></div>
                </form>
                            <script src="<%=request.getContextPath()%>/resources/theme/ckeditor/ckeditor.js"></script>
        <script>
            var editor = ClassicEditor
                    .create(document.querySelector('#contenu'))
                    .catch (error => {
                        console.error(error);
            }) ;
        </script> 
            </div>
        </section>
    </div>
    <div>
        <footer class="footer-basic">
            <div class="social"><a href="#"><i class="icon ion-social-instagram"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-facebook"></i></a></div>
            <ul class="list-inline"></ul>
            <p class="copyright">Company Name © 2023</p>
        </footer>
    </div>
    <script src="<%= request.getContextPath()%>/resources/theme/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/theme/js/agency.js"></script>
</body>
</html>