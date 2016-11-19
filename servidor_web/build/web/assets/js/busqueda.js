/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).on('ready page:load', function(){
    $('.orden').change(function() {
        var sort = $(this).val();
        var busqueda = document.getElementsByClassName("busqueda-term")[0].getAttribute("value")
        $.get($(this).data('url'), $.param({ sort: sort, busqueda: busqueda }),
              function(data){
                var current_tab = $('li.active a').prop('href');
                $('.aca').replaceWith(data);
                $('[href="#tab1"]').click(function (e) {
                    e.preventDefault()
                    $(this).tab('show')
                });
                $('[href="#tab3"]').click(function (e) {
                    e.preventDefault()
                    $(this).tab('show')
                });
                $('[href="#tab2"]').click(function (e) {
                    e.preventDefault()
                    $(this).tab('show')
                });
                var tab = current_tab.split('#')[1];
                $('[href="#' + tab + '"]').click();//                
              }
        );
    }); 
});