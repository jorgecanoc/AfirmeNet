/**
 * 
 */

var $textElements;
var $passwordElements;
var $emailElements;
var $selectElements;
var $textAreaElements;
var $datePickerElements; 

function submitForm(name) {
	$('form#' + name).submit();
}

function submitForm(formName, actionName) {
	$('form#' + formName).attr('action', actionName);
	$('form#' + formName).submit();
}

function submitFormModal(formName, actionName) {
	$('form#' + formName).attr('action', actionName);
}

/**
 * Funciones para envio de formularios via Ajax y submit
 */

function callController(page) {
	window.parent.document.location = page;
}

function blockPage() {
	$('body').append('<div id="loading"></div>');
	$('#loading').fadeIn();
}
function unblockPage() {
	$('#loading').fadeOut();
}
function sendRequestJQ(fobj, actionURL, targetId) {
	blockPage();
    $.ajax({
    	type: "POST",
        url : actionURL,
        success : function(data) {
            $('#'+targetId).html(data);
            unblockPage();
        }
    });
}

function submitFormAnimate(formName, actionName){
		$('form#'+formName).attr('action', context + '/' + actionName);
		$('body').append('<div id="loading"></div>');
		$('#loading').fadeIn(500, function(){
			$('form#' + formName).submit();
		});
	}
function submitFormAnimateWOC(formName, actionName){
	$('form#'+formName).attr('action', actionName);
	$('body').append('<div id="loading"></div>');
	$('#loading').fadeIn(500, function(){
		$('form#' + formName).submit();
	});
}

function validForm(formID, actionName) {
	$('form#'+formName).attr('action',actionName);
	return validForm(formID);
}

/**
 * Valida si TODOS los elementos (input, select u cualquera indicado)
 * de un determinado FORM ID no se encuentren vacios; valida solo aquellos 
 * elementos visibles (ignora elementos HIDDEN o hijos de padres HIDDEN) 
 * y elementos habilitados (ignora elementos DISABLED).
 * Toma solo aquellos elementos que contengan el atributo: CLASS="REQ"
 * Regresa TRUE si TODOS los elementos requeridos contengan algun valor,
 * FALSE si encuentra alguno vacio.
 */
function validForm(formID) {
	
	// obtiene todos los elementos de la forma
	loadAllFormElements();
	// procede a buscar todos los padres con elementos ocultos
	$parents = $('*').filter(function() {
		return $(this).css('display') == 'none';
	});
	// recorre los elementos padre y selecciona aquellos que ocultan elementos input, select y textarea
	var $hidden = $.grep($parents, function(parentElement) {
		$hidElement = $(parentElement).find('input, select, textarea');
		if ($hidElement.length > 0) {
			return $hidElement;
		}
	});
	
	$remove = [];
	// obtiene los elementos ocultos de cada padre y los inserta en un array
	$.each($hidden, function(index, element) {
		$.each($(element).find('input, select, textarea'), function(index, e) {
			$remove.push(e);
		});
	});
	// remueve los elementos ocultos para que no sean validados
	$textElements = removeHiddenElements($textElements, $remove);
	$passwordElements = removeHiddenElements($passwordElements, $remove);
	$emailElements = removeHiddenElements($emailElements, $remove);
	$selectElements = removeHiddenElements($selectElements, $remove);
	$textAreaElements = removeHiddenElements($textAreaElements, $remove);
	$datePickerElements = removeHiddenElements($datePickerElements, $remove);
	
	// une todos los elementos en un solo arreglo
	var $allElements = $.merge($textElements, $passwordElements);
	$allElements = $.merge($allElements, $emailElements);
	$allElements = $.merge($allElements, $selectElements);
	$allElements = $.merge($allElements, $textAreaElements);
	$allElements = $.merge($allElements, $datePickerElements);
	
	//console.log($($allElements).toArray());
	
	var isValid = true;
	
	for (var i = 0; i < $($allElements).length; i++) {
		
		var element = $allElements[i];
		
		if ($(element).val() == "") {
			isValid = false;
			setErrorStyle(element);
		} else {
			removeErrorStyle(element);
		}
	}
	
	return isValid;
}

/**
 * Remueve elementos de un Array que se encuentren
 * en otro Array, retornando un Array 'limpio'. Además de
 * asignar valores vacíos a todos los elementos ocultos, para
 * evitar el envío de datos no visibles.
 * */
function removeHiddenElements(array, removeElementsArray) {
	
	var cleanArray = [];
	cleanArray = $.grep(array, function(element) {
		// si el elemento no se va a remover, se retorna como válido,
		// de lo contrario, se deshabilita
		if ($.inArray(element, removeElementsArray) == -1)
			return element;
		else
			$(element).prop('disabled', true);
	});
	return cleanArray;
}

