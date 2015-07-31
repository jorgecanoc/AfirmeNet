package com.afirme.afirmenet.enums;

/**
 * Para ver mas informacion sobre los codigos ver la tabla de AS400
 * IBSR04M07.MSSGS
 * <ul>
 * <li>2900 No hay registros para la búsqueda</li>
 * <li>2901 El Usuario que autoriza no puede ser el mismo que ingresó la
 * transacción</li>
 * <li>2902 Sólo el Usuario que ingresa la transacción puede modificarla</li>
 * <li>2903 Solo el usuario que opera puede eliminar</li>
 * <li>2904 Para ingresar una operación usuario debe ser Operador o Ambos</li>
 * <li>2904 Para ingresar una transaccion Ud. debe ser Operador o Ambos</li>
 * <li>2905 Para Aprobar una transaccion Ud. debe ser Supervisor o Ambos</li>
 * <li>2906 Ud. necesita una transacción para esta acción</li>
 * <li>2907 Ud. necesita una o mas cuentas de detalle para Ingresar una
 * Transaccion</li>
 * <li>2908 Monto excede su Limite Autorizado</li>
 * <li>2909 Cuenta ya fue Agregada Favor de Verificar</li>
 * <li>2910 Ud. necesita dos o mas cuentas de detalle para agregar una
 * transaccion</li>
 * <li>2911 La Fecha/Hora Programacion es posterior a la Fecha/Hora Actual</li>
 * <li>2912 Monto de la Transaccion es Menor al Minimo</li>
 * <li>2913 La fecha u hora de Programacion es Invalida, Favor de Verificar</li>
 * <li>2914 CON ESTA TRANSACCION SOBREPASA SU LIMITE MENSUAL APROBADO</li>
 * <li>2915 Numero de Cuenta Invalido Por Favor Verifique, Gracias</li>
 * <li>2916 TRANSACCION YA FUE PROCESADA, GRACIAS</li>
 * <li>2917 CUENTA ASIGNADA COMO CUENTA PROPIA</li>
 * <li>2918 NUMERO DE CUENTA CLABE INVALIDA</li>
 * <li>2919 Cuenta de cargo y abono deben ser de diferente tipo</li>
 * <li>2920 Nombre o Apellido no coincide con los del cliente</li>
 * <li>2921 Numero de cuenta no corresponde al cliente</li>
 * <li>2922 RFC no corresponde al cliente</li>
 * <li>2923 Nombre de usuario deseado diferente a la confirmacion</li>
 * <li>2924 Contrasena deseada diferente a la confirmacion</li>
 * <li>2925 Favor ingresar el nombre de usuario</li>
 * <li>2926 Este Nombre de Usuario ya ha sido registrado anteriormente</li>
 * <li>2927 Favor de ingresar su contraseña</li>
 * <li>2928 Favor ingrese la respuesta a la pregunta secreta</li>
 * <li>2929 Usuario no registrado en el sistema</li>
 * <li>2930 Numero de Tarjeta de Credito Invalida</li>
 * <li>2931 Fuera del horario permitido, le sugerimos programar esta operacion.</li>
 * <li>2932 La fecha de programación no esta permitida para esta transacción</li>
 * <li>2933 El total de las transacciones sobregira la cuenta.</li>
 * <li>2934 Registro duplicado, una de las operaciones rechazada, favor
 * verifique</li>
 * </ul>
 * 
 * @author Jorge.canoc@gmail.com
 * 
 */
public enum CodigoExcepcion {
	ERR_2900(2900), ERR_2901(2901), ERR_2902(2902), ERR_2903(2903), ERR_2904(
			2904), ERR_2905(2905), ERR_2906(2906), ERR_2907(2907), ERR_2908(
			2908), ERR_2909(2909), ERR_2910(2910), ERR_2911(2911), ERR_2912(
			2912), ERR_2913(2913), ERR_2914(2914), ERR_2915(2915), ERR_2916(
			2916), ERR_2917(2917), ERR_2918(2918), ERR_2919(2919), ERR_2920(
			2920), ERR_2921(2921), ERR_2922(2922), ERR_2923(2923), ERR_2924(
			2924), ERR_2925(2925), ERR_2926(2926), ERR_2927(2927), ERR_2928(
			2928), ERR_2929(2929), ERR_2930(2930), ERR_2931(2931), ERR_2932(
			2932), ERR_2933(2933), ERR_2934(2934), ERR_2935(2935), ERR_2936(
			2936), ERR_2937(2937), ERR_2938(2938), ERR_3000(3000), ERR_3001(
			3001), ERR_3002(3002), ERR_3003(3003);

	CodigoExcepcion(Integer value) {
		this.value = value;
	}

	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public static CodigoExcepcion findByValue(Integer value) {

		for (CodigoExcepcion excepcion : values()) {
			if (excepcion.getValue().intValue() == value.intValue()) {
				return excepcion;
			}
		}
		return null;
	}

}
