<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="./assets/img/favicon.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
        <title>
            Proyecto Restaurante Comida
        </title>
        <!--     Fonts and icons     -->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
        <!-- Nucleo Icons -->
        <link href="material-dashboard//assets/css/nucleo-icons.css" rel="stylesheet" />
        <link href="material-dashboard//assets/css/nucleo-svg.css" rel="stylesheet" />
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <!-- CSS Files -->
        <link id="pagestyle" href="material-dashboard//assets/css/material-dashboard.css?v=3.0.0" rel="stylesheet" />
    </head>

    <body class="g-sidenav-show  bg-gray-200">
        <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark" id="sidenav-main">
            <div class="sidenav-header">
                <i class="fas fa-times p-3 cursor-pointer text-white opacity-5 position-absolute end-0 top-0 d-none d-xl-none" aria-hidden="true" id="iconSidenav"></i>
                <a class="navbar-brand m-0" href="Dashboard.jsp" target="_blank">
                    <img src="img-dashboard/logo.jpg" class="navbar-brand-img h-100" alt="main_logo">
                    <span class="ms-1 font-weight-bold text-white">Proyecto Comida</span>
                </a>
            </div>
            <hr class="horizontal light mt-0 mb-2">
            <div class="collapse navbar-collapse  w-auto  max-height-vh-100" id="sidenav-collapse-main">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link text-white active bg-gradient-primary" href="registroCocinero.jsp">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                            </div>
                            <span class="nav-link-text ms-1"><i class="bi bi-table"></i> Cocineros</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white active bg-gradient-primary" href="registroIngredientes.jsp">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                            </div>
                            <span class="nav-link-text ms-1"><i class="bi bi-table"></i> Ingredientes</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white active bg-gradient-primary" href="registroPlato.jsp">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                            </div>
                            <span class="nav-link-text ms-1"><i class="bi bi-table"></i> Plato</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white active bg-gradient-primary"  href="registroAlmacen.jsp">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                            </div>
                            <span class="nav-link-text ms-1"><i class="bi bi-table"></i> Almacen</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white active bg-gradient-primary" href="registroEstante.jsp">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                            </div>
                            <span class="nav-link-text ms-1"><i class="bi bi-table"></i> Estanteria</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white active bg-gradient-primary" href="registroPinches.jsp">
                            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
                            </div>
                            <span class="nav-link-text ms-1"><i class="bi bi-table"></i> Pinches</span>
                        </a>
                    </li>
                    <div class="dropdown">
                        <button style="margin-left: 10px; border: none;" class="btn btn-outline-ligth dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Logout
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#">Usuario: ${usuario}</a></li>
                            <li><a class="dropdown-item" href="UsuarioServlet?action=logout"><i class="bi bi-box-arrow-left"></i> Cerrar Session</a></li>
                        </ul>
                    </div>
                </ul>
            </div>
        </aside>
        <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
            <!-- Navbar -->
            <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" navbar-scroll="true">
                <div class="container-fluid py-1 px-3">
                    <nav aria-label="breadcrumb">
                        <h5 class="font-weight-bolder mb-0">Dashboard Proyecto Comida</h5>
                    </nav>
                    <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
                        <div class="ms-md-auto pe-md-3 d-flex align-items-center">
                            <div class="input-group input-group-outline">
                                <label class="form-label">Type here...</label>
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <ul class="navbar-nav  justify-content-end">
                            <li class="nav-item d-xl-none ps-3 d-flex align-items-center">
                                <a href="javascript:;" class="nav-link text-body p-0" id="iconNavbarSidenav">
                                    <div class="sidenav-toggler-inner">
                                        <i class="sidenav-toggler-line"></i>
                                        <i class="sidenav-toggler-line"></i>
                                        <i class="sidenav-toggler-line"></i>
                                    </div>
                                </a>
                            </li>
                            <li class="nav-item px-3 d-flex align-items-center">
                                <a href="javascript:;" class="nav-link text-body p-0">
                                    <i class="fa fa-cog fixed-plugin-button-nav cursor-pointer"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->

            <!-- Carousel-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="img-dashboard/platillo 1.jpg" class="d-block w-100" alt="..." width="450px" height="450px">
                                </div>
                                <div class="carousel-item">
                                    <img src="img-dashboard/platillo 2.jpg" class="d-block w-100" alt="..." width="650px" height="450px">
                                </div>
                                <div class="carousel-item">
                                    <img src="img-dashboard/Platillo 3.jpg" class="d-block w-100" alt="..." width="650px" height="450px">
                                </div>
                                <div class="carousel-item">
                                    <img src="img-dashboard/platillo 4.jpg" class="d-block w-100" alt="..." width="650px" height="450px">
                                </div>
                                <div class="carousel-item">
                                    <img src="img-dashboard/platillo 5.jpg" class="d-block w-100" alt="..." width="650px" height="450px">
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Carousel-->

            <!-- Principal-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group text-center">
                            <h2>Autentica comida Italiana en El Salvador</h2>
                            <img src="img-dashboard/logo.jpg" width="150"/>
                            <h1>Sobre Nosotros</h1>
                            <div class="section-description section-style-fill">
                                <h3>100% Italianos</h3>
                                <h3>Ingredientes Originales</h3>
                                <p>Al Pomodoro busca crear una experiencia 100% italiana,
                                    por lo que nos preocupamos sobre todos los ingredientes
                                    en nuestros platos. Nos aseguramos de tener ingredientes de los mejores ingredientes.</p>
                            </div>
                            <br>
                            <h2>El toque Italiano en cada uno de nuestros platos</h2>
                            <p>La comida de Italia no se basa en la innovación sino en la constancia.
                                A los italianos les gusta comer platos locales, sus queridas recetas del terruño,
                                y el resultado es una continuidad real con el pasado, donde las mujeres todavía
                                elaboran la pasta fresca para el almuerzo y florecen las pequeñas trattorias que
                                sirven especialidades regionales en medio de un bullicio de personas y familia.</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Principal-->
            <!-- Divisiones-->
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-sm-12">
                        <div class="form-group text-center">
                            <h4>Bienvenidos al Pamodoro</h4>
                            <p>Un restaurante Italianode mucha tradición en El Salvador
                                por su insuperable calidad. La esencia de la "Dolce Vita"</p>
                            <img src="img-dashboard/pomodoro.jpg" width="150"/>
                            <ul class="nav nav-footer">
                                <li class="nav-item">
                                    <a href="https://www.google.com/maps/dir//Al+Pomodoro,+Ave.+La+Revoluci%C3%B3n+y+Calle+Circunvalaci%C3%B3n+No.+184,+San+Salvador+CP+1101/@13.6906561,-89.2430334,17z/data=!4m8!4m7!1m0!1m5!1m1!1s0x8f63302f2212a5b5:0x544fe942ab74e141!2m2!1d-89.2408447!2d13.6906509"
                                       class="nav-link text-muted" target="_blank"><img src="img-dashboard/Maps.png" width="40"/>Google Maps</a>
                                </li>
                            </ul>
                            <ul class="nav nav-footer">
                                <li>
                                    <img src="img-dashboard/telefono (1).png" width="25">Llamanos al +503 2243-7888
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="form-group text-center">
                            <h4>Horarios</h4>
                            <p>Le compartimos nuestros horario regular de servicio:</p>
                            <h5>Lunes a Viernes</h5>
                            <p>Almuerzo 12md a 3pm</p>
                            <p>Cena 6pm a 10pm</p>
                            <h5>Sábado a Domingo</h5>
                            <p>Todo el día 12md a 11pm</p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="form-group text-center">
                            <h4>Reservaciones</h4>
                            <p>Atendemos reservaciones digitales de 9am a 5pm de lunes a viernes.
                                Espera nuestra confirmación de tu reservación por correo o teléfono
                                en 3-4 horas. Cualquier duda o reservación urgente,
                                no dudes llamarnos al 2243-7888.</p>
                            <p>Escríbenos a <b>reservaciones@alpomodoro.com.sv</b></p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Divisiones-->
            <!-- Footer-->
            <footer class="footer py-4  ">
                <div class="container-fluid">
                    <div class="row align-items-center justify-content-lg-between">
                        <div class="col-lg-6 mb-lg-0 mb-4">
                            <div class="copyright text-center text-sm text-muted text-lg-start">
                                © <script>
                                    document.write(new Date().getFullYear())
                                </script>,
                                Universidad Salvadoreña Alberto Masferrer <i class="fa fa-heart"> </i> By Group 9
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <ul class="nav nav-footer justify-content-center justify-content-lg-end">
                                <li class="nav-item">
                                    <a href="https://www.facebook.com/alpomodoro/" class="nav-link text-muted" target="_blank"><img src="img-dashboard/Facebook.png" width="40"/>Facebook</a>
                                </li>
                                <li class="nav-item">
                                    <a href="https://www.tripadvisor.com/Restaurant_Review-g294476-d806875-Reviews-Al_Pomodoro-San_Salvador_San_Salvador_Department.html"
                                       class="nav-link text-muted" target="_blank"><img src="img-dashboard/Tripad.png" width="40"/>Tripadvisor</a>
                                </li>
                                <li class="nav-item">
                                    <a href="https://accounts.google.com/AccountChooser/signinchooser?service=lbc&continue=https%3A%2F%2Fbusiness.google.com%2Fu%2F0%2Fdashboard%2Fl%2F13219381480782035056%3Fhl%3Den-US%26acct_rdr%3D1&hl=en-US&flowName=GlifWebSignIn&flowEntry=AccountChooser"
                                       class="nav-link text-muted" target="_blank"><img src="img-dashboard/Google.png" width="40"/>Google+</a>
                                </li>
                                <li class="nav-item">
                                    <a href="https://www.instagram.com/alpomodorosv/" class="nav-link pe-0 text-muted" target="_blank"><img src="img-dashboard/Instagram.png" width="20"/>Instagram</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- End Footer-->
        </div>
    </main>

    <!--   Core JS Files   -->
    <script src="material-dashboard//assets/js/core/popper.min.js"></script>
    <script src="material-dashboard//assets/js/core/bootstrap.min.js"></script>
    <script src="material-dashboard//assets/js/plugins/perfect-scrollbar.min.js"></script>
    <script src="material-dashboard//assets/js/plugins/smooth-scrollbar.min.js"></script>
    <script src="material-dashboard//assets/js/plugins/chartjs.min.js"></script>
    <script>
                                    var ctx = document.getElementById("chart-bars").getContext("2d");

                                    new Chart(ctx, {
                                        type: "bar",
                                        data: {
                                            labels: ["M", "T", "W", "T", "F", "S", "S"],
                                            datasets: [{
                                                    label: "Sales",
                                                    tension: 0.4,
                                                    borderWidth: 0,
                                                    borderRadius: 4,
                                                    borderSkipped: false,
                                                    backgroundColor: "rgba(255, 255, 255, .8)",
                                                    data: [50, 20, 10, 22, 50, 10, 40],
                                                    maxBarThickness: 6
                                                }, ],
                                        },
                                        options: {
                                            responsive: true,
                                            maintainAspectRatio: false,
                                            plugins: {
                                                legend: {
                                                    display: false,
                                                }
                                            },
                                            interaction: {
                                                intersect: false,
                                                mode: 'index',
                                            },
                                            scales: {
                                                y: {
                                                    grid: {
                                                        drawBorder: false,
                                                        display: true,
                                                        drawOnChartArea: true,
                                                        drawTicks: false,
                                                        borderDash: [5, 5],
                                                        color: 'rgba(255, 255, 255, .2)'
                                                    },
                                                    ticks: {
                                                        suggestedMin: 0,
                                                        suggestedMax: 500,
                                                        beginAtZero: true,
                                                        padding: 10,
                                                        font: {
                                                            size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                        },
                                                        color: "#fff"
                                                    },
                                                },
                                                x: {
                                                    grid: {
                                                        drawBorder: false,
                                                        display: true,
                                                        drawOnChartArea: true,
                                                        drawTicks: false,
                                                        borderDash: [5, 5],
                                                        color: 'rgba(255, 255, 255, .2)'
                                                    },
                                                    ticks: {
                                                        display: true,
                                                        color: '#f8f9fa',
                                                        padding: 10,
                                                        font: {
                                                            size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                        },
                                                    }
                                                },
                                            },
                                        },
                                    });


                                    var ctx2 = document.getElementById("chart-line").getContext("2d");

                                    new Chart(ctx2, {
                                        type: "line",
                                        data: {
                                            labels: ["Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                            datasets: [{
                                                    label: "Mobile apps",
                                                    tension: 0,
                                                    borderWidth: 0,
                                                    pointRadius: 5,
                                                    pointBackgroundColor: "rgba(255, 255, 255, .8)",
                                                    pointBorderColor: "transparent",
                                                    borderColor: "rgba(255, 255, 255, .8)",
                                                    borderColor: "rgba(255, 255, 255, .8)",
                                                    borderWidth: 4,
                                                    backgroundColor: "transparent",
                                                    fill: true,
                                                    data: [50, 40, 300, 320, 500, 350, 200, 230, 500],
                                                    maxBarThickness: 6

                                                }],
                                        },
                                        options: {
                                            responsive: true,
                                            maintainAspectRatio: false,
                                            plugins: {
                                                legend: {
                                                    display: false,
                                                }
                                            },
                                            interaction: {
                                                intersect: false,
                                                mode: 'index',
                                            },
                                            scales: {
                                                y: {
                                                    grid: {
                                                        drawBorder: false,
                                                        display: true,
                                                        drawOnChartArea: true,
                                                        drawTicks: false,
                                                        borderDash: [5, 5],
                                                        color: 'rgba(255, 255, 255, .2)'
                                                    },
                                                    ticks: {
                                                        display: true,
                                                        color: '#f8f9fa',
                                                        padding: 10,
                                                        font: {
                                                            size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                        },
                                                    }
                                                },
                                                x: {
                                                    grid: {
                                                        drawBorder: false,
                                                        display: false,
                                                        drawOnChartArea: false,
                                                        drawTicks: false,
                                                        borderDash: [5, 5]
                                                    },
                                                    ticks: {
                                                        display: true,
                                                        color: '#f8f9fa',
                                                        padding: 10,
                                                        font: {
                                                            size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                        },
                                                    }
                                                },
                                            },
                                        },
                                    });

                                    var ctx3 = document.getElementById("chart-line-tasks").getContext("2d");

                                    new Chart(ctx3, {
                                        type: "line",
                                        data: {
                                            labels: ["Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                            datasets: [{
                                                    label: "Mobile apps",
                                                    tension: 0,
                                                    borderWidth: 0,
                                                    pointRadius: 5,
                                                    pointBackgroundColor: "rgba(255, 255, 255, .8)",
                                                    pointBorderColor: "transparent",
                                                    borderColor: "rgba(255, 255, 255, .8)",
                                                    borderWidth: 4,
                                                    backgroundColor: "transparent",
                                                    fill: true,
                                                    data: [50, 40, 300, 220, 500, 250, 400, 230, 500],
                                                    maxBarThickness: 6

                                                }],
                                        },
                                        options: {
                                            responsive: true,
                                            maintainAspectRatio: false,
                                            plugins: {
                                                legend: {
                                                    display: false,
                                                }
                                            },
                                            interaction: {
                                                intersect: false,
                                                mode: 'index',
                                            },
                                            scales: {
                                                y: {
                                                    grid: {
                                                        drawBorder: false,
                                                        display: true,
                                                        drawOnChartArea: true,
                                                        drawTicks: false,
                                                        borderDash: [5, 5],
                                                        color: 'rgba(255, 255, 255, .2)'
                                                    },
                                                    ticks: {
                                                        display: true,
                                                        padding: 10,
                                                        color: '#f8f9fa',
                                                        font: {
                                                            size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                        },
                                                    }
                                                },
                                                x: {
                                                    grid: {
                                                        drawBorder: false,
                                                        display: false,
                                                        drawOnChartArea: false,
                                                        drawTicks: false,
                                                        borderDash: [5, 5]
                                                    },
                                                    ticks: {
                                                        display: true,
                                                        color: '#f8f9fa',
                                                        padding: 10,
                                                        font: {
                                                            size: 14,
                                                            weight: 300,
                                                            family: "Roboto",
                                                            style: 'normal',
                                                            lineHeight: 2
                                                        },
                                                    }
                                                },
                                            },
                                        },
                                    });
    </script>
    <script>
        var win = navigator.platform.indexOf('Win') > -1;
        if (win && document.querySelector('#sidenav-scrollbar')) {
            var options = {
                damping: '0.5'
            }
            Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
        }
    </script>
    <!-- Github buttons -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
    <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
    <script src="material-dashboard/assets/js/material-dashboard.min.js?v=3.0.0"></script>
</body>

</html>