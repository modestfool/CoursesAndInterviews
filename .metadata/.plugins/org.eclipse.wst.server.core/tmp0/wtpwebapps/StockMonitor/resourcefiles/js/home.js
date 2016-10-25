if (document.images) {
    img1 = new Image();
    img1.src = "http://idratherbewriting.com/wp-content/uploads/2013/03/plus3.jpg";
    img2 = new Image();
    img2.src = "http://idratherbewriting.com/wp-content/uploads/2013/03/minusb.jpg";
}


$(document).ready(function () {
    $('.section').hide();
    $('h2').click(function () {
        $(this).toggleClass("open");
        $(this).next().toggle();
    }); //end toggle

    $('#expandall').click(function () {
        $('.section').show();
        $('h2').addClass("open");
    });

    $('#collapseall').click(function () {
        $('.section').hide();
        $('h2').removeClass("open");
    });

}); //end ready

$(document).ready(function(){
	$('#sindhu').hide();
	});

