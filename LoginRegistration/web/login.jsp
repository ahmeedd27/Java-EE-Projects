
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/1ab94d0eba.js" crossorigin="anonymous"></script>
        <title>Login Form</title>
        <link rel="stylesheet" href="stylet.css">
    </head>
    <body>
        <main class="container">
            <h2>Login</h2>
            <form action="login" method="get">
                <div class="input-field">
                    <input type="email" name="email" id="username"
                           placeholder="Enter Your Email" required="">
                    <div class="underline"></div>
                </div>
                <div class="input-field">
                    <input type="password" name="password" id="password"
                           placeholder="Enter Your Password" required="">
                    <div class="underline"></div>
                </div>

                <input type="submit" value="Continue">
            </form>
           
            <div class="footer">
                <span>do you have an Account</span>
                <div class="social-field facebook">
                    <a href="reg.jsp">
                        <i class="fab fa-facebook-f"></i>
                        Sign up
                    </a>
                </div>
            </div>

        </div>

    </main>
</body>
</html>