/**
 * Carga todos los elementos DOM que hayan sido especificados como 
 * requeridos (CLASS="REQ")
 * */
function loadAllFormElements() {
	
	$textElements = $(document).find('input[type=text].req:not([disabled])');
	$passwordElements = $(document).find('input[type=password].req:not([disabled])');
	$emailElements = $(document).find('input[type=email].req:not([disabled])');
	$selectElements = $(document).find('select.req');
	$textAreaElements = $(document).find('textarea.req');
	$datePickerElements = $(document).find('#datepicker.req');
	
	addBlurEvent($textElements);
	addBlurEvent($passwordElements);
	addBlurEvent($emailElements);
	addBlurEvent($selectElements);
	addBlurEvent($textAreaElements);
	addBlurEvent($datePickerElements);
}

/**
 * Adiciona el evento BLUR a cada elemento DOM contenido
 * en un Array.
 * Adiciona la validacion si el VALUE del elemento es vacío, 
 * se añade una clase CSS indicando error.
 * */
function addBlurEvent(DOMElementArray) {
	
	if (DOMElementArray.length) {
		$.each(DOMElementArray, function(index, DOMElement) {
			$(DOMElement).blur(function() {
				if ($(DOMElement).val() == "") {
					setErrorStyle(DOMElement);
				} else {
					removeErrorStyle(DOMElement);
				}
			});
		});
	}
}

/**
 * Establece el style en los elementos que hayan presentado 
 * error.
 * */
function setErrorStyle(element) {
	
	var tagName = element.tagName;
	
	switch(tagName) {
		case 'SELECT':
			$sibling = $(element).prev();
			$sibling.children().css('border-color','red');
		break;
		case 'TEXTAREA':
			$(element).css('border-color', 'red');
		break;
		default:
			if ($(element).attr('type') == 'button') {
				$(element).css('border-color', 'red');
				if (!$(element).parent().children('p.error').length)
					$(element).parent().append('<p class="error">Campo requerido</p>');
			}
			else {
				$(element).addClass('error');
				if (!$(element).parent().children('p.error').length) {
					$(element).parent().append('<p class="error">Campo requerido</p>');
					if (!$('.mensaje').length) {
					$("#errores").prepend('<div class="mensaje error fc"><span class="icon icon-error"></span><span class="icon icon-close2"></span><p><strong class="error">ERRORES</strong><br>Los campos marcados en rojo son necesarios para realiar la operación.</p></div>');
					$('.mensaje .icon-close2').click(function(){ $(this).parent().slideUp(); });
					}
				}
			}
	}
}

/**
 * Remueve el style establecido para aquellos elementos
 * que tengan error.
 * */
function removeErrorStyle(element) {
	
	var tagName = element.tagName;
	
	switch(tagName) {
		case 'SELECT':
			$sibling = $(element).prev();
			$sibling.children().css('border-color','');
		break;
		case 'TEXTAREA':
			$(element).css('border-color', '');
		break;
		default:
			$(element).removeClass('error');
		    $(element).siblings('p').remove();
	}
}

$(document).ready(function() {
	/**
	 * Validacion de elementos que requieran solo numeros.
	 * Bloquea cualquier tecla que no sea un digito, backspace, 
	 * flechas de movimiento, inicio o fin.
	 * */
	$('.onlyNum').keypress(function(tecla) {
		
		var value = $(this).val();
		var char = tecla.charCode;
		var key = tecla.keyCode;
		var period = /[.]/g.test(value);
		var periodIndex = value.indexOf('.');
		var ctrl = tecla.ctrlKey;
		//alert(key + " - " + char);
		// valida que el primer digito no sea punto decimal
		if (value == '' && char == 46)
			return false;
		// valida que exista solo un punto decimal
		if (!period && char == 46)
			return true;
		// permite las teclas backspace, flechas, inicio y fin
		if (key == 8 || (key >= 35 && key <= 40) || (ctrl && char == 118) || key == 9)
			return true;
		// valida que solo se impriman numeros
		if (char < 48 || char > 57)
			return false;
		else {
			// valida que al agregar digitos sea solo antes del punto decimal
			try {
				// selectionStart/selectionEnd no es compatible en Chrome desde v.33.0.1750.146
				if (this.selectionStart <= periodIndex && this.selectionEnd <= periodIndex)
					return true;
			} catch(ex) {
				return true;
			}
		}
		// valida que existan solo dos numeros despues del punto decimal
		if (periodIndex > -1) {
			var afterDecimal = value.substring(periodIndex, value.length);
			if (afterDecimal.length > 2)
				return false;
		}
	});
});
