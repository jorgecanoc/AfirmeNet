package com.afirme.afirmenet.dao.impl.acceso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.afirme.afirmenet.dao.DB2Dao;
import com.afirme.afirmenet.dao.acceso.MenuDao;
import com.afirme.afirmenet.daoUtil.DaoUtil;
import com.afirme.afirmenet.ibs.beans.menu.JBMenu;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuServicio;
import com.afirme.afirmenet.ibs.beans.menu.JBMenuTransaccion;

@Repository
public class MenuDaoImpl implements MenuDao{
	
	@Autowired
	private DB2Dao db2Dao;

	@Override
	public List<JBMenu> findMenu(String grupoId, int renglon, String contrato) {
			
			List<JBMenu> c = new ArrayList<JBMenu>();
			
			JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();

			StringBuffer sb = new StringBuffer();
			sb.append("SELECT * FROM ");
			sb.append(" DC_MENU_AFIRMENET ");
			sb.append(" A, ");
			sb.append(" DC_MENU_GRUPO ");
			sb.append(" B ");
			sb.append(" WHERE B.GRPID = ? ");
			sb.append(" AND A.MMID = B.MMID ");
			sb.append(" AND A.CMID = B.CMID ");
			sb.append(" AND A.SMID = B.SMID ");
			sb.append(" AND A.STATUS = 'A' ORDER ");
			sb.append("BY A.MMID, A.CMID, A.SMID");
			
			List<Map<String, Object>> rows;
			
			if(contrato.equals("202194045")){
				rows = jdbcTemplate.queryForList(sb.toString(), new Object[] { Integer.parseInt("100") }); //PARA INSTALAR
			}else{
				rows = jdbcTemplate.queryForList(sb.toString(), new Object[] { Integer.parseInt("100") }); //CAMBIAR EL 100 POR grupoId
			}
			
			for (Map<String, Object> row : rows) {
				JBMenu mp = new JBMenu();
				mp.setMmid(((Integer) row.get("MMID"))==null?0:(Integer) row.get("MMID"));
				mp.setCmid(((Integer) row.get("CMID"))==null?0:(Integer) row.get("CMID"));
				mp.setSmid(((Integer) row.get("SMID"))==null?0:(Integer) row.get("SMID"));
				mp.setName(((String) row.get("NAME"))==null?"":(String) row.get("NAME"));
				mp.setUrl(((String) row.get("URL") )==null?"":(String) row.get("URL"));
				mp.setIcon(((String) row.get("ICON"))==null?"":(String) row.get("ICON"));
				mp.setStatus(((String) row.get("STATUS"))==null?"":(String) row.get("STATUS"));
				mp.setLegalType(((Integer) row.get("LEGAL_TYPE"))==null?0:(Integer) row.get("LEGAL_TYPE"));				
				mp.setGroupId(((Integer) row.get("GRPID"))==null?"":((Integer) row.get("GRPID")).toString());
				mp.setActivePage(((String) row.get("ACTIVE_PAGE"))==null?"":(String) row.get("ACTIVE_PAGE"));
				mp.setVisible(((String) row.get("VISIBLE"))==null?"":(String) row.get("VISIBLE"));
				c.add(mp);
			}
			
			return c;
		
	}

	@Override
	public List<JBMenuTransaccion> findMenuTransaccional() {

		List<JBMenuTransaccion> menuTransaccion = new ArrayList<JBMenuTransaccion>();
		
		JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM ");
		sb.append(" DC_MENU_TRANSACCION ");
		sb.append(" ORDER BY TRANSTYPE, SERTYP, INTERTYPE ");
		
		List<Map<String, Object>> rows;
		
        rows = jdbcTemplate.queryForList(sb.toString(), new Object[] { }); 

		
		for (Map<String, Object> row : rows) {
			JBMenuTransaccion mt = new JBMenuTransaccion();
			mt.setTranstype(DaoUtil.getString(row.get("TRANSTYPE")));
			mt.setSertyp(DaoUtil.getInt(row.get("SERTYP")));
			mt.setIntertype(DaoUtil.getInt(row.get("INTERTYPE")));
			mt.setTransname(DaoUtil.getString(row.get("TRANSNAME")));
			mt.setActive(DaoUtil.getString(row.get("ACTIVE")));
			menuTransaccion.add(mt);
		}
		
		return menuTransaccion;

	}

	@Override
	public List<JBMenuServicio> findMenuServios() {
		List<JBMenuServicio> menuServicio = new ArrayList<JBMenuServicio>();
		
		JdbcTemplate jdbcTemplate = db2Dao.getJdbcTemplate();

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM ");
		sb.append(" DC_MENU_SERVICIO ");
		sb.append(" ORDER BY TRANSTYPE, SERTYP, INTERTYPE ");
		
		List<Map<String, Object>> rows;
		
        rows = jdbcTemplate.queryForList(sb.toString(), new Object[] { }); 

		
		for (Map<String, Object> row : rows) {
			JBMenuServicio ms = new JBMenuServicio();
			ms.setTranstype(DaoUtil.getString(row.get("TRANSTYPE")));
			ms.setSertyp(DaoUtil.getInt(row.get("SERTYP")));
			ms.setIntertype(DaoUtil.getInt(row.get("INTERTYPE")));
			ms.setTransname(DaoUtil.getString(row.get("TRANSNAME")));
			menuServicio.add(ms);
		}
		
		return menuServicio;
	}

}
