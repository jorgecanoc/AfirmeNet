package com.afirme.afirmenet.utils.string;

import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void formatearMensaje() {
		String unaCadena = "Por ser un cliente mat�n, tenemos para ti la nueva tarjeta matona, "
				+ "�nica que te regresa el $b5% de tus compras en efectivo ademas de contar con anualidad $b0 de por vida. "
				+ "Solic�tala ahora mismo";
		String unPatron = "$b";
		String pre = "<strong>";
		String post = "</strong>";

		String out = StringUtils.formateaMensaje(unaCadena, unPatron, null,
				pre, post, false);

		System.out.println("Cadena con formato ==>" + out);
	}

}
