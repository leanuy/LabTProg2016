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

function crearTema(data) {
    var datos = JSON.parse(data);
    var $temas = $('.temas');
    var $tema = $temas.children('.tema').first().clone();
    $tema.children('.orden').text(datos["orden"]);
    $tema.children('.nombre').text(datos["nombre"]);
    $tema.children('.duracion').text(datos["duracion"]);
    $tema.children('.tipo').text(datos["tipo"]);

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
    var album = $('#album').val();
    var orden = $('#orden').val();
    var nombre = $('#nombre').val();
    var tipo;
    if($("active").hasClass('form-web')){
        tipo = "web";
    }else{
        tipo = "archivo";
    }
    var duracion = 0;
    var multiplicador = 1;
    var $duracion_str = $('#duracion');
    var duracion_arr = $duracion_str.val().split(":");
    if(duracion_arr.length()<1){
        $duracion_str.parent().addClass("has-error");
        has_error = true;
    }else if(duracion_arr.length() > 3){
        $duracion_str.parent().addClass("has-error");
        has_error = true;
    }else{
        for(i= duracion_arr.length()-1; i >= 0; i--){
            duracion =+ duracion_arr[i]*multiplicador;
            multiplicador *= 60;
        }
    }
    var tema = $('.active').find('input').val();
    if(!has_error){
        var parameters = '{"orden":"' + orden + '", "nombre":"' + nombre + '", "duracion_f": "' + $duracion_str.val() + '", "duracion": "' + duracion + '", "tipo": "' + tipo + '", "tema": "' + tema + '"}';
    $.post("/AltaAlbum/paso2?album="+album, parameters, function(data, status){
        if(status === "success"){
            crearTema(data);
            clearFormTema();
        }
    }, "json");
    }
}
