<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
        <title>Login</title>
        <style>
            body{
                background-image: url(img/fondo-home1.jpg); 
            }
            .bg{
                background-image: url(img/restaurante1.jpg);
                background-position: center center;
                
            }
        </style>
    </head>
    <body>
        <div class="container w-75  mt-5 shadow" style="background: white;">
            <div class="row align-items-stretch">
                <div class="col bg d-none d-lg-block">
                    
                </div>
                <div class="col">
                    <div class="text-end">
                        <img src="img/logo.jpg" width="48" alt="">
                    </div>
                    
                    
                    <h2 class="fw-bold text-center py-5">Bienvenidos</h2>
                    
                    
                    <form action="UsuarioServlet?action=login" method="POST">
                        <div class="mb-4">
                            <label for="email" class="form-label"><i class="bi bi-person-bounding-box"></i> Usuario</label>
                            <input type="email" class="form-control" name="usuario" placeholder="user01@user">
                        </div>
                        <div class="mb-4">
                             <label for="passwor" class="form-label"><i class="bi bi-key-fill"></i> Contraseña</label>
                             <input type="password" class="form-control" name="clave" placeholder="******">
                        </div>
                        <div class="mb-4 form-check">
                            <input type="checkbox" name="connected" class="form-check-input">
                            <label for="connected" class="form-check-label">Mantener la sesion abierta</label>                         
                        </div>
                        
                        <div class="d-grid">
                            <button class="btn btn-primary" type="submit">Iniciar Sesion</button>
                        </div>
                        <div class="my-3">
                            <span>No tienes cuenta?  <a href="registroUser.jsp">Registrate</a></span>
                        </div>
                    </form>
                </div>
                
            </div>
            
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>

