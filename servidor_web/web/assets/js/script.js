$('.pull-down').each(function() {
  var $this = $(this);
  $this.css('margin-top', $this.parent().height() - $this.height());
});

$(".boton-web").click(function(){
    var $form_web = $(".form-web");
    var $form_archivo = $(".form-archivo");
    $form_archivo.hide();
    $form_archivo.removeClass("active");
    $form_web.show();
    $form_web.addClass("active");
});

$(".boton-archivo").click( function(){
    var $form_web = $(".form-web");
    var $form_archivo = $(".form-archivo");
    $form_web.hide();
    $form_web.removeClass("active");
    $form_archivo.show();
    $form_archivo.addClass("active");
});

function crearTema(tipo) {
    console.log("crearTema");
    var $temas = $('.temas');
    var $tema = $temas.children('.tema').first().clone();
    $tema.children('.orden').text($("#orden").val());
    $tema.children('.nombre').text($("#nombre").val());
    $tema.children('.duracion').text($("#duracion").val());
    $tema.children('.tipo').text(tipo);

    $temas.append($tema);
    $tema.show();
}

function clearFormTema() {
    $('#orden').val("");
    $('#nombre').val("");
    $('#duracion').val("");
    $('#tipo').val("");
    $('#url').val("");
    $('#archivo').empty();
    $('.active').hide().removeClass("active");
}

$(".temas").on('click', '.delete-tema', function () {
    console.log("delete-tema");
    var $nombre = $(this).parent().siblings(".nombre");
    console.log($nombre);
    $.ajax({
        type: "GET",
        url: "/BorrarTema?album=" + $("#album").val() + "&tema=" + $nombre.text(),
        success: function (msg) {
            if (msg === "true") {
                console.log("success");
                $nombre.parent().empty();
            }
        }
    });
});

$("#aceptar").click(function(){
    var has_error = false;
    var $help = $(".help");
    var $album = $('#album');
    var orden;
    var $orden = $('#orden');
    var $nombre = $('#nombre');
    var tipo;
    
    $(".has-error").each(function () {
        $(this).removeClass("has-error");
    });

    $help.parent().hide();
    $help.html("<strong>Errores:</string>");

    if($(".active").hasClass('form-web')){
        tipo = "web";
    }else if($(".active").hasClass('form-archivo')){
        tipo = "archivo";
    }else{
        $help.append("<br />Debes elegir un tipo de tema y completar los datos.");
        has_error = true;
    }
    var duracion = 0;
    var multiplicador = 1;
    var $duracion = $('#duracion');
    var duracion_str = $duracion.val()
    var duracion_arr = $duracion.val().split(":");
    
    //VALIDACIONES
    if($orden.val() === ""){
        $orden.parent().addClass("has-error");
        $help.append("<br />El orden del tema es requerido.");
        has_error = true;
    }else{
        orden = parseInt($orden.val());
        if(isNaN(orden)){
            $help.append("<br />El orden del tema debe ser numerico.");
            has_error = true;
        }else if(orden <= 0){
            $help.append("<br />El orden del tema debe mayor a 0.");
            has_error = true;
        }else{
            var repetido = false;
            $(".orden").each(function(){
               if($(this).text() === $orden.val()){
                   repetido = true;
               } 
            });
            if(repetido){
                $help.append("<br />Ya tienes otro tema en este álbum con ese orden.");
                has_error = true;
            }
        }
    }
    if ($nombre.val() === ""){
        $nombre.parent().addClass("has-error");
        $help.append("<br />El nombre del tema es requerido.");
        has_error = true;
    }else{
        $.ajax({
            type: "GET",
            url: "/ValidarNombreTema?album=" + $album.val()+"&tema="+$nombre.val(),
            success: function (msg) {
                if (msg !== "true") {
                    $nombre.parent().addClass("has_error");
                    $help.append("<br />El álbum ya tiene un tema con ese nombre.");
                    has_error = true;
                }
            }
        });
    }
    if($duracion.val() === ""){
        $duracion.parent().addClass("has-error");
        $help.append("<br />La duración del tema es requerida");
        has_error = true;
    }else if(duracion_arr.length > 3){
        $duracion.parent().addClass("has-error");
        $help.append("<br />La duración del tema no es correcta");
        has_error = true;
    }else{
        var parte_duracion;
        for(i= duracion_arr.length-1; i >= 0; i--){
            parte_duracion = parseInt(duracion_arr[i]);
            if (isNaN(parte_duracion)) {
                $help.append("<br />La duracion del tema tiene caracteres inesperados");
                has_error = true;
            }else{
            duracion =+ duracion_arr[i]*multiplicador;
            multiplicador *= 60;
            }
        }
    }
    var $tema = $('.active').find('input');
        if($tema.val() === ""){
            $tema.parent().addClass("has-error");
            $help.append("<br />La URL o archivo del tema es requerido.");
            has_error = true;
        }
    if(!has_error){
        $duracion.val(duracion);
        $("#tipo").val(tipo);
        var data = new FormData($("form#form-tema")[0]);

        $.ajax({
            type: "POST",
            url: "/AltaAlbum/paso2",
            processData: false,
            contentType: false,
            data: data,
            success: function (msg) {
                if (msg === "true") {
                    crearTema(tipo);
                    clearFormTema();
                }
            }
        });
    }else{
        $help.parent().show();
    }
    
});

