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
					<h6>Medios Electrónicos</h6>

					<h6>El presente es un Agregado al Contrato de la Cuenta que Usted (en lo sucesivo el “Cliente”) y Banca Afirme, S. A.,
						Institución de Banca Múltiple, Afirme Grupo Financiero (en lo sucesivo "Afirme") tienen celebrada.</h6>

					<h6>1. Salvo que se indique lo contrario en el presente Agregado, Afirme y el Cliente (como se definen en la presente
						cláusula) están de acuerdo en que los siguientes términos (cuando se usen con mayúscula inicial) tendrán los significados que a
						continuación se establecen que serán igualmente aplicados a las formas singular o plural de dichos términos:</h6>
					<h6>“Afirme”.- Significa Banca Afirme, S. A., Institución de Banca Múltiple, Afirme Grupo Financiero.</h6>
					<h6>“Cliente”.- Significa la persona física o moral que tiene aperturada la Cuenta en Afirme.</h6>
					<h6>“Cuenta”.- Significa el depósito bancario de dinero del Cliente, sin perjuicio de su naturaleza y del nombre o
						denominación comercial con el cual se identifique, el cual fue celebrado con Afirme y que se refiere el Estado de Cuenta adjunto
						al presente.</h6>
					<h6>“Datos de Creación de Firma Electrónica”.- Significan los datos únicos, como códigos o claves criptográficas privadas, que
						el Firmante genera de manera secreta y utiliza para crear su Firma Electrónica, a fin de lograr el vínculo entre dicha Firma
						Electrónica y el Firmante.</h6>
					<h6>“Dispositivos de Seguridad”.- Significan el(los) "Nombre(s) de Usuario", "Contraseña(s)", “Número(s) de
						Identificación Personal” y demás mecanismos, claves o elementos electrónicos de seguridad que servirán para tener acceso a los
						Sistemas de Información y que serán generados a solicitud del Cliente a través de Medios Electrónicos o por su comparecencia
						personal en la oficina de Afirme donde se encuentre aperturada la Cuenta, debiendo cumplir con las medidas de seguridad que Afirme
						determine en los propios Sistemas de Información, para brindar seguridad y control en el acceso a los mismos. Los Dispositivos de
						Seguridad deberán ser utilizados por el Cliente para hacer posible la ejecución de las Instrucciones materia del presente Agregado,
						relacionándose automáticamente en el Sistema de Información, los accesos efectuados con las funciones ejercidas o con las
						Instrucciones ejecutadas. Dichos Dispositivos de Seguridad lo identificarán como Cliente de Afirme, le permitirán acceder a los
						distintos medios electrónicos reconocidos por las partes para efecto de concertar operaciones y servicios bancarios, y le
						permitirán concertar operaciones, ejercer derechos, cumplir obligaciones, hacer movimientos en la Cuenta y servicios, dar y
						recibir avisos y notificaciones, hacer requerimientos y girar cualquier otra instrucción en relación con la Cuenta y contratos
						que a su nombre lleve en Afirme.</h6>
					<h6>“Firma Electrónica”.- Significan los datos en forma electrónica consignados en un Mensaje de Datos, o adjuntados o
						lógicamente asociados al mismo por cualquier tecnología, que son utilizados para identificar al Firmante en relación con el Mensaje
						de Datos e indicar que el Firmante aprueba la información contenida en el Mensaje de Datos, y que produce los mismos efectos
						jurídicos que la firma autógrafa, siendo admisible como prueba en juicio.</h6>
					<h6>“Firmante”.- Significa el Cliente o Afirme, cuando alguno de éstos posea los Datos de Creación de la Firma Electrónica, o
						bien, la persona que represente a cualquiera de éstos.</h6>
					<h6>“Instrucciones”.- Significan todas aquellas comunicaciones que el Cliente emita a Afirme para celebrar operaciones concretas,
						ejercer derechos y cumplir obligaciones, dar y recibir avisos, todo a través de Medios Electrónicos, aún cuando no generen
						Mensajes de Datos.</h6>
					<h6>“Internet”.- Significa el medio electrónico de comunicación masivo a través del cual un equipo de cómputo que
						reúna un mínimo de características puede enviar y recibir datos, voz, vídeo y demás información a través de redes telefónicas
						locales o internacionales, vía cable o transmisión de ondas, vía satélite y demás redes públicas o privadas de comunicación,
						utilizando a su vez a diversas empresas proveedoras del servicio de conexión, que mediante la utilización de equipos de computo
						denominados servidores y ruteadores transfieren la información
						para que ésta llegue hacia el equipo de cómputo destinatario.</h6>
					<h6>“Medios Electrónicos”.- Significa individual o conjuntamente, de acuerdo a lo establecido en el presente
						Agregado, el teléfono, el fax, los cajeros automáticos, las tecnologías conocidas como GSM (Global System for Mobile
						communications), GPRS (General Packet Radio Service), GPS (Global Positioning System), CDMA (Code Division for Multiple Access),
						TDMA (Time Division for Multiple Access), BLUETOOTH o cualquier otra tecnología celular o de radio frecuencias que permitan
						utilizar SMS (servicio de mensajes cortos por sus siglas “Short Message Service”), MMS (servicio de mensajes multimedia, por sus
						siglas “Multimedia Messaging Service”) o cualquier otro servicio análogo, las terminales de cómputo, los Mensajes de Datos, la
						Firma Electrónica, Internet, los Sistemas de Información y aquellos elementos electrónicos que en el futuro se lleguen a
						considerar como tal, de acuerdo con las políticas generales de Afirme.</h6>
					<h6>“Mensaje de Datos”.- Significa la información generada, enviada, recibida o archivada por Medios Electrónicos, ópticos o
						cualquier otra tecnología.</h6>
					<h6>“Partes”.- Significan conjuntamente el Cliente y Afirme.</h6>
					<h6>“Sistemas de Información”.- Significan los programas, desarrollos tecnológicos y/o de telecomunicación, sistemas, y
						cualquier otro documento electrónico o conjunto de información, desarrollados e implementados por Afirme, los cuales son puestos a
						disposición del Cliente a través de Internet o cualquier otro Medio Electrónico para generar, enviar, recibir, archivar o
						procesar de alguna otra forma Mensajes de Datos y cualquier otro elemento electrónico.</h6>
					<h6>2. Afirme y el Cliente acuerdan implementar la utilización de Instrucciones habilitadas a través de Medios Electrónicos y/o
						los Sistemas de Información para ejercer derechos, cumplir obligaciones, efectuar notificaciones, dar y recibir avisos, hacer
						requerimientos, enviar datos, información y en general, acordar o convenir operaciones y servicios permitidos por Afirme a través de
						los Sistemas de Información. Asimismo, Afirme pone a disposición del Cliente servicios de información de todo tipo relacionados con
						la Cuenta a través de Medios Electrónicos o los Sistemas de Información.</h6>
					<h6>El Cliente se obliga a cumplir con las políticas y disposiciones pactadas previamente con Afirme, y con aquellas que
						éste determine para los servicios materia del presente Agregado, así también, las que Afirme de a conocer al Cliente a través de
						cualquier Medio Electrónico.</h6>
					<h6>El Cliente estará en posibilidad de contratar con Afirme otros servicios bancarios que complementen, amplíen o adicionen
						los servicios que se tengan actualmente convenidos, todo, a través de los Medios Electrónicos.</h6>
					<h6>Las operaciones y servicios referidos estarán sujetos a las posibilidades y disponibilidad que Afirme ofrezca al Cliente.</h6>

					<h6>3. Para efectos de crear una mayor seguridad respecto a las Instrucciones entre el Cliente y Afirme, convienen en que a
						partir de que surta los efectos legales correspondientes el presente Agregado conforme a lo estipulado en el contrato de
						apertura de la Cuenta entre el Cliente y Afirme en su respectivo apartado de modificaciones, Afirme podrá proporcionar al Cliente
						los Dispositivos de Seguridad correspondientes y demás elementos de seguridad que determine, no estando obligado Afirme a
						considerar válidas aquéllas Instrucciones no impresas que no contengan dichas Firmas Electrónicas o Dispositivos de Seguridad.
						Afirme se reserva el derecho de solicitar en cualquier momento la confirmación de las Instrucciones suscrita autógrafamente por el
						Cliente.</h6>
					<h6>El Cliente consiente que Afirme grabe las conversaciones telefónicas que se realicen entre ellos con motivo de dar
						seguridad y control a cualquier Medio Electrónico o Dispositivo de Seguridad. El contenido de tales grabaciones constituirán prueba
						plena.</h6>

					<h6>4. Cuando Afirme se encuentre en posibilidad de incorporar nuevos Medios Electrónicos para la prestación de servicios materia
						del presente Agregado, así lo comunicará al Cliente junto con las bases para determinar los servicios que podrán contratarse a
						través del Medio Electrónico de que se trate, los medios de identificación del usuario y las responsabilidades
						correspondientes a su uso, conviniendo expresamente las partes desde ahora que su utilización por parte del Cliente implica la
						aceptación del equipo, sistema o Medios Electrónicos y de todos los efectos jurídicos de éstos derivados.</h6>

					<h6>5. La utilización de los Sistemas de Información, así como el acceso y uso de éstos a través de Internet o cualquier otro
						Medio Electrónico, constituirán la aceptación plena por parte del Cliente de (i) los términos y condiciones vigentes en cada momento
						en que el Cliente acceda y/o utilice los mismos y (ii) cualesquiera modificaciones de los mismos que hayan sido
						debidamente comunicados al Cliente a través de Medios Electrónicos o se encuentren en los mismos Sistemas de Información.</h6>

					<h6>6. Afirme no será en ningún caso responsable por incumplimiento en las Instrucciones recibidas del Cliente, cuando
						la falta de cumplimiento se deba al mantenimiento, fallas, casos fortuito o de fuerza mayor, por fallas en el funcionamiento de
						sistemas de computación o interrupción en los Sistemas de Información o algún acontecimiento similar, fuera del control de
						Afirme.</h6>
					<h6>El Cliente manifiesta y acepta expresamente que Afirme no será responsable de ningún daño o perjuicio que se le pudiera
						causar si por caso fortuito, fuerza mayor o por cualquier otro acontecimiento o circunstancia inevitable, más allá del control de
						Afirme, no pudiera hacer uso de los Sistemas de Información o realizar alguna de las operaciones que el mismo ofrece. Así
						también, Afirme no tendrá responsabilidad alguna por la interrupción, demora o falta de cumplimiento de cualquier
						Instrucción que se presente a través de los Sistemas de Información y/o cualquier otro Medio Electrónico, quedando Afirme
						libre de cualquier responsabilidad asociada con cualesquier virus que pudiera causar en el equipo de cómputo o software del Cliente.</h6>

					<h6>7. El Cliente manifiesta que Afirme no será responsable por ningún daño y/o perjuicio que se le llegue a ocasionar por la
						falta de veracidad, vigencia y/o autenticidad de la información que el mismo Cliente, o cualquier tercero ajeno o no a él, dé de
						alta en los Sistemas de Información o procedimientos de seguridad de Afirme y por cualquier medio engañe dichos Sistemas de
						Información o Dispositivos de Seguridad establecidos por Afirme. Lo anterior, con independencia de las sanciones penales que
						determinen las leyes aplicables en materia de alteración de medios de identificación electrónica o de delitos por medios
						electrónicos.</h6>
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