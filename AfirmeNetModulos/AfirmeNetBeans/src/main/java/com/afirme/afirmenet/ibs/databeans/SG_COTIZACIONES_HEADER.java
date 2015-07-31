/*
 * Sistema DCIBS_Banca_Afirme
 * Archivo: SG_COTIZACIONES_HEADER.java
 * Creado: May 5, 2006
 * Paquete: com.datapro.dibs.databeans
 * Clase: SG_COTIZACIONES_HEADER
 *
 */
package com.afirme.afirmenet.ibs.databeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datapro.exception.ServiceLocatorException;
import com.datapro.services.ServiceLocator;

/**
 * @author cosurof
 * 
 */
public class SG_COTIZACIONES_HEADER implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	static final Logger LOG = LoggerFactory
			.getLogger(SG_COTIZACIONES_HEADER.class);
	private String IDCOTIZACION;
	private String ENTITYID;
	private String USERID;
	private String NOMBRE;
	private String PRODUCTO;
	private String LINEA;
	private String FABRICANTE;
	private String MODELO;
	private String ID_TIPO_BIEN;
	private String IDDESCRIPCION;
	private String DESCRIPCION;
	private String ESTADO;
	private String OBSERVACIONES;
	private String DESCFABRICANTE;

	private String VERSION; // VERSION DEL PRODUCTO

	private String ID_VERSION_REG; // VERSION REG.
	private String ID_TIPO_VEHIC; // TIPO DE VEHICULO
	private int NUM_ASIENTOS; // NUMERO DE ASIENTOS
	private double CAPAC_TONS; // CAPACIDAD EN TONELADAS
	private int NUM_PUERTAS; // NUMERO DE PUERTAS
	private String CVE_T_CILINDROS; // NUMERO DE CILINDROS EN EL MOTOR
	private String CVE_T_TRANSMIS; // TIPO DE TRANSMISION
	private String CVEL_ZONA_TAR; // Zona de Tarificacion

	private String SA_VAL_COMERC; // valor comercial
	private String SA_VAL_NUEVO; // valor nuevo

	private String CVEL_SERV_AUTO; // tipo de servicio
	private String CVEL_USO_AUTO; // tipo de uso

	private String PCT_DCTO;

	private String STS;
	private String APP;
	private String ODATE;
	private String VDATE;
	private double SEYCOS_NUM_COT;
	private int PAQ_ELEGIDO;
	private int TIPO_PAGO;

	private double NUM_COTIZACION;

	public static final String[] TIPOS_DE_PAGO = { "Contado", "Semestral",
			"Trimestral", "Mensual" };
	public static final int[] PLAZOS_TIPOS_DE_PAGO = { 12, 6, 3, 1 };

	public static final int PAGO_CONTADO = 1;
	public static final int PAGO_SEMESTRAL = 2;
	public static final int PAGO_TRIMESTRAL = 3;
	public static final int PAGO_MENSUAL = 4;

	public SG_COTIZACIONES_HEADER() {
		IDCOTIZACION = "";
		ENTITYID = "";
		USERID = "";
		NOMBRE = "";
		PRODUCTO = "1";
		LINEA = "0";
		FABRICANTE = "";
		DESCFABRICANTE = "";
		MODELO = "";
		IDDESCRIPCION = "";
		DESCRIPCION = "";
		ESTADO = "";
		OBSERVACIONES = "";
		STS = "";
		APP = "";
		ODATE = "";
		VDATE = "";
		ID_TIPO_BIEN = "AUTOS";
		SEYCOS_NUM_COT = 0;
		PAQ_ELEGIDO = 1;
		TIPO_PAGO = 1;
		NUM_COTIZACION = 0;

		VERSION = "1"; // VERSION DEL PRODUCTO
		ID_VERSION_REG = "1"; // VERSION REG.
		ID_TIPO_VEHIC = "1"; // TIPO DE VEHICULO
		NUM_ASIENTOS = 4; // NUMERO DE ASIENTOS
		CAPAC_TONS = 0; // CAPACIDAD EN TONELADAS
		NUM_PUERTAS = 4; // NUMERO DE PUERTAS
		CVE_T_CILINDROS = "4"; // NUMERO DE CILINDROS EN EL MOTOR
		CVE_T_TRANSMIS = "STD"; // TIPO DE TRANSMISION
		PCT_DCTO = "0"; // PORCENTAJE DE DESCUENTO

		CVEL_ZONA_TAR = "";
		CVEL_SERV_AUTO = "PR";
		CVEL_USO_AUTO = "NO";

		SA_VAL_COMERC = "";
		SA_VAL_NUEVO = "";

	}

	/**
	 * @return
	 */
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	/**
	 * @return
	 */
	public String getENTITYID() {
		return ENTITYID;
	}

	/**
	 * @return
	 */
	public String getESTADO() {
		return ESTADO;
	}

	/**
	 * @return
	 */
	public String getFABRICANTE() {
		return FABRICANTE;
	}

	/**
	 * @return
	 */
	public String getIDDESCRIPCION() {
		return IDDESCRIPCION;
	}

	/**
	 * @return
	 */
	public String getLINEA() {
		return LINEA;
	}

	/**
	 * @return
	 */
	public String getMODELO() {
		return MODELO;
	}

	/**
	 * @return
	 */
	public String getNOMBRE() {
		return NOMBRE;
	}

	/**
	 * @return
	 */
	public String getOBSERVACIONES() {
		return OBSERVACIONES;
	}

	/**
	 * @return
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @param string
	 */
	public void setDESCRIPCION(String string) {
		DESCRIPCION = string;
	}

	/**
	 * @param string
	 */
	public void setENTITYID(String string) {
		ENTITYID = string;
	}

	/**
	 * @param string
	 */
	public void setESTADO(String string) {
		ESTADO = string;
	}

	/**
	 * @param string
	 */
	public void setFABRICANTE(String string) {
		FABRICANTE = string;
	}

	/**
	 * @param string
	 */
	public void setIDDESCRIPCION(String string) {
		IDDESCRIPCION = string;
	}

	/**
	 * @param string
	 */
	public void setLINEA(String string) {
		LINEA = string;
	}

	/**
	 * @param string
	 */
	public void setMODELO(String string) {
		MODELO = string;
	}

	/**
	 * @param string
	 */
	public void setNOMBRE(String string) {
		NOMBRE = string;
	}

	/**
	 * @param string
	 */
	public void setOBSERVACIONES(String string) {
		OBSERVACIONES = string;
	}

	/**
	 * @param string
	 */
	public void setUSERID(String string) {
		USERID = string;
	}

	/**
	 * @return
	 */
	public String getIDCOTIZACION() {
		return IDCOTIZACION;
	}

	/**
	 * @param string
	 */
	public void setIDCOTIZACION(String string) {
		IDCOTIZACION = string;
	}

	public String getNewIdCotizacion() {
		String sqlerror = null;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = ""
					+ "select COALESCE(max(a.idcotizacion), 0) from (select cast( idcotizacion as decimal(10,2)) as idcotizacion from sg_cotizaciones_header ) as a ";

			Statement st = cnx.createStatement();

			ResultSet rs = st.executeQuery(STMT);
			int id = 0;

			if (rs.next()) {
				id = rs.getInt(1) + 1;
			}

			if (id > 0) {
				sqlerror = "" + id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			sqlerror = "";
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = null;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = null;
			}
		}

		return (sqlerror);

	}

	public boolean searchOneCotizacion(String ENTITYID, String USERID,
			String IDCOTIZACION) {
		boolean sqlerror = false;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = "" + "select"
					+ " c.IDCOTIZACION, c.ENTITYID, c.USERID, c.NOMBRE, "
					+ "c.LINEA, c.FABRICANTE,  c.MODELO, c.IDDESCRIPCION, "
					+ "c.DESCRIPCION, c.ESTADO, c.OBSERVACIONES, c.STS, "
					+ "c.APP, c.SEYCOS_NUM_COT, c.ID_TIPO_BIEN,"
					+ "c.TIPO_PAGO, c.PAQ_ELEGIDO, " + "c.ID_VERSION_REG, "
					+ "c.ID_TIPO_VEHIC," + "c.NUM_ASIENTOS," + "c.CAPAC_TONS,"
					+ "c.NUM_PUERTAS," + "c.CVE_T_CILINDROS,"
					+ "c.CVE_T_TRANSMIS," + "c.CVEL_ZONA_TAR,"
					+ "c.SA_VAL_COMERC," + "c.SA_VAL_NUEVO," + "c.PRODUCTO,"
					+ "c.VERSION," + "c.CVEL_SERV_AUTO," + "c.CVEL_USO_AUTO,"
					+ "c.NUM_COTIZACION " + "FROM sg_cotizaciones_header c "
					+ "WHERE " + "c.ENTITYID=? AND c.USERID=? AND "
					+ "c.IDCOTIZACION = ? AND " + "c.STS='1' AND c.APP='1'";

			PreparedStatement st = cnx.prepareStatement(STMT);
			st.setString(1, ENTITYID);
			st.setString(2, USERID);
			st.setString(3, IDCOTIZACION);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				setENTITYID(ENTITYID);
				setUSERID(USERID);

				setPRODUCTO(rs.getString("PRODUCTO"));
				setVERSION(rs.getString("VERSION"));
				setIDCOTIZACION(rs.getString("IDCOTIZACION") != null ? rs
						.getString("IDCOTIZACION") : "");
				setNOMBRE(rs.getString("NOMBRE") != null ? rs
						.getString("NOMBRE") : "");
				setLINEA(rs.getString("LINEA") != null ? rs.getString("LINEA")
						: "");
				setFABRICANTE(rs.getString("FABRICANTE") != null ? rs
						.getString("FABRICANTE").trim() : "");
				setMODELO(rs.getString("MODELO") != null ? rs
						.getString("MODELO") : "");
				setIDDESCRIPCION(rs.getString("IDDESCRIPCION") != null ? rs
						.getString("IDDESCRIPCION") : "");
				setDESCRIPCION(rs.getString("DESCRIPCION") != null ? rs
						.getString("DESCRIPCION") : "");
				setESTADO(rs.getString("ESTADO") != null ? rs
						.getString("ESTADO") : "");
				setOBSERVACIONES(rs.getString("OBSERVACIONES") != null ? rs
						.getString("OBSERVACIONES") : "");
				setSTS(rs.getString("STS") != null ? rs.getString("STS") : "");
				setAPP(rs.getString("APP") != null ? rs.getString("APP") : "");
				setSEYCOS_NUM_COT(rs.getDouble("SEYCOS_NUM_COT"));
				setID_TIPO_BIEN(rs.getString("ID_TIPO_BIEN") != null ? rs
						.getString("ID_TIPO_BIEN") : "");
				setPAQ_ELEGIDO(rs.getInt("PAQ_ELEGIDO"));
				setTIPO_PAGO(rs.getInt("TIPO_PAGO"));
				setID_VERSION_REG(rs.getString("ID_VERSION_REG"));
				setID_TIPO_VEHIC(rs.getString("ID_TIPO_VEHIC"));
				setNUM_ASIENTOS(rs.getInt("NUM_ASIENTOS"));
				setCAPAC_TONS(rs.getDouble("CAPAC_TONS"));
				setNUM_PUERTAS(rs.getInt("NUM_PUERTAS"));
				setCVE_T_CILINDROS(rs.getString("CVE_T_CILINDROS"));
				setCVE_T_TRANSMIS(rs.getString("CVE_T_TRANSMIS"));
				setCVEL_ZONA_TAR(rs.getString("CVEL_ZONA_TAR"));
				setSA_VAL_COMERC(rs.getString("SA_VAL_COMERC"));
				setSA_VAL_NUEVO(rs.getString("SA_VAL_NUEVO"));
				setCVEL_SERV_AUTO(rs.getString("CVEL_SERV_AUTO"));
				setCVEL_USO_AUTO(rs.getString("CVEL_USO_AUTO"));
				setNUM_COTIZACION(rs.getDouble("NUM_COTIZACION"));

			}

		} catch (SQLException e) {
			LOG.debug("Exception e : " + e);
			e.printStackTrace();
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}
		return (sqlerror);

	}

	public boolean searchOneSeycosCotizacion(double IDCOTIZACION) {
		boolean sqlerror = true;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = "" + "select"
					+ " c.IDCOTIZACION, c.ENTITYID, c.USERID, c.NOMBRE, "
					+ "c.LINEA, c.FABRICANTE,  c.MODELO, c.IDDESCRIPCION, "
					+ "c.DESCRIPCION, c.ESTADO, c.OBSERVACIONES, c.STS, "
					+ "c.APP, c.SEYCOS_NUM_COT, c.ID_TIPO_BIEN,"
					+ "c.TIPO_PAGO, c.PAQ_ELEGIDO, " + "c.ID_VERSION_REG, "
					+ "c.ID_TIPO_VEHIC," + "c.NUM_ASIENTOS," + "c.CAPAC_TONS,"
					+ "c.NUM_PUERTAS," + "c.CVE_T_CILINDROS,"
					+ "c.CVE_T_TRANSMIS," + "c.CVEL_ZONA_TAR,"
					+ "c.SA_VAL_COMERC," + "c.SA_VAL_NUEVO," + "c.PRODUCTO,"
					+ "c.VERSION," + "c.CVEL_SERV_AUTO," + "c.CVEL_USO_AUTO,"
					+ "c.NUM_COTIZACION " + "FROM sg_cotizaciones_header c "
					+ "WHERE " + "c.SEYCOS_NUM_COT = ? " + "AND c.APP='1'";

			PreparedStatement st = cnx.prepareStatement(STMT);
			st.setDouble(1, IDCOTIZACION);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				setENTITYID(ENTITYID);
				setUSERID(USERID);

				setPRODUCTO(rs.getString("PRODUCTO"));
				setVERSION(rs.getString("VERSION"));
				setIDCOTIZACION(rs.getString("IDCOTIZACION") != null ? rs
						.getString("IDCOTIZACION") : "");
				setNOMBRE(rs.getString("NOMBRE") != null ? rs
						.getString("NOMBRE") : "");
				setLINEA(rs.getString("LINEA") != null ? rs.getString("LINEA")
						: "");
				setFABRICANTE(rs.getString("FABRICANTE") != null ? rs
						.getString("FABRICANTE").trim() : "");
				setMODELO(rs.getString("MODELO") != null ? rs
						.getString("MODELO") : "");
				setIDDESCRIPCION(rs.getString("IDDESCRIPCION") != null ? rs
						.getString("IDDESCRIPCION") : "");
				setDESCRIPCION(rs.getString("DESCRIPCION") != null ? rs
						.getString("DESCRIPCION") : "");
				setESTADO(rs.getString("ESTADO") != null ? rs
						.getString("ESTADO") : "");
				setOBSERVACIONES(rs.getString("OBSERVACIONES") != null ? rs
						.getString("OBSERVACIONES") : "");
				setSTS(rs.getString("STS") != null ? rs.getString("STS") : "");
				setAPP(rs.getString("APP") != null ? rs.getString("APP") : "");
				setSEYCOS_NUM_COT(rs.getDouble("SEYCOS_NUM_COT"));
				setID_TIPO_BIEN(rs.getString("ID_TIPO_BIEN") != null ? rs
						.getString("ID_TIPO_BIEN") : "");
				setPAQ_ELEGIDO(rs.getInt("PAQ_ELEGIDO"));
				setTIPO_PAGO(rs.getInt("TIPO_PAGO"));
				setID_VERSION_REG(rs.getString("ID_VERSION_REG"));
				setID_TIPO_VEHIC(rs.getString("ID_TIPO_VEHIC"));
				setNUM_ASIENTOS(rs.getInt("NUM_ASIENTOS"));
				setCAPAC_TONS(rs.getDouble("CAPAC_TONS"));
				setNUM_PUERTAS(rs.getInt("NUM_PUERTAS"));
				setCVE_T_CILINDROS(rs.getString("CVE_T_CILINDROS"));
				setCVE_T_TRANSMIS(rs.getString("CVE_T_TRANSMIS"));
				setCVEL_ZONA_TAR(rs.getString("CVEL_ZONA_TAR"));
				setSA_VAL_COMERC(rs.getString("SA_VAL_COMERC"));
				setSA_VAL_NUEVO(rs.getString("SA_VAL_NUEVO"));
				setCVEL_SERV_AUTO(rs.getString("CVEL_SERV_AUTO"));
				setCVEL_USO_AUTO(rs.getString("CVEL_USO_AUTO"));
				setNUM_COTIZACION(rs.getDouble("NUM_COTIZACION"));

				sqlerror = false;
			} else {
				sqlerror = true;
			}

		} catch (SQLException e) {
			LOG.debug("Exception e : " + e);
			e.printStackTrace();
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}
		return (sqlerror);

	}

	public boolean createCotizacionRecord() {
		boolean sqlerror = false;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = ""
					+ "insert into SG_COTIZACIONES_HEADER "
					+ " ("
					+ "IDCOTIZACION,"
					+ "ENTITYID,			USERID ,"
					+ "NOMBRE,			LINEA , "
					+ "FABRICANTE ,		MODELO,"
					+ "IDDESCRIPCION,	    DESCRIPCION,"
					+ "ESTADO,	"
					+ "OBSERVACIONES,"
					+ "STS,"
					+ "APP,"
					+ "ODATE,"
					+ "VDATE,"
					+ "ID_TIPO_BIEN,"
					+ "SEYCOS_NUM_COT, "
					+ "ID_VERSION_REG, "
					+ "ID_TIPO_VEHIC,"
					+ "NUM_ASIENTOS,"
					+ "CAPAC_TONS,"
					+ "NUM_PUERTAS,"
					+ "CVE_T_CILINDROS,"
					+ "CVE_T_TRANSMIS,"
					+ "CVEL_ZONA_TAR,"
					+ "SA_VAL_COMERC,"
					+ "SA_VAL_NUEVO,"
					+ "PRODUCTO,"
					+ "VERSION, "
					+ "CVEL_SERV_AUTO,"
					+ "CVEL_USO_AUTO,"
					+ "PCT_DCTO,"
					+ "NUM_COTIZACION"
					+ ") "
					+ " values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = cnx.prepareStatement(STMT);
			st.setString(1, getIDCOTIZACION());
			st.setString(2, getENTITYID());
			st.setString(3, getUSERID());
			st.setString(4, getNOMBRE());
			st.setString(5, getLINEA());
			st.setString(6, getFABRICANTE());
			st.setString(7, getMODELO());
			st.setString(8, getIDDESCRIPCION());
			st.setString(9, getDESCRIPCION());
			st.setString(10, getESTADO());
			st.setString(11, getOBSERVACIONES());
			st.setString(12, getSTS());
			st.setString(13, getAPP());
			st.setString(14, getODATE());
			st.setString(15, getVDATE());
			st.setString(16, getID_TIPO_BIEN());
			st.setDouble(17, getSEYCOS_NUM_COT());
			st.setString(18, getID_VERSION_REG());
			st.setString(19, getID_TIPO_VEHIC());
			st.setInt(20, getNUM_ASIENTOS());
			st.setDouble(21, getCAPAC_TONS());
			st.setInt(22, getNUM_PUERTAS());
			st.setString(23, getCVE_T_CILINDROS());
			st.setString(24, getCVE_T_TRANSMIS());
			st.setString(25, getCVEL_ZONA_TAR());
			st.setString(26, getSA_VAL_COMERC());
			st.setString(27, getSA_VAL_NUEVO());
			st.setString(28, getPRODUCTO());
			st.setString(29, getVERSION());
			st.setString(30, getCVEL_SERV_AUTO());
			st.setString(31, getCVEL_USO_AUTO());
			st.setString(32, getPCT_DCTO());
			st.setDouble(33, getNUM_COTIZACION());

			st.executeUpdate();

		} catch (SQLException e) {
			LOG.debug("Exception e : " + e);
			e.printStackTrace();
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}

		return (sqlerror);

	}

	public boolean setPaquete(int PaqElegido) {
		boolean sqlerror = false;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = "" + "update SG_COTIZACIONES_HEADER " + " set "
					+ " PAQ_ELEGIDO= ?, TIPO_PAGO= ? " + "where "
					+ "SEYCOS_NUM_COT = ? AND " + "ENTITYID = ? AND "
					+ "USERID = ? ";

			PreparedStatement st = cnx.prepareStatement(STMT);

			st.setInt(1, PaqElegido);
			st.setInt(2, getTIPO_PAGO());
			st.setDouble(3, getSEYCOS_NUM_COT());
			st.setString(4, getENTITYID());
			st.setString(5, getUSERID());

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}

		return (sqlerror);

	}

	public boolean editCotizacionRecord() {
		boolean sqlerror = false;

		Connection cnx = null;

		try {

			cnx = ServiceLocator.getInstance().getDBConn("MSS");

			String STMT = "" + "update SG_COTIZACIONES_HEADER " + " set "
					+ "NOMBRE = ?,			LINEA=? , "
					+ "FABRICANTE= ? ,		MODELO= ?,"
					+ "IDDESCRIPCION= ?,	    DESCRIPCION= ?,"
					+ "ESTADO= ?,				OBSERVACIONES= ?, "
					+ "VDATE= ?, ODATE= ? " + "where "
					+ "IDCOTIZACION = ? AND " + "ENTITYID = ? AND "
					+ "USERID = ? AND " + "STS = ? ";

			PreparedStatement st = cnx.prepareStatement(STMT);

			st.setString(1, getNOMBRE());
			st.setString(2, getLINEA());
			st.setString(3, getFABRICANTE());
			st.setString(4, getMODELO());
			st.setString(5, getIDDESCRIPCION());
			st.setString(6, getDESCRIPCION());
			st.setString(7, getESTADO());
			st.setString(8, getOBSERVACIONES());
			st.setString(9, getVDATE());
			st.setString(10, getODATE());

			st.setString(11, getIDCOTIZACION());
			st.setString(12, getENTITYID());
			st.setString(13, getUSERID());
			st.setString(14, getSTS());

			st.executeUpdate();

		} catch (SQLException e) {
			LOG.debug("Exception e : " + e);
			e.printStackTrace();
			sqlerror = true;
		} catch (ServiceLocatorException e) {
			LOG.debug("Exception e : " + e);
			sqlerror = true;
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				LOG.debug("Exception e : " + e);
				sqlerror = true;
			}
		}

		return (sqlerror);

	}

	/**
	 * @return
	 */
	public String getDESCFABRICANTE() {
		return DESCFABRICANTE;
	}

	/**
	 * @param string
	 */
	public void setDESCFABRICANTE(String string) {
		DESCFABRICANTE = string;
	}

	/**
	 * @return
	 */
	public String getSTS() {
		return STS;
	}

	/**
	 * @param string
	 */
	public void setSTS(String string) {
		STS = string;
	}

	/**
	 * @return
	 */
	public String getAPP() {
		return APP;
	}

	/**
	 * @param string
	 */
	public void setAPP(String string) {
		APP = string;
	}

	/**
	 * @return
	 */
	public String getODATE() {
		return ODATE;
	}

	/**
	 * @return
	 */
	public String getVDATE() {
		return VDATE;
	}

	/**
	 * @param string
	 */
	public void setODATE(String string) {
		ODATE = string;
	}

	/**
	 * @param string
	 */
	public void setVDATE(String string) {
		VDATE = string;
	}

	/**
	 * @return
	 */
	public String getPRODUCTO() {
		return PRODUCTO;
	}

	/**
	 * @param string
	 */
	public void setPRODUCTO(String string) {
		PRODUCTO = string;
	}

	/**
	 * @return
	 */
	public String getID_TIPO_BIEN() {
		return ID_TIPO_BIEN;
	}

	/**
	 * @return
	 */
	public double getSEYCOS_NUM_COT() {
		return SEYCOS_NUM_COT;
	}

	/**
	 * @param string
	 */
	public void setID_TIPO_BIEN(String string) {
		ID_TIPO_BIEN = string;
	}

	/**
	 * @param string
	 */
	public void setSEYCOS_NUM_COT(double dob) {
		SEYCOS_NUM_COT = dob;
	}

	/**
	 * @return
	 */
	public int getPAQ_ELEGIDO() {
		return PAQ_ELEGIDO;
	}

	/**
	 * @param i
	 */
	public void setPAQ_ELEGIDO(int i) {
		PAQ_ELEGIDO = i;
	}

	/**
	 * @return
	 */
	public int getTIPO_PAGO() {
		return TIPO_PAGO;
	}

	/**
	 * @param i
	 */
	public void setTIPO_PAGO(int i) {
		TIPO_PAGO = i;
	}

	/**
	 * @return
	 */
	public String getCVE_T_CILINDROS() {
		return CVE_T_CILINDROS;
	}

	/**
	 * @return
	 */
	public String getCVE_T_TRANSMIS() {
		return CVE_T_TRANSMIS;
	}

	/**
	 * @return
	 */
	public String getCVEL_ZONA_TAR() {
		return CVEL_ZONA_TAR;
	}

	/**
	 * @return
	 */
	public String getID_TIPO_VEHIC() {
		return ID_TIPO_VEHIC;
	}

	/**
	 * @return
	 */
	public String getID_VERSION_REG() {
		return ID_VERSION_REG;
	}

	/**
	 * @return
	 */
	public String getVERSION() {
		return VERSION;
	}

	/**
	 * @param string
	 */
	public void setCVE_T_CILINDROS(String string) {
		CVE_T_CILINDROS = string;
	}

	/**
	 * @param string
	 */
	public void setCVE_T_TRANSMIS(String string) {
		CVE_T_TRANSMIS = string;
	}

	/**
	 * @param string
	 */
	public void setCVEL_ZONA_TAR(String string) {
		CVEL_ZONA_TAR = string;
	}

	/**
	 * @param string
	 */
	public void setID_TIPO_VEHIC(String string) {
		ID_TIPO_VEHIC = string;
	}

	/**
	 * @param string
	 */
	public void setID_VERSION_REG(String string) {
		ID_VERSION_REG = string;
	}

	/**
	 * @param string
	 */
	public void setVERSION(String string) {
		VERSION = string;
	}

	/**
	 * @return
	 */
	public int getNUM_ASIENTOS() {
		return NUM_ASIENTOS;
	}

	/**
	 * @return
	 */
	public int getNUM_PUERTAS() {
		return NUM_PUERTAS;
	}

	/**
	 * @param i
	 */
	public void setNUM_ASIENTOS(int i) {
		NUM_ASIENTOS = i;
	}

	/**
	 * @param i
	 */
	public void setNUM_PUERTAS(int i) {
		NUM_PUERTAS = i;
	}

	/**
	 * @return
	 */
	public double getCAPAC_TONS() {
		return CAPAC_TONS;
	}

	/**
	 * @param d
	 */
	public void setCAPAC_TONS(double d) {
		CAPAC_TONS = d;
	}

	/**
	 * @return
	 */
	public String getSA_VAL_COMERC() {
		return SA_VAL_COMERC;
	}

	/**
	 * @return
	 */
	public String getSA_VAL_NUEVO() {
		return SA_VAL_NUEVO;
	}

	/**
	 * @param string
	 */
	public void setSA_VAL_COMERC(String string) {
		SA_VAL_COMERC = string;
	}

	/**
	 * @param string
	 */
	public void setSA_VAL_NUEVO(String string) {
		SA_VAL_NUEVO = string;
	}

	/**
	 * @return
	 */
	public String getCVEL_SERV_AUTO() {
		return CVEL_SERV_AUTO;
	}

	/**
	 * @return
	 */
	public String getCVEL_USO_AUTO() {
		return CVEL_USO_AUTO;
	}

	/**
	 * @param string
	 */
	public void setCVEL_SERV_AUTO(String string) {
		CVEL_SERV_AUTO = string;
	}

	/**
	 * @param string
	 */
	public void setCVEL_USO_AUTO(String string) {
		CVEL_USO_AUTO = string;
	}

	/**
	 * @return
	 */
	public String getPCT_DCTO() {
		return PCT_DCTO;
	}

	/**
	 * @param string
	 */
	public void setPCT_DCTO(String string) {
		PCT_DCTO = string;
	}

	/**
	 * @return
	 */
	public double getNUM_COTIZACION() {
		return NUM_COTIZACION;
	}

	/**
	 * @param d
	 */
	public void setNUM_COTIZACION(double d) {
		NUM_COTIZACION = d;
	}

}
