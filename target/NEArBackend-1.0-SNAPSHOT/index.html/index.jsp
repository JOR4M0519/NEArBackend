<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Pagina de inicio - NEAr</title>
  <link rel="shortcut icon" href="Assets/img/logo.ico">
  <!-- BOOTSTRAP CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
        integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
  <!-- FONT AWESOME -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
        integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
  <!-- CUSTOM CSS -->
  <link rel="stylesheet" href="Assets/Styles/main.css">

</head>

<body>
<!-- NAVIGATION -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: #9b205e ;">
  <div class="container">
    <a class="navbar-brand" href="#">
      <img src="Assets/img/logo.png" style="width: 20%;">
    </a>
    <div class="input-group">
      <div class="form-outline">
        <input type="search" id="form1" class="form-control" placeholder="Buscar arte" />
      </div>
      <button type="button" class="btn btn-primary">
        <i class="fas fa-search"></i>
      </button>
    </div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="#info">Info</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#Artist">Artistas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#Contact">Contáctenos</a>
        </li>
        <ul class="sub-nav-bar" >
          <a class="nav-link">Mi cuenta</a>
          <li class="sub-nav-item">
            <a class="nav-link" href="login.html">Ingresar</a>
          </li>
          <li class="sub-nav-item">
            <a class="nav-link" href="sign-up.html">Crear Cuenta</a>
          </li>
        </ul>
      </ul>
    </div>
  </div>
</nav>

<!-- HEADER -->
<header class="main-header" style="margin-top: 61px;">
  <div class="bg-dark text-white py-5">
    <div class="container">
      <div class="row d-flex h-100">
        <div class="col-sm-6 text-center justify-content-center align-self-center">
          <h1>
            New Era Art
          </h1>
          <p>Arte para todos</p>
        </div>
        <div class="col-sm-6">
          <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="Assets/img/ROBDVO4PFNFULOLBIK3DGUO5KQ.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="Assets/img/monos.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="Assets/img/Rude-Golems.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</header>

<!-- FEATURES -->

<section class="py-5">
  <div class="container">
    <div class="row">
      <div class="col-md-3">
        <div class="card text-center border-primary">
          <div class="card-body">
            <table>
              <tr>
                <td>
                  <img
                          src="https://http2.mlstatic.com/resources/frontend/homes-korriban/assets/images/payments/credit-card.svg"
                          alt="Metodos de pago">
                </td>
                <td>
                  <h5>Paga a cuotas</h5>
                  <p class="tarjetas">
                    Ver más
                  </p>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card text-center border-primary">
          <div class="card-body text-center">
            <table>
              <tr>
                <td>
                  <img src="Assets/img/cryptos.png" alt="Metodos de pago" style="width:30px; margin: 10px;">
                </td>
                <td>
                  <h5>Paga con Cryptos</h5>
                  <p class="tarjetas">
                    Ver más
                  </p>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card text-center border-primary">
          <div class="card-body">
            <table>
              <tr>
                <td>
                  <img
                          src="https://http2.mlstatic.com/resources/frontend/homes-korriban/assets/images/payments/transfer.svg"
                          alt="Metodos de pago">
                </td>
                <td>
                  <h5>Paga en bancos</h5>
                  <p class="tarjetas">
                    Ver más
                  </p>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      <div class="col-md-3">
        <div class="card text-center border-primary">
          <div class="card-body text-center">
            <table>
              <tr>
                <td>
                  <img
                          src="https://http2.mlstatic.com/resources/frontend/homes-korriban/assets/images/payments/view-more.svg"
                          alt="Metodos de pago">
                </td>
                <td>
                  <h5>Otros métodos</h5>
                  <p class="tarjetas">
                    Ver más
                  </p>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- ABOUT -->
<section class="m5 text-center bg-light" id="info">
  <div class="container">
    <div class="row">
      <div class="m-5">
        <h3>¿Que son los NFT's?</h3>
        <p>
          Los Tokens no fungibles (NFT) por sus siglas en ingles, son tokens criptográficos que representa algo único.
          Los tókenes no fungibles no son, por tanto, mutuamente intercambiables.
        </p>
      </div>
    </div>
  </div>
</section>


