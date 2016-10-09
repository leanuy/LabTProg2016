$('.pull-down').each(function() {
  var $this = $(this);
  $this.css('margin-top', $this.parent().height() - $this.height())
});

function formTemaWeb(){
    var $form_web = $(".form-web");
    var $form_archivo = $(".form-archivo");
    $form_archivo.hide();
    $form_archivo.removeClass("active");
    $form_web.show();
    $form_web.addClass("active");
}

function formTemaArchivo(){
    var $form_web = $(".form-web");
    var $form_archivo = $(".form-archivo");
    $form_archivo.hide();
    $form_archivo.removeClass("active");
    $form_web.show();
    $form_web.addClass("active");
}
function AgregarTema(){
    var $form_web = $(".form-web");
    var $form_archivo = $(".form-archivo");
    $form_archivo.hide();
    $form_archivo.removeClass("active");
    $form_web.show();
    $form_web.addClass("active");
}