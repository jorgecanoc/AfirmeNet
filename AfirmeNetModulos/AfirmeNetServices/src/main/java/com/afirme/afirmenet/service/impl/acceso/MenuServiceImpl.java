package com.afirme.afirmenet.service.impl.acceso;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afirme.afirmenet.dao.acceso.MenuDao;
import com.afirme.afirmenet.ibs.beans.menu.JBMenu;
import com.afirme.afirmenet.service.acceso.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao menuDao;
	
	private static final String TARGET = "body";	
	public static final String BLOCKED_PAGE = "body_blocked_page.jsp";
	// Menu Nuevo
	private static final String PAGE_PATH = "/DIBS_AFIRME/pages/s/";
	private	static final String WAIT_PAGE = "body_wait.jsp";
	private static final String SERVLET_NAME = "?ServletName=";
	private static final String CALL_SERVLET = "/DIBS_AFIRME/servlet/";

	@Override
	public String getMenu(String grupoId, int renglon,String contrato) {

		StringBuffer sb = new StringBuffer();
		
		ArrayList<JBMenu>  listadoMenu = (ArrayList<JBMenu>)menuDao.findMenu(grupoId,renglon,contrato);
	
		//openNav(sb);
		openAllMenu(sb);
		int count = 0;
		JBMenu mpTemp = null;
		
		for (JBMenu menu : listadoMenu) {
			if (menu.getCmid() == 0 && menu.getSmid() == 0 && menu.getVisible().equals("S"))
			   count ++;
			 sb.append(getSubMenu(menu, mpTemp, count));
			 if (menu.getVisible().equals("S"))
			 	mpTemp = menu;
		}
		
		//closeULTag(sb);
		if (count>0)	
			closeNav(sb);//el ultimo elemento del menu siempre sera una accion	
		else
			return "";
		
		return sb.toString();
	}
	
	/**
	 * La lógica para la creación del menú.
	 * @param mp			Datos del menú de persona
	 * @param mpTemp		La información del proceso anterior, para tenerlo como referencia en algunas validaciones	
	 * @param count			El contador del proceso.
	 * @return				El menú de Afirme Net Persona
	 * @author vmpermad
	 */
	private static StringBuffer getSubMenu(JBMenu mp, JBMenu mpTemp, int count)
	{
		StringBuffer sb = new StringBuffer();
		if (mp.getVisible().equals("S"))
		{
			if (validaMenu(mp))
			{
				validaActivePage(mp);
				closeULLITagMenu(sb, mp, mpTemp);
				if(validaAction(mp))
					openMenuAction(sb,mp);
				else{
					openMenu(sb, mp.getName(), mp.getIcon());
				    openULTag(sb);	
				}
			}
			else
			{
				if (validaSubMenu(mp))
				{
					validaActivePage(mp);
					closeULLITag(sb, mp, mpTemp);					
					openLITag(sb, mp.getName());
					openULTagSegundoNivel(sb,mp.getName(),mpTemp.getName());
				}
				else if (mp.getCmid() > 0 && mp.getSmid() == 0 && mp.getUrl().length() > 1)
				{
					validaActivePage(mp);
					closeULLITag(sb, mp, mpTemp);							
					openLITag(sb, mp);
					closeLITag(sb);
				}
				else
				{
					validaActivePage(mp);					
					closeULLITag(sb, mp, mpTemp);
					openLITag(sb, mp);
					closeLITag(sb);
				} 
			} 
		}
		return sb;		
	}
	/**
	 * Cierra el tag UL y LI Antes de escribir un menú de primer nivel
	 * @param sb			El objeto donde se guarda el menú.
	 * @param mp			La información del menú.
	 * @param mpTemp		La información anterior del menú.
	 * @author vmpermad
	 */
	private static void closeULLITagMenu (StringBuffer sb, JBMenu mp, JBMenu mpTemp)
	{
		if ((mpTemp != null && mpTemp.getMmid() != mp.getMmid()) ||
		(mpTemp != null && mpTemp.getCmid() != mp.getCmid() && mp.getSmid() == 0 && mpTemp.getSmid() > 0))
		{
			closeULTag(sb);
					
			if ((mpTemp != null && mpTemp.getMmid() != mp.getMmid()) &&
				(mpTemp != null && mpTemp.getCmid() != mp.getCmid() && 
				mp.getSmid() == 0 && mpTemp.getSmid() > 0 ))
				closeULTag(sb);
						
			closeLITag(sb); 
		}
	}
	
	/**
	 * Cierra el tag UL y LI antes de escribir un menú de Segundo Nivel
	 * @param sb			El objeto donde se guarda el menú.
	 * @param mp			La información del menú.
	 * @param mpTemp		El menú que fué procesado previamente.
	 * @author vmpermad
	 */
	private static void closeULLITag (StringBuffer sb, JBMenu mp, JBMenu mpTemp)
	{
		if (mpTemp != null && mpTemp.getCmid() != mp.getCmid() && mp.getSmid() == 0 && 
		    mpTemp.getSmid() > 0)
		{
			closeULTag(sb);
			closeLITag(sb); 
		}		
	}
	/**
	 * Valida sí para el menú que se procesa se debe de mostrar la página de 01-8002-AFIRME
	 * @param mp			La información del Menú que se procesa
	 * @author vmpermad
	 */
	private static void validaActivePage (JBMenu mp)
	{
		if (mp.getActivePage().equals("S"))
			mp.setUrl(BLOCKED_PAGE);
	}
	
	/**
	 * Valida sí para el menú que se procesa se tiene una accion
	 * @param mp			La información del Menú que se procesa
	 * @author vmpermad
	 */
	private static boolean validaAction (JBMenu mp)
	{
		if (!mp.getUrl().equals(""))
			return true;
		
		return false;
	}
	/**
	 * Verifica si el menú que se procesa es de primer nivel (Menú principal)
	 * @param mp			La información del menú.
	 * @return				true si el menú es de primer nivel, false en cualquier otro caso
	 * @author vmpermad
	 */
	private static boolean validaMenu (JBMenu mp)
	{
		if (mp.getCmid() == 0 && mp.getSmid() == 0)
			return true;
		else
			return false;
	}
	/**
	 * Verifica si el menú es de segundo nivel
	 * @param mp			La información del menú.
	 * @return				true si el menú es de segundo nivel, false en cualquier otro caso
	 * @author vmpermad
	 */
	private static boolean validaSubMenu (JBMenu mp)
	{
		if (mp.getCmid() > 0 && mp.getSmid() == 0 && mp.getUrl().length() <= 1 )
			return true;
		else 
			return false;
	}
	/**
	 * Abre el tag UL
	 * @param sb			El objeto donde se está guardando la información para pintar el menú.
	 * @author vmpermad
	 */
	private static void openULTag (StringBuffer sb)
	{
		sb.append("<ul class=\"nivel-1\">");	
	}
	
	private static void openULTagSegundoNivel (StringBuffer sb, String menuName, String menuNamePrincipal)
	{
		sb.append("<ul class=\"nivel-2\">");
		sb.append("<li class=\"show-xs\"><span>");
		sb.append(menuNamePrincipal);
		sb.append("<br>");
		sb.append(menuName);
		sb.append("</span></li>");
	}
	/**
	 * Cierra el tag UL
	 * @param sb			El objeto donde se guarda la información para el menú.
	 * @author vmpermad
	 */
	private static void closeULTag (StringBuffer sb)
	{
		sb.append("</ul>");
	}
	/**
	 * Abre el tag LI para mostar un menú
	 * @param sb			El objeto donde se guarda el código para mostar el menú en pantalla.
	 * @param menu			La información del menú.
	 * @author vmpermad
	 */
	private static void openLITag (StringBuffer sb, JBMenu menu)
	{
				
		sb.append("<li><a href=\"#\" onclick=\"submitFormAnimate('menu','");
		sb.append(menu.getUrl());
		sb.append("')\"");
		sb.append(">");
		sb.append(menu.getName());
		sb.append("</a>");
	}
	/**
	 * Abre un menú de segundo Nivel
	 * @param sb				El objeto donde se guarda la información para mostrar el menú.
	 * @param menuName			El nombre de menú de segundo nivel
	 * @author vmpermad
	 */
	private static void openLITag (StringBuffer sb, String menuName)
	{
		sb.append("<li class=\"subparent\"><a href=\"#\">");
		sb.append(menuName);
		sb.append("</a>");
	}
	/**
	 * Cierra el Tag LI
	 * @param sb			El objeto donde se guarda el menú.
	 * @author vmpermad
	 */
	private static void closeLITag(StringBuffer sb)
	{
		sb.append("</li>");
	}
	/**
	 * Pinta un menú de primer nivel (principal)
	 * @param sb			El objeto donde se guarda el código para mostar el menú.
	 * @param menuName		El nombre del menú
	 * @param count			El consecutivo, para darle un id diferente a cada menú.
	 * @author vmpermad
	 */
	private static void openMenu (StringBuffer sb, String menuName, String icon)
	{
		sb.append("<li class=\"parent\">");
		sb.append("<a><span class=\"");
		sb.append(icon);
		sb.append("\"></span><span>");
		sb.append(menuName);
		sb.append("</span></a>");
	}
	
	/**
	 * Pinta un menú de primer nivel (principal con una accion)
	 * @param sb			El objeto donde se guarda el código para mostar el menú.
	 * @param menuName		El nombre del menú
	 * @param count			El consecutivo, para darle un id diferente a cada menú.
	 * @author vmpermad
	 */
	private static void openMenuAction (StringBuffer sb, JBMenu menu)
	{
		sb.append("<li class=\"parent\">");
		sb.append("<a href=\"#\" onclick=\"submitFormAnimate('menu','");
		sb.append(menu.getUrl());
		sb.append("')\"");
		sb.append(">");
		sb.append("<span class=\"");
		sb.append(menu.getIcon());
		sb.append("\"></span><span>");
		sb.append(menu.getName());
		sb.append("</span></a>");

	}
	/**
	 * Abre la tabla principal donde va el menú.
	 * @param sb			El objeto donde se guarda el código para el menú.
	 * @author vmpermad
	 */
	private static void openNav (StringBuffer sb)
	{
		//String tableWidth = property.getString("menu.afirme.width");
	
		sb.append("<nav>");
		sb.append("<div class=\"cerrar-menu\">");
		sb.append("<p>Menú</p>");
		sb.append("<a class=\"close\"></a><a class=\"close-sm\"></a><a class=\"close-ssm\"></a>");
		sb.append("</div>");
	}
	/**
	 * Cierra la tabla donde se encuentra el menú.
	 * @param sb			El objeto para guarda el código.
	 * @author vmpermad
	 */
	private static void closeNav (StringBuffer sb)
	{
		sb.append("</li></ul>");
	}
	/**
	 * Abré el tag principal para empezar a escribir el menú.
	 * @param sb			El objeto para guardar el código.
	 * @author vmpermad
	 */
	private static void openAllMenu (StringBuffer sb)
	{
		sb.append("<ul>");
	}

}