<section class="py-5">
  <div class="cards">
    <p id="ofertas" class="card_tittle">Catálogo:</p>
    <!--Guia js-->
    <div class="card-group contenedor-social" id="socialcard">
      <!--
      <div class="card">
        <img src="https://www.ratbastard.io/static/media/8.38f68f8e.png">
        <p>Name</p>
      </div>-->
    </div>
  </div>
</section>


<!-- TEAM -->
<section class="text-center team">
  <div class="container p-5">
    <h1 class="text-center text-white" id="Artist">Artistas</h1>
    <p class="text-white">
      Artistas del momento
    </p>
    <div class="row">
      <!-- USER TEAM -->
      <div class="col-lg-3">
        <div class="card">
          <div class="card-body">
            <img src="https://upload.wikimedia.org/wikipedia/commons/d/d0/Mike_Winkelmann.png"
                 class="img-fluid rounded-circle w-50">
            <h3>Mike Winkelmann</h3>
            <p>
              Artista visual, videojockey, diseñador gráfico, artista y NFT artist
            </p>
            <div class="d-flex flex-row justify-content-center">
            </div>
          </div>
        </div>
      </div>

      <div class="col-lg-3">
        <div class="card">
          <div class="card-body">
            <img
                    src="https://yt3.ggpht.com/ytc/AKedOLRYkj_Jh5coL9ljmJgpPudg6g4UzsjQPeQ1jc7L2w=s900-c-k-c0x00ffffff-no-rj"
                    class="img-fluid rounded-circle w-50">
            <h3>3LAU</h3>
            <p>
              DJ, Productor musical y NFT artist.
            </p>
          </div>
        </div>
      </div>

      <div class="col-lg-3">
        <div class="card">
          <div class="card-body">
            <img src="https://miro.medium.com/max/1200/1*zfkFCW52ity5kH9SeKd2XQ.jpeg"
                 class="img-fluid rounded-circle w-50">
            <h3>José Delbo</h3>
            <p>
              Artista de comics y NFT artist
            </p>
          </div>
        </div>
      </div>

      <div class="col-lg-3">
        <div class="card">
          <div class="card-body">
            <img
                    src="https://images.squarespace-cdn.com/content/v1/53ad9fcae4b0f941aa4e511f/1622666810733-8XLUH8KEQ13Y6IXNK73A/Sarah+Zucker+2021+headshot.jpg"
                    class="img-fluid rounded-circle w-50">
            <h3>Sarah Zucker</h3>
            <p>
              Artista visual, diseñadora grafica, artista digital y NFT artist.
            </p>
          </div>
        </div>
      </div>

    </div>
  </div>
</section>

<!-- CONTACT -->
<section class="bg-light py-5">
  <div class="container">
    <div class="row">
      <div class="col-lg-9" id="Contact">
        <h3>Contáctanos</h3>
        <p>
          ¿Tienes alguna pregunta, sugerencia o queja? <br>
          Consígnala aquí nosotros estaremos atendiendo tu reclamo.
        </p>
        <form action="">
          <div class="input-group mb-3">
            <div class="input-group-prepend">
              <i class="fas fa-user input-group-text"></i>
            </div>
            <input type="text" class="form-control" placeholder="Nombre" aria-label="Username"
                   aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
            <div class="input-group-prepend">
              <i class="fas fa-envelope input-group-text"></i>
            </div>
            <input type="text" class="form-control" placeholder="Correo" aria-label="Username"
                   aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
            <div class="input-group-prepend">
              <i class="fas fa-pencil-alt input-group-text"></i>
            </div>
            <textarea name="" cols="30" rows="10" placeholder="Mensaje" class="form-control"></textarea>
          </div>
          <button type="submit" class="btn btn-primary btn-block">Enviar</button>
        </form>
      </div>
      <div class="col-lg-3 align-self-center">
        <a href="#">
          <img src="Assets/img/Logo_footer.png" style=" width: 129%;">
        </a>
      </div>
    </div>
  </div>
</section>

<footer>
  <div class="container p-3">
    <div class="row text-center text-white">
      <div class="col ml-auto">
        <p>Copyright &copy; 2022 <br>
          Kevin García <br>
          Laura Mateus <br>
          Santiago Prieto <br>
          Jeanpier Ramos
        </p>
      </div>
    </div>
  </div>
</footer>


<!-- BOOTSTRAP SCRIPTS -->
<script src="Assets/js/functions.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>

</html>