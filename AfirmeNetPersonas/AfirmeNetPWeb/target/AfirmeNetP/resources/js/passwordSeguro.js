/*
 * Creado por:			Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Creacion:		Septiembre-2006
 * Modificado por:		Christian Antonio Gómez Flores
 * Empresa:				Consiss
 * Fecha Modificacion:	25-Septiembre-2006
 * */
 	
 	var textoPWAnt="";
 	var borrado=false;
 	
 	function validaCambio(){
 		var prop=event.propertyName;
 		var enmedio=0;
 		var corrige=false;
 		if(prop=="value"){
 			var textoPW=document.forms[0].password.value.toUpperCase();
 			if(textoPW!=textoPWAnt){
	 			if(borrado==true){
	 				if(textoPW == textoPWAnt.substring(0,textoPWAnt.length-1)){
		 				if(valSeguPassword(textoPW)==false){
		 					corrige=true;
		 				}
		 			}else{
		 				if(textoPW.length>1){
		 					enmedio=1;
		 					corrige=true;
		 				}
		 			}
	 			}else{
	 				if(textoPW.substring(0,textoPW.length-1) == textoPWAnt){
	 					if(valSeguPassword(textoPW)==false){
		 					corrige=true;
		 				}
	 				}else{
	 					if(textoPW.length>1){
		 					enmedio=2;
		 					corrige=true;
		 				}
	 				}
	 			}
	 			if(corrige==true){
	 				document.forms[0].password.value=textoPWAnt;
	 				textoPW=textoPWAnt;
	 			}
	 			if(enmedio==1)
	 				alert("Solo puede borrar caracteres a la derecha del texto, su último caracter ingresado sera ignorado");
	 			else if (enmedio==2)
	 				alert("Solo puede escribir caracteres a la derecha del texto, su último caracter ingresado sera ignorado");
	 			pintaNivel(textoPW);
	 			textoPWAnt=textoPW;
	 		}
 		}
 	}
 	
 	function validaCambio(evnt){
 		var prop=(window.event)?event.propertyName:evnt.propertyName;
 		var enmedio=0;
 		var corrige=false;
 		//if(prop=="value"){
 			var textoPW=document.forms[0].password.value.toUpperCase();
 			if(textoPW!=textoPWAnt){
	 			if(borrado==true){
	 				if(textoPW == textoPWAnt.substring(0,textoPWAnt.length-1)){
		 				if(valSeguPassword(textoPW)==false){
		 					corrige=true;
		 				}
		 			}/*else{
		 				if(textoPW.length>1){
		 					enmedio=1;
		 					corrige=true;
		 				}
		 			}*/
	 			}else{
	 				if(textoPW.substring(0,textoPW.length-1) == textoPWAnt){
	 					if(valSeguPassword(textoPW)==false){
		 					corrige=true;
		 				}
	 				}/*else{
	 					if(textoPW.length>1){
		 					enmedio=2;
		 					corrige=true;
		 				}
	 				}*/
	 			}
	 			if(corrige==true){
	 				document.forms[0].password.value=textoPWAnt;
	 				textoPW=textoPWAnt;
	 			}
	 			/*if(enmedio==1)
	 				alert("Solo puede borrar caracteres a la derecha del texto, su último caracter ingresado sera ignorado");
	 			else if (enmedio==2)
	 				alert("Solo puede escribir caracteres a la derecha del texto, su último caracter ingresado sera ignorado");*/
	 			pintaNivel(textoPW);
	 			textoPWAnt=textoPW;
	 		}
 		//}
 		return !corrige;
 	} 	
 
 	function caracteresPermitidos(texto){
		var re = /^[¡!¿?*+#$%&.:_<>@^~a-zñA-ZÑ\d]+$/;
		if(re.test(texto))
			return true;
		else
			return false;
	}
 	
	function validaLetrasPW(texto){
		var re = /[a-zñA-ZÑ]+/;
		if(re.test(texto))
			return true;
		else
			return false;
	}
	
	function validaNumePW(texto){
		var re = /\d+/;
		if(re.test(texto))
			return true;
		else
			return false;
	}
	
	function validaMinusPW(texto){
		var re = /[a-zñ]+/;
		if(re.test(texto))
			return true;
		else
			return false;
	}
	
	function validaMayusPW(texto){
		var re = /[A-ZÑ]+/;
		if(re.test(texto))
			return true;
		else
			return false;
	}
	
	function validaCaracPW(texto){
		var re = /[¡!¿?*+#$%&.:_<>@^~]+/;
		if(re.test(texto))
			return true;
		else
			return false;
	}
	
	function codigoPressPW(){
		var kcode=event.keyCode;
		if(caracteresPermitidos(String.fromCharCode(kcode))==false){
			alert("El caracter no esta permitido, su último caracter ingresado sera ignorado");
			return false;
		}else{
			return true;
		}
	}
	
	function codigoPressPW(evnt){
		//var kcode=event.keyCode;
		var kcode = (window.event)?event.keyCode:evnt.which;
		
		if(kcode!= 8 && caracteresPermitidos(String.fromCharCode(kcode))==false){
			alert("El caracter no esta permitido, su último caracter ingresado sera ignorado");
			return false;
		}else{
			return true;
		}
	}	
	
	/*
	8:	backspace 
	9:	tab
	13:	enter
	16:	shift  
    17:	ctrl  
    18:	alt  
    20:	caps lock 
	27:	esc  
	33:	page up  
    34:	page down  
    35:	end 
    36:	home  
    37:	left arrow
    38:	up arrow
    39:	right arrow      
    40:	down arrow
    45:	insert 
   	46:	supr
    */
	function codigoDownPW(){
		var kcode=event.keyCode;
		borrado=false;
		if(kcode == 13 || kcode == 27 || kcode == 46)
			return false;
		else{
			if(kcode == 8)
				borrado=true;
			return true;
		}
	}
	
	function codigoDownPW(evnt){
		var kcode = (window.event)?event.keyCode:evnt.which;
		borrado=false;
		if(kcode == 13 || kcode == 27 || kcode == 46)
			return false;
		else{
			if(kcode == 8)
				borrado=true;
			return true;
		}
	}	
	
	function validaPaste(){
		alert("No esta permitido pegar texto, favor de escribirlo");
		return false;
	}
	
	function valSeguPassword(textoPW){
		var longitud=textoPW.length;
		if(longitud > 2){
			var letra1=textoPW.charCodeAt(longitud-3);
			var letra2=textoPW.charCodeAt(longitud-2);
			var letra3=textoPW.charCodeAt(longitud-1);
			if(letra1 == letra2 && letra2 == letra3){
				alert("La contraseña no puede contener 3 caracteres idénticos en forma consecutiva, su último caracter ingresado sera ignorado.");
				return false;
			}
			if(letra1 == (letra2-1) && letra2 == (letra3-1)){
				alert("La contraseña no puede contener 3 caracteres consecutivos ascendentes, su último caracter ingresado sera ignorado.");
				return false;
			}
			if(letra1 == (letra2+1) && letra2 == (letra3+1)){
				alert("La contraseña no puede contener 3 caracteres consecutivos descendentes, su último caracter ingresado sera ignorado.");
				return false;
			}
		}
		return true;
	}
	
	function pintaNivel(textoPW){
		var nivel=0;
		var longitud=textoPW.length;
		if(longitud > 5){
			if(validaLetrasPW(textoPW))
				nivel++;
			if(validaNumePW(textoPW))
				nivel++;
			if(validaCaracPW(textoPW))
				 nivel++;
		}
		if(nivel == 0){
			document.getElementById("td1").style.backgroundColor = "white";
		 	document.getElementById("td2").style.backgroundColor = "white";
		 	document.getElementById("td3").style.backgroundColor = "white";
			document.getElementById("td5").innerHTML = "<br>";
		}else if(nivel == 1){
		 	document.getElementById("td1").style.backgroundColor = "red";
		 	document.getElementById("td2").style.backgroundColor = "white";
		 	document.getElementById("td3").style.backgroundColor = "white";
		 	document.getElementById("td5").innerHTML = "Bajo";
		}else if(nivel == 2){
		 	document.getElementById("td1").style.backgroundColor = "yellow";
		 	document.getElementById("td2").style.backgroundColor = "yellow";
		 	document.getElementById("td3").style.backgroundColor = "white";
		 	document.getElementById("td5").innerHTML = "Medio";
		}else if(nivel == 3){
		 	document.getElementById("td1").style.backgroundColor = "green";
		 	document.getElementById("td2").style.backgroundColor = "green";
		 	document.getElementById("td3").style.backgroundColor = "green";
		 	document.getElementById("td5").innerHTML = "Alto";
		}
	}
	
	function validaPW(idUsuario){
		var textoPW=document.forms[0].password.value.toUpperCase();
		var longitud=textoPW.length;
		if(longitud < 8){
			alert("La contraseña debe tener al menos 8 caracteres.");
			return false;
		}
		if(textoPW.indexOf("AFIRME") != -1){
			alert("La contraseña no puede ser igual o contener la palabra AFIRME.");
			return false;
		}
		if(textoPW.indexOf(idUsuario) != -1){
			alert("La contraseña no puede ser igual o contener su clave de usuario.");
			return false;
		}
		if(validaLetrasPW(textoPW)==false || validaNumePW(textoPW)==false){
			alert("La contraseña debe ser alfanumérica, es decir debe contener letras y números.");
			return false;
		}
		if(textoPW != document.forms[0].confirma.value.toUpperCase()){
			alert("La confirmación de contraseña debe ser igual a la nueva contraseña.");
			return false;
		}
		return true;
	}
	
	function validaCambioCompleto(){
 		var textoPW=document.forms[0].password.value.toUpperCase();
 		pintaNivel(textoPW);
 	}
 	
 	function valSeguPasswordCompleto(textoPW){
		var longitud=textoPW.length;
		if(longitud > 2){
			for(var i=3;i<=longitud;i++){
				var textoPWTemp=textoPW.substring(i-3,i);
				var longitudTemp=textoPWTemp.length;
				var letra1=textoPWTemp.charCodeAt(longitudTemp-3);
				var letra2=textoPWTemp.charCodeAt(longitudTemp-2);
				var letra3=textoPWTemp.charCodeAt(longitudTemp-1);
				if(letra1 == letra2 && letra2 == letra3){
					alert("La contraseña no puede contener 3 caracteres idénticos en forma consecutiva.");
					return false;
				}
				if(letra1 == (letra2-1) && letra2 == (letra3-1)){
					alert("La contraseña no puede contener 3 caracteres consecutivos ascendentes.");
					return false;
				}
				if(letra1 == (letra2+1) && letra2 == (letra3+1)){
					alert("La contraseña no puede contener 3 caracteres consecutivos descendentes.");
					return false;
				}
			}
		}
		return true;
	}
	
	function validaPWCompleto(idUsuario){
		var textoPW=document.forms[0].password.value.toUpperCase();
		var longitud=textoPW.length;
		if(longitud < 8){
			alert("La contraseña debe tener al menos 8 caracteres.");
			return false;
		}
		if(textoPW.indexOf("AFIRME") != -1){
			alert("La contraseña no puede ser igual o contener la palabra AFIRME.");
			return false;
		}
		if(textoPW.indexOf(idUsuario) != -1){
			alert("La contraseña no puede ser igual o contener su clave de usuario.");
			return false;
		}
		if(valSeguPasswordCompleto(textoPW)==false){
			return false;
		}
		if(textoPW != document.forms[0].confirma.value.toUpperCase()){
			alert("La contraseña de confirmación debe ser igual a la nueva contraseña.");
			return false;
		}
		return true;
	}