
// floating buttons
jQuery.fn.semiCircle = function (cx, cy, radius, radiusY, startDegrees, endDegrees, length) {
    if (radiusY === undefined) radiusY = radius;
    if (startDegrees === undefined) startDegrees = 0;
    if (endDegrees === undefined) endDegrees = 360;
    var startRadians = startDegrees * Math.PI / 180,
        endRadians = endDegrees * Math.PI / 180,
        stepRadians = (endRadians - startRadians) / (this.length - length);
    return this.each(function (i) {
        var a = i * stepRadians + startRadians,
            x = Math.cos(a) * radius + cx,
            y = Math.sin(a) * radiusY + cy;
        $(this).css({
            left: x + 'px',
            top: y + 'px'
        });
    });
};


jQuery(document).ready(function($){

    $(document).on('click','.floating-dial-bottom-left button', function () {
        var floatingEl = $(this).parents('.floating-share').find('.floating-item');
        var floatParent = $(this).parents('.floating-share');
        $(this).find('.fa').toggleClass('fa-cog' + " " + 'fa-cog');
        if (floatParent.hasClass("opened")) {
            floatingEl.semiCircle(0, 0, 0, 0, 0, 0, 0);
            floatParent.removeClass("opened").addClass("closing");
            setTimeout(function () {
                floatParent.removeClass("closing");
            }, 200);
        } else {
            floatingEl.semiCircle(0, 0, 50, 50, 90, 180, 1);
            floatParent.addClass("opened").removeClass("closing");
        }
    });

    // add class to togggle button on switch
    $(document).on('click', '.toggle-view-mode',  function(){    
        $(this).toggleClass('switched').attr('data-tooltip', $($(this)).attr('data-tooltip') == 'View as Grid' ? 'View as List' : 'View as Grid')
    });

    // open filters
    $(document).on('click', '.open-filters',  function() {
        $('.filter-toolbar').toggleClass('opened');
    });

    // close filters
    $(document).on("mouseup", function(e) {
        var filters = $(".filter-toolbar");

        // if the target of the click isn't the container nor a descendant of the container
        if (!filters.is(e.target) && filters.has(e.target).length === 0)  {
            filters.removeClass('opened');
        }
    });

    $(document).on("click", '.toggle-view-mode', function(){
        var delay = 50;
        $('[__idx]').each(function() {
    
            $(this).css('animation-delay', delay + 'ms');
            delay += 50;
    
        });
        
        changeView();
    });




    function changeView() {

        var grid = $('.person-view .content > div');
        var card= $('[__idx]');

        var currentState = grid.attr('class');

        if (currentState == "grid") {
           card.removeClass('animate-list-in animate-grid-in is-animating-grid').addClass('is-animating-list');
        } else {
            card.removeClass('animate-list-in animate-grid-in is-animating-list').addClass('is-animating-grid');
        }
        
        setTimeout(function(){
            if (currentState == "grid") {
                grid.attr('class', 'table');
                card.removeClass('animate-grid-in').addClass('animate-list-in');
            } else {
                grid.attr('class', 'grid');
                card.removeClass('animate-list-in').addClass('animate-grid-in');
            }
        }, 700);

        setTimeout(function(){
            card.removeClass('is-animating-list is-animating-grid');
        }, 800);



    }


});
