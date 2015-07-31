package com.afirme.afirmenet.service.impl.transferencia;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.transferencia.ComisionesDao;
import com.afirme.afirmenet.enums.ComisionTransaccion;
import com.afirme.afirmenet.ibs.beans.transferencia.Comision;
import com.afirme.afirmenet.service.transferencia.ComisionesService;
@Service
public class ComisionesServiceImpl implements ComisionesService{

	@Autowired
	private ComisionesDao comisionesDao;
	public BigDecimal getFee(ComisionTransaccion transaccion, BigDecimal monto, String paqueteAfirmeNet, String numeroCliente){
		BigDecimal fee=BigDecimal.TEN;
		switch (transaccion) {
		case TRANSFERENCIA_SPEI:
				fee=comisionesDao.getNationalFee(transaccion, monto);
			break;
		case PAGO_INTERBANCARIO:
				fee=comisionesDao.getGeneralPIFee(paqueteAfirmeNet);
				//Revisamos si el cliente en particular tiene una comision especial
				Comision especial=comisionesDao.getEspecialPIFee(transaccion, numeroCliente);
				if(especial != null){
					//Si el porcentaje es diferente de cero utilizamos este
					if(especial.getPorcentaje().intValue() != 0)
			         {
			            BigDecimal porcentaje = new BigDecimal(100);
			            porcentaje = especial.getPorcentaje().divide(porcentaje);
			            fee = fee.subtract(fee.multiply(porcentaje));
			         }
			         else
			         {
			            fee = especial.getFija();
			         }
				}
			break;
		}
		 
		return fee;
	}
}
