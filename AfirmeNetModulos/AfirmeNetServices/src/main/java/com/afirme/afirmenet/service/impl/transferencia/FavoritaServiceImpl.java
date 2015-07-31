package com.afirme.afirmenet.service.impl.transferencia;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.transferencia.FavoritaDao;
import com.afirme.afirmenet.enums.TipoServicio;
import com.afirme.afirmenet.ibs.beans.consultas.Cuenta;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.Favorita;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.service.consultas.CuentaService;
import com.afirme.afirmenet.service.transferencia.FavoritaService;

@Service
public class FavoritaServiceImpl implements FavoritaService {

	static final Logger LOG = LoggerFactory
			.getLogger(FavoritaServiceImpl.class);
	@Autowired
	private FavoritaDao favoritaDao;

	@Autowired
	private CuentaService cuentaService;
	@Override
	public void procesaFavoritas(List<Comprobante> comprobantes) {
		try {
			for (Comprobante comprobante : comprobantes) {
				if (comprobante.getErrores() == null
						|| comprobante.getErrores().isEmpty()) {
					// Se validan las transferencias ejecutadas como exitosas
					if (comprobante.isAgregarFavoritas()) {
						// Se valida que la conbinacion de cuenta cargo, cuenta
						// destino
						favoritaDao.agregar(getFavorita(comprobante));
						// Se marca como favorita
						comprobante.setEsFavoritas(true);
					} else {
						// Valida si es favorita
						if (favoritaDao
								.existeFavorita(getFavorita(comprobante))) {
							// Se marca como favorita
							comprobante.setEsFavoritas(true);
						}
					}
				}
			}
		} catch (Exception e) {
			// Previene un error al momento de procesar a favoritos
			LOG.info("Ocurrio un error al procesaro la operacion como favorita: "
					+ e.getMessage());
			LOG.error(
					"Ocurrio un error al procesaro la operacion como favorita",
					e);
		}

	}

	private Favorita getFavorita(Comprobante comprobante) {
		Favorita favorita = new Favorita();
		BeanUtils.copyProperties(comprobante, favorita);
		favorita.setTipoTransferencia(TipoTransferencia.findByValue(comprobante
				.getTransactionCode()));
		if (comprobante.getTipoServicio() != null) {
			favorita.setTipoServicio(comprobante.getTipoServicio());
		} else if (comprobante.getServiceType() > 0) {
			favorita.setTipoServicio(TipoServicio.findByValue(String
					.valueOf(comprobante.getServiceType())));
		}
		favorita.setOrigen(comprobante.getOrigen());
		favorita.setDestino(comprobante.getDestino());
		favorita.setNumeroServicio(comprobante.getServiceNumber());
		return favorita;
	}

	@Override
	public List<Favorita> getFavoritas(String contractId, int cuantas) {
		List<Favorita> favoritasTemp = favoritaDao.listar(contractId);
		List<Favorita> favoritas = new ArrayList<Favorita>(0);
		List<Cuenta> cuentas = cuentaService.getCuentas(contractId, "", false);

		if (cuantas == 0 || cuantas > (favoritasTemp.size())) {
			cuantas = favoritasTemp.size() - 1;
		}
		for (int i = cuantas, x = 0; i > 0; i--, x++) {
			favoritas.add(favoritasTemp.get(x));
		}
		for(Favorita fav: favoritas){
			for(Cuenta cta: cuentas){
				if(fav.getOrigen().getNumber().equals(cta.getNumber())){
					fav.setOrigen(cta);
					break;
				}
			}
		}
		return favoritas;
	}

	@Override
	public void actualizaFavoritas(List<Favorita> favoritas) {
		for (Favorita favorita : favoritas) {
			if (favorita.isEjecutar()) {
				favoritaDao.modificar(favorita);
			}
		}

	}

}
