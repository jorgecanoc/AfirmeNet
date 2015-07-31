package com.afirme.afirmenet.dao.impl.consultas;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.AS400Dao;
import com.afirme.afirmenet.dao.consultas.MovimientoDao;
import com.afirme.afirmenet.ibs.beans.consultas.Consulta;
import com.afirme.afirmenet.ibs.beans.consultas.Movimiento;
import com.afirme.afirmenet.utils.AfirmeNetConstants;
@Repository
public class MovimientoDaoImpl implements MovimientoDao{
	static final Logger LOG = LoggerFactory.getLogger(MovimientoDaoImpl.class);

	@Autowired
	private AS400Dao as400Dao;
	
	@Override
	public Consulta consultaOrdenada(Consulta consulta) {
		//Consulta consulta= new Consulta();
		Connection cnx = null;
		try {
//			consulta.setUsuario(usuario);
//			consulta.setCuenta(cuenta);
//			consulta.setClave(clave);
//			consulta.setFechaInicio(fechaInicio);
//			consulta.setFechaFin(fechaFin);
//			consulta.setReferenciaFinal(referenciaFinal);
//			consulta.setReferenciaInicial(referenciaInicial);
//			consulta.setMontoInicial(montoInicial);
//			consulta.setMontoFinal(montoFinal);
//			consulta.setPaginaActual(paginaActual);
//			
			List<Movimiento> oListaMovs = new ArrayList<Movimiento>();
			cnx = as400Dao.getAs400DataSource().getConnection();
//			consulta.setRegXpagina(regXpag);
			// Statement st = cnx.createStatement();
			String STM = "Call " + AfirmeNetConstants.AS400_LIBRARY + "CONS_EDOCTA("
					+ "?,?,?," + "?,?,?," + "?,?,?," + "?,?,?," + "?,?,?,"
					+ "?,?,"+ "?,?" + ")";
			CallableStatement cs = null;
			cs = cnx.prepareCall(STM);
			int i = 1;
			cs.setString(i++, consulta.getUsuario());
			cs.setBigDecimal(i++, consulta.getCuenta());
			cs.setString(i++, consulta.getClave());
			cs.setBigDecimal(i++, consulta.getFechaInicio());
			cs.setBigDecimal(i++, consulta.getFechaFin());
			cs.setBigDecimal(i++, consulta.getReferenciaInicial());
			cs.setBigDecimal(i++, consulta.getReferenciaFinal());
			cs.setBigDecimal(i++, consulta.getMontoInicial());
			cs.setBigDecimal(i++, consulta.getMontoFinal());
			cs.setBigDecimal(i++, new BigDecimal(consulta.getRegXpagina()));
			cs.setBigDecimal(i++, new BigDecimal(consulta.getPaginaActual()));
			int j = i;
			cs.setString(i++, "");
			cs.setString(i++, "");
			cs.setString(i++, "");
			cs.setString(i++, "");
			cs.setString(i++, "");
			cs.setString(i++, "");
			cs.setString(i++, "");
			cs.setString(i++, "");
			i = j;
			cs.registerOutParameter(i++, Types.VARCHAR);
			cs.registerOutParameter(i++, java.sql.Types.VARCHAR);
			cs.registerOutParameter(i++, java.sql.Types.VARCHAR);
			cs.registerOutParameter(i++, java.sql.Types.VARCHAR);
			cs.registerOutParameter(i++, java.sql.Types.VARCHAR);
			cs.registerOutParameter(i++, java.sql.Types.VARCHAR);
			cs.registerOutParameter(i++, java.sql.Types.VARCHAR);
			cs.registerOutParameter(i++, java.sql.Types.VARCHAR);
			j = i - 8;

			// execute getDBUSERByUserId store procedure
			ResultSet rs = cs.executeQuery();
			if (consulta.getPaginaActual() == 1) {
				consulta.setRegistros(Integer.parseInt(cs.getString(j++)
						.trim()));
				consulta.setPaginas(Integer.parseInt(cs.getString(j++)
						.trim()));
				consulta.setNumCargos(Integer.parseInt(cs.getString(j++).trim()));
				consulta.setNumAbonos(Integer.parseInt(cs.getString(j++).trim()));

				consulta.setCargos(new BigDecimal(cs.getString(j++).replaceAll(" ", "")));
				consulta.setAbonos(new BigDecimal(cs.getString(j++).replaceAll(" ", "")));
				
				consulta.setCodigoError(cs.getString(j++));
				consulta.setDescError(cs.getString(j++));

			}
			while (rs.next()) {
				String narr="";
				Movimiento oMov = new Movimiento();
				oMov.setUsuario(rs.getString("STMUSR")); // STMUSR
				oMov.setCuenta(rs.getBigDecimal("STMACC")); // STMACC
				oMov.setCodigo(rs.getString("STMCDE")); // STMCDE
				narr+=rs.getString("STMNAR"); // STMNAR
				oMov.setFecha(rs.getBigDecimal("STMFECHA")); // STMFECHA
				oMov.setHora(rs.getBigDecimal("STMHORA")); // STMHORA
				oMov.setReferencia(rs.getBigDecimal("STMCKN")); // STMCKN
				oMov.setSaldoB(rs.getBigDecimal("STMBBL")); // STMBBL
				oMov.setMonto(rs.getBigDecimal("STMAMT")); // STMAMT
				oMov.setCodigoDCC(rs.getString("STMDCC")); // STMDCC
				oMov.setBalance(rs.getBigDecimal("STMEBL")); // STMEBL
				oMov.setRegistro(rs.getBigDecimal("STMREC")); // STMREC
				oMov.setMem(rs.getString("STMMEM")); // STMMEM
				oMov.setDrr(rs.getBigDecimal("STMDRR")); // STMDRR
				oMov.setNnar(rs.getBigDecimal("STMNNAR")); // STMNNAR
				if (consulta.getPaginaActual() == 1 && oListaMovs.size()==0) {
				//if (" ".equals(oEncabezado.getClave()) && oEncabezado.getPaginaActual() == 1 && oListaMovs.size()==0) {
					consulta.setSaldoIncial(rs.getBigDecimal("STMBBL"));
				}
				for(int k=1; k<=9; k++){
					narr=narr.trim()+ (rs.getString("STMNA"+k)!=null?rs.getString("STMNA"+k).trim():"");
				}
				oMov.setNarrativa(narr.trim()); // STMNAR
				oListaMovs.add(oMov);
			}
			consulta.setMovimientos(oListaMovs);
			rs.close();
			cs.close();
			// si es mes actual y la pagina uno
			if (MovimientoDao.CLAVE_MES_ACTUAL.equals(consulta.getClave())
					&& consulta.getPaginaActual() == 1) {
				// Sacamos los saldos a mostrar
				String STMS = "Call " + AfirmeNetConstants.AS400_LIBRARY
						+ "saldo_edocta(" + "?,?,?," + "?" + ")";
				CallableStatement css = null;
				css = cnx.prepareCall(STMS);
				
				i = 1;
				css.setString(i++, consulta.getUsuario());
				css.setBigDecimal(i++, consulta.getCuenta());
				j = i;
				css.setString(i++, "");
				css.setString(i++, "");
				i = j;
				css.registerOutParameter(i++, Types.VARCHAR);
				css.registerOutParameter(i++, java.sql.Types.VARCHAR);
				j = i - 2;
				ResultSet rss = css.executeQuery();
				consulta.setCodigoError(css.getString(j++));
				consulta.setDescError(css.getString(j++));
				if (rss.next()) {
					consulta.setSaldoFinal(rss.getBigDecimal("STBMGB"));
					consulta.setSaldoDiferido(rss.getBigDecimal("STBUNC"));
					// Este campo me trae cero, preguntar a Victor si esta mal.
					consulta.setSaldoDisponible(rss.getBigDecimal("STBAVL"));

					consulta
							.setInteresSobregiro(rss.getBigDecimal("STBCLI"));
					consulta.setInteresPagar(rss.getBigDecimal("STBIAC"));
				}
				rss.close();
				css.close();
			}

		} catch (Exception ex) {

			LOG.error("Exception en consultaOrdenada.consultaOrdenada() : "
							+ ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				LOG.error("Exception al cerrar conexion BD en consultaOrdenada.consultaOrdenada() "
								+ e);
			}
		}
		return consulta;
	}

	

}
