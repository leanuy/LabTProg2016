<%-- 
    Document   : index
    Created on : Sep 13, 2016, 10:35:45 AM
    Author     : agustina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:body>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <!--<div class="panel-heading">Album</div>-->
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
                    <img src="assets/img/cover2.jpg" style="width:100%">
                </div>
                <div class="col-lg-10 col-md-9 col-sm-8 col-xs-12">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2 id="album-title">Let It Be</h2>
                            <p class="descripcion">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras commodo ornare lorem, at viverra lectus tincidunt eu. Sed ornare gravida tortor, ac facilisis tortor ultrices non. Pellentesque pharetra quis lacus at sagittis. Ut at est eros. Quisque in condimentum lacus. Nunc quis lectus mi. Donec vitae imperdiet est. Donec in dignissim tellus, vitae rhoncus felis. Aenean eu massa lectus. Integer aliquet dolor quam, eu ullamcorper purus tempus et. Phasellus fermentum velit congue, efficitur quam nec, vehicula orci. Cras in commodo diam. Curabitur pellentesque sodales accumsan. Phasellus eu justo sed ligula ultrices pellentesque sed et felis. Etiam suscipit orci nec tellus commodo, in iaculis eros luctus.</p>
                        </div>
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 col-sm-12 col-xs-12 pull-down">
                                    <button class="btn btn-success btn-sm">Reproducir</button>
                                    <button class="btn btn-inverse btn-sm">Guardar</button>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12 col-xs-12 pull-down">
                                    <div class="pull-right">
                                        <h4>Generos</h4>
                                        <a href="#" class="btn btn-inverse btn-sm round">Rock</a>
                                        <a href="#" class="btn btn-inverse btn-sm round">Pop de los 70'</a>
                                        <a href="#" class="btn btn-inverse btn-sm round">Pop</a>
                                    </div>                    
                                </div>
                            </div>                                    
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <!-- Table -->
        <table class="table">
            <thead>
                <tr>    
                    <th class="btn-table">&nbsp;</th>
                    <th>#</th>
                    <th>Nombre</th>
                    <th class="hidden-xs"><i class="glyphicon glyphicon-time"></i></th>
                    <th class="hidden-xs"><i class="glyphicon glyphicon-star"></i></th>
                    <th class="btn-table">&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>1</td>
                    <td>Two Of Us</td>
                    <td class="hidden-xs">3:37</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right "><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>2</td>
                    <td>Dig A Pony</td>
                    <td class="hidden-xs">3:55</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>3</td>
                    <td>Across The Universe</td>
                    <td class="hidden-xs">3:48</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>4</td>
                    <td>I Me Mine</td>
                    <td class="hidden-xs">2:26</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>5</td>
                    <td>Dig It</td>
                    <td class="hidden-xs">0:50</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>6</td>
                    <td>Let It Be</td>
                    <td class="hidden-xs">4:03</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>7</td>
                    <td>Maggie Mae</td>
                    <td class="hidden-xs">0:40</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>8</td>
                    <td>I've Got A Feeling</td>
                    <td class="hidden-xs">3:38</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>9</td>
                    <td>One After 909</td>
                    <td class="hidden-xs">2:54</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>10</td>
                    <td>The Long And Winding Road</td>
                    <td class="hidden-xs">3:38</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg"><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>11</td>
                    <td>For You Blue</td>
                    <td class="hidden-xs">2:32</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>
                <tr>
                    <td><button class="btn btn-link btn-lg "><i class="glyphicon glyphicon-play-circle"></i></button></td>
                    <td>12</td>
                    <td>Get Back</td>
                    <td class="hidden-xs">3:09</td>
                    <td class="hidden-xs">34.567</td>
                    <td><button class="btn btn-link pull-right"><i class="glyphicon glyphicon-option-horizontal"></i></button></td>
                </tr>

            </tbody>
        </table>
    </div>
    </t:body>