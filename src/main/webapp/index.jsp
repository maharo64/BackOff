<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Untitled</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/fonts/ionicons.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/theme/css/styles.css">
</head>

<body>
    <section class="login-clean">
        <form action ="<%= request.getContextPath()%>/IntelligenceArtificielle/TraitLogin" method="post">
            <h2 class="visually-hidden">Login Form</h2>
            <div class="illustration"><i class="icon ion-android-person" style="border-color: var(--bs-indigo);color: rgb(0,0,0);"></i></div>
            <div class="mb-3"><input class="form-control" type="text" name="nom" value="admin"></div>
            <div class="mb-3"><input class="form-control" type="password" name="mdp" value="admin"></div>
            <div class="mb-3"><button class="btn btn-primary d-block w-100" type="submit" style="background: var(--bs-dark);">Log In</button></div><a class="forgot" href="#">Forgot your email or password?</a>
        </form>
    </section>
    <script src="<%= request.getContextPath()%>/resources/theme/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>