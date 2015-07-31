/**
*  This Class was created By Luis Velando
*  Copyright Datapro Inc. 1999
**/

package com.afirme.afirmenet.ibs.objects;

import com.afirme.afirmenet.security.SHA1;


public class JOEncrypt{

	public JOEncrypt() {
	}

	public String getEncrypt(String Password) {

		String error = "0";

		SHA1 secpsw = new SHA1();

		if (!secpsw.selfTest()) {
			error = "1";
		}
		else {

			secpsw.clear();
			secpsw.update(Password.trim());
			secpsw.finalize();

			error = secpsw.toString().trim();
		}

			return (error);

		}

	}