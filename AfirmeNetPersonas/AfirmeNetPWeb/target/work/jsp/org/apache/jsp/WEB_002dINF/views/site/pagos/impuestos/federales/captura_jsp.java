package org.apache.jsp.WEB_002dINF.views.site.pagos.impuestos.federales;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class captura_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(5);
    _jspx_dependants.add("/WEB-INF/views/base/include/include.jsp");
    _jspx_dependants.add("/WEB-INF/views/base/include/headerSession.jsp");
    _jspx_dependants.add("/WEB-INF/views/site/comun/menu.jsp");
    _jspx_dependants.add("/WEB-INF/views/site/transferencias/error.jsp");
    _jspx_dependants.add("/WEB-INF/views/base/include/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_message_code_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_method_commandName_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_modelAttribute_method_commandName_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_hidden_path_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_select_path_name_id_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_option_value;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_message_code_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_form_method_commandName_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_form_modelAttribute_method_commandName_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_hidden_path_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_select_path_name_id_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_option_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_message_code_nobody.release();
    _jspx_tagPool_c_url_value_nobody.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_form_form_method_commandName_action.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_form_form_modelAttribute_method_commandName_action.release();
    _jspx_tagPool_form_hidden_path_id_nobody.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_form_select_path_name_id_cssClass.release();
    _jspx_tagPool_form_option_value.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\"> <!--<![endif]-->\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>");
      if (_jspx_meth_spring_message_0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("\t\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t<meta http-equiv=\"Content-Language\" content=\"es-MX\" />\r\n");
      out.write("\t<meta name=\"title\" content=\"AfirmeNet\" /> \r\n");
      out.write("\t<meta name=\"author\" content=\"Afirme\" />\r\n");
      out.write("\t<meta name=\"copyright\" content=\"Afirme\" />\r\n");
      out.write("\t<meta name=\"Language\" content=\"Spanish\" />\r\n");
      out.write("\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\r\n");
      out.write("\t<meta name=\"robots\" content=\"all | index | follow\" />\r\n");
      out.write("\t<meta name=\"description\" content=\"AfirmeNet\" />\r\n");
      out.write("\t<meta name=\"keywords\" content=\"afirme,afirmenet,banco,banca,electronica,ebank,bank\" />\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\">\r\n");
      out.write("\r\n");
      out.write("  \t<link rel=\"icon\" href='");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("' type=\"image/vnd.microsoft.icon\"/> \r\n");
      out.write("  \t<link rel=\"shortcut icon\" href='");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("' type=\"image/vnd.microsoft.icon\"/> \r\n");
      out.write("  \t<link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\" />\r\n");
      out.write("  \t<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"apple-touch-icon-72x72-precomposed.png\" />\r\n");
      out.write("  \t<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"apple-touch-icon-114x114-precomposed.png\" />\r\n");
      out.write("  \t<link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"apple-touch-icon-144x144-precomposed.png\" />\r\n");
      out.write("  \t\r\n");
      out.write("    <!-- CSS PRINCIPAL\t -->\r\n");
      out.write("\t<link href='");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("' rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<!-- CSS CARGA LOS ESTILOS DEL MODAL\t -->\r\n");
      out.write("\t<link href='");
      if (_jspx_meth_c_url_3(_jspx_page_context))
        return;
      out.write("' rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<!-- CSS Contiene los estilos requeridos del plugin Dropkick, utilizado para darle la apariencia a los selectores dropdown\t -->\r\n");
      out.write("\t<link href=\"");
      if (_jspx_meth_c_url_4(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- JS Librería de Javascript que controla interacciones, manipulación de elementos del DOM\t -->\r\n");
      out.write("    <script>window.jQuery || document.write('<script src=\\'");
      if (_jspx_meth_c_url_5(_jspx_page_context))
        return;
      out.write("\\'><\\/script>')</script>\r\n");
      out.write("    <!-- JS Librería de Javascript que detecta características de HTML5 y CSS3, usado generalmente para la compatibilidad en browsers\t -->\r\n");
      out.write("  \t<script src='");
      if (_jspx_meth_c_url_6(_jspx_page_context))
        return;
      out.write("' type=\"text/javascript\"></script>\r\n");
      out.write("  \t<!-- JS Contiene las funciones Javascript utilizadas a través de todo el sitio\t -->  \t\r\n");
      out.write("  \t<script src='");
      if (_jspx_meth_c_url_7(_jspx_page_context))
        return;
      out.write("' type=\"text/javascript\"></script>\r\n");
      out.write("  \t<!-- JS Plugin de Javascript utilizado para cajas modales.\t -->\r\n");
      out.write("\t<script src='");
      if (_jspx_meth_c_url_8(_jspx_page_context))
        return;
      out.write("' type=\"text/javascript\"></script>\r\n");
      out.write("\t<!-- JS Plugin de Javascript que ayuda en el despliegue de los bloques de Resumen de Cuentas\t --> \r\n");
      out.write("\t<script src='");
      if (_jspx_meth_c_url_9(_jspx_page_context))
        return;
      out.write("' type=\"text/javascript\"></script>\r\n");
      out.write("\t<!-- Plugin de Javascript que da funcionalidad a los selectores dropdown estilizados\t -->\r\n");
      out.write("\t<script src='");
      if (_jspx_meth_c_url_10(_jspx_page_context))
        return;
      out.write("' type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tvar context = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${context}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("</script>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"head-izq\">\r\n");
      out.write("\t\t\t<a id=\"logo\" href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${context}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/home.htm'><img src='");
      if (_jspx_meth_c_url_11(_jspx_page_context))
        return;
      out.write("'  alt=\"Afirme\"></a> \r\n");
      out.write("\t\t\t<a class=\"btn-menu\"> \r\n");
      out.write("\t\t\t\t<span class=\"linea\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"linea\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"linea\"></span> \r\n");
      out.write("\t\t\t\t<span class=\"notificaciones\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${afirmeNetUser.notificaciones}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"head-der\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"head-btns\">\r\n");
      out.write("\t\t\t\t<a class=\"avatar\"> <img src='");
      if (_jspx_meth_c_url_12(_jspx_page_context))
        return;
      out.write("'\r\n");
      out.write("\t\t\t\t\theight=\"36\" width=\"36\" alt=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.afirmeNetUser.nombreCorto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> <span\r\n");
      out.write("\t\t\t\t\tclass=\"notificaciones\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${afirmeNetUser.notificaciones}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t\t</a> <a href=\"#\" class=\"btn\" onclick=\"submitFormAnimate('menu','login/logout.htm')\"><span class=\"txt\">");
      if (_jspx_meth_spring_message_1(_jspx_page_context))
        return;
      out.write("</span><span\r\n");
      out.write("\t\t\t\t\tclass=\"icon icon-exit\"></span></a>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"head-datos\">\r\n");
      out.write("\t\t\t\t<p> ");
      if (_jspx_meth_spring_message_2(_jspx_page_context))
        return;
      out.write(" <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.afirmeNetUser.nombreLargo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p class=\"f12\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_spring_message_3(_jspx_page_context))
        return;
      out.write(" <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.afirmeNetUser.contrato}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong> \r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_spring_message_4(_jspx_page_context))
        return;
      out.write("  <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.afirmeNetUser.ultimoAccesoStr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_url_13(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<section>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<article>\r\n");
      out.write("\t\t\t<div class=\"col-izq\" id=\"menu-wrap\">\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<nav>\r\n");
      out.write("\t\t\t<div class=\"cerrar-menu\">\r\n");
      out.write("\t\t\t\t<p>Menú</p>\r\n");
      out.write("\t\t\t\t<a class=\"close\"></a><a class=\"close-sm\"></a><a class=\"close-ssm\"></a><a\r\n");
      out.write("\t\t\t\t\tclass=\"close-sssm\"></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.menu}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t<div class=\"datos-usuario\">\r\n");
      out.write("\t\t\t\t<p class=\"h6\">\r\n");
      out.write("\t\t\t\t\t<strong>Ing. xxxx xxxxx xxxxx xxxxxx</strong>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p class=\"f12\">\r\n");
      out.write("\t\t\t\t\tContrato: <strong>kkkkkkkkkkkk</strong> Último acceso: <strong>25-nov-14,\r\n");
      out.write("\t\t\t\t\t\t16:30 hrs.</strong>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"btn\"><span class=\"mr10\">xxxxxx SESIÓN</span><span\r\n");
      out.write("\t\t\t\t\tclass=\"icon icon-exit\"></span></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_form_form_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"col-der relative\">\r\n");
      out.write("\t\t\t\t<div class=\"contenido\">\r\n");
      out.write("\t\t\t\t\t<!--INCLUDE DE ERRORES PARA TRANSFERENCIAS-->\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"p20\">\r\n");
      out.write("\t\t\t\t\t\t");
      //  form:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_1 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_modelAttribute_method_commandName_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_form_form_1.setPageContext(_jspx_page_context);
      _jspx_th_form_form_1.setParent(null);
      _jspx_th_form_form_1.setCommandName("impuesto");
      _jspx_th_form_form_1.setMethod("POST");
      _jspx_th_form_form_1.setModelAttribute("impuesto");
      _jspx_th_form_form_1.setAction("impuestos/federales/confirmar");
      int[] _jspx_push_body_count_form_form_1 = new int[] { 0 };
      try {
        int _jspx_eval_form_form_1 = _jspx_th_form_form_1.doStartTag();
        if (_jspx_eval_form_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            //  c:set
            org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
            _jspx_th_c_set_1.setPageContext(_jspx_page_context);
            _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
            _jspx_th_c_set_1.setVar("now");
            _jspx_th_c_set_1.setValue(new java.text.SimpleDateFormat("dd/MMMM/yy HH:mm").format(new java.util.Date()));
            int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
            if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
              return;
            }
            _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            //  c:set
            org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
            _jspx_th_c_set_2.setPageContext(_jspx_page_context);
            _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
            _jspx_th_c_set_2.setVar("fechaLong");
            _jspx_th_c_set_2.setValue(new java.util.Date().getTime());
            int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
            if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
              return;
            }
            _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            if (_jspx_meth_form_hidden_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            if (_jspx_meth_form_hidden_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            if (_jspx_meth_form_hidden_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            if (_jspx_meth_form_hidden_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            if (_jspx_meth_form_hidden_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            if (_jspx_meth_form_hidden_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t");
            if (_jspx_meth_form_hidden_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t\t<h3 class=\"titulo\">\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            if (_jspx_meth_spring_message_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t</h3>\r\n");
            out.write("\t\t\t\t\t\t\t<p>\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            if (_jspx_meth_spring_message_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t<span class=\"f-verdeO\">");
            if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</span>\r\n");
            out.write("\t\t\t\t\t\t\t</p>\r\n");
            out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"cerrar\"></a>\r\n");
            out.write("\t\t\t\t\t\t\t<div class=\"ovhidden mb30\">\r\n");
            out.write("\t\t\t\t\t\t\t\t<div class=\"pasos\">\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<span class=\"paso col4 activo\"><span>");
            if (_jspx_meth_spring_message_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("<small class=\"hide-xs\">");
            if (_jspx_meth_spring_message_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</small></span></span> \r\n");
            out.write("\t\t\t\t\t\t\t\t\t<span class=\"paso col4\"><span>");
            if (_jspx_meth_spring_message_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("<small class=\"hide-xs\">");
            if (_jspx_meth_spring_message_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</small></span></span>\r\n");
            out.write("\t\t\t\t\t\t\t\t\t<span class=\"paso col4\"><span>");
            if (_jspx_meth_spring_message_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("<small class=\"hide-xs\">");
            if (_jspx_meth_spring_message_12((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</small></span></span>\r\n");
            out.write("\t\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t \r\n");
            out.write("\t\t\t\t\t\t\t<div id=\"errores\"></div>\r\n");
            out.write("\t\t\t\t            <div class=\"row\">\r\n");
            out.write("\t\t\t\t              <div class=\"col9 xs-mb20\">\r\n");
            out.write("\t\t\t\t                <h3 class=\"f-verdeO m0 fL\">");
            if (_jspx_meth_spring_message_13((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</h3> \r\n");
            out.write("\t\t\t\t                <div class=\"ml20 fL xs-col12 xs-m0\"><h6 class=\"m0 mt7\"><span class=\"op50\">");
            if (_jspx_meth_spring_message_14((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</span><span class=\"f-verdeO\">*</span></h6></div>\r\n");
            out.write("\t\t\t\t              </div>\r\n");
            out.write("\t\t\t\t              <div class=\"col3\">\r\n");
            out.write("\t\t\t\t                <a href=\"#\" class=\"icon icon-info fR tooltip\"><span><span class=\"icon icon-close2\"></span><span class=\"h6\"><strong>INFORMACIÓN DEL SERVICIO</strong></span><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea</span></span></a>\r\n");
            out.write("\t\t\t\t              </div>\r\n");
            out.write("\t\t\t\t            </div>\r\n");
            out.write("            \r\n");
            out.write("\t\t\t\t\t\t <!-- Listado de Cuentas -->\r\n");
            out.write("\t\t\t\t           <div class=\"p20-0 mb30\">\r\n");
            out.write("\t\t\t                <h6 class=\"mb5\">");
            if (_jspx_meth_spring_message_15((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</h6>\r\n");
            out.write("\t\t\t                ");
            //  form:select
            org.springframework.web.servlet.tags.form.SelectTag _jspx_th_form_select_0 = (org.springframework.web.servlet.tags.form.SelectTag) _jspx_tagPool_form_select_path_name_id_cssClass.get(org.springframework.web.servlet.tags.form.SelectTag.class);
            _jspx_th_form_select_0.setPageContext(_jspx_page_context);
            _jspx_th_form_select_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
            _jspx_th_form_select_0.setId("origen");
            _jspx_th_form_select_0.setDynamicAttribute(null, "name", new String("origen"));
            _jspx_th_form_select_0.setPath("origen.number");
            _jspx_th_form_select_0.setCssClass("drop req");
            int[] _jspx_push_body_count_form_select_0 = new int[] { 0 };
            try {
              int _jspx_eval_form_select_0 = _jspx_th_form_select_0.doStartTag();
              if (_jspx_eval_form_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t                \t<option value=\"\">Seleccionar</option>\r\n");
                  out.write("\t\t\t\t\t\t\t    ");
                  //  c:forEach
                  org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
                  _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
                  _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_select_0);
                  _jspx_th_c_forEach_2.setVar("cuentaPropia");
                  _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cuentasPropias}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
                  int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
                  try {
                    int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
                    if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      do {
                        out.write("\r\n");
                        out.write("\t\t\t\t\t\t\t        ");
                        //  form:option
                        org.springframework.web.servlet.tags.form.OptionTag _jspx_th_form_option_0 = (org.springframework.web.servlet.tags.form.OptionTag) _jspx_tagPool_form_option_value.get(org.springframework.web.servlet.tags.form.OptionTag.class);
                        _jspx_th_form_option_0.setPageContext(_jspx_page_context);
                        _jspx_th_form_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
                        _jspx_th_form_option_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cuentaPropia.number}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
                        int[] _jspx_push_body_count_form_option_0 = new int[] { 0 };
                        try {
                          int _jspx_eval_form_option_0 = _jspx_th_form_option_0.doStartTag();
                          if (_jspx_eval_form_option_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                            java.lang.Object value = null;
                            java.lang.String displayValue = null;
                            if (_jspx_eval_form_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                              out = _jspx_page_context.pushBody();
                              _jspx_push_body_count_form_option_0[0]++;
                              _jspx_th_form_option_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                              _jspx_th_form_option_0.doInitBody();
                            }
                            value = (java.lang.Object) _jspx_page_context.findAttribute("value");
                            displayValue = (java.lang.String) _jspx_page_context.findAttribute("displayValue");
                            do {
                              if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_option_0, _jspx_page_context, _jspx_push_body_count_form_option_0))
                              return;
                              int evalDoAfterBody = _jspx_th_form_option_0.doAfterBody();
                              value = (java.lang.Object) _jspx_page_context.findAttribute("value");
                              displayValue = (java.lang.String) _jspx_page_context.findAttribute("displayValue");
                              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                              break;
                            } while (true);
                            if (_jspx_eval_form_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                              out = _jspx_page_context.popBody();
                              _jspx_push_body_count_form_option_0[0]--;
                          }
                          if (_jspx_th_form_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                            return;
                          }
                        } catch (Throwable _jspx_exception) {
                          while (_jspx_push_body_count_form_option_0[0]-- > 0)
                            out = _jspx_page_context.popBody();
                          _jspx_th_form_option_0.doCatch(_jspx_exception);
                        } finally {
                          _jspx_th_form_option_0.doFinally();
                          _jspx_tagPool_form_option_value.reuse(_jspx_th_form_option_0);
                        }
                        out.write("\r\n");
                        out.write("\t\t\t\t\t\t\t    ");
                        int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
                        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                          break;
                      } while (true);
                    }
                    if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      return;
                    }
                  } catch (Throwable _jspx_exception) {
                    while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
                      out = _jspx_page_context.popBody();
                    _jspx_th_c_forEach_2.doCatch(_jspx_exception);
                  } finally {
                    _jspx_th_c_forEach_2.doFinally();
                    _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
                  }
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_form_select_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_form_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_select_0[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_select_0.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_select_0.doFinally();
              _jspx_tagPool_form_select_path_name_id_cssClass.reuse(_jspx_th_form_select_0);
            }
            out.write("\t\t\t\t\t\t          \r\n");
            out.write("\t\t\t\t          </div>\t\t\r\n");
            out.write("\t\t\t\t          \r\n");
            out.write("\t\t\t\t            <div class=\"clearfix\">\r\n");
            out.write("\t\t\t\t              <h6 class=\"fL\">");
            if (_jspx_meth_spring_message_16((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("<span class=\"f-verdeO\">*</span></h6>\r\n");
            out.write("\t\t\t\t            </div> \r\n");
            out.write("\t\t\t\t            <div class=\"row mb30\"><div class=\"col6 xs-col12\">\r\n");
            out.write("\t\t\t\t              <div class=\"form-input relative importe\">\r\n");
            out.write("\t\t\t\t                <input name=\"fechaOperacion\"  type=\"text\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${now}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" readonly=\"readonly\">\r\n");
            out.write("\t\t\t\t                <a class=\"ayuda\">?</a>\r\n");
            out.write("\t\t\t\t              </div>\r\n");
            out.write("\t\t\t\t            </div></div>\r\n");
            out.write("\r\n");
            out.write("\t\t          \t\t    <h3 class=\"f-verdeO mb20\">");
            if (_jspx_meth_spring_message_17((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</h3> \r\n");
            out.write("\t\t          \t\t  \r\n");
            out.write("\t\t\t\t          <!-- Applet -->\r\n");
            out.write("\t\t\t\t          <div class=\"mb20\">  \r\n");
            out.write("\r\n");
            out.write("\t\t\t\t          \t<script type=\"text/javascript\">\r\n");
            out.write("\t\t\t\t          \t<!--\r\n");
            out.write("\t\t\t\t          \t\t  var tipoImpuesto = $('#tipoImpuesto').val();\r\n");
            out.write("\t\t\t\t          \t\t  \r\n");
            out.write("\t\t\t\t          \t\t  if(tipoImpuesto == 'ANUAL'){\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<APPLET id='AppImpEjercicio' style='LEFT: 0px; TOP: 0px' name='AppImpEjercicio' code='ejercicio.EjercicioAWT.class' archive='");
            if (_jspx_meth_c_url_14((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("'' width='850' height='700' VIEWASTEXT >\");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<param Name='NUMERO_CONCEPTOS'value='5' /> \");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<param name='FECHA_ACTUAL' VALUE='");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fechaLong}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("'/>\");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<param name='TARJETA_TRIBUTARIA' value='i'  />\");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"</APPLET>\");\t\t\t\t\t          \t\t  \r\n");
            out.write("\t\t\t\t          \t\t  }else{\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<APPLET id='AppImpEjercicio' style='LEFT: 0px; TOP: 0px' name='AppImpEjercicio' code='derechos.DerechosAWT.class' archive='");
            if (_jspx_meth_c_url_15((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("'' width='850' height='700' VIEWASTEXT >\");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<param Name='NUMERO_CONCEPTOS'value='5' /> \");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<param name='FECHA_ACTUAL' VALUE='");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${now}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("'/>\");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"<param name='TARJETA_TRIBUTARIA' value=''  />\");\r\n");
            out.write("\t\t\t\t\t\t\t\t\t  document.writeln(\"</APPLET>\");\t\t\t\t\t          \t\t  \r\n");
            out.write("\t\t\t\t          \t\t  }\t\r\n");
            out.write("\t\t\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t\t//-->\r\n");
            out.write("\t\t\t\t          \t</script>\r\n");
            out.write("\t\t\t\t          </div>\r\n");
            out.write("\t\t\t\t          <!-- Seccion de Acciones -->\t\r\n");
            out.write("\t\t\t\t          <div class=\"p20\">\r\n");
            out.write("\t\t\t\t            <div class=\"row acciones\" align=\"right\">\r\n");
            out.write("\t\t\t\t                <a href=\"#\" class=\"btn verde\">");
            if (_jspx_meth_spring_message_18((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_1, _jspx_page_context, _jspx_push_body_count_form_form_1))
              return;
            out.write("</a>\r\n");
            out.write("\t\t\t\t            </div>\r\n");
            out.write("\t\t\t\t          </div>\t\r\n");
            out.write("\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_form_form_1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_form_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_form_form_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_form_form_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_form_form_1.doFinally();
        _jspx_tagPool_form_form_modelAttribute_method_commandName_action.reuse(_jspx_th_form_form_1);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t      \r\n");
      out.write("\t\t$('a.btn.verde').click(function() {\r\n");
      out.write("\t\t\tif (validForm($('#impuesto').attr('id')) && setDatosSAT())\r\n");
      out.write("\t\t\t\tsubmitFormAnimate($('#impuesto').attr('id'), $('#impuesto').attr('action'));\r\n");
      out.write("\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t    $('.drop').dropkick({\r\n");
      out.write("\t        mobile: true,\r\n");
      out.write("\t        change: function(dk) {\r\n");
      out.write("\t            $(this.data.elem).find('.dk-selected').addClass('f-verde');\r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t    // Solo para el ejemplo\r\n");
      out.write("\t    $('.dropfinal').dropkick({\r\n");
      out.write("\t        mobile: true,\r\n");
      out.write("\t        change: function() {\r\n");
      out.write("\t            $(this.data.elem).find('.dk-selected').addClass('f-verde');\r\n");
      out.write("\t            $('.acciones .hidden').removeClass('hidden');\r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction setDatosSAT(){\r\n");
      out.write("\t\tif(document.AppImpEjercicio.getXMLValue() =='*'){\r\n");
      out.write("\t\t\t  $('#errores').prepend('<div class=\"mensaje error fc\"><span class=\"icon icon-error\"></span><span class=\"icon icon-close2\"></span><p><strong class=\"error\">ERRORES</strong><br>Debe confirmar los datos.</p></div>');\r\n");
      out.write("              $('.mensaje .icon-close2').click(function(){ $(this).parent().slideUp(); });\t\t\t\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$('#datosXML').val(document.AppImpEjercicio.getXMLValue());\r\n");
      out.write("\t\t$('#datos').val( document.AppImpEjercicio.appEnviaDatos());\r\n");
      out.write("\t\t$('#datosImpl').val( document.AppImpEjercicio.appEnviaImpresion());\r\n");
      out.write("\t\t$('#cadenaOriginal').val( document.AppImpEjercicio.appEnviaCadOriginal());\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      if (_jspx_meth_c_url_16(_jspx_page_context))
        return;
      out.write("\" id=\"globo\">\r\n");
      out.write("\t\t\t\t<div class=\"row mb40 flex\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col6\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      if (_jspx_meth_c_url_17(_jspx_page_context))
        return;
      out.write("\" alt=\"20 años\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col5 pt15\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dib\">\r\n");
      out.write("\t\t\t\t\t\t\t<h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_spring_message_19(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<br><a href=\"tel:018002234763\">");
      if (_jspx_meth_spring_message_20(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t</h6>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-lg lima\">");
      if (_jspx_meth_spring_message_21(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col6\">\r\n");
      out.write("\t\t\t\t\t\t<strong>");
      if (_jspx_meth_spring_message_22(_jspx_page_context))
        return;
      out.write("</strong><br>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">");
      if (_jspx_meth_spring_message_23(_jspx_page_context))
        return;
      out.write("</a> | <a href=\"#\">");
      if (_jspx_meth_spring_message_24(_jspx_page_context))
        return;
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col5\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<p class=\"h6\">");
      if (_jspx_meth_spring_message_25(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"ml20\" src=\"");
      if (_jspx_meth_c_url_18(_jspx_page_context))
        return;
      out.write("\" alt=\"Verisign\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"ml20\" src=\"");
      if (_jspx_meth_c_url_19(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t<!-- JS para las funciones propias de AfirmeNet\t -->\r\n");
      out.write("\t<script src='");
      if (_jspx_meth_c_url_20(_jspx_page_context))
        return;
      out.write("' type=\"text/javascript\"></script>\t\t\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_message_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_0 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_0.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_0.setParent(null);
    _jspx_th_spring_message_0.setCode("afirmenet.titulo");
    int[] _jspx_push_body_count_spring_message_0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_0 = _jspx_th_spring_message_0.doStartTag();
      if (_jspx_th_spring_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_0.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/resources/favicon.ico");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue("/resources/favicon.ico");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent(null);
    _jspx_th_c_url_2.setValue("/resources/css/main.css?frameX");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_3.setPageContext(_jspx_page_context);
    _jspx_th_c_url_3.setParent(null);
    _jspx_th_c_url_3.setValue("/resources/css/fancybox.css");
    int _jspx_eval_c_url_3 = _jspx_th_c_url_3.doStartTag();
    if (_jspx_th_c_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
    return false;
  }

  private boolean _jspx_meth_c_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_4.setPageContext(_jspx_page_context);
    _jspx_th_c_url_4.setParent(null);
    _jspx_th_c_url_4.setValue("/resources/css/dropkick.css");
    int _jspx_eval_c_url_4 = _jspx_th_c_url_4.doStartTag();
    if (_jspx_th_c_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
    return false;
  }

  private boolean _jspx_meth_c_url_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_5.setPageContext(_jspx_page_context);
    _jspx_th_c_url_5.setParent(null);
    _jspx_th_c_url_5.setValue("/resources/js/jquery-1.11.0.min.js");
    int _jspx_eval_c_url_5 = _jspx_th_c_url_5.doStartTag();
    if (_jspx_th_c_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
    return false;
  }

  private boolean _jspx_meth_c_url_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_6.setPageContext(_jspx_page_context);
    _jspx_th_c_url_6.setParent(null);
    _jspx_th_c_url_6.setValue("/resources/js/vendor/modernizr-2.6.2.min.js");
    int _jspx_eval_c_url_6 = _jspx_th_c_url_6.doStartTag();
    if (_jspx_th_c_url_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
    return false;
  }

  private boolean _jspx_meth_c_url_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_7.setPageContext(_jspx_page_context);
    _jspx_th_c_url_7.setParent(null);
    _jspx_th_c_url_7.setValue("/resources/js/main.js");
    int _jspx_eval_c_url_7 = _jspx_th_c_url_7.doStartTag();
    if (_jspx_th_c_url_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
    return false;
  }

  private boolean _jspx_meth_c_url_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_8.setPageContext(_jspx_page_context);
    _jspx_th_c_url_8.setParent(null);
    _jspx_th_c_url_8.setValue("/resources/js/vendor/jquery.fancybox.pack.js");
    int _jspx_eval_c_url_8 = _jspx_th_c_url_8.doStartTag();
    if (_jspx_th_c_url_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
    return false;
  }

  private boolean _jspx_meth_c_url_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_9.setPageContext(_jspx_page_context);
    _jspx_th_c_url_9.setParent(null);
    _jspx_th_c_url_9.setValue("/resources/js/vendor/packery.js");
    int _jspx_eval_c_url_9 = _jspx_th_c_url_9.doStartTag();
    if (_jspx_th_c_url_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
    return false;
  }

  private boolean _jspx_meth_c_url_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_10.setPageContext(_jspx_page_context);
    _jspx_th_c_url_10.setParent(null);
    _jspx_th_c_url_10.setValue("/resources/js/vendor/dropkick.js");
    int _jspx_eval_c_url_10 = _jspx_th_c_url_10.doStartTag();
    if (_jspx_th_c_url_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_10);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_10);
    return false;
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("context");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_url_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_11 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_11.setPageContext(_jspx_page_context);
    _jspx_th_c_url_11.setParent(null);
    _jspx_th_c_url_11.setValue("/resources/img/icons/logotipo.png");
    int _jspx_eval_c_url_11 = _jspx_th_c_url_11.doStartTag();
    if (_jspx_th_c_url_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_11);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_11);
    return false;
  }

  private boolean _jspx_meth_c_url_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_12 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_12.setPageContext(_jspx_page_context);
    _jspx_th_c_url_12.setParent(null);
    _jspx_th_c_url_12.setValue("/resources/img/photos/avatar2.png");
    int _jspx_eval_c_url_12 = _jspx_th_c_url_12.doStartTag();
    if (_jspx_th_c_url_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_12);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_12);
    return false;
  }

  private boolean _jspx_meth_spring_message_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_1 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_1.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_1.setParent(null);
    _jspx_th_spring_message_1.setCode("afirmenet.header.cerrarSession");
    int[] _jspx_push_body_count_spring_message_1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_1 = _jspx_th_spring_message_1.doStartTag();
      if (_jspx_th_spring_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_1.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_2 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_2.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_2.setParent(null);
    _jspx_th_spring_message_2.setCode("afirmenet.header.saludo");
    int[] _jspx_push_body_count_spring_message_2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_2 = _jspx_th_spring_message_2.doStartTag();
      if (_jspx_th_spring_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_2.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_2);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_3 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_3.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_3.setParent(null);
    _jspx_th_spring_message_3.setCode("afirmenet.header.contrato");
    int[] _jspx_push_body_count_spring_message_3 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_3 = _jspx_th_spring_message_3.doStartTag();
      if (_jspx_th_spring_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_3.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_3);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_4 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_4.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_4.setParent(null);
    _jspx_th_spring_message_4.setCode("afirmenet.header.ultimoAcceso");
    int[] _jspx_push_body_count_spring_message_4 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_4 = _jspx_th_spring_message_4.doStartTag();
      if (_jspx_th_spring_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_4.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_4);
    }
    return false;
  }

  private boolean _jspx_meth_c_url_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_13 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_13.setPageContext(_jspx_page_context);
    _jspx_th_c_url_13.setParent(null);
    _jspx_th_c_url_13.setValue("/resources/css/transaccion.css");
    int _jspx_eval_c_url_13 = _jspx_th_c_url_13.doStartTag();
    if (_jspx_th_c_url_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_13);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_13);
    return false;
  }

  private boolean _jspx_meth_form_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_method_commandName_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_form_0.setPageContext(_jspx_page_context);
    _jspx_th_form_form_0.setParent(null);
    _jspx_th_form_form_0.setMethod("POST");
    _jspx_th_form_form_0.setCommandName("menu");
    _jspx_th_form_form_0.setAction("#");
    int[] _jspx_push_body_count_form_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_form_0 = _jspx_th_form_form_0.doStartTag();
      if (_jspx_eval_form_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_form_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_form_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_form_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_form_0.doFinally();
      _jspx_tagPool_form_form_method_commandName_action.reuse(_jspx_th_form_form_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty errores}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<div class=\"notificacion error\">\r\n");
        out.write("\t<a class=\"icon icon-close2\"></a>\r\n");
        out.write("\t<div class=\"clearfix\">\r\n");
        out.write("\t\t<span class=\"icon icon-error\"></span>\r\n");
        out.write("\t\t<span class=\"f21 m0\"><strong>ERROR</strong></span>\r\n");
        out.write("\t\t<br>\r\n");
        out.write("\t\t<ul>\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t \t</ul>\r\n");
        out.write("\t</div>\r\n");
        out.write("</div>\r\n");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setVar("erroresTotal");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errores}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t \t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_1.setVar("error");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${erroresTotal.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<li>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${erroresTotal.key}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" - ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </li>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_form_hidden_0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_form_hidden_0 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_form_hidden_path_id_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_form_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_form_hidden_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_form_hidden_0.setPath("datosXML");
    _jspx_th_form_hidden_0.setId("datosXML");
    int[] _jspx_push_body_count_form_hidden_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_hidden_0 = _jspx_th_form_hidden_0.doStartTag();
      if (_jspx_th_form_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_hidden_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_hidden_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_hidden_0.doFinally();
      _jspx_tagPool_form_hidden_path_id_nobody.reuse(_jspx_th_form_hidden_0);
    }
    return false;
  }

  private boolean _jspx_meth_form_hidden_1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_form_hidden_1 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_form_hidden_path_id_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_form_hidden_1.setPageContext(_jspx_page_context);
    _jspx_th_form_hidden_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_form_hidden_1.setPath("datos");
    _jspx_th_form_hidden_1.setId("datos");
    int[] _jspx_push_body_count_form_hidden_1 = new int[] { 0 };
    try {
      int _jspx_eval_form_hidden_1 = _jspx_th_form_hidden_1.doStartTag();
      if (_jspx_th_form_hidden_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_hidden_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_hidden_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_hidden_1.doFinally();
      _jspx_tagPool_form_hidden_path_id_nobody.reuse(_jspx_th_form_hidden_1);
    }
    return false;
  }

  private boolean _jspx_meth_form_hidden_2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_form_hidden_2 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_form_hidden_path_id_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_form_hidden_2.setPageContext(_jspx_page_context);
    _jspx_th_form_hidden_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_form_hidden_2.setPath("datosImpl");
    _jspx_th_form_hidden_2.setId("datosImpl");
    int[] _jspx_push_body_count_form_hidden_2 = new int[] { 0 };
    try {
      int _jspx_eval_form_hidden_2 = _jspx_th_form_hidden_2.doStartTag();
      if (_jspx_th_form_hidden_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_hidden_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_hidden_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_hidden_2.doFinally();
      _jspx_tagPool_form_hidden_path_id_nobody.reuse(_jspx_th_form_hidden_2);
    }
    return false;
  }

  private boolean _jspx_meth_form_hidden_3(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_form_hidden_3 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_form_hidden_path_id_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_form_hidden_3.setPageContext(_jspx_page_context);
    _jspx_th_form_hidden_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_form_hidden_3.setPath("cadenaOriginal");
    _jspx_th_form_hidden_3.setId("cadenaOriginal");
    int[] _jspx_push_body_count_form_hidden_3 = new int[] { 0 };
    try {
      int _jspx_eval_form_hidden_3 = _jspx_th_form_hidden_3.doStartTag();
      if (_jspx_th_form_hidden_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_hidden_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_hidden_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_hidden_3.doFinally();
      _jspx_tagPool_form_hidden_path_id_nobody.reuse(_jspx_th_form_hidden_3);
    }
    return false;
  }

  private boolean _jspx_meth_form_hidden_4(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_form_hidden_4 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_form_hidden_path_id_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_form_hidden_4.setPageContext(_jspx_page_context);
    _jspx_th_form_hidden_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_form_hidden_4.setPath("tipoImpuesto");
    _jspx_th_form_hidden_4.setId("tipoImpuesto");
    int[] _jspx_push_body_count_form_hidden_4 = new int[] { 0 };
    try {
      int _jspx_eval_form_hidden_4 = _jspx_th_form_hidden_4.doStartTag();
      if (_jspx_th_form_hidden_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_hidden_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_hidden_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_hidden_4.doFinally();
      _jspx_tagPool_form_hidden_path_id_nobody.reuse(_jspx_th_form_hidden_4);
    }
    return false;
  }

  private boolean _jspx_meth_form_hidden_5(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_form_hidden_5 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_form_hidden_path_id_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_form_hidden_5.setPageContext(_jspx_page_context);
    _jspx_th_form_hidden_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_form_hidden_5.setPath("contratoId");
    _jspx_th_form_hidden_5.setId("contratoId");
    int[] _jspx_push_body_count_form_hidden_5 = new int[] { 0 };
    try {
      int _jspx_eval_form_hidden_5 = _jspx_th_form_hidden_5.doStartTag();
      if (_jspx_th_form_hidden_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_hidden_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_hidden_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_hidden_5.doFinally();
      _jspx_tagPool_form_hidden_path_id_nobody.reuse(_jspx_th_form_hidden_5);
    }
    return false;
  }

  private boolean _jspx_meth_form_hidden_6(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:hidden
    org.springframework.web.servlet.tags.form.HiddenInputTag _jspx_th_form_hidden_6 = (org.springframework.web.servlet.tags.form.HiddenInputTag) _jspx_tagPool_form_hidden_path_id_nobody.get(org.springframework.web.servlet.tags.form.HiddenInputTag.class);
    _jspx_th_form_hidden_6.setPageContext(_jspx_page_context);
    _jspx_th_form_hidden_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_form_hidden_6.setPath("nombreCliente");
    _jspx_th_form_hidden_6.setId("nombreCliente");
    int[] _jspx_push_body_count_form_hidden_6 = new int[] { 0 };
    try {
      int _jspx_eval_form_hidden_6 = _jspx_th_form_hidden_6.doStartTag();
      if (_jspx_th_form_hidden_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_hidden_6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_hidden_6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_hidden_6.doFinally();
      _jspx_tagPool_form_hidden_path_id_nobody.reuse(_jspx_th_form_hidden_6);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_5(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_5 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_5.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_5.setCode("afirmenet.pago.impuestos.federales.anual.titulo");
    int[] _jspx_push_body_count_spring_message_5 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_5 = _jspx_th_spring_message_5.doStartTag();
      if (_jspx_th_spring_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_5.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_5);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_6(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_6 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_6.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_6.setCode("afirmenet.horarios");
    int[] _jspx_push_body_count_spring_message_6 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_6 = _jspx_th_spring_message_6.doStartTag();
      if (_jspx_th_spring_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_6.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_6);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${horario}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_spring_message_7(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_7 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_7.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_7.setCode("afirmenet.pago.impuestos.federales.paso1");
    int[] _jspx_push_body_count_spring_message_7 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_7 = _jspx_th_spring_message_7.doStartTag();
      if (_jspx_th_spring_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_7[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_7.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_7.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_7);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_8(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_8 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_8.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_8.setCode("afirmenet.pago.impuestos.federales.paso.datos");
    int[] _jspx_push_body_count_spring_message_8 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_8 = _jspx_th_spring_message_8.doStartTag();
      if (_jspx_th_spring_message_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_8[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_8.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_8.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_8);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_9(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_9 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_9.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_9.setCode("afirmenet.pago.impuestos.federales.paso2");
    int[] _jspx_push_body_count_spring_message_9 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_9 = _jspx_th_spring_message_9.doStartTag();
      if (_jspx_th_spring_message_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_9[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_9.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_9.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_9);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_10(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_10 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_10.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_10.setCode("afirmenet.pago.impuestos.federales.paso.confirmar");
    int[] _jspx_push_body_count_spring_message_10 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_10 = _jspx_th_spring_message_10.doStartTag();
      if (_jspx_th_spring_message_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_10[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_10.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_10.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_10);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_11(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_11 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_11.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_11.setCode("afirmenet.pago.impuestos.federales.paso3");
    int[] _jspx_push_body_count_spring_message_11 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_11 = _jspx_th_spring_message_11.doStartTag();
      if (_jspx_th_spring_message_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_11[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_11.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_11.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_11);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_12(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_12 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_12.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_12.setCode("afirmenet.pago.impuestos.federales.paso.comprobante");
    int[] _jspx_push_body_count_spring_message_12 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_12 = _jspx_th_spring_message_12.doStartTag();
      if (_jspx_th_spring_message_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_12[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_12.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_12.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_12);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_13(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_13 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_13.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_13.setCode("afirmenet.transferencias.seleccionar");
    int[] _jspx_push_body_count_spring_message_13 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_13 = _jspx_th_spring_message_13.doStartTag();
      if (_jspx_th_spring_message_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_13[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_13.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_13.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_13);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_14(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_14 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_14.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_14.setCode("afirmenet.obligatorio");
    int[] _jspx_push_body_count_spring_message_14 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_14 = _jspx_th_spring_message_14.doStartTag();
      if (_jspx_th_spring_message_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_14[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_14.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_14.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_14);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_15(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_15 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_15.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_15.setCode("afirmenet.transferencias.origen");
    int[] _jspx_push_body_count_spring_message_15 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_15 = _jspx_th_spring_message_15.doStartTag();
      if (_jspx_th_spring_message_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_15[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_15.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_15.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_15);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_option_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_option_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_option_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cuentaPropia.description} (${cuentaPropia.numberMask}) - $${cuentaPropia.balanceFormatted} ${cuentaPropia.ccy}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_spring_message_16(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_16 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_16.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_16.setCode("afirmenet.pago.impuestos.federales.fecha");
    int[] _jspx_push_body_count_spring_message_16 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_16 = _jspx_th_spring_message_16.doStartTag();
      if (_jspx_th_spring_message_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_16[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_16.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_16.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_16);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_17(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_17 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_17.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_17.setCode("afirmenet.pago.impuestos.federales.datos");
    int[] _jspx_push_body_count_spring_message_17 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_17 = _jspx_th_spring_message_17.doStartTag();
      if (_jspx_th_spring_message_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_17[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_17.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_17.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_17);
    }
    return false;
  }

  private boolean _jspx_meth_c_url_14(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_14 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_14.setPageContext(_jspx_page_context);
    _jspx_th_c_url_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_c_url_14.setValue("/resources/applet/Ejercicio.jar");
    int _jspx_eval_c_url_14 = _jspx_th_c_url_14.doStartTag();
    if (_jspx_th_c_url_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_14);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_14);
    return false;
  }

  private boolean _jspx_meth_c_url_15(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_15 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_15.setPageContext(_jspx_page_context);
    _jspx_th_c_url_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_c_url_15.setValue("/resources/applet/Derechos.jar");
    int _jspx_eval_c_url_15 = _jspx_th_c_url_15.doStartTag();
    if (_jspx_th_c_url_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_15);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_15);
    return false;
  }

  private boolean _jspx_meth_spring_message_18(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_18 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_18.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_1);
    _jspx_th_spring_message_18.setCode("afirmenet.botones.continuar");
    int[] _jspx_push_body_count_spring_message_18 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_18 = _jspx_th_spring_message_18.doStartTag();
      if (_jspx_th_spring_message_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_18[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_18.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_18.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_18);
    }
    return false;
  }

  private boolean _jspx_meth_c_url_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_16 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_16.setPageContext(_jspx_page_context);
    _jspx_th_c_url_16.setParent(null);
    _jspx_th_c_url_16.setValue("/resources/img/photos/globo.png");
    int _jspx_eval_c_url_16 = _jspx_th_c_url_16.doStartTag();
    if (_jspx_th_c_url_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_16);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_16);
    return false;
  }

  private boolean _jspx_meth_c_url_17(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_17 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_17.setPageContext(_jspx_page_context);
    _jspx_th_c_url_17.setParent(null);
    _jspx_th_c_url_17.setValue("/resources/img/icons/logotipo-20.png");
    int _jspx_eval_c_url_17 = _jspx_th_c_url_17.doStartTag();
    if (_jspx_th_c_url_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_17);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_17);
    return false;
  }

  private boolean _jspx_meth_spring_message_19(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_19 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_19.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_19.setParent(null);
    _jspx_th_spring_message_19.setCode("afirmenet.asistenciaTelefonica");
    int[] _jspx_push_body_count_spring_message_19 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_19 = _jspx_th_spring_message_19.doStartTag();
      if (_jspx_th_spring_message_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_19[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_19.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_19.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_19);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_20(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_20 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_20.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_20.setParent(null);
    _jspx_th_spring_message_20.setCode("afirmenet.01800");
    int[] _jspx_push_body_count_spring_message_20 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_20 = _jspx_th_spring_message_20.doStartTag();
      if (_jspx_th_spring_message_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_20[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_20.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_20.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_20);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_21(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_21 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_21.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_21.setParent(null);
    _jspx_th_spring_message_21.setCode("afirmenet.AYUDA");
    int[] _jspx_push_body_count_spring_message_21 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_21 = _jspx_th_spring_message_21.doStartTag();
      if (_jspx_th_spring_message_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_21[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_21.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_21.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_21);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_22(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_22 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_22.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_22.setParent(null);
    _jspx_th_spring_message_22.setCode("afirmenet.copyright");
    int[] _jspx_push_body_count_spring_message_22 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_22 = _jspx_th_spring_message_22.doStartTag();
      if (_jspx_th_spring_message_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_22[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_22.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_22.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_22);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_23(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_23 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_23.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_23.setParent(null);
    _jspx_th_spring_message_23.setCode("afirmenet.avisoPrivacidad");
    int[] _jspx_push_body_count_spring_message_23 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_23 = _jspx_th_spring_message_23.doStartTag();
      if (_jspx_th_spring_message_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_23[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_23.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_23.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_23);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_24(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_24 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_24.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_24.setParent(null);
    _jspx_th_spring_message_24.setCode("afirmenet.terminosLegales");
    int[] _jspx_push_body_count_spring_message_24 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_24 = _jspx_th_spring_message_24.doStartTag();
      if (_jspx_th_spring_message_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_24[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_24.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_24.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_24);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_25(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_25 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_25.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_25.setParent(null);
    _jspx_th_spring_message_25.setCode("afirmenet.sellosDeSeguridad");
    int[] _jspx_push_body_count_spring_message_25 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_25 = _jspx_th_spring_message_25.doStartTag();
      if (_jspx_th_spring_message_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_25[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_25.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_25.doFinally();
      _jspx_tagPool_spring_message_code_nobody.reuse(_jspx_th_spring_message_25);
    }
    return false;
  }

  private boolean _jspx_meth_c_url_18(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_18 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_18.setPageContext(_jspx_page_context);
    _jspx_th_c_url_18.setParent(null);
    _jspx_th_c_url_18.setValue("/resources/img/icons/verisign.jpg");
    int _jspx_eval_c_url_18 = _jspx_th_c_url_18.doStartTag();
    if (_jspx_th_c_url_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_18);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_18);
    return false;
  }

  private boolean _jspx_meth_c_url_19(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_19 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_19.setPageContext(_jspx_page_context);
    _jspx_th_c_url_19.setParent(null);
    _jspx_th_c_url_19.setValue("/resources/img/icons/amipci.jpg");
    int _jspx_eval_c_url_19 = _jspx_th_c_url_19.doStartTag();
    if (_jspx_th_c_url_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_19);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_19);
    return false;
  }

  private boolean _jspx_meth_c_url_20(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_20 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_20.setPageContext(_jspx_page_context);
    _jspx_th_c_url_20.setParent(null);
    _jspx_th_c_url_20.setValue("/resources/js/afirmenet/utils.js");
    int _jspx_eval_c_url_20 = _jspx_th_c_url_20.doStartTag();
    if (_jspx_th_c_url_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_20);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_20);
    return false;
  }
}
