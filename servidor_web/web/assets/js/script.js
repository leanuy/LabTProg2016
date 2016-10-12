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

function agregarTema(){
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
    $.post("/AltaAlbum/paso2?album="+album, '{orden:"'+orden+'",nombre:"'+nombre+'", duracion: "'+duracion+'", tipo: "'+tipo+'", tema: "'+tema+'"}', function(){
        
    });
    }
}


function crearTema(){
    var tr = '<tr class="tema">\
                <td class = "orden" > < /td>\
                <td class = "nombre" > < /td>\
                <td class = "duracion" > < /td>\
                <td class = "tipo" > < /td>\
                <td class = "tools" > < button class = "btn btn-custom" onclick = "agregarTema()" type = "button" > Agregar </button> </td>\
                </tr>';
    
}

function AgregarTema(){
    var $form_web = $(".form-web");
    var $form_archivo = $(".form-archivo");
    $form_archivo.hide();
    $form_archivo.removeClass("active");
    $form_web.show();
    $form_web.addClass("active");
}