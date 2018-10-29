jQuery(document).ready(function($){

    // add class to togggle button on switch

    $(document).on('click', '.toggle-view-mode',  function(){
        
        if ($(this).hasClass('switched')) {
            $(this).removeClass('switched').attr('data-tooltip', 'View as Table');

        } else {
            $(this).addClass('switched').attr('data-tooltip', 'View as Grid');;
        }
    });

    $(document).on('click', '.open-filters',  function() {
        $('.filter-toolbar').toggleClass('opened');
    });

});