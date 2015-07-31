package com.afirme.afirmenet.service.impl.transferencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.enums.CodigoExcepcion;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.exception.AfirmeNetException;
import com.afirme.afirmenet.ibs.databeans.INSER;
import com.afirme.afirmenet.model.pagos.servicios.Servicio;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.Favorita;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;
import com.afirme.afirmenet.model.transferencia.TransferenciaCuentasPropias;
import com.afirme.afirmenet.service.pagos.PagosService;
import com.afirme.afirmenet.service.transferencia.TransferenciaAfirmeNet;
import com.afirme.afirmenet.service.transferencia.TransferenciaPagoServiciosService;
import com.afirme.afirmenet.service.transferencia.TransferenciaPropiasService;
import com.afirme.afirmenet.service.transferencia.TransferenciaTercerosService;

@Service("transferenciaFavoritosServiceImpl")
public class TransferenciaFavoritosServiceImpl implements
		TransferenciaAfirmeNet {

	@Autowired
	TransferenciaTercerosService tercerosService;
	
	@Autowired
	TransferenciaPropiasService propiasService;
	
	@Autowired
	TransferenciaPagoServiciosService pagoServiciosService;
	
	@Autowired
	PagosService pagosService;
	
	@Override
	public ComprobanteTransferencia ejecutaTransferencia(
			TransferenciaBase transferenciaBase) throws AfirmeNetException {
		return null;
	}

	@Override
	public List<? extends ComprobanteTransferencia> ejecutaTransferencia(
			List<TransferenciaBase> transferencias) {
		List<ComprobanteTransferencia> comprobantes = new ArrayList<ComprobanteTransferencia>(
				0);
		List<TransferenciaBase> base = null;
		
		for (TransferenciaBase tx : transferencias) {
			try {
				if(tx.getErrores() == null || tx.getErrores().isEmpty()){
					base =  new ArrayList<TransferenciaBase>(0);
					
					if(tx.getTipoTransferencia().equals(TipoTransferencia.TRASPASO_PROPIAS)){
						//Se cambia el tipo de transferencia de favorita a propia
						TransferenciaCuentasPropias propias = new TransferenciaCuentasPropias();
						BeanUtils.copyProperties(tx, propias);

						base.add(propias);
						propiasService.setTransferencias(base);
						comprobantes.addAll(propiasService.confirmaTransferencias());
					}else if(tx.getTipoTransferencia().equals(TipoTransferencia.TRASPASO_TERCEROS)){
						
						base.add(tx);
						tercerosService.setTransferencias(base);
						comprobantes.addAll(tercerosService.confirmaTransferencias());
					}else if(tx.getTipoTransferencia().equals(TipoTransferencia.PAGO_DE_SERVICIOS)){
						Favorita fav = (Favorita) tx;
						Servicio servicio =new Servicio();
						BeanUtils.copyProperties(tx, servicio);
						servicio.setServiceType(Integer.valueOf(servicio.getTipoServicio().getValor()));
						//Set info favoritas
						if(fav.getTipoServicio() != null && fav.getTipoServicio().equals(TipoServicio.TELEFONOS_DE_MEXICO)){
							servicio.setCreditAccount(fav.getReferenceNumber());
							servicio.setServiceNumber(fav.getReferenceNumber());	
							servicio.setLada(fav.getReferenceNumber().substring(0,2));
							servicio.setNumeroTelefonico(fav.getReferenceNumber().substring(2,fav.getReferenceNumber().length()));
							servicio.setEsFavoritas(true);
						}else{
							servicio.setReferenceNumber(fav.getReferenceNumber());
						}
						
						//Obtiene informacion de servicio
						INSER inser = pagosService.getConvenio(servicio.getTipoServicio().getValorComercial());						
						servicio.setIdServicio400(inser.getSERDTR().intValue());
						servicio.setUserId(servicio.getContractId());
						servicio.setBeneficiaryName(fav.getBeneficiaryName());
						base.add(servicio);
						pagoServiciosService.setTransferencias(base);
						comprobantes.addAll(pagoServiciosService.confirmaTransferencias());
					}
				}else{
					Comprobante comprobante = new Comprobante(tx);
					comprobantes.add(comprobante);
				}
				
			} catch (AfirmeNetException e) {
				Comprobante comprobante = new Comprobante(tx);
				Map<CodigoExcepcion, String> errors = new HashMap<CodigoExcepcion, String>(
						0);
				CodigoExcepcion error = CodigoExcepcion.findByValue(Integer
						.valueOf(e.getErrCode()));
				if (error == null) {
					// Error generico
					error = CodigoExcepcion.ERR_3000;
					errors.put(error, e.getMessage());
				} else {
					errors.put(error, e.getErrMsg());
				}
				comprobante.setErrores(errors);
				comprobantes.add(comprobante);
			}
		}
		return comprobantes;
	}

}
