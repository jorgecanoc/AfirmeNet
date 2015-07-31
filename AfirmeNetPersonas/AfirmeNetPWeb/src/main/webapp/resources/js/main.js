$(document).ready(function(){

	$('body').append('<div id="overlay">');

	var checkWidth = function() {
    if (!oldWindowWidth) return; var windowWidth = $(window).width();
    if (oldWindowWidth < 991 && windowWidth > 991) {
      setupDesktop();
    }
    else if (oldWindowWidth > 991 && windowWidth < 991) {
    	$('footer').waypoint('destroy');
      setupMobile();
    }
    oldWindowWidth = windowWidth;
  };
	$(window).resize(checkWidth).load(function() {
    var windowWidth = $(window).width();
    if (windowWidth > 991) {
      setupDesktop();
    } else {
      setupMobile();
    }
    oldWindowWidth = windowWidth;
  });
   
  var setupMobile = function() {
	
		// Menú 
		$('nav .parent > a').click(function(){ openSM($(this));	});
		$('nav .nivel-1 > .subparent > a').click(function(){ openSSM($(this));	});
		$('nav .nivel-2 > .subparent > a').click(function(){ openSSSM($(this));	});

	}
   
  var setupDesktop = function() {
    
	  $.getScript(context + "/resources/js/vendor/waypoints.min.js", function(){
	    $('footer').waypoint(function(direction) {
		  	if( direction == 'down' ) $('.col-izq nav').addClass('nf').css('top',$(window).scrollTop());
		  	if( direction == 'up' ) $('.col-izq nav').removeClass('nf').css('top','inherit');
	    }, {
	      offset: '90%'
	    });
	  });    
	
		// Menú 
		$('nav').hover(function(){ $('body').toggleClass('over'); });
		$('nav li').hover(function(){ $(this).siblings().removeClass('active'); $(this).addClass('active'); });
		$('#overlay, header').mouseover(function(){ $('body').removeClass('over'); $('nav .active').removeClass('active'); });

		// Scroll Header
	  $(window).bind('scroll',function(){ Move(); });

	  function Move(){
	    pos = $(window).scrollTop();
	    if( pos < 35 ) { $('header').removeClass('scrolled');  }
	    if( pos > 35 ) { $('header').addClass('scrolled'); }
	  }

	}	
	
	// Botones Menú
	$('header .btn.amarillo').hover(function(){ $('.titulo').fadeOut(200); }, function(){ $('.titulo').fadeIn(200); });
	
	$('header .btn-menu').click(function(){ 
		$('nav > ul, .menu, .col-izq').animate({ right: 0 }, 300); 
		setTimeout(function(){ $('body').addClass('menu-open'); $('nav').addClass('nav-open');  }, 100);
	});
	$('.cerrar-menu .close').click(function(){ $('body').removeClass('menu-open'); $('nav').removeClass('nav-open'); closeMenu(); });
	$('.cerrar-menu .close-sm').click(function(){ closeSM(); });
	$('.cerrar-menu .close-ssm').click(function(){ closeSSM(); });
	$('.cerrar-menu .close-sssm').click(function(){ closeSSSM(); });
   
	// Tooltips   
  if(isTouchDevice()===true || $(window).width() < 641 ) {
    $('.tooltip').click(function(e){
      e.preventDefault(); 
      if( $(this).hasClass('visible') ){
        $(this).removeClass('visible');
      } else{
        $(this).addClass('visible'); 
      }
  		$(this).find('.icon-close2').click(function(e){ $(this).removeClass('visible'); });
      return false; 
    });
    $('input').focus(function(){ $('.tooltip').removeClass('visible'); });
  }
  
	// Mensajes  
  $('.mensaje .icon-close2').click(function(){ $(this).parent().slideUp(); });
  $('.notificacion .icon-close2').click(function(){ $(this).parent().slideUp(); });

  // Inputs numericos
  $('input.numinput').keydown(function(e){ if (e.keyCode == 46 || e.keyCode == 8 || e.keyCode == 9 || e.keyCode == 27 || e.keyCode == 13 || e.keyCode == 190 || e.keyCode == 188 ) return; if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) { e.preventDefault(); } });

});

function isTouchDevice(){ return true == ("ontouchstart" in window || window.DocumentTouch && document instanceof DocumentTouch);}

// Abrir Menú 2do Nivel
function openSM(e){	e.parent().find('> ul').animate({ right: 0 }, 300); $('nav').addClass('open-sm'); }
// Abrir Menú 3er Nivel
function openSSM(e){ e.parent().find('> ul').animate({ right: 0 }, 300); $('nav').addClass('open-ssm'); }
// Abrir Menú 4to Nivel
function openSSSM(e){ e.parent().find('> ul').animate({ right: 0 }, 300); $('nav').addClass('open-sssm'); }

// Cerrar Menú
function closeMenu(){ $('nav ul, .menu, .col-izq').animate({ right: '-100%' }, 300); $('body').removeClass('over'); $('nav').removeClass('open-sm open-ssm open-sssm'); }
// Cerrar Menú 2do Nivel
function closeSM(){ $('.nivel-1').animate({ right: '-100%' }, 300); $('nav').removeClass('open-sm'); }
// Cerrar Menú 3er Nivel
function closeSSM(){ $('.nivel-2').animate({ right: '-100%' }, 300); $('nav').removeClass('open-ssm'); }
// Cerrar Menú 4to Nivel
function closeSSSM(){ $('.nivel-3').animate({ right: '-100%' }, 300); $('nav').removeClass('open-sssm'); }