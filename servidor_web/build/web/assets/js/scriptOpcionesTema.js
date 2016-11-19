$(document).ready(function() {
            $(".btn-mas-opciones-tema").click(function() {
                $(".btn-mas-opciones-tema").show(); //muestra los botones de ... ocultos
                $(".contenedor-opciones-tema").remove(); //oculta los paneles iguales al que quiere desplegar
                var nomTema = $(this).attr("data-nomTema");
                var nomArtista = $(this).attr("data-nomArtista");
                var nomAlbum = $(this).attr("data-nomAlbum");

               $(this).parent().parent().after('<tr class="contenedor-opciones-tema" col-span="6"></tr>');  //crea panel
               $.ajax({
                    type: "GET",
                    url: "/OpcionesTema?artista="+nomArtista+"&album="+nomAlbum+"&tema="+nomTema,
                    success: function(msg) {
                        $(".contenedor-opciones-tema").html(msg);
                    }
                }); //busca datos del servlet y muestra panel
                $(this).hide(); //oculta botón de ...
            });
        });
        function ConfirmarAgregarLista() {
            lista = $(".combolistas :selected").text();
            nick = $(".boton_confirmar").attr("data-nick");
            tema = $(".boton_confirmar").attr("data-tema");
            album = $(".boton_confirmar").attr("data-album");
            artista = $(".boton_confirmar").attr("data-artista");
            $.ajax({
                type: "GET",
                url: "AgregarTemaListaWeb?nick="+nick+"&lista="+lista+"&nom_tema="+tema+"&album="+album+"&artista="+artista,
                success: function(msg) {
                    $(".mensaje").html("Tema agregado con éxito.");
                },
                error: function() {
                    $(".mensaje").html("El tema ya existía en la lista, o se generó algún otro tipo de error.");
                }
            });
        }