package com.afirme.afirmenet.service.impl.token;

import org.springframework.stereotype.Service;
import com.afirme.afirmenet.service.token.ValidaTokenService;

@Service
public class ValidaTokenServiceImpl implements ValidaTokenService{

	@Override
	public boolean validaClave(String passCode, String contrato,
			String usuario,	boolean basicoSinToken) {
		boolean sResp=true;
		
		return sResp;
		
	}

}
