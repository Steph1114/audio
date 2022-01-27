
<!-- template resume la squelette HTML de vos pages -->

<!DOCTYPE html>
<html lang="en">
    <head>
        <?php
            include('common/head.php');
        ?>
    </head>
    <body>
            
          <?php 
            //  $loc = 'loc';
              // <!-- Header -->
              include('common/header.php');
          
              // <!-- Navigation-->
              include('common/navigation.php');

            //  echo $_GET['loc'];

            //Controleur des contenus
            //$loc = $_GET['loc']; acceder directement a superglobales. A EVITER (Question de securité)
            // $loc = filter_input($loc, FILTER_SANITIZE);
            $loc = filter_input(INPUT_GET, 'loc', FILTER_SANITIZE_STRING);
           
            switch ($loc) {

                case 'home':
                include("content/index_content.php");
                break;

                case 'about':
                include("content/about_content.php");
                break;

                case 'products':
                include("content/product_content.php");
                break;

                case 'realisations':
                include("content/realisation_content.php");
                break;

                default;
              //  <html><a href="404.php"></a></html> 


                
               //include('404.php');
                header('Location: http://www.404.php');
                exit();
                break;               
            }

              // <!-- Main / Section content de l'index -->
            //  include('content/index_content.php');

              // <!-- footer -->
              include('common/footer.php');
          ?>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>