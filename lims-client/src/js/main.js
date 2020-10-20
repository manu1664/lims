import 'bootstrap';
import 'jquery-ui';

import '@fortawesome/fontawesome-free/js/fontawesome'
import '@fortawesome/fontawesome-free/js/solid'
import '@fortawesome/fontawesome-free/js/regular'
import '@fortawesome/fontawesome-free/js/brands'

import '../scss/main.scss'


$(function() {
    $( ".calendar" ).datepicker({
        dateFormat: 'dd/mm/yy',
        firstDay: 1
    });

    $(document).on('click', '.date-picker .input', function() {
        var $me = $(this),
            $parent = $me.parents('.date-picker');
        $parent.toggleClass('open');
    });


    $(".calendar").on("change",function() {
        var $me = $(this),
            $selected = $me.val(),
            $parent = $me.parents('.date-picker');
        $parent.find('.result').children('span').html($selected);
    });
});