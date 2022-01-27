<?php
    $cda = array(
        [
         'nom&prenom'=>  'Razafia Stephan' ,
         'site'=>'https://razafiasimanana.needemand.com/'
        ],
        [
         'nom&prenom'=>  'Ho Tong Minh Yen Nhi' ,
         'site'=>'https://hotongminh.needemand.com/'
        ],
        [
         'nom&prenom'=>  'Baudino Pierre-Olivier' , 
         'site'=> 'https://pierre-olivierb.github.io'
        ],
        [ 
         'nom&prenom'=> 'Young Hee Kim' ,
         'site'=>'https://kim.needemand.com/'
        ],
        [
         'nom&prenom'=>'Cochonneau Laurent' , 
         'site'=> 'https://cochonneau.needemand.com/'
        ],
        [
         'nom&prenom'=> 'Hernandez Raul' ,
         'site'=>'https://hernandez.needemand.com/'
        ],
        [
         'nom&prenom'=> 'Arnaud Patrick' ,
         'site'=>'https://arnaud.needemand.com/'
        ],
        [
         'nom&prenom'=> 'Briois Jean-Bernard' ,
         'site'=>'https://briois.needemand.com/'
        ],
        [
         'nom&prenom'=> 'Linxe Sylvie' , 
         'site'=> 'https://linxe.needemand.com/'
        ],
        [
         'nom&prenom'=>  'Mourichon Thibault'  ,
         'site'=> 'https://mourichon.needemand.com/'
        ],
        [
         'nom&prenom'=> 'Grossi Julien' ,
         'site'=>'https://grossi.needemand.com/'
        ]
    )
?>

<section class="page-section cta">
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto">
                        <div class="cta-inner bg-faded text-center rounded">
                            <h2 class="section-heading mb-5">
                                <span class="section-heading-upper">Coming Soon</span>
                                <span class="section-heading-lower">Réalisations</span>
                            </h2>

                            <ul class="list-unstyled list-hours mb-5 text-left mx-auto">
                                <?php foreach ($cda as $key => $value) : ?> 
                                    <li class="list-unstyled-item list-hours-item d-flex justify-content-between">
                                        <!-- <span>
                                          <?= $key ?> //donne l'indexe de la cle
                                        </span> -->
                                        <span>
                                            <?= strtoupper($value['nom&prenom']) . ' '  ?>
                                        </span>
                                        <!-- <span>
                                            <?= $value['prenom']?>
                                        </span> -->
                                        <span>
                                            <a class="ms-auto ml-auto" href="<?= $value['site']?>">Portfolio</a>                                       
                                        </span>
                                    </li>
                                <?php endforeach ?>                                            
                            </ul>

                            <p class="address mb-5">
                                <em>
                                    <strong>Promo 2021 - 2022</strong>
                                    <br />
                                    Concepteurs & développeurs d'application
                                </em>
                            </p>
                            <p class="mb-0">
                                <small><em>Needemand</em></small>
                                <br />
                                contact@needemand.com
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="page-section about-heading">
            <div class="container">
                <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="assets/img/about.jpg" alt="..." />
                <div class="about-heading-content">
                    <div class="row">
                        <div class="col-xl-9 col-lg-10 mx-auto">
                            <div class="bg-faded rounded p-5">
                                <h2 class="section-heading mb-4">
                                    <span class="section-heading-upper">Projet Fil Rouge</span>
                                    <span class="section-heading-lower">Contexte</span>
                                </h2>
                                <p>Projet réalisé dans le cadre d'une formation. En partie en groupe et en partie individuellement, ce projet est le résultat d'un apprentissage lors d'une formation</p>
                                <p class="mb-0">
                                Temps de réalisation du projet <em>5 mois environ</em> 
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>