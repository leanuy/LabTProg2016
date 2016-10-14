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

function crearTema() {
    var $temas = $('.temas');
    var $tema = $temas.children('.tema').first().clone();
    $tema.children('.orden').text($("#orden"));
    $tema.children('.nombre').text($("#nombre"));
    $tema.children('.duracion').text($("#duracion"));
    $tema.children('.tipo').text($("#tipo"));

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
}

$("#aceptar").click(function(){
    var has_error = false;
    var $help = $(".help");
    var $album = $('#album');
    var orden;
    var $orden = $('#orden');
    var $nombre = $('#nombre');
    var tipo;

    $help.hide();
    $help.html("");

    if($("active").hasClass('form-web')){
        tipo = "web";
    }else{
        tipo = "archivo";
    }
    var duracion = 0;
    var multiplicador = 1;
    var $duracion_str = $('#duracion');
    var duracion_arr = $duracion_str.val().split(":");
    
    //VALIDACIONES
    if($orden.val() === ""){
        $orden.parent().addClass("has-error");
        $help.append("El orden del tema es requerido.");
        has_error = true;
    }else{
        orden = $orden.val().parseInt();
        if(isNaN(orden)){
            if (!($help.html() === "")) {
                $help.append("<br />");
            }
        $help.append("El orden del tema debe ser numerico.");
        has_error = true;
        }else if(orden <= 0){
            if (!($help.html() === "")) {
                $help.append("<br />");
            }
            $help.append("El orden del tema debe mayor a 0.");
            has_error = true;
        }
    }
    if ($nombre.val() === ""){
        $orden.parent().addClass("has-error");
        if(!($help.html()==="")){
            $help.append("<br />");
        }
        $help.append("El nombre del tema es requerido.");
        has_error = true;
    }else{
        $.ajax({
            type: "GET",
            url: "/ValidarNombreTema?album=" + $album.val()+"&tema="+$nombre.val(),
            success: function (msg) {
                if (msg === "true") {
                    $nombre.parent().addClass("has_error");
                    if (!($help.html() === "")) {
                        $help.append("<br />");
                    }
                    $help.append("El álbum ya tiene un tema con ese nombre.");
                    has_error = true;
                }
            }
        });
    }
    if(duracion_arr.length()<1){
        $duracion_str.parent().addClass("has-error");
        if (!($help.html() === "")) {
            $help.append("<br />");
        }
        $help.append("La duración del tema es requerida");
        has_error = true;
    }else if(duracion_arr.length() > 3){
        $duracion_str.parent().addClass("has-error");
        if (!($help.html() === "")) {
            $help.append("<br />");
        }
        $help.append("La duración del tema no es correcta");
        has_error = true;
    }else{
        var parte_duracion;
        for(i= duracion_arr.length()-1; i >= 0; i--){
            parte_duracion = duracion_arr[i].parseInt();
            if (isNaN(parte_duracion)) {
                if (!($help.html() === "")) {
                    $help.append("<br />");
                }
                $help.append("La duracion del tema tiene caracteres inesperados");
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
            if (!($help.html() === "")) {
                $help.append("<br />");
            }
            $help.append("La URL o archivo del tema es requerido.");
            has_error = true;
        }
    if(!has_error){
        $.ajax({
            type: "POST",
            url: "/AltaAlbum/paso2",
            data: {
                orden: orden,
                nombre: $nombre.val(),
                duracion: duracion,
                tipo: tipo,
                tema: $tema.val()
            },
            success: function (msg) {
                if (msg === "true") {
                    crearTema();
                    clearFormTema();
                }
            }
        });
    }else{
        $help.show();
    }
    $(".has-error").each(function(){
        $(this).removeClass("has-error");
    });
});

$(".remove-tema").click(function(){
    var $nombre = $(this).siblings(".nombre");
    $.ajax({
        type: "GET",
        url: "/BorrarTema?album=" + $(".album").val() + "&tema=" + $nombre.val(),
        success: function (msg) {
            $(this).parent().addClass("to-remove");
            $(document).remove(".to-remove");
        }
    });
});
