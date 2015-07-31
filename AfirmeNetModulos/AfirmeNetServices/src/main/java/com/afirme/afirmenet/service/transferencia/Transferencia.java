package com.afirme.afirmenet.service.transferencia;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afirme.afirmenet.dao.transferencia.ComprobanteTransferenciaDao;
import com.afirme.afirmenet.dao.transferencia.ParametricasUsuarioDao;
import com.afirme.afirmenet.model.transferencia.Comprobante;
import com.afirme.afirmenet.model.transferencia.ComprobanteTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoTransferencia;
import com.afirme.afirmenet.model.transferencia.TipoValidacion;
import com.afirme.afirmenet.model.transferencia.TipoValidacionEspecial;
import com.afirme.afirmenet.model.transferencia.TransferenciaBase;

/**
 * Clase se soporte para todas las transferencias soportadas por afirmenet, en
 * esta calse se define el comportamiento principal de una tranferencia
 * 
 * @author jorge.canoc@gmail.com
 * 
 */
@Component
public abstract class Transferencia {

	static final Logger LOG = LoggerFactory
			.getLogger(Transferencia.class);
	@Autowired
	private ParametricasUsuarioDao parametricasTransaccionDao;
	@Autowired
	protected ValidacionTransferenciaService validacion;
	@Autowired
	protected FavoritaService favoritaService;	
	@Autowired
	private ComprobanteTransferenciaDao comprobanteTransferenciaDao;

	protected List<TransferenciaBase> transferencias;

	protected TipoTransferencia tipoTransferencia;
	
	protected List<TransferenciaBase> pagos;

	/**
	 * Constructor default que indica que tipo de transferencia es la que sera
	 * atendida.
	 * 
	 * @param tipoTransferencia
	 */
	protected Transferencia(TipoTransferencia tipoTransferencia) {
		super();
		this.tipoTransferencia = tipoTransferencia;
	}

	/**
	 * Metodo abstracto que provee la implementacion especifica para ejecutar
	 * cada trasferencia que sea implementada
	 * 
	 * @return
	 */
	public abstract TransferenciaAfirmeNet getTransferenciaService();

	/**
	 * Metodo abstracto que provee las validaciones especificas a aplicar a cada
	 * tipo de transferencia, en caso que esta lista sea vacia o nula se
	 * ejecutan todas las transferencias definidas en {@link TipoValidacion}
	 * 
	 * @return
	 */
	public abstract List<TipoValidacion> getValidaciones();

	/**
	 * Metodo que provee las validaciones especificas para cierto tipo de
	 * transferencia son ejecutadas desde el metodo valida de esta clase
	 * 
	 * @return la lista de validacion a aplicar
	 */
	public abstract List<TipoValidacionEspecial> getValidacionesEspecificas();

	/**
	 * Metodo que permite realizar una validacion previa a la ejecucion de las
	 * transferencias contenidas en la lista de transferencias de esta clase
	 * 
	 * @param transferencias
	 */
	public void validaTransferencias(List<TransferenciaBase> transferencias) {
		validacion.applyValidations(transferencias, tipoTransferencia,
				getValidaciones());
	}

	/**
	 * Metodo abstracto que permite realizar valdiaciones especificas sobre la
	 * lista de transferencias contenidas en esta clase
	 * 
	 * @param transferencias
	 */
	public abstract void valida(List<? extends TransferenciaBase> transferencias);
	
	/**
	 * Metodo que ejecuta la lista de transferencias contenidas en esta clase.
	 * La secuencia de ejecucion es la siguiente
	 * <ul>
	 * <li>Aplica Validaciones Generales mediante el metodo applyValidations</li>
	 * <li>Aplica Validaciones Particulares mediante el metodo valida</li>
	 * <li>Ejecuta las transferencias mediante el metodo ejecutaTransferencia</li>
	 * </ul>
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<? extends ComprobanteTransferencia> confirmaTransferencias() {
		// Validaciones Generales:
		validacion.applyValidations(transferencias, tipoTransferencia,
				getValidaciones());
		// Validaciones Particulares
		valida(transferencias);
		// Ejecuta Transaccion
		List<? extends ComprobanteTransferencia> comprobantes = getTransferenciaService()
				.ejecutaTransferencia(transferencias);
		//Actualiza informacion de limites diario y mensual
		actualizaInformacionParameterica((List<Comprobante>) comprobantes);
		// Validacion si fue marcada como favoritos
		favoritaService.procesaFavoritas((List<Comprobante>) comprobantes);
		// Inserta Informacion de Comprobantes
		insertaComprobate((List<Comprobante>)comprobantes);

		return comprobantes;
	}
	
	private void insertaComprobate(List<Comprobante> comprobantes){
		for(Comprobante comprobante: comprobantes){
			if(comprobante.getErrores() == null || comprobante.getErrores().isEmpty()){ //Transaccion Exitosa
				try{
					comprobanteTransferenciaDao.insertaConfirmacionOperacion(comprobante);
				}catch(Exception e){
					LOG.info("===> Error al actualizar la informacion de comprobantes <===");
					LOG.info("===> Informacion de Comprobante <===");
					LOG.info("===> " + comprobante);
					LOG.error("===> Error al actualizar la informacion de comprobantes <===", e);
				}				
			}
		}		
	}
	
	private void actualizaInformacionParameterica(List<Comprobante> comprobantes){
		for(Comprobante comprobante: comprobantes){
			if(comprobante.getErrores() == null || comprobante.getErrores().isEmpty()){ //Transaccion Exitosa
				try{
					parametricasTransaccionDao.insert(comprobante);
				}catch(Exception e){
					LOG.info("===> Error al actualizar la informacion parametrica <===");
					LOG.info("===> Informacion de Comprobante <===");
					LOG.info("===> " + comprobante);
					LOG.error("===> Error al actualizar la informacion parametrica <===", e);
				}				
			}
		}

	}

	public void delete(TransferenciaBase transferencia) throws SQLException {
		parametricasTransaccionDao.delete(
				Long.valueOf(transferencia.getContractId()),
				transferencia.getReferenceNumber());
	}

	public List<TransferenciaBase> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<TransferenciaBase> transferencias) {
		this.transferencias = transferencias;
	}
	
	public List<TransferenciaBase> getPagos() {
		return pagos;
	}

	public void setPagos(List<TransferenciaBase> pagos) {
		this.pagos = pagos;
	}	
}
