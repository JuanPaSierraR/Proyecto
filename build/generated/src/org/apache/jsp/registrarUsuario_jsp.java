package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registrarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registrar Usuario</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Css/registrarUsuario.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <form class=\"Formulario\" method = \"post\" action = \"Usuarios\" > \n");
      out.write("            <h1>Registrar Usuario</h1>\n");
      out.write("            <input type=\"text\" name=\"txtNombre\" placeholder=\"Nombres\" required=\"\" >\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"txtDocumento\" placeholder=\"Documento\" required=\"\">\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"txtTelefono\" placeholder=\"Telefono\" required=\"\">\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"txtEmail\" placeholder=\"Email\" required=\"\">\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"txtDireccion\" placeholder=\"Direccion\" required=\"\">\n");
      out.write("            <br>\n");
      out.write("            <input type=\"number\" name=\"txtEstado\" placeholder=\"Estado\" required=\"\">\n");
      out.write("            <br>\n");
      out.write("            <input type=\"password\" name=\"txtContrasena\" placeholder=\"Contraseña\" required=\"\"><br>\n");
      out.write("            <button id=\"Boton\"> Registrar </button>\n");
      out.write("            <input type=\"hidden\" value=\"1\" name=\"opcion\">\n");
      out.write("            <a href=\"index.jsp\">Iniciar Sesion</a><br>\n");
      out.write("            \n");
      out.write("            <div class=\"mensaje\">\n");
      out.write("                ");

                if (request.getAttribute("mensajeError") != null) {
      out.write("\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("                ");
   } else {
      out.write("\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
