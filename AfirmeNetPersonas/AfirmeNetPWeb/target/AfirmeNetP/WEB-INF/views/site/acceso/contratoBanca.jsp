<%@ include file="/WEB-INF/views/base/include/include.jsp"%>
<link href='<c:url value="/resources/css/login.css"/>' rel="stylesheet" type="text/css">
<%@ include file="/WEB-INF/views/base/include/header.jsp"%>

<form:form method="POST" commandName="activacion">
<form:hidden path="contrato" id="contrato" />
<form:hidden path="serialToken" id="serialToken" />

	<div class="aviso">
		<div class="container">

			<h3 align="center">
				<span class="op50"><spring:message code="afirmenet.activacion"/></span> <br> <strong><spring:message code="afirmenet.contrato"/></strong>
			</h3>

			<div class="contrato">
				<div>
					<h6>AGREGADO</h6>
					<h6>Medios Electr�nicos</h6>

					<h6>El presente es un Agregado al Contrato de la Cuenta que Usted (en lo sucesivo el �Cliente�) y Banca Afirme, S. A.,
						Instituci�n de Banca M�ltiple, Afirme Grupo Financiero (en lo sucesivo "Afirme") tienen celebrada.</h6>

					<h6>1. Salvo que se indique lo contrario en el presente Agregado, Afirme y el Cliente (como se definen en la presente
						cl�usula) est�n de acuerdo en que los siguientes t�rminos (cuando se usen con may�scula inicial) tendr�n los significados que a
						continuaci�n se establecen que ser�n igualmente aplicados a las formas singular o plural de dichos t�rminos:</h6>
					<h6>�Afirme�.- Significa Banca Afirme, S. A., Instituci�n de Banca M�ltiple, Afirme Grupo Financiero.</h6>
					<h6>�Cliente�.- Significa la persona f�sica o moral que tiene aperturada la Cuenta en Afirme.</h6>
					<h6>�Cuenta�.- Significa el dep�sito bancario de dinero del Cliente, sin perjuicio de su naturaleza y del nombre o
						denominaci�n comercial con el cual se identifique, el cual fue celebrado con Afirme y que se refiere el Estado de Cuenta adjunto
						al presente.</h6>
					<h6>�Datos de Creaci�n de Firma Electr�nica�.- Significan los datos �nicos, como c�digos o claves criptogr�ficas privadas, que
						el Firmante genera de manera secreta y utiliza para crear su Firma Electr�nica, a fin de lograr el v�nculo entre dicha Firma
						Electr�nica y el Firmante.</h6>
					<h6>�Dispositivos de Seguridad�.- Significan el(los) "Nombre(s) de Usuario", "Contrase�a(s)", �N�mero(s) de
						Identificaci�n Personal� y dem�s mecanismos, claves o elementos electr�nicos de seguridad que servir�n para tener acceso a los
						Sistemas de Informaci�n y que ser�n generados a solicitud del Cliente a trav�s de Medios Electr�nicos o por su comparecencia
						personal en la oficina de Afirme donde se encuentre aperturada la Cuenta, debiendo cumplir con las medidas de seguridad que Afirme
						determine en los propios Sistemas de Informaci�n, para brindar seguridad y control en el acceso a los mismos. Los Dispositivos de
						Seguridad deber�n ser utilizados por el Cliente para hacer posible la ejecuci�n de las Instrucciones materia del presente Agregado,
						relacion�ndose autom�ticamente en el Sistema de Informaci�n, los accesos efectuados con las funciones ejercidas o con las
						Instrucciones ejecutadas. Dichos Dispositivos de Seguridad lo identificar�n como Cliente de Afirme, le permitir�n acceder a los
						distintos medios electr�nicos reconocidos por las partes para efecto de concertar operaciones y servicios bancarios, y le
						permitir�n concertar operaciones, ejercer derechos, cumplir obligaciones, hacer movimientos en la Cuenta y servicios, dar y
						recibir avisos y notificaciones, hacer requerimientos y girar cualquier otra instrucci�n en relaci�n con la Cuenta y contratos
						que a su nombre lleve en Afirme.</h6>
					<h6>�Firma Electr�nica�.- Significan los datos en forma electr�nica consignados en un Mensaje de Datos, o adjuntados o
						l�gicamente asociados al mismo por cualquier tecnolog�a, que son utilizados para identificar al Firmante en relaci�n con el Mensaje
						de Datos e indicar que el Firmante aprueba la informaci�n contenida en el Mensaje de Datos, y que produce los mismos efectos
						jur�dicos que la firma aut�grafa, siendo admisible como prueba en juicio.</h6>
					<h6>�Firmante�.- Significa el Cliente o Afirme, cuando alguno de �stos posea los Datos de Creaci�n de la Firma Electr�nica, o
						bien, la persona que represente a cualquiera de �stos.</h6>
					<h6>�Instrucciones�.- Significan todas aquellas comunicaciones que el Cliente emita a Afirme para celebrar operaciones concretas,
						ejercer derechos y cumplir obligaciones, dar y recibir avisos, todo a trav�s de Medios Electr�nicos, a�n cuando no generen
						Mensajes de Datos.</h6>
					<h6>�Internet�.- Significa el medio electr�nico de comunicaci�n masivo a trav�s del cual un equipo de c�mputo que
						re�na un m�nimo de caracter�sticas puede enviar y recibir datos, voz, v�deo y dem�s informaci�n a trav�s de redes telef�nicas
						locales o internacionales, v�a cable o transmisi�n de ondas, v�a sat�lite y dem�s redes p�blicas o privadas de comunicaci�n,
						utilizando a su vez a diversas empresas proveedoras del servicio de conexi�n, que mediante la utilizaci�n de equipos de computo
						denominados servidores y ruteadores transfieren la informaci�n
						para que �sta llegue hacia el equipo de c�mputo destinatario.</h6>
					<h6>�Medios Electr�nicos�.- Significa individual o conjuntamente, de acuerdo a lo establecido en el presente
						Agregado, el tel�fono, el fax, los cajeros autom�ticos, las tecnolog�as conocidas como GSM (Global System for Mobile
						communications), GPRS (General Packet Radio Service), GPS (Global Positioning System), CDMA (Code Division for Multiple Access),
						TDMA (Time Division for Multiple Access), BLUETOOTH o cualquier otra tecnolog�a celular o de radio frecuencias que permitan
						utilizar SMS (servicio de mensajes cortos por sus siglas �Short Message Service�), MMS (servicio de mensajes multimedia, por sus
						siglas �Multimedia Messaging Service�) o cualquier otro servicio an�logo, las terminales de c�mputo, los Mensajes de Datos, la
						Firma Electr�nica, Internet, los Sistemas de Informaci�n y aquellos elementos electr�nicos que en el futuro se lleguen a
						considerar como tal, de acuerdo con las pol�ticas generales de Afirme.</h6>
					<h6>�Mensaje de Datos�.- Significa la informaci�n generada, enviada, recibida o archivada por Medios Electr�nicos, �pticos o
						cualquier otra tecnolog�a.</h6>
					<h6>�Partes�.- Significan conjuntamente el Cliente y Afirme.</h6>
					<h6>�Sistemas de Informaci�n�.- Significan los programas, desarrollos tecnol�gicos y/o de telecomunicaci�n, sistemas, y
						cualquier otro documento electr�nico o conjunto de informaci�n, desarrollados e implementados por Afirme, los cuales son puestos a
						disposici�n del Cliente a trav�s de Internet o cualquier otro Medio Electr�nico para generar, enviar, recibir, archivar o
						procesar de alguna otra forma Mensajes de Datos y cualquier otro elemento electr�nico.</h6>
					<h6>2. Afirme y el Cliente acuerdan implementar la utilizaci�n de Instrucciones habilitadas a trav�s de Medios Electr�nicos y/o
						los Sistemas de Informaci�n para ejercer derechos, cumplir obligaciones, efectuar notificaciones, dar y recibir avisos, hacer
						requerimientos, enviar datos, informaci�n y en general, acordar o convenir operaciones y servicios permitidos por Afirme a trav�s de
						los Sistemas de Informaci�n. Asimismo, Afirme pone a disposici�n del Cliente servicios de informaci�n de todo tipo relacionados con
						la Cuenta a trav�s de Medios Electr�nicos o los Sistemas de Informaci�n.</h6>
					<h6>El Cliente se obliga a cumplir con las pol�ticas y disposiciones pactadas previamente con Afirme, y con aquellas que
						�ste determine para los servicios materia del presente Agregado, as� tambi�n, las que Afirme de a conocer al Cliente a trav�s de
						cualquier Medio Electr�nico.</h6>
					<h6>El Cliente estar� en posibilidad de contratar con Afirme otros servicios bancarios que complementen, ampl�en o adicionen
						los servicios que se tengan actualmente convenidos, todo, a trav�s de los Medios Electr�nicos.</h6>
					<h6>Las operaciones y servicios referidos estar�n sujetos a las posibilidades y disponibilidad que Afirme ofrezca al Cliente.</h6>

					<h6>3. Para efectos de crear una mayor seguridad respecto a las Instrucciones entre el Cliente y Afirme, convienen en que a
						partir de que surta los efectos legales correspondientes el presente Agregado conforme a lo estipulado en el contrato de
						apertura de la Cuenta entre el Cliente y Afirme en su respectivo apartado de modificaciones, Afirme podr� proporcionar al Cliente
						los Dispositivos de Seguridad correspondientes y dem�s elementos de seguridad que determine, no estando obligado Afirme a
						considerar v�lidas aqu�llas Instrucciones no impresas que no contengan dichas Firmas Electr�nicas o Dispositivos de Seguridad.
						Afirme se reserva el derecho de solicitar en cualquier momento la confirmaci�n de las Instrucciones suscrita aut�grafamente por el
						Cliente.</h6>
					<h6>El Cliente consiente que Afirme grabe las conversaciones telef�nicas que se realicen entre ellos con motivo de dar
						seguridad y control a cualquier Medio Electr�nico o Dispositivo de Seguridad. El contenido de tales grabaciones constituir�n prueba
						plena.</h6>

					<h6>4. Cuando Afirme se encuentre en posibilidad de incorporar nuevos Medios Electr�nicos para la prestaci�n de servicios materia
						del presente Agregado, as� lo comunicar� al Cliente junto con las bases para determinar los servicios que podr�n contratarse a
						trav�s del Medio Electr�nico de que se trate, los medios de identificaci�n del usuario y las responsabilidades
						correspondientes a su uso, conviniendo expresamente las partes desde ahora que su utilizaci�n por parte del Cliente implica la
						aceptaci�n del equipo, sistema o Medios Electr�nicos y de todos los efectos jur�dicos de �stos derivados.</h6>

					<h6>5. La utilizaci�n de los Sistemas de Informaci�n, as� como el acceso y uso de �stos a trav�s de Internet o cualquier otro
						Medio Electr�nico, constituir�n la aceptaci�n plena por parte del Cliente de (i) los t�rminos y condiciones vigentes en cada momento
						en que el Cliente acceda y/o utilice los mismos y (ii) cualesquiera modificaciones de los mismos que hayan sido
						debidamente comunicados al Cliente a trav�s de Medios Electr�nicos o se encuentren en los mismos Sistemas de Informaci�n.</h6>

					<h6>6. Afirme no ser� en ning�n caso responsable por incumplimiento en las Instrucciones recibidas del Cliente, cuando
						la falta de cumplimiento se deba al mantenimiento, fallas, casos fortuito o de fuerza mayor, por fallas en el funcionamiento de
						sistemas de computaci�n o interrupci�n en los Sistemas de Informaci�n o alg�n acontecimiento similar, fuera del control de
						Afirme.</h6>
					<h6>El Cliente manifiesta y acepta expresamente que Afirme no ser� responsable de ning�n da�o o perjuicio que se le pudiera
						causar si por caso fortuito, fuerza mayor o por cualquier otro acontecimiento o circunstancia inevitable, m�s all� del control de
						Afirme, no pudiera hacer uso de los Sistemas de Informaci�n o realizar alguna de las operaciones que el mismo ofrece. As�
						tambi�n, Afirme no tendr� responsabilidad alguna por la interrupci�n, demora o falta de cumplimiento de cualquier
						Instrucci�n que se presente a trav�s de los Sistemas de Informaci�n y/o cualquier otro Medio Electr�nico, quedando Afirme
						libre de cualquier responsabilidad asociada con cualesquier virus que pudiera causar en el equipo de c�mputo o software del Cliente.</h6>

					<h6>7. El Cliente manifiesta que Afirme no ser� responsable por ning�n da�o y/o perjuicio que se le llegue a ocasionar por la
						falta de veracidad, vigencia y/o autenticidad de la informaci�n que el mismo Cliente, o cualquier tercero ajeno o no a �l, d� de
						alta en los Sistemas de Informaci�n o procedimientos de seguridad de Afirme y por cualquier medio enga�e dichos Sistemas de
						Informaci�n o Dispositivos de Seguridad establecidos por Afirme. Lo anterior, con independencia de las sanciones penales que
						determinen las leyes aplicables en materia de alteraci�n de medios de identificaci�n electr�nica o de delitos por medios
						electr�nicos.</h6>
				</div>
			</div>

			<div align="center">
				<a href="javascript: submitFormAnimate('activacion', 'controlAcceso/preguntaSecreta.htm');" class="btn verde mb20"><spring:message code="afirmenet.acuerdo"/></a>
				<h6 class="f-negro"><spring:message code="afirmenet.desacuerdo"/></h6>
				<a href="#" class="btn sec"><spring:message code="afirmenet.cancelar"/></a>
			</div>

		</div>
	</div>

</form:form>
<%@ include file="/WEB-INF/views/base/include/footer.jsp"%>