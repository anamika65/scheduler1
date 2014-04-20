package org.apache.jsp.WEB_002dINF.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class TrainingProgress_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
  _jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:contains", org.apache.taglibs.standard.functions.Functions.class, "contains", new Class[] {java.lang.String.class, java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/common/header.jspf");
    _jspx_dependants.add("/WEB-INF/jsp/admin/AddResident.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifNotGranted;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifAnyGranted;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifNotGranted = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifAnyGranted = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifNotGranted.release();
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifAnyGranted.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.release();
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\"  type=\"text/css\" />\r\n");
      out.write("<link href=\"../resources/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../resources/bootstrap/css/bootstrap-responsive.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../resources/bootstrap/extension/bootstrap-progressbar.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<link href=\"../resources/bootstrap/extension/datepicker.css\" rel=\"stylesheet\"/>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"></script>  \r\n");
      out.write("<script src=\"../resources/js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("<script src=\"../resources/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"../resources/bootstrap/extension/bootstrap-progressbar.js\"></script>\r\n");
      out.write("<script src=\"../resources/bootstrap/extension/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar OK = 0;\r\n");
      out.write("\t\r\n");
      out.write("\tvar currentForm;\r\n");
      out.write("\tvar OK_Difficult = 0;\r\n");
      out.write("\t//check already exist username\r\n");
      out.write("\t$(\"#usr_name\").blur(function(){\r\n");
      out.write("\t\tif($.trim($(\"#usr_name\").val()).length >0){\r\n");
      out.write("\t\t\tvar userName = $.trim($(this).val());\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"../administration/crud/checkUser\",//servlet URL that gets first option as parameter and returns JSON of to-be-populated options\r\n");
      out.write("\t\t\t\tdata : \"usrNameValue=\"+ userName,\r\n");
      out.write("\t\t\t\ttype : \"POST\",//request type, can be GET\r\n");
      out.write("\t\t\t\tcache : false,//do not cache returned data\r\n");
      out.write("\t\t\t}).done(function(data) {\r\n");
      out.write("\t\t\t\t// -1,0 : Password doesn't exist, others : Password found\r\n");
      out.write("\t\t\t\tif (data == \"1\") {\r\n");
      out.write("\t\t\t\t\t// ask user to enter passwords\r\n");
      out.write("\t\t\t\t\t$(\".mappingSuggestion1\").html(\"User Name Already Exist.Choose Another\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.css(\"color\",\"#aa0000\");\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t$(\".mappingSuggestion1\").html(\"User Name Available\")\r\n");
      out.write("\t\t\t\t\t.css(\"color\",\"#00aa00\");\r\n");
      out.write("\t\t\t\t\tOK = 1;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t$( \"#userRegistrationForm\" ).submit(function( event ) {\r\n");
      out.write("\t\t  if ( OK == 1 ) { //all are ok\r\n");
      out.write("\t\t    return;\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  event.preventDefault();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".chooseDiffOpForm\").submit(function( event ) {\r\n");
      out.write("\t\tif ( OK_Difficult == 1 ) { //all are ok\r\n");
      out.write("\t\t    return;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tcurrentForm = $(this);\r\n");
      out.write("\t\tevent.preventDefault();\r\n");
      out.write("\t\t$('#diffChangeModal').modal();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$( \"#yesChange\" ).click(function() {\r\n");
      out.write("\t\tOK_Difficult = 1;\r\n");
      out.write("\t\tcurrentForm.submit();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}); \r\n");
      out.write(" \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Training progress</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

	DateFormat pickerFormatter = new SimpleDateFormat("dd-MM-yyyy");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"wrap\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\t\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("\t\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fremove_005f0(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fremove_005f1(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\t\n");
      out.write("\t\t<h1 style = \"background:#004682\">\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<p style = \"padding: 7px 0px 0px 0px; height: 110px; font-size: 13px; color: #FFFFFF; font-weight: normal\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t</h1>\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<table  class=\"homepageTable\" style=\"width:100%;\">\n");
      out.write("\t\t\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t</table>");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f9.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f9.setParent(null);
      // /WEB-INF/jsp/admin/TrainingProgress.jsp(111,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userRole == 'ROLE_ADMIN' }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_005fif_005f9 = _jspx_th_c_005fif_005f9.doStartTag();
      if (_jspx_eval_c_005fif_005f9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \r\n");
          out.write("\t\t\t<table  class=\"homepageTable\" style=\"width:100%;\">\r\n");
          out.write("\t\t\t    <tr>\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t");
          out.write("<td style=\"width:50px;\"/>\n");
          out.write("\n");
          out.write("\t\t\t\t<td style=\"width:950px;\">\n");
          out.write("\t\t    \t\t<legend class=\"legendFont\">Residents</legend>\n");
          out.write("\t\t    \t</td>\n");
          out.write("\n");
          out.write("\t\t   \t\t<td class=\"buttonRight\">\n");
          out.write("\n");
          out.write("\t\t\t\t\t<!-- Button to trigger modal for adding a new Catalogue -->\n");
          out.write("\t\t\t\t\t<a href=\"#myAddURL\" class=\"btn btn-primary\" role=\"button\" data-toggle=\"modal\"> Add Resident </a>\n");
          out.write("\n");
          out.write("\t\t\t\t\t<!-- URL for adding the catalogue; the new values will be available in controller using parameters -->\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005furl_005f8(_jspx_th_c_005fif_005f9, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t\t    <form method=\"POST\" action=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" id=\"userRegistrationForm\">\n");
          out.write("\n");
          out.write("\t\t\t\t\t<!-- Modal for adding a new catalogue -->\t\t\t\t\t\t    \n");
          out.write("\t\t\t\t    <div id=\"myAddURL\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
          out.write("\t\t\t\t\t        <div class=\"modal-header\">\n");
          out.write("\t\t\t\t\t            <a class=\"close\" data-dismiss=\"modal\">×</a>\n");
          out.write("\t\t\t\t\t\t\t    <h3 id=\"myModalLabel\" style=\"text-align:left\"> New Resident </h3>\n");
          out.write("\t\t\t\t\t\t    </div>\n");
          out.write("\n");
          out.write("\t\t\t\t\t        <div class=\"modal-body\" style=\"text-align:left;\">\n");
          out.write("\t\t\t\t\t\t\t\t<table>\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Title: </label>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t              <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t\t\t              \t<div class=\"controls\">\n");
          out.write("\t\t\t\t\t\t\t\t            \t<input name=\"title\" type=\"text\" placeholder=\"Type title...\" required/> \n");
          out.write("\t\t\t\t\t\t\t             \t</div>\n");
          out.write("\t\t\t\t\t\t\t              </div>\n");
          out.write("\t\t\t\t\t\t\t            </td>\n");
          out.write("\t\t\t\t\t\t\t        </tr>\n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Name: </label>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t              <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t\t\t              \t<div class=\"controls\">\n");
          out.write("\t\t\t\t\t\t\t\t            \t<input name=\"name\" type=\"text\" placeholder=\"Type name...\" required/> \n");
          out.write("\t\t\t\t\t\t\t             \t</div>\n");
          out.write("\t\t\t\t\t\t\t              </div>\n");
          out.write("\t\t\t\t\t\t\t            </td>\n");
          out.write("\t\t\t\t\t\t            </tr>\n");
          out.write("\t\t\t\t\t\t            <tr>\n");
          out.write("\t\t\t\t\t\t            \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > First Name: </label>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t              <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t\t\t              \t<div class=\"controls\">\n");
          out.write("\t\t\t\t\t\t\t\t            \t<input name=\"firstName\" type=\"text\" placeholder=\"Type first name...\" required/> \n");
          out.write("\t\t\t\t\t\t\t             \t</div>\n");
          out.write("\t\t\t\t\t\t\t              </div>\n");
          out.write("\t\t\t\t\t\t\t            </td>\n");
          out.write("\t\t\t\t\t\t\t        </tr>\n");
          out.write("\t\t\t\t\t\t\t        <tr>\n");
          out.write("\t\t\t\t\t                    <td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <label class=\"control-label\" > Username: </label>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                    <td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t                            <div class=\"controls\">\n");
          out.write("\t\t\t\t\t                                <input id=\"usr_name\" name=\"username\" type=\"text\" placeholder=\"Enter Username\" required/> \n");
          out.write("\t\t\t\t\t                            </div>\n");
          out.write("\t\t\t\t\t                        </div>\n");
          out.write("\t\t\t\t\t                    </td>  \n");
          out.write("\t\t\t\t\t                    <td>\n");
          out.write("\t\t\t\t\t                    \t<span class=\"mappingSuggestion1 miniSugg\" ></span>\n");
          out.write("\t\t\t\t\t                    </td>                      \n");
          out.write("\t\t\t\t\t                </tr>\n");
          out.write("\t\t\t\t\t                <tr>\n");
          out.write("\t\t\t\t\t                    <td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <label class=\"control-label\" > Password: </label>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                    <td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t                            <div class=\"controls\">\n");
          out.write("\t\t\t\t\t                                <input name=\"password\" type=\"password\" placeholder=\"Enter Password\" required/> \n");
          out.write("\t\t\t\t\t                            </div>\n");
          out.write("\t\t\t\t\t                        </div>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                </tr>\t       \n");
          out.write("\t\t\t\t\t\t\t\t\t<tr>\n");
          out.write("\t\t\t\t\t                    <td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <label class=\"control-label\" > Speciality: </label>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                    <td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t                            <div class=\"controls\">\n");
          out.write("\t\t\t\t\t                                <select   name=\"specialityID\" >\n");
          out.write("\t\t\t\t\t                                      ");
          if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fif_005f9, _jspx_page_context))
            return;
          out.write(" \n");
          out.write("\t\t\t\t\t                                </select> \n");
          out.write("\t\t\t\t\t                            </div>\n");
          out.write("\t\t\t\t\t                        </div>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                </tr>\n");
          out.write("\t\t\t\t\t                <tr>\n");
          out.write("\t\t\t\t\t                    <td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <label class=\"control-label\" > Training System: </label>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                    <td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t                            <div class=\"controls\">\n");
          out.write("\t\t\t\t\t                                <select   name=\"trainSysId\" >\n");
          out.write("\t\t\t\t\t                                      ");
          if (_jspx_meth_c_005fforEach_005f2(_jspx_th_c_005fif_005f9, _jspx_page_context))
            return;
          out.write(" \n");
          out.write("\t\t\t\t\t                                </select> \n");
          out.write("\t\t\t\t\t                            </div>\n");
          out.write("\t\t\t\t\t                        </div>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                </tr>\n");
          out.write("\t\t\t\t\t                <tr>\n");
          out.write("\t\t\t\t\t\n");
          out.write("\t\t\t\t\t                    <td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                        <label class=\"control-label\" for=\"email\">Email Address</label>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                    <td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t                         <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t                          <div class=\"controls\">\n");
          out.write("\t\t\t\t\t                           <input type=\"email\" name=\"emailAdd\" id=\"email\" placeholder=\"Your email address\">\n");
          out.write("\t\t\t\t\t                          </div>\n");
          out.write("\t\t\t\t\t                         </div>\n");
          out.write("\t\t\t\t\t                    </td>\n");
          out.write("\t\t\t\t\t                    </tr>\n");
          out.write("                    \t\t\t\t\t <tr>\n");
          out.write("\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Function: </label>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t              <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t\t\t              \t<div class=\"controls\">\n");
          out.write("\t\t\t\t\t\t\t\t            \t<input name=\"function\" type=\"text\" placeholder=\"Type function...\" required/> \n");
          out.write("\t\t\t\t\t\t\t             \t</div>\n");
          out.write("\t\t\t\t\t\t\t              </div>\n");
          out.write("\t\t\t\t\t\t\t            </td>\n");
          out.write("\t\t\t\t\t\t\t        </tr>\n");
          out.write("\t\t\t\t\t\t\t        <tr>\n");
          out.write("\t\t\t\t\t\t\t            <td class=\"tdCatalogueType1\" style=\"padding-bottom: 15px;\"> Start date: </td>\n");
          out.write("\t\t\t\t\t\t\t            <td style=\"padding-bottom: 15px;\">\n");
          out.write("\t\t\t\t\t\t\t            \t<div class=\"input-append date\" id=\"dp3\" data-date='");
          out.print(  pickerFormatter.format(new Date()) );
          out.write("' data-date-format=\"dd-mm-yyyy\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"startDate\" class=\"span2\" size=\"16\" type=\"text\" readonly=\"\" value='");
          out.print(  pickerFormatter.format(new Date()) );
          out.write("'>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"add-on\"><i class=\"icon-th\"></i></span>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t           \t</td> \n");
          out.write("\t\t\t\t\t\t\t        </tr>\n");
          out.write("\t\t\t\t\t\t\t        <tr>\n");
          out.write("\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Duration: </label>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\n");
          out.write("\t\t\t\t\t\t\t              <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t\t\t              \t<div class=\"controls\">\n");
          out.write("\t\t\t\t\t\t\t\t            \t<input name=\"duration\" min=\"1\" max=\"200\" type=\"number\" placeholder=\"Type duration in months...\" required/> \n");
          out.write("\t\t\t\t\t\t\t             \t</div>\n");
          out.write("\t\t\t\t\t\t\t             \t<div class=\"alert\">\n");
          out.write(" \t\t\t\t\t\t\t\t\t\t\t\t\t Training Duration of a resident\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t              </div>\n");
          out.write("\t\t\t\t\t\t\t            </td>\n");
          out.write("\t\t\t\t\t\t\t        </tr>\t\n");
          out.write("\t\t\t\t\t\t\t        <tr>\n");
          out.write("\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline; height: 15px;\">\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Capacity: </label>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</td>\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline; height: 15px;\">\n");
          out.write("\t\t\t\t\t\t\t              <div class=\"control-group\">\n");
          out.write("\t\t\t\t\t\t\t              \t<div class=\"controls\">\n");
          out.write("\t\t\t\t\t\t\t\t            \t<input name=\"capacity\" min=\"1\" max=\"200\" type=\"number\" placeholder=\"Type capacity per month...\" required/> \n");
          out.write("\t\t\t\t\t\t\t             \t</div>\n");
          out.write("\t\t\t\t\t\t\t             \t<div class=\"alert \">\n");
          out.write(" \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tMonthly Capacity of operation for a resident\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t              </div>\n");
          out.write("\t\t\t\t\t\t\t            </td>\n");
          out.write("\t\t\t\t\t\t\t        </tr>\t\t\n");
          out.write("\t\t\t\t\t            </table>\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("\t\t\t\t\t        <div class=\"modal-footer\">\n");
          out.write("\t\t\t\t\t            <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\n");
          out.write("\t\t\t\t\t            <input type=\"submit\" value=\"Add\" class=\"btn btn-primary\" />\n");
          out.write("\t\t\t\t\t        </div>\n");
          out.write("\t\t\t\t    </div>\n");
          out.write("\t\t\t\t    </form>\n");
          out.write("\t\t\t\t</td>\n");
          out.write("\n");
          out.write("\t\t\t\t<td style=\"width:50px;\"/>");
          out.write("\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t</table>\r\n");
          out.write("\t\t\t\r\n");
          out.write("\t\t\t<!-- counts residents in list  -->\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_c_005fset_005f3(_jspx_th_c_005fif_005f9, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t<!-- wrapper for tabs -->\r\n");
          out.write("\t\t\t<div class=\"centeredTableNoTop\" style=\"width:1100px;\">\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t<!-- tabs for active and inactive residents -->\r\n");
          out.write("\t            <ul id=\"myTab\" class=\"nav nav-tabs\">\r\n");
          out.write("\t              <li class=\"active\"><a href=\"#activeProjects\" data-toggle=\"tab\">Active</a></li>\r\n");
          out.write("\t              <li class=\"\"><a href=\"#inactiveProjects\" data-toggle=\"tab\">Inactive</a></li>\r\n");
          out.write("\t            </ul>\r\n");
          out.write("\t            \r\n");
          out.write("\t\t\t\t<!-- tab content with active residents -->\r\n");
          out.write("\t            <div id=\"myTabContent\" class=\"tab-content\">\r\n");
          out.write("\t\t\t\t  <!-- active tab is the one with active residents -->\r\n");
          out.write("\t              <div class=\"tab-pane fade active in\" id=\"activeProjects\">\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t<!-- all residents are wrapped in an group that manages which body is visible -->\r\n");
          out.write("\t\t\t\t\t<div class=\"accordion\" id=\"accordion1\">\r\n");
          out.write("\t\t\t\t\t\t");
          //  c:forEach
          org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
          _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
          _jspx_th_c_005fforEach_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f9);
          // /WEB-INF/jsp/admin/TrainingProgress.jsp(136,6) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_c_005fforEach_005f3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${activeProjects}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
          // /WEB-INF/jsp/admin/TrainingProgress.jsp(136,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_c_005fforEach_005f3.setVar("project");
          int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
          try {
            int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
            if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t<div class=\"accordion-group\">\r\n");
                out.write("\t\t\t\t\t\t\t    <div class=\"accordion-heading\">\r\n");
                out.write("\t\t\t\t\t\t\t\t  <!-- unique id for each project -->\r\n");
                out.write("\t\t\t\t\t\t\t      ");
                if (_jspx_meth_c_005fset_005f4(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t      ");
                if (_jspx_meth_c_005fset_005f5(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t      <script>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t $(document).ready(function() {\r\n");
                out.write("\t\t\t\t\t\t\t\t        \t$('#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${generateProgress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("').on('click', function(event) {        \t\r\n");
                out.write("\t\t\t\t\t\t\t\t        \t\t$('#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${collapseResident}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write(" .progress .bar.text-centered-1').progressbar({\r\n");
                out.write("\t\t\t\t\t\t\t\t        \t\t\tupdate: function(current_percentage) { $('#v-callback-update-1').text(current_percentage); },\r\n");
                out.write("\t\t\t\t\t\t\t\t        \t\t\tdone: function(current_percentage) { $('#v-callback-done-1').text('done!'); },\r\n");
                out.write("\t\t\t\t\t\t\t\t        \t\t\tdisplay_text: 2\r\n");
                out.write("\t\t\t\t\t\t\t\t        \t\t\t}); \r\n");
                out.write("\t\t\t\t\t\t\t\t        \t}); \r\n");
                out.write("\t\t\t\t\t\t\t\t        });\r\n");
                out.write("\t\t\t\t\t\t  \t\t  </script>\r\n");
                out.write("\t\t\t\t\t\t\t\t  <!-- collapse header -->\r\n");
                out.write("\t\t\t\t\t\t\t      <a id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${generateProgress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${collapseResident}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">\r\n");
                out.write("\t\t\t\t\t\t\t        \t");
                if (_jspx_meth_c_005fset_005f6(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(". \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" \r\n");
                out.write("\t\t\t\t\t\t\t\t        ");
                if (_jspx_meth_c_005fout_005f5(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" \r\n");
                out.write("\t\t\t\t\t\t\t\t        ");
                if (_jspx_meth_c_005fif_005f10(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t      </a>\r\n");
                out.write("\t\t\t\t\t    \t\t</div>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t<!-- collapse body -->\r\n");
                out.write("\t\t\t\t\t    \t\t<div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${collapseResident}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"accordion-body collapse\">\r\n");
                out.write("\t\t\t\t\t\t\t      <div class=\"accordion-inner\">\r\n");
                out.write("\t\t\t\t\t\t\t      \t");
                if (_jspx_meth_c_005fif_005f11(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t \tName: <b style=\"font-size:16px;\"> ");
                if (_jspx_meth_c_005fout_005f6(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" </b>\r\n");
                out.write("\t\t\t\t\t\t\t       \t<font style=\"padding-left:30px;\">First Name:</font> <b style=\"font-size:16px;\"> ");
                if (_jspx_meth_c_005fout_005f7(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" </b>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<font style=\"padding-left:30px;\">Nickname: <b style=\"font-size:16px;\">");
                if (_jspx_meth_c_005fout_005f8(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("</b></font>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<ul class=\"dropdown nav pull-right\" style=\"text-align: left;\">\r\n");
                out.write("\t\t\t\t                      <a href=\"#\" id=\"drop3\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Manage<b class=\"caret\"></b></a>\r\n");
                out.write("\t\t\t\t                      <ul class=\"dropdown-menu\" role=\"menu\">\r\n");
                out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${birtURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("/frameset?__report=Generated_Status.rptdesign&projectID=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" target=\"_blank\">View operations</a>\r\n");
                out.write("\t\t\t\t                        </li>\r\n");
                out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t                        \t<a role=\"menuitem\" tabindex=\"-1\" href=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${birtURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("/run?__pageoverflow=2&__report=Generated_status.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&projectID=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">Download operations</a>\r\n");
                out.write("\t\t\t\t                        </li>\r\n");
                out.write("\t\t\t\t                        <li role=\"presentation\" class=\"divider\"></li>\r\n");
                out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t                       \t\t<!-- Button to trigger modal to edit Person Information -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    \t");
                if (_jspx_meth_c_005fset_005f7(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myEditPersonURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" role=\"button\" data-toggle=\"modal\">Edit</a>\r\n");
                out.write("\t\t\t\t                        </li>\r\n");
                out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t                       \t\t<!-- Button to trigger modal to edit Person Information -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    \t");
                if (_jspx_meth_c_005fset_005f8(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myUpdatePasswordURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" role=\"button\" data-toggle=\"modal\">Change Password</a>\r\n");
                out.write("\t\t\t\t                        </li>\r\n");
                out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t                       \t\t<!-- Button to trigger modal for entering the vacation for the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    \t");
                if (_jspx_meth_c_005fset_005f9(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myOnVacationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" role=\"button\" data-toggle=\"modal\"> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\tVacation leave \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t</a> \r\n");
                out.write("\t\t\t\t                        </li>\r\n");
                out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t                         \t<!-- Button to trigger modal for deactivating the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    \t");
                if (_jspx_meth_c_005fset_005f10(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myDeactivateURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" role=\"button\" data-toggle=\"modal\"> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\tDeactivate \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t</a> \r\n");
                out.write("\t\t\t\t                         </li>\r\n");
                out.write("\t\t\t\t                      </ul>\r\n");
                out.write("\t\t\t\t                    </ul>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Generate the URL with the dSuppOpId -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005furl_005f9(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t    <form method=\"POST\" action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${editPersonURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">\r\n");
                out.write("\t\r\n");
                out.write("\t\t \t\t\t\t\t\t    <!------------------------------------- Modal for editing the current person ------------------------------------------------>\r\n");
                out.write("\t\t\t\t\t\t\t\t    <div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myEditPersonURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        <div class=\"modal-header\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            <a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    <h3 id=\"myModalLabel\"> Edit person </h3>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t      \t<div class=\"modal-body\" style=\"text-align:left;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<table>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Title: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t            \t<input name=\"title\" type=\"text\"  value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Name: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t            \t<input name=\"name\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > First Name: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t            \t<input name=\"firstName\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Function: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t            \t<input name=\"function\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.function}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            \t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Nickname: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t            \t<input name=\"nickname\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.nickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required disabled/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t       \t\t</tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t       \t\t<tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            <td class=\"tdCatalogueType1\"> Start date: </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            <td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            \t<div class=\"input-append date\" id=\"dp3\" data-date=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.startDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" data-date-format=\"dd-mm-yyyy\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"startDate\" class=\"span2\" size=\"16\" type=\"text\" readonly=\"\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.startDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" disabled>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"add-on\"><i class=\"icon-th\"></i></span>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t           \t</td> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Duration: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t            \t<input name=\"duration\" min=\"1\" max=\"200\" type=\"number\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.duration}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        </tr>\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Capacity: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t            \t<input name=\"capacity\" min=\"1\" max=\"200\" type=\"number\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.capacity}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t        </tr>\t\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </table>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        <div class=\"modal-footer\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            <input type=\"submit\" value=\"Save\" class=\"btn btn-primary\" />\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t    </form>\r\n");
                out.write("\t\t\t\t\t\t\t\t    <!------------------------------------- End Modal for editing the current person ------------------------------------------------>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Update Password for Resident -->\r\n");
                out.write("                                    ");
                if (_jspx_meth_c_005furl_005f10(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("                                    <form method=\"POST\" action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${updatePasswordURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"passwordChangeForm\">\r\n");
                out.write("\r\n");
                out.write("                                    <!------------------------------------- Modal  for Updating Password for Resident ------------------------------------------------>\r\n");
                out.write("                                    <div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myUpdatePasswordURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
                out.write("                                         <div class=\"modal-header\"><a class=\"close\" data-dismiss=\"modal\">×</a><h3 id=\"myModalLabel\">Change Password</h3></div>\r\n");
                out.write("                                         <div class=\"modal-body\" style=\"text-align:left;\">\r\n");
                out.write("                                         \t<br/>\r\n");
                out.write("                                         \t<table> \r\n");
                out.write("                                                <tr>\r\n");
                out.write("                                                     <td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("                                                          <label class=\"control-label\" >Current Password: </label>\r\n");
                out.write("                                                     </td>\r\n");
                out.write("                                                     <td style=\"vertical-align:baseline;\">\r\n");
                out.write("                                             \t\t\t\t<div class=\"control-group\">\r\n");
                out.write("                                                     \t\t\t<div class=\"controls\">\r\n");
                out.write("                                                           \t\t<input class=\"curr_password\" name=\"curr_password\" type=\"password\" required/> \r\n");
                out.write("                                                    \t\t\t<input class=\"upid\" name=\"upid\" type=\"hidden\" value = \"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\"/> <!-- Necessary for ajax validation -->\r\n");
                out.write("                                                    \t\t\t<input class=\"pageType\" name=\"pageType\" type=\"hidden\" value = \"residentProgress\"/> <!-- Necessary for ajax validation -->\r\n");
                out.write("                                                    \t\t\t</div>\r\n");
                out.write("                                             \t\t\t\t</div>\r\n");
                out.write("                                           \t\t\t</td>\r\n");
                out.write("                                           \t\t\t<td><span class=\"mappingSuggestionPass miniSugg\" ></span></td> \t\r\n");
                out.write("                                      \t\t\t</tr> \r\n");
                out.write("                                      \t\t\t<tr>\r\n");
                out.write("                                                     <td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("                                                          <label class=\"control-label\" >New Password: </label>\r\n");
                out.write("                                                     </td>\r\n");
                out.write("                                                     <td style=\"vertical-align:baseline;\">\r\n");
                out.write("                                             \t\t\t\t<div class=\"control-group\">\r\n");
                out.write("                                                     \t\t\t<div class=\"controls\">\r\n");
                out.write("                                                           \t\t<input class=\"newPassword\" name=\"newPassword\" type=\"password\" required/> \r\n");
                out.write("                                                    \t\t\t</div>\r\n");
                out.write("                                             \t\t\t\t</div>\r\n");
                out.write("                                            \t\t\t</td>\r\n");
                out.write("                                          \t\t\t<td>&nbsp;</td> \r\n");
                out.write("                                         \t\t</tr>\r\n");
                out.write("                                     \t \t</table>\r\n");
                out.write("                                         </div>\r\n");
                out.write("                                         <div class=\"modal-footer\">\r\n");
                out.write("                                             <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
                out.write("                                             <input type=\"submit\" value=\"Save\" class=\"btn btn-primary\" />\r\n");
                out.write("                                         </div>\r\n");
                out.write("                                    </div>\r\n");
                out.write("                                    </form>\r\n");
                out.write("                                    <!------------------------------------- End Modal for Updating Password for Resident ------------------------------------------------>\r\n");
                out.write("                   \r\n");
                out.write("\t\r\n");
                out.write("\t\r\n");
                out.write("\t\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Deactivate for each project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Generate the URL with the projectID -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005furl_005f11(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<form method=\"POST\" action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeactivateUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">\t\t\t\t\t\t\t\t    \r\n");
                out.write("\t\t\t\t \t\t\t\t\t\t<!-- Modal for deactivating the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myDeactivateURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    \t<a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<h3 id=\"myModalLabel\"> Deactivate </h3>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-body\" style=\"text-align:left;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<p> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tDo you want to deactivate resident\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f9(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f10(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("?\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t   \t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t    </p>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-footer\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <input type=\"submit\" value=\"Deactivate\" class=\"btn btn-primary\" />\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Enter Vacation for each project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Generate the URL with the projectID -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005furl_005f12(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<form method=\"POST\" action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OnVacationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">\t\t\t\t\t\t\t\t    \r\n");
                out.write("\t\t\t\t \t\t\t\t\t\t<!-- Modal for deactivating the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myOnVacationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    \t<a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<h3 id=\"myModalLabel\"> Enter vacation for resident </h3>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-body\" style=\"text-align:left;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<p> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tPlease enter return date from vacation for\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f11(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f12(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(".\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t   \t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t    </p>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"input-append date datepicker\" id=\"dpOnVacation\" data-date='");
                out.print(  pickerFormatter.format(new Date()) );
                out.write("' data-date-format=\"dd-mm-yyyy\" style=\"width:60px\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"untilDate\" class=\"span2\" size=\"16\" type=\"text\" readonly=\"\" value='");
                out.print(  pickerFormatter.format(new Date()) );
                out.write("'>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"add-on\"><i class=\"icon-th\"></i></span>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-footer\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <input type=\"submit\" value=\"Save\" class=\"btn btn-primary\" />\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t      \tStart Date: ");
                if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t      \t<font style=\"padding-left:30px\">Duration:</font> ");
                if (_jspx_meth_c_005fout_005f13(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" months\r\n");
                out.write("\t\t\t\t\t\t\t      \t<font style=\"padding-left:30px\">Capacity:</font> ");
                if (_jspx_meth_c_005fout_005f14(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write(" operations/month \r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t      \t<br>\r\n");
                out.write("\t\t\t\t\t\t\t      \t<br>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t      \t\t\t");
                if (_jspx_meth_c_005fset_005f11(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t      \t\t\t");
                if (_jspx_meth_c_005fset_005f12(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t      \t<table>\r\n");
                out.write("\t\t\t\t\t\t\t\t      <tbody> \r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t      <tr style=\"border-top:2px solid white\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    ");
                if (_jspx_meth_c_005fforEach_005f4(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t   </tr>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t   <tr style=\"border-top:2px solid white\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    ");
                if (_jspx_meth_c_005fforEach_005f5(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t   </tr>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t   </tbody>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fset_005f17(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fset_005f18(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fset_005f19(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_fmt_005fsetLocale_005f0(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\tOverall training progress: <b>");
                if (_jspx_meth_fmt_005fformatNumber_005f0(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("%</b>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fif_005f12(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<i>(expected training progress: ");
                if (_jspx_meth_fmt_005fformatNumber_005f1(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("%)</i>\r\n");
                out.write("\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<br>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<i><b>Performed number of operations:</b></i>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<br>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fforEach_005f6(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t  </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t");
                int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              return;
            }
          } catch (Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
              out = _jspx_page_context.popBody();
            _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
          } finally {
            _jspx_th_c_005fforEach_005f3.doFinally();
            _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
          }
          out.write("\r\n");
          out.write("\t\t\t\t\t</div>\t\t\t\t\t    \r\n");
          out.write("\t              </div>\r\n");
          out.write("\t              \r\n");
          out.write("\t\t\t\t  <!-- counts residents in list  -->\r\n");
          out.write("\t\t\t\t  ");
          if (_jspx_meth_c_005fset_005f21(_jspx_th_c_005fif_005f9, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t  <!-- tab for inactive residents -->\r\n");
          out.write("\t              <div class=\"tab-pane fade\" id=\"inactiveProjects\">\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t<!-- all residents are wrapped in an group that manages which body is visible -->\r\n");
          out.write("\t              \t<div class=\"accordion\" id=\"accordion2\">\r\n");
          out.write("\t              \t\t");
          if (_jspx_meth_c_005fforEach_005f7(_jspx_th_c_005fif_005f9, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\r\n");
          out.write("\t              </div>\r\n");
          out.write("\t            </div>\r\n");
          out.write("\t            \r\n");
          out.write("\t        </div>\r\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f9.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f9);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f9);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f13 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f13.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f13.setParent(null);
      // /WEB-INF/jsp/admin/TrainingProgress.jsp(678,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f13.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userRole == 'ROLE_RESIDENT' }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_005fif_005f13 = _jspx_th_c_005fif_005f13.doStartTag();
      if (_jspx_eval_c_005fif_005f13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \t\r\n");
          out.write("        \t<table  class=\"homepageTable\" style=\"width:100%;\">\r\n");
          out.write("        \t\t<tr>\r\n");
          out.write("        \t\t<td style=\"width:50px;\"></td>\r\n");
          out.write("        \t\t<td style=\"width:1080px;\">\r\n");
          out.write("\t\t    \t\t<legend class=\"legendFont\">Resident Detail</legend>\r\n");
          out.write("\t\t    \t</td>\r\n");
          out.write("\t\t    \t<td class=\"buttonRight\"></td>\r\n");
          out.write("\t\t\t    <td style=\"width:50px;\"></td>\r\n");
          out.write("\t\t    \t</tr>\r\n");
          out.write("\t\t\t</table>\r\n");
          out.write("        \t<div class=\"centeredTableNoTop\" style=\"width:1100px;\">\r\n");
          out.write("\t        \t<!-- counts residents in list  -->\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fset_005f31(_jspx_th_c_005fif_005f13, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t<!-- all residents are wrapped in an group that manages which body is visible -->\r\n");
          out.write("\t\t        ");
          //  c:forEach
          org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f11 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
          _jspx_th_c_005fforEach_005f11.setPageContext(_jspx_page_context);
          _jspx_th_c_005fforEach_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f13);
          // /WEB-INF/jsp/admin/TrainingProgress.jsp(693,10) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_c_005fforEach_005f11.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${thisProject}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
          // /WEB-INF/jsp/admin/TrainingProgress.jsp(693,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
          _jspx_th_c_005fforEach_005f11.setVar("project");
          int[] _jspx_push_body_count_c_005fforEach_005f11 = new int[] { 0 };
          try {
            int _jspx_eval_c_005fforEach_005f11 = _jspx_th_c_005fforEach_005f11.doStartTag();
            if (_jspx_eval_c_005fforEach_005f11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write(" <!-- in this case this loop should run for only once -->\r\n");
                out.write("\t\t\t\t\t  <!-- unique id for each project -->\r\n");
                out.write("\t\t\t\t\t  ");
                if (_jspx_meth_c_005fset_005f32(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t  ");
                if (_jspx_meth_c_005fset_005f33(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t  <script>\r\n");
                out.write("\t\t\t\t\t\t$(document).ready(function() {\r\n");
                out.write("\t\t\t\t\t       \t//$('#forRoleResident').on('click', function(event) {        \t\r\n");
                out.write("\t\t\t\t\t       \t\t$('#forRoleResident .progress .bar.text-centered-1').progressbar({\r\n");
                out.write("\t\t\t\t\t       \t\t\tupdate: function(current_percentage) { $('#v-callback-update-1').text(current_percentage); },\r\n");
                out.write("\t\t\t\t\t       \t\t\tdone: function(current_percentage) { $('#v-callback-done-1').text('done!'); },\r\n");
                out.write("\t\t\t\t\t       \t\t\tdisplay_text: 2\r\n");
                out.write("\t\t\t\t\t       \t\t\t}); \r\n");
                out.write("\t\t\t\t\t       \t//}); \r\n");
                out.write("\t\t\t\t\t \t});\r\n");
                out.write("\t\t\t\t\t  </script>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t  <div class=\"singleProject\">\r\n");
                out.write("\t\t\t\t\t      \t");
                if (_jspx_meth_c_005fif_005f14(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t \tName: <b style=\"font-size:16px;\"> ");
                if (_jspx_meth_c_005fout_005f35(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(" </b>\r\n");
                out.write("\t\t\t\t\t       \t<font style=\"padding-left:30px;\">First Name:</font> <b style=\"font-size:16px;\"> ");
                if (_jspx_meth_c_005fout_005f36(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(" </b>\r\n");
                out.write("\t\t\t\t\t\t\t<font style=\"padding-left:30px;\">Nickname: <b style=\"font-size:16px;\">");
                if (_jspx_meth_c_005fout_005f37(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("</b></font>\r\n");
                out.write("\t\t\t\t\t\t\t<ul class=\"dropdown nav pull-right\" style=\"text-align: left;\">\r\n");
                out.write("\t\t\t\t\t                   <a href=\"#\" id=\"drop3\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Manage<b class=\"caret\"></b></a>\r\n");
                out.write("\t\t\t\t\t                   <ul class=\"dropdown-menu\" role=\"menu\">\r\n");
                out.write("\t\t\t\t\t                     <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${birtURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("/frameset?__report=Generated_Status.rptdesign&projectID=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" target=\"_blank\">View operations</a>\r\n");
                out.write("\t\t\t\t\t                     </li>\r\n");
                out.write("\t\t\t\t\t                     <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t\t                     \t<a role=\"menuitem\" tabindex=\"-1\" href=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${birtURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("/run?__pageoverflow=2&__report=Generated_status.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&projectID=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">Download operations</a>\r\n");
                out.write("\t\t\t\t\t                     </li>\r\n");
                out.write("\t\t\t\t\t                     <li role=\"presentation\" class=\"divider\"></li>\r\n");
                out.write("\t\t\t\t\t                     <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t\t                    \t\t<!-- Button to trigger modal to edit Person Information -->\r\n");
                out.write("\t\t\t\t\t\t\t    \t");
                if (_jspx_meth_c_005fset_005f34(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myEditPersonURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" role=\"button\" data-toggle=\"modal\">Edit</a>\r\n");
                out.write("\t\t\t\t\t                     </li>\r\n");
                out.write("\t\t\t\t\t                     <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t\t                    \t\t<!-- Button to trigger modal for entering the vacation for the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t    \t");
                if (_jspx_meth_c_005fset_005f35(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myOnVacationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" role=\"button\" data-toggle=\"modal\"> \r\n");
                out.write("\t\t\t\t\t\t\t\t\tVacation leave \r\n");
                out.write("\t\t\t\t\t\t\t\t\t</a> \r\n");
                out.write("\t\t\t\t\t                     </li>\r\n");
                out.write("\t\t\t\t\t                     <li role=\"presentation\">\r\n");
                out.write("\t\t\t\t\t                      \t<!-- Button to trigger modal for deactivating the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t    \t");
                if (_jspx_meth_c_005fset_005f36(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myDeactivateURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" role=\"button\" data-toggle=\"modal\"> \r\n");
                out.write("\t\t\t\t\t\t\t\t\tDeactivate \r\n");
                out.write("\t\t\t\t\t\t\t\t\t</a> \r\n");
                out.write("\t\t\t\t\t                      </li>\r\n");
                out.write("\t\t\t\t\t                   </ul>\r\n");
                out.write("\t\t\t\t\t                 </ul>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t<!-- Generate the URL with the dSuppOpId -->\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005furl_005f14(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t    <form method=\"POST\" action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${editPersonURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t    <!------------------------------------- Modal for editing the current person ------------------------------------------------>\r\n");
                out.write("\t\t\t\t\t\t    <div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myEditPersonURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
                out.write("\t\t\t\t\t\t\t        <div class=\"modal-header\">\r\n");
                out.write("\t\t\t\t\t\t\t            <a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    <h3 id=\"myModalLabel\"> Edit person </h3>\r\n");
                out.write("\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t\t      \t<div class=\"modal-body\" style=\"text-align:left;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<table>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Title: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<input name=\"title\" type=\"text\"  value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Name: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<input name=\"name\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t            </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t            <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t            \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > First Name: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<input name=\"firstName\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Function: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<input name=\"function\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.function}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t            \t\t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Nickname: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<input name=\"nickname\" type=\"text\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.nickname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required disabled/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t       \t\t</tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t       \t\t<tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            <td class=\"tdCatalogueType1\"> Start date: </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            <td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            \t<div class=\"input-append date\" id=\"dp3\" data-date=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.startDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" data-date-format=\"dd-mm-yyyy\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"startDate\" class=\"span2\" size=\"16\" type=\"text\" readonly=\"\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.startDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" disabled>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"add-on\"><i class=\"icon-th\"></i></span>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t           \t</td> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Duration: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<input name=\"duration\" min=\"1\" max=\"200\" type=\"number\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.duration}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </tr>\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        <tr>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        \t<td class=\"tdCatalogueType1\" style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label\" > Capacity: </label>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"vertical-align:baseline;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              <div class=\"control-group\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              \t<div class=\"controls\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t            \t<input name=\"capacity\" min=\"1\" max=\"200\" type=\"number\" value=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.capacity}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" required/> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t             \t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t              </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t            </td>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t        </tr>\t\t\r\n");
                out.write("\t\t\t\t\t\t\t            </table>\r\n");
                out.write("\t\t\t\t\t\t\t        </div>\r\n");
                out.write("\t\t\t\t\t\t\t        <div class=\"modal-footer\">\r\n");
                out.write("\t\t\t\t\t\t\t            <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
                out.write("\t\t\t\t\t\t\t            <input type=\"submit\" value=\"Save\" class=\"btn btn-primary\" />\r\n");
                out.write("\t\t\t\t\t\t\t        </div>\r\n");
                out.write("\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t    </form>\r\n");
                out.write("\t\t\t\t\t\t    <!------------------------------------- End Modal for editing the current person ------------------------------------------------>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t<!-- Deactivate for each project -->\r\n");
                out.write("\t\t\t\t\t\t\t<!-- Generate the URL with the projectID -->\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005furl_005f15(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t<form method=\"POST\" action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeactivateUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">\t\t\t\t\t\t\t\t    \r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Modal for deactivating the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t<div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myDeactivateURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    \t<a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<h3 id=\"myModalLabel\"> Deactivate </h3>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    <div class=\"modal-body\" style=\"text-align:left;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<p> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\tDo you want to deactivate resident\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f38(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(" \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f39(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("?\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t   \t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    </p>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    <div class=\"modal-footer\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    <input type=\"submit\" value=\"Deactivate\" class=\"btn btn-primary\" />\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t</form>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t<!-- Enter Vacation for each project -->\r\n");
                out.write("\t\t\t\t\t\t\t<!-- Generate the URL with the projectID -->\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005furl_005f16(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t<form method=\"POST\" action=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OnVacationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\">\t\t\t\t\t\t\t\t    \r\n");
                out.write("\t\t\t\t\t\t\t\t\t<!-- Modal for deactivating the current project -->\r\n");
                out.write("\t\t\t\t\t\t\t\t<div id=\"");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myOnVacationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    \t<a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<h3 id=\"myModalLabel\"> Enter vacation for resident </h3>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    <div class=\"modal-body\" style=\"text-align:left;\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t<p> \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\tPlease enter return date from vacation for\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f40(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(" \r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fout_005f41(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(".\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t   \t<br/>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    </p>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    <div class=\"input-append date datepicker\" id=\"dpOnVacation\" data-date='");
                out.print(  pickerFormatter.format(new Date()) );
                out.write("' data-date-format=\"dd-mm-yyyy\" style=\"width:60px\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"untilDate\" class=\"span2\" size=\"16\" type=\"text\" readonly=\"\" value='");
                out.print(  pickerFormatter.format(new Date()) );
                out.write("'>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"add-on\"><i class=\"icon-th\"></i></span>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    <div class=\"modal-footer\">\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
                out.write("\t\t\t\t\t\t\t\t\t\t    <input type=\"submit\" value=\"Save\" class=\"btn btn-primary\" />\r\n");
                out.write("\t\t\t\t\t\t\t\t\t    </div>\r\n");
                out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t\t\t</form>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t      \tStart Date: ");
                if (_jspx_meth_fmt_005fformatDate_005f3(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t      \t<font style=\"padding-left:30px\">Duration:</font> ");
                if (_jspx_meth_c_005fout_005f42(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(" months\r\n");
                out.write("\t\t\t\t\t      \t<font style=\"padding-left:30px\">Capacity:</font> ");
                if (_jspx_meth_c_005fout_005f43(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(" operations/month \r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t      \t<br>\r\n");
                out.write("\t\t\t\t\t      \t<br>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t    \t\t\t");
                if (_jspx_meth_c_005fset_005f37(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t    \t\t\t");
                if (_jspx_meth_c_005fset_005f38(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t      \t<table id=\"forRoleResident\">\r\n");
                out.write("\t\t\t\t\t\t      <tbody> \r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t      <tr style=\"border-top:2px solid white\">\r\n");
                out.write("\t\t\t\t\t\t\t\t    ");
                if (_jspx_meth_c_005fforEach_005f12(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t   </tr>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t\t   <tr style=\"border-top:2px solid white\">\r\n");
                out.write("\t\t\t\t\t\t\t\t    ");
                if (_jspx_meth_c_005fforEach_005f13(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t\t   </tr>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t   </tbody>\r\n");
                out.write("\t\t\t\t\t\t\t</table>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fset_005f43(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fset_005f44(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fset_005f45(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_fmt_005fsetLocale_005f2(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\tOverall training progress: <b>");
                if (_jspx_meth_fmt_005fformatNumber_005f3(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("%</b>\r\n");
                out.write("\t\t\t\t\t\t\t");
                if (_jspx_meth_c_005fif_005f15(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t<i>(expected training progress: ");
                if (_jspx_meth_fmt_005fformatNumber_005f4(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("%)</i>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t\t\t\t<div>\r\n");
                out.write("\t\t\t\t\t\t\t\t<br>\r\n");
                out.write("\t\t\t\t\t\t\t\t<i><b>Performed number of operations:</b></i>\r\n");
                out.write("\t\t\t\t\t\t\t\t<br>\r\n");
                out.write("\t\t\t\t\t\t\t\t ");
                if (_jspx_meth_c_005fforEach_005f14(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write("\r\n");
                out.write("\t\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t<br /><br />\r\n");
                out.write("\t\t\t\t\t<legend>Difficult Operations</legend>\r\n");
                out.write("\t\t\t\t\t<br />\r\n");
                out.write("\t\t\t\t\t<table class=\"table table-hover\" style=\"width:100%;\">\r\n");
                out.write("\t\t\t\t\t\t<thead>\r\n");
                out.write("\t\t\t\t\t\t<tr>\r\n");
                out.write("\t\t\t\t\t\t\t<!-- th>ID</th -->\r\n");
                out.write("\t\t\t\t\t\t\t<th>Operation Date</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>OPSC01</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>OPSC02</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>Op1</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>Op2</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>Assistant</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>Operated As</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>Credit as Difficult</th>\r\n");
                out.write("\t\t\t\t\t\t\t<th>&nbsp;</th>\r\n");
                out.write("\t\t\t\t\t\t</tr>\r\n");
                out.write("\t\t\t\t\t\t</thead>\r\n");
                out.write("\t\t\t\t\t\t<tbody>\r\n");
                out.write("\t\t\t\t\t\t");
                if (_jspx_meth_c_005fforEach_005f15(_jspx_th_c_005fforEach_005f11, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
                  return;
                out.write(" \r\n");
                out.write("\t\t\t\t\t\t</tbody>\r\n");
                out.write("\t\t\t\t\t</table>\r\n");
                out.write("\t\t\t\t\t\r\n");
                out.write("\t\t\t\t");
                int evalDoAfterBody = _jspx_th_c_005fforEach_005f11.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fforEach_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              return;
            }
          } catch (Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_005fforEach_005f11[0]-- > 0)
              out = _jspx_page_context.popBody();
            _jspx_th_c_005fforEach_005f11.doCatch(_jspx_exception);
          } finally {
            _jspx_th_c_005fforEach_005f11.doFinally();
            _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f11);
          }
          out.write("\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f13.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f13);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f13);
      out.write("\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/common/footer.jspf", out, false);
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style = \"height:30px\"></div>\r\n");
      out.write("\t<!-- Modal for updating the Difficult operation -->\r\n");
      out.write("\t<div id=\"diffChangeModal\" class=\"modal hide fade\"\r\n");
      out.write("\t\ttabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"\r\n");
      out.write("\t\taria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t<a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
      out.write("\t\t\t<h3 id=\"myModalLabel\">Delete</h3>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"modal-body\" style=\"text-align: left;\">\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\tAre you sure you want to credit this operation as Difficult? <br>\r\n");
      out.write("\t\t\t\t<span style=\"color: rgb(170, 0, 0);\"><b>You cannot undo this change.</b></span><br>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"btn\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\taria-hidden=\"true\">Cancel</a> <input type=\"button\" id=\"yesChange\"\r\n");
      out.write("\t\t\t\tvalue=\"Count as Difficult\" class=\"btn btn-primary\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(14,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/styles/body.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(26,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/scheduler/resources/js/jqBootstrapValidation.js");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(27,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/scheduler/resources/js/training.progress.js");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(29,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/scheduler/resources/js/specialty.js");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(30,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/scheduler/resources/js/jquery.cookie.js");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(32,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/scheduler/resources/js/admin.usrmngement.js");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(102,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("headerGoSchedule");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(102,2) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new String("../schedule/view"));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(102,2) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setScope("session");
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(103,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("headerViewAdministration");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(103,2) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new String("../administration/home"));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(103,2) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setScope("session");
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(104,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("headerModule");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(104,2) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new String("Residents and training progress"));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fremove_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_005fremove_005f0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_005fremove_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fremove_005f0.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(106,2) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fremove_005f0.setVar("headerViewSchedule");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(106,2) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fremove_005f0.setScope("session");
    int _jspx_eval_c_005fremove_005f0 = _jspx_th_c_005fremove_005f0.doStartTag();
    if (_jspx_th_c_005fremove_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.reuse(_jspx_th_c_005fremove_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.reuse(_jspx_th_c_005fremove_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fremove_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_005fremove_005f1 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_005fremove_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fremove_005f1.setParent(null);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(107,2) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fremove_005f1.setVar("headerGoAdministration");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(107,2) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fremove_005f1.setScope("session");
    int _jspx_eval_c_005fremove_005f1 = _jspx_th_c_005fremove_005f1.doStartTag();
    if (_jspx_th_c_005fremove_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.reuse(_jspx_th_c_005fremove_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fscope_005fnobody.reuse(_jspx_th_c_005fremove_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/common/header.jspf(3,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerImage == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t<img align=\"left\" src = \"../resources/images/header.png\"/>\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsp/common/header.jspf(6,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerImage != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t<img align=\"left\" src = \"../../resources/images/header.png\"/>\t\t\t\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/jsp/common/header.jspf(11,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${specialties != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\tSpecialization\n");
        out.write("\t\t\t\t\t<select id=\"chosenSpecialty\" name=\"chosenSpecialty\">\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("\t\t\t     \t</select> \n");
        out.write("\t\t     \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /WEB-INF/jsp/common/header.jspf(14,6) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${specialties}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/common/header.jspf(14,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("specialty");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("  \n");
          out.write("\t\t\t\t            <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${specialty.specialtyID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</option>  \n");
          out.write("\t\t\t\t     \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/jsp/common/header.jspf(15,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${specialty.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/jsp/common/header.jspf(24,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerViewAdministration != null or headerViewSchedule != null \n						or headerGoAdministration != null or headerGoSchedule != null \n						or headerModule != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\n");
        out.write("\t\t\t<div class=\"navbar navbarCustomization\" style=\"width:1100px;\">\n");
        out.write("\t\t\t    <div class=\"navbar-inner\">\n");
        out.write("\t\t\t    \t");
        if (_jspx_meth_c_005fif_005f4(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t   \t \t");
        if (_jspx_meth_c_005fif_005f5(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t    \t\n");
        out.write("\t\t\t    \t");
        if (_jspx_meth_c_005fif_005f6(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t   \n");
        out.write("\t\t\t\t    <ul class=\"nav\" style=\"float:right;\">\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f7(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t   \t\n");
        out.write("\t\t\t\t\t   \t");
        if (_jspx_meth_c_005fif_005f8(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t   \t");
        if (_jspx_meth_sec_005fauthorize_005f0(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t   \t");
        if (_jspx_meth_sec_005fauthorize_005f1(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t\t\t\n");
        out.write("\t\t\t\t\t\t\n");
        out.write("\t\t\t\t    </ul>\n");
        out.write("\t\t\t    </div>\n");
        out.write("\t\t    </div>\n");
        out.write("\t\t    \n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/common/header.jspf(30,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerViewAdministration != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t   \t \t\t<a id=\"smaller\" class=\"brand\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerViewAdministration}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">Administration</a>\n");
        out.write("\t\t\t   \t \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/common/header.jspf(33,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerViewSchedule != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
    if (_jspx_eval_c_005fif_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\t\n");
        out.write("\t\t\t    \t\t<a id=\"smaller\" class=\"brand\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerViewSchedule}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">Schedule View</a>\n");
        out.write("\t\t\t    \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/common/header.jspf(37,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerModule != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f6 = _jspx_th_c_005fif_005f6.doStartTag();
    if (_jspx_eval_c_005fif_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t    \t\t<a id=\"smaller\" class=\"brand\">></a>\n");
        out.write("\t\t\t    \t\t<a id=\"smaller\" class=\"brand\" href=\"\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerModule}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</a>\n");
        out.write("\t\t\t    \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/common/header.jspf(43,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerGoAdministration != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f7 = _jspx_th_c_005fif_005f7.doStartTag();
    if (_jspx_eval_c_005fif_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t   \t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerGoAdministration}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">Go to administration view</a></li>\n");
        out.write("\t\t\t\t\t   \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/common/header.jspf(47,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerGoSchedule != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f8 = _jspx_th_c_005fif_005f8.doStartTag();
    if (_jspx_eval_c_005fif_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("   \t\t\t\t\t   \t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${headerGoSchedule}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">Go to schedule view</a></li>\n");
        out.write("\t\t\t\t\t   \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f8);
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.AuthorizeTag _jspx_th_sec_005fauthorize_005f0 = (org.springframework.security.taglibs.authz.AuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifNotGranted.get(org.springframework.security.taglibs.authz.AuthorizeTag.class);
    _jspx_th_sec_005fauthorize_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthorize_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/common/header.jspf(50,9) name = ifNotGranted type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthorize_005f0.setIfNotGranted("ROLE_ADMIN,ROLE_RESIDENT,ROLE_INSTRUCTOR");
    int _jspx_eval_sec_005fauthorize_005f0 = _jspx_th_sec_005fauthorize_005f0.doStartTag();
    if (_jspx_eval_sec_005fauthorize_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t   \t\t<li><a href=\"");
        if (_jspx_meth_c_005furl_005f6(_jspx_th_sec_005fauthorize_005f0, _jspx_page_context))
          return true;
        out.write("\">Login</li> \n");
        out.write("\t\t\t\t\t   \t");
        int evalDoAfterBody = _jspx_th_sec_005fauthorize_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_sec_005fauthorize_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifNotGranted.reuse(_jspx_th_sec_005fauthorize_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifNotGranted.reuse(_jspx_th_sec_005fauthorize_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_sec_005fauthorize_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sec_005fauthorize_005f0);
    // /WEB-INF/jsp/common/header.jspf(51,23) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/scheduler/login");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.AuthorizeTag _jspx_th_sec_005fauthorize_005f1 = (org.springframework.security.taglibs.authz.AuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifAnyGranted.get(org.springframework.security.taglibs.authz.AuthorizeTag.class);
    _jspx_th_sec_005fauthorize_005f1.setPageContext(_jspx_page_context);
    _jspx_th_sec_005fauthorize_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/jsp/common/header.jspf(53,9) name = ifAnyGranted type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sec_005fauthorize_005f1.setIfAnyGranted("ROLE_ADMIN,ROLE_RESIDENT,ROLE_INSTRUCTOR");
    int _jspx_eval_sec_005fauthorize_005f1 = _jspx_th_sec_005fauthorize_005f1.doStartTag();
    if (_jspx_eval_sec_005fauthorize_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t   \t\t");
        if (_jspx_meth_c_005furl_005f7(_jspx_th_sec_005fauthorize_005f1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t   \t\t<li><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logOutUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">Logout</a></li>\n");
        out.write("\t\t\t\t\t   \t");
        int evalDoAfterBody = _jspx_th_sec_005fauthorize_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_sec_005fauthorize_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifAnyGranted.reuse(_jspx_th_sec_005fauthorize_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005fifAnyGranted.reuse(_jspx_th_sec_005fauthorize_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_sec_005fauthorize_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sec_005fauthorize_005f1);
    // /WEB-INF/jsp/common/header.jspf(54,10) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/j_spring_security_logout");
    // /WEB-INF/jsp/common/header.jspf(54,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setVar("logOutUrl");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f9);
    // /WEB-INF/jsp/admin/AddResident.jspf(13,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setVar("addUrl");
    // /WEB-INF/jsp/admin/AddResident.jspf(13,5) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setValue("../administration/progress/add");
    int _jspx_eval_c_005furl_005f8 = _jspx_th_c_005furl_005f8.doStartTag();
    if (_jspx_th_c_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f9);
    // /WEB-INF/jsp/admin/AddResident.jspf(96,43) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${specIality}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/AddResident.jspf(96,43) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("speciality");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("  \n");
          out.write("\t\t\t\t\t                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${speciality.specialtyID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t                                             ");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("</option>\n");
          out.write("\t\t\t\t\t                                        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /WEB-INF/jsp/admin/AddResident.jspf(98,50) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${speciality.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f9);
    // /WEB-INF/jsp/admin/AddResident.jspf(113,43) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${trainSystems}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/AddResident.jspf(113,43) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("trainSystem");
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("  \n");
          out.write("\t\t\t\t\t                                        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${trainSystem.train_system_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("\t\t\t\t\t                                             ");
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f2))
            return true;
          out.write("</option>\n");
          out.write("\t\t\t\t\t                                        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f2);
    // /WEB-INF/jsp/admin/AddResident.jspf(115,50) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${trainSystem.train_system_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f9);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(119,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setVar("count");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(119,3) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(140,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setVar("collapseResident");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(140,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("collapseResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f4 = _jspx_th_c_005fset_005f4.doStartTag();
    if (_jspx_th_c_005fset_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(141,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setVar("generateProgress");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(141,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("generateProgress${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f5 = _jspx_th_c_005fset_005f5.doStartTag();
    if (_jspx_th_c_005fset_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f6 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(155,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setVar("count");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(155,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${count + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f6 = _jspx_th_c_005fset_005f6.doStartTag();
    if (_jspx_th_c_005fset_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(156,10) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(157,10) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(158,16) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(159,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value[0].overdue}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f10 = _jspx_th_c_005fif_005f10.doStartTag();
    if (_jspx_eval_c_005fif_005f10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t        <span class=\"badge badge-important\">!</span>\r\n");
        out.write("\t\t\t\t\t\t\t\t        ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(168,14) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value[0].overdue}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f11 = _jspx_th_c_005fif_005f11.doStartTag();
    if (_jspx_eval_c_005fif_005f11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t      \t<div class=\"alert alert-error\t\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t  <strong>Warning!</strong>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t   Training duration is not accurate, decision support cannot be provided for this resident.\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t   Please change the duration or deactivate the resident.\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(176,44) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(177,95) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(178,79) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.nickname}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f8 = _jspx_th_c_005fout_005f8.doStartTag();
    if (_jspx_th_c_005fout_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f7 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(191,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setVar("myEditPersonURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(191,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("editPerson${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f7 = _jspx_th_c_005fset_005f7.doStartTag();
    if (_jspx_th_c_005fset_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f8 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(196,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f8.setVar("myUpdatePasswordURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(196,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("changePassPerson${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f8 = _jspx_th_c_005fset_005f8.doStartTag();
    if (_jspx_th_c_005fset_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f9 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(201,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f9.setVar("myOnVacationUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(201,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("onVacationResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f9 = _jspx_th_c_005fset_005f9.doStartTag();
    if (_jspx_th_c_005fset_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f10 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(208,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f10.setVar("myDeactivateURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(208,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("deactivateResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f10 = _jspx_th_c_005fset_005f10.doStartTag();
    if (_jspx_th_c_005fset_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(217,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f9.setVar("editPersonURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(217,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f9.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/progress/editPersonInformation?id=${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f9 = _jspx_th_c_005furl_005f9.doStartTag();
    if (_jspx_th_c_005furl_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(335,36) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f10.setVar("updatePasswordURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(335,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f10.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/crud/updatePassword?id=${project.key.project.projectID}&fromPage=residentProgress", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f10 = _jspx_th_c_005furl_005f10.doStartTag();
    if (_jspx_th_c_005furl_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f11 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(388,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f11.setVar("DeactivateUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(388,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f11.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/progress/deactivate?id=${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f11 = _jspx_th_c_005furl_005f11.doStartTag();
    if (_jspx_th_c_005furl_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(401,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f9 = _jspx_th_c_005fout_005f9.doStartTag();
    if (_jspx_th_c_005fout_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(402,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f10 = _jspx_th_c_005fout_005f10.doStartTag();
    if (_jspx_th_c_005fout_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f12 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(416,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f12.setVar("OnVacationUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(416,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f12.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/progress/onVacation?id=${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f12 = _jspx_th_c_005furl_005f12.doStartTag();
    if (_jspx_th_c_005furl_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f11 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(429,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f11.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f11 = _jspx_th_c_005fout_005f11.doStartTag();
    if (_jspx_th_c_005fout_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f12 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(430,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f12.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f12 = _jspx_th_c_005fout_005f12.doStartTag();
    if (_jspx_th_c_005fout_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f12);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(446,26) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("dd.MM.yyyy");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(446,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.startDate}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f13 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(447,63) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f13.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.duration}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f13 = _jspx_th_c_005fout_005f13.doStartTag();
    if (_jspx_th_c_005fout_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f14 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(448,63) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f14.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.capacity}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f14 = _jspx_th_c_005fout_005f14.doStartTag();
    if (_jspx_th_c_005fout_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f11 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(453,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f11.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(453,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f11.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f11 = _jspx_th_c_005fset_005f11.doStartTag();
    if (_jspx_th_c_005fset_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f12 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(454,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f12.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(454,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f12.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f12 = _jspx_th_c_005fset_005f12.doStartTag();
    if (_jspx_th_c_005fset_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(459,14) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(459,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVar("items");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(459,14) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setBegin(0);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(459,14) name = step type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setStep(2);
    int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
      if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t      <td style = \"padding-right:15px\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f15(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write("\r\n");
          out.write("\t\t\t   \t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f13(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f14(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t        <div class=\"progress horizontal wide\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"myProgress\" class=\"bar text-centered-1\" data-percentage=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f4.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.reuse(_jspx_th_c_005fforEach_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f15 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(461,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f15.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f15 = _jspx_th_c_005fout_005f15.doStartTag();
    if (_jspx_th_c_005fout_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f13 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(462,21) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f13.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(462,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f13.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs + totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f13 = _jspx_th_c_005fset_005f13.doStartTag();
    if (_jspx_th_c_005fset_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f14 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(463,18) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f14.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(463,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f14.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentShouldBe + expectedProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f14 = _jspx_th_c_005fset_005f14.doStartTag();
    if (_jspx_th_c_005fset_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(473,14) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(473,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setVar("items");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(473,14) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setBegin(1);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(473,14) name = step type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setStep(2);
    int[] _jspx_push_body_count_c_005fforEach_005f5 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f5 = _jspx_th_c_005fforEach_005f5.doStartTag();
      if (_jspx_eval_c_005fforEach_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t      <td style = \"padding-right:15px\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f16(_jspx_th_c_005fforEach_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f5))
            return true;
          out.write("\r\n");
          out.write("\t\t\t   \t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f15(_jspx_th_c_005fforEach_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f5))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f16(_jspx_th_c_005fforEach_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f5))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t        <div class=\"progress horizontal wide\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"myProgress\" class=\"bar text-centered-1\" data-percentage=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f5.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.reuse(_jspx_th_c_005fforEach_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f16 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f16.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(475,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f16.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f16 = _jspx_th_c_005fout_005f16.doStartTag();
    if (_jspx_th_c_005fout_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f15 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(476,21) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f15.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(476,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f15.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs + totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f15 = _jspx_th_c_005fset_005f15.doStartTag();
    if (_jspx_th_c_005fset_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f16 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f16.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(477,18) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f16.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(477,18) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f16.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentShouldBe + expectedProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f16 = _jspx_th_c_005fset_005f16.doStartTag();
    if (_jspx_th_c_005fset_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f17 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f17.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(489,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f17.setVar("nrOfCatalogs");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(489,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f17.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:length(project.value)}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
    int _jspx_eval_c_005fset_005f17 = _jspx_th_c_005fset_005f17.doStartTag();
    if (_jspx_th_c_005fset_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f18 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f18.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(490,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f18.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(490,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f18.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalProgressPercent / nrOfCatalogs}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f18 = _jspx_th_c_005fset_005f18.doStartTag();
    if (_jspx_th_c_005fset_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f18);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f19 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f19.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(491,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f19.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(491,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f19.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${expectedProgressPercent / nrOfCatalogs}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f19 = _jspx_th_c_005fset_005f19.doStartTag();
    if (_jspx_th_c_005fset_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f19);
    return false;
  }

  private boolean _jspx_meth_fmt_005fsetLocale_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_005fsetLocale_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_005fsetLocale_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fsetLocale_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(492,9) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fsetLocale_005f0.setValue(new String("en_US"));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(492,9) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fsetLocale_005f0.setScope("session");
    int _jspx_eval_fmt_005fsetLocale_005f0 = _jspx_th_fmt_005fsetLocale_005f0.doStartTag();
    if (_jspx_th_fmt_005fsetLocale_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(493,39) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(493,39) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setPattern("0.0");
    int _jspx_eval_fmt_005fformatNumber_005f0 = _jspx_th_fmt_005fformatNumber_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f12 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(494,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${expectedProgressPercent > 100 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f12 = _jspx_th_c_005fif_005f12.doStartTag();
    if (_jspx_eval_c_005fif_005f12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f20(_jspx_th_c_005fif_005f12, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f12, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f20 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f20.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f12);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(495,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f20.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(495,10) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f20.setValue(new String("100"));
    int _jspx_eval_c_005fset_005f20 = _jspx_th_c_005fset_005f20.doStartTag();
    if (_jspx_th_c_005fset_005f20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f20);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f20);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(497,41) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${expectedProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(497,41) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f1.setPattern("0.0");
    int _jspx_eval_fmt_005fformatNumber_005f1 = _jspx_th_fmt_005fformatNumber_005f1.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f6 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(503,11) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f6.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(503,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f6.setVar("items");
    int[] _jspx_push_body_count_c_005fforEach_005f6 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f6 = _jspx_th_c_005fforEach_005f6.doStartTag();
      if (_jspx_eval_c_005fforEach_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t \t");
          if (_jspx_meth_c_005fout_005f17(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
            return true;
          out.write(':');
          out.write(' ');
          if (_jspx_meth_c_005fout_005f18(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
            return true;
          out.write(" \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t \t / ");
          if (_jspx_meth_c_005fout_005f19(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
            return true;
          out.write(" <br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f6.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f6);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f17 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f17.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(504,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f17.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f17 = _jspx_th_c_005fout_005f17.doStartTag();
    if (_jspx_th_c_005fout_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f18 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f18.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(504,54) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f18.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.completedOpNumber}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f18 = _jspx_th_c_005fout_005f18.doStartTag();
    if (_jspx_th_c_005fout_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f18);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f19 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f19.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(505,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f19.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.totalOpNumber}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f19 = _jspx_th_c_005fout_005f19.doStartTag();
    if (_jspx_th_c_005fout_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f19);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f21 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f21.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f9);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(516,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f21.setVar("count");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(516,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f21.setValue(new String("1000"));
    int _jspx_eval_c_005fset_005f21 = _jspx_th_c_005fset_005f21.doStartTag();
    if (_jspx_th_c_005fset_005f21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f21);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f21);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f7 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f9);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(522,17) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f7.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inactiveProjects}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(522,17) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f7.setVar("project");
    int[] _jspx_push_body_count_c_005fforEach_005f7 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f7 = _jspx_th_c_005fforEach_005f7.doStartTag();
      if (_jspx_eval_c_005fforEach_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("              \t\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"accordion-group\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"accordion-heading\">\r\n");
          out.write("\t\t\t\t\t\t\t\t   <!-- unique id for each project -->\r\n");
          out.write("\t\t\t\t\t\t\t\t   ");
          if (_jspx_meth_c_005fset_005f22(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t   ");
          if (_jspx_meth_c_005fset_005f23(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t   <script>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t$(document).ready(function() {\r\n");
          out.write("\t\t\t\t\t\t\t\t\t       \t$('#");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${generateProgress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("').on('click', function(event) {        \t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t       \t\t$('#");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${collapseResident}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(" .progress .bar.text-centered-1').progressbar({\r\n");
          out.write("\t\t\t\t\t\t\t\t\t       \t\t\tupdate: function(current_percentage) { $('#v-callback-update-1').text(current_percentage); },\r\n");
          out.write("\t\t\t\t\t\t\t\t\t       \t\t\tdone: function(current_percentage) { $('#v-callback-done-1').text('done!'); },\r\n");
          out.write("\t\t\t\t\t\t\t\t\t       \t\t\tdisplay_text: 2\r\n");
          out.write("\t\t\t\t\t\t\t\t\t       \t\t\t}); \r\n");
          out.write("\t\t\t\t\t\t\t\t\t       \t}); \r\n");
          out.write("\t\t\t\t\t\t\t\t\t  });\r\n");
          out.write("\t\t\t\t\t\t\t\t   </script>\r\n");
          out.write("\t\t\t\t\t\t\t       <a id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${generateProgress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"accordion-toggle\" data-toggle=\"collapse\" data-parent=\"#accordion2\" href=\"#");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${collapseResident}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t        \t");
          if (_jspx_meth_c_005fset_005f24(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f20(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(". \r\n");
          out.write("\t\t\t\t\t\t\t\t\t \t");
          if (_jspx_meth_c_005fout_005f21(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" \r\n");
          out.write("\t\t\t\t\t\t\t        \t");
          if (_jspx_meth_c_005fout_005f22(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" \r\n");
          out.write("\t\t\t\t\t\t\t        \t");
          if (_jspx_meth_c_005fchoose_005f0(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t    </a>\r\n");
          out.write("\t\t\t\t\t\t\t    </div>\r\n");
          out.write("\t\t\t\t\t\t\t    <div id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${collapseResident}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"accordion-body collapse\">\r\n");
          out.write("\t\t\t\t\t\t\t      <div class=\"accordion-inner\">\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t \tName: <b style=\"font-size:16px;\"> ");
          if (_jspx_meth_c_005fout_005f23(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" </b>\r\n");
          out.write("\t\t\t\t\t\t\t       \t<font style=\"padding-left:30px;\">First Name:</font> <b style=\"font-size:16px;\"> ");
          if (_jspx_meth_c_005fout_005f24(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" </b>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<font style=\"padding-left:30px;\">Nickname: <b style=\"font-size:16px;\">");
          if (_jspx_meth_c_005fout_005f25(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("</b></font>\r\n");
          out.write("\t\t\t\t\t\t\t  \t\t<ul class=\"dropdown nav pull-right\" style=\"text-align: left;\">\r\n");
          out.write("\t\t\t\t                      <a href=\"#\" id=\"drop3\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Manage<b class=\"caret\"></b></a>\r\n");
          out.write("\t\t\t\t                      <ul class=\"dropdown-menu\" role=\"menu\">\r\n");
          out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${birtURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("/frameset?__report=Generated_Status.rptdesign&projectID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" target=\"_blank\">View operations</a>\r\n");
          out.write("\t\t\t\t                        </li>\r\n");
          out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
          out.write("\t\t\t\t                        \t<a role=\"menuitem\" tabindex=\"-1\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${birtURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("/run?__pageoverflow=2&__report=Generated_status.rptdesign&__masterpage=true&__format=xls&__parameterpage=false&projectID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">Download operations</a>\r\n");
          out.write("\t\t\t\t                        </li>\r\n");
          out.write("\t\t\t\t                        <li role=\"presentation\" class=\"divider\"></li>\r\n");
          out.write("\t\t\t\t                        <li role=\"presentation\">\r\n");
          out.write("\t\t\t\t                         \t<!-- Button to trigger modal for activating the current project -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t   \t");
          if (_jspx_meth_c_005fset_005f25(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a role=\"menuitem\" tabindex=\"-1\" href=\"#");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myActivateURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" role=\"button\" data-toggle=\"modal\"> \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tActivate \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</a> \r\n");
          out.write("\t\t\t\t                         </li>\r\n");
          out.write("\t\t\t\t                      </ul>\r\n");
          out.write("\t\t\t\t                    </ul>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<!-- Activate for each project -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<!-- Generate the URL with the catalogueID -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005furl_005f13(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<form method=\"POST\" action=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ActivateUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\t\t\t\t\t\t\t\t    \r\n");
          out.write("\t\t\t\t \t\t\t\t\t\t<!-- Modal for activating the current project -->\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myActivateURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t    \t<a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<h3 id=\"myModalLabel\"> Activate </h3>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-body\" style=\"text-align:left;\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<p> \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tDo you want to activate resident\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t \t");
          if (_jspx_meth_c_005fout_005f26(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t \t");
          if (_jspx_meth_c_005fout_005f27(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("?\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t   \t<br/>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t    </p>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t    <div class=\"modal-footer\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <a href=\"#\" class=\"btn\" data-dismiss=\"modal\" aria-hidden=\"true\">Cancel</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <input type=\"submit\" value=\"Activate\" class=\"btn btn-primary\" />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t    </div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t      \tStart Date: ");
          if (_jspx_meth_fmt_005fformatDate_005f2(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" \r\n");
          out.write("\t\t\t\t\t\t\t      \t<font style=\"padding-left:30px\">Duration:</font> ");
          if (_jspx_meth_c_005fout_005f28(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" months\r\n");
          out.write("\t\t\t\t\t\t\t      \t<font style=\"padding-left:30px\">Capacity:</font> ");
          if (_jspx_meth_c_005fout_005f29(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write(" operations/month \r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t      \t<br>\r\n");
          out.write("\t\t\t\t\t\t\t      \t<br>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t      \t");
          if (_jspx_meth_c_005fset_005f26(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t      \t<table>\r\n");
          out.write("\t\t\t\t\t\t\t\t      <tbody> \r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t      <tr style=\"border-top:2px solid white\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t    ");
          if (_jspx_meth_c_005fforEach_005f8(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t   </tr>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t   <tr style=\"border-top:2px solid white\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t    ");
          if (_jspx_meth_c_005fforEach_005f9(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t   </tr>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t   </tbody>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f29(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f30(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_fmt_005fsetLocale_005f1(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\tOverall training progress: <b>");
          if (_jspx_meth_fmt_005fformatNumber_005f2(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("%</b>\r\n");
          out.write("\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<i><b>Performed number of operations:</b></i>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t ");
          if (_jspx_meth_c_005fforEach_005f10(_jspx_th_c_005fforEach_005f7, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t      </div>\r\n");
          out.write("\t\t\t\t\t\t    </div>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f7.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f7[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f7.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f7.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f7);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f22 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f22.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(526,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f22.setVar("collapseResident");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(526,11) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f22.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("collapseResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f22 = _jspx_th_c_005fset_005f22.doStartTag();
    if (_jspx_th_c_005fset_005f22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f22);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f22);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f23 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f23.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(527,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f23.setVar("generateProgress");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(527,11) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f23.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("generateProgress${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f23 = _jspx_th_c_005fset_005f23.doStartTag();
    if (_jspx_th_c_005fset_005f23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f23);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f23);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f24(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f24 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f24.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(540,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f24.setVar("count");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(540,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f24.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${count + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f24 = _jspx_th_c_005fset_005f24.doStartTag();
    if (_jspx_th_c_005fset_005f24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f24);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f24);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f20 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f20.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(541,10) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f20.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${count-1000}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f20 = _jspx_th_c_005fout_005f20.doStartTag();
    if (_jspx_th_c_005fout_005f20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f20);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f20);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f21 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f21.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(542,11) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f21.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f21 = _jspx_th_c_005fout_005f21.doStartTag();
    if (_jspx_th_c_005fout_005f21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f21);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f21);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f22 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f22.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(543,16) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f22.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f22 = _jspx_th_c_005fout_005f22.doStartTag();
    if (_jspx_th_c_005fout_005f22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f22);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f22);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t    ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t    ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(545,14) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty project.key.project.deactivatedUntil}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t \t    <font class=\"floatRight\"><i>indefinitely</i></font>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t    ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t        <font class=\"floatRight\"><i>until: ");
        if (_jspx_meth_fmt_005fformatDate_005f1(_jspx_th_c_005fotherwise_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f7))
          return true;
        out.write("</i></font>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t    ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(549,53) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f1.setPattern("dd-MM-yyyy");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(549,53) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f1.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.deactivatedUntil}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_005fformatDate_005f1 = _jspx_th_fmt_005fformatDate_005f1.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f23 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f23.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(557,44) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f23.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f23 = _jspx_th_c_005fout_005f23.doStartTag();
    if (_jspx_th_c_005fout_005f23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f23);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f23);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f24(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f24 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f24.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(558,95) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f24.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f24 = _jspx_th_c_005fout_005f24.doStartTag();
    if (_jspx_th_c_005fout_005f24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f24);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f24);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f25(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f25 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f25.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(559,79) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f25.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.nickname}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f25 = _jspx_th_c_005fout_005f25.doStartTag();
    if (_jspx_th_c_005fout_005f25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f25);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f25);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f25(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f25 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f25.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(572,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f25.setVar("myActivateURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(572,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f25.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("activateResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f25 = _jspx_th_c_005fset_005f25.doStartTag();
    if (_jspx_th_c_005fset_005f25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f25);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f25);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f13 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(582,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f13.setVar("ActivateUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(582,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f13.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/progress/activate?id=${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f13 = _jspx_th_c_005furl_005f13.doStartTag();
    if (_jspx_th_c_005furl_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f26(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f26 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f26.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(595,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f26.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f26 = _jspx_th_c_005fout_005f26.doStartTag();
    if (_jspx_th_c_005fout_005f26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f26);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f26);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f27(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f27 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f27.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(596,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f27.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f27 = _jspx_th_c_005fout_005f27.doStartTag();
    if (_jspx_th_c_005fout_005f27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f27);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f27);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(608,26) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f2.setPattern("dd.MM.yyyy");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(608,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f2.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.startDate}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_005fformatDate_005f2 = _jspx_th_fmt_005fformatDate_005f2.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f28(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f28 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f28.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(609,63) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f28.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.duration}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f28 = _jspx_th_c_005fout_005f28.doStartTag();
    if (_jspx_th_c_005fout_005f28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f28);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f28);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f29(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f29 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f29.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(610,63) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f29.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.capacity}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f29 = _jspx_th_c_005fout_005f29.doStartTag();
    if (_jspx_th_c_005fout_005f29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f29);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f29);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f26(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f26 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f26.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(615,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f26.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(615,14) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f26.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f26 = _jspx_th_c_005fset_005f26.doStartTag();
    if (_jspx_th_c_005fset_005f26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f26);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f26);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f8 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(621,14) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f8.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(621,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f8.setVar("items");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(621,14) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f8.setBegin(0);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(621,14) name = step type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f8.setStep(2);
    int[] _jspx_push_body_count_c_005fforEach_005f8 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f8 = _jspx_th_c_005fforEach_005f8.doStartTag();
      if (_jspx_eval_c_005fforEach_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t      <td style = \"padding-right:15px\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f30(_jspx_th_c_005fforEach_005f8, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f8))
            return true;
          out.write("\r\n");
          out.write("\t\t\t   \t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f27(_jspx_th_c_005fforEach_005f8, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f8))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t        <div class=\"progress horizontal wide\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"myProgress\" class=\"bar text-centered-1\" data-percentage=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f8.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f8[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f8.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f8.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.reuse(_jspx_th_c_005fforEach_005f8);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f8)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f30 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f30.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f8);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(623,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f30.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f30 = _jspx_th_c_005fout_005f30.doStartTag();
    if (_jspx_th_c_005fout_005f30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f30);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f30);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f27(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f8, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f8)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f27 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f27.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f8);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(624,21) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f27.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(624,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f27.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs + totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f27 = _jspx_th_c_005fset_005f27.doStartTag();
    if (_jspx_th_c_005fset_005f27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f27);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f27);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f9 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(633,14) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f9.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(633,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f9.setVar("items");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(633,14) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f9.setBegin(1);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(633,14) name = step type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f9.setStep(2);
    int[] _jspx_push_body_count_c_005fforEach_005f9 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f9 = _jspx_th_c_005fforEach_005f9.doStartTag();
      if (_jspx_eval_c_005fforEach_005f9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t      <td style = \"padding-right:15px\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f31(_jspx_th_c_005fforEach_005f9, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f9))
            return true;
          out.write("\r\n");
          out.write("\t\t\t   \t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f28(_jspx_th_c_005fforEach_005f9, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f9))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t        <div class=\"progress horizontal wide\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"myProgress\" class=\"bar text-centered-1\" data-percentage=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t  </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f9.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f9[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f9.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f9.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.reuse(_jspx_th_c_005fforEach_005f9);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f9, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f9)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f31 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f31.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f9);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(635,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f31.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f31 = _jspx_th_c_005fout_005f31.doStartTag();
    if (_jspx_th_c_005fout_005f31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f31);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f31);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f28(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f9, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f9)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f28 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f28.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f9);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(636,21) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f28.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(636,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f28.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs + totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f28 = _jspx_th_c_005fset_005f28.doStartTag();
    if (_jspx_th_c_005fset_005f28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f28);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f28);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f29(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f29 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f29.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(647,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f29.setVar("nrOfCatalogs");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(647,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f29.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:length(project.value)}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
    int _jspx_eval_c_005fset_005f29 = _jspx_th_c_005fset_005f29.doStartTag();
    if (_jspx_th_c_005fset_005f29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f29);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f29);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f30 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f30.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(648,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f30.setVar("overallProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(648,9) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f30.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalProgressPercent / nrOfCatalogs}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f30 = _jspx_th_c_005fset_005f30.doStartTag();
    if (_jspx_th_c_005fset_005f30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f30);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f30);
    return false;
  }

  private boolean _jspx_meth_fmt_005fsetLocale_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_005fsetLocale_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_005fsetLocale_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fsetLocale_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(649,9) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fsetLocale_005f1.setValue(new String("en_US"));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(649,9) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fsetLocale_005f1.setScope("session");
    int _jspx_eval_fmt_005fsetLocale_005f1 = _jspx_th_fmt_005fsetLocale_005f1.doStartTag();
    if (_jspx_th_fmt_005fsetLocale_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f1);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(650,39) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${overallProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(650,39) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f2.setPattern("0.0");
    int _jspx_eval_fmt_005fformatNumber_005f2 = _jspx_th_fmt_005fformatNumber_005f2.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f7, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f7)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f10 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f7);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(656,11) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f10.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(656,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f10.setVar("items");
    int[] _jspx_push_body_count_c_005fforEach_005f10 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f10 = _jspx_th_c_005fforEach_005f10.doStartTag();
      if (_jspx_eval_c_005fforEach_005f10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t \t");
          if (_jspx_meth_c_005fout_005f32(_jspx_th_c_005fforEach_005f10, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f10))
            return true;
          out.write(':');
          out.write(' ');
          if (_jspx_meth_c_005fout_005f33(_jspx_th_c_005fforEach_005f10, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f10))
            return true;
          out.write(" \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t \t / ");
          if (_jspx_meth_c_005fout_005f34(_jspx_th_c_005fforEach_005f10, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f10))
            return true;
          out.write(" <br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f10.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f10[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f10.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f10.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f10);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f10)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f32 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f32.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f10);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(657,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f32.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f32 = _jspx_th_c_005fout_005f32.doStartTag();
    if (_jspx_th_c_005fout_005f32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f32);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f32);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f33(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f10)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f33 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f33.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f10);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(657,54) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f33.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.completedOpNumber}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f33 = _jspx_th_c_005fout_005f33.doStartTag();
    if (_jspx_th_c_005fout_005f33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f33);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f33);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f10, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f10)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f34 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f34.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f10);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(658,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f34.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.totalOpNumber}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f34 = _jspx_th_c_005fout_005f34.doStartTag();
    if (_jspx_th_c_005fout_005f34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f34);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f34);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f13, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f31 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f31.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f13);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(691,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f31.setVar("count");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(691,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f31.setValue(new String("2000"));
    int _jspx_eval_c_005fset_005f31 = _jspx_th_c_005fset_005f31.doStartTag();
    if (_jspx_th_c_005fset_005f31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f31);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f31);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f32 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f32.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(695,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f32.setVar("collapseResident");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(695,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f32.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("collapseResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f32 = _jspx_th_c_005fset_005f32.doStartTag();
    if (_jspx_th_c_005fset_005f32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f32);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f32);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f33(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f33 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f33.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(696,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f33.setVar("generateProgress");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(696,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f33.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("generateProgress${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f33 = _jspx_th_c_005fset_005f33.doStartTag();
    if (_jspx_th_c_005fset_005f33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f33);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f33);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f14 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(710,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f14.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value[0].overdue}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f14 = _jspx_th_c_005fif_005f14.doStartTag();
    if (_jspx_eval_c_005fif_005f14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t      \t<div class=\"alert alert-error\t\">\r\n");
        out.write("\t\t\t\t\t\t\t\t  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\r\n");
        out.write("\t\t\t\t\t\t\t\t  <strong>Warning!</strong>\r\n");
        out.write("\t\t\t\t\t\t\t\t   Training duration is not accurate, decision support cannot be provided for this resident.\r\n");
        out.write("\t\t\t\t\t\t\t\t   Please change the duration or deactivate the resident.\t\r\n");
        out.write("\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f14.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f35(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f35 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f35.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(718,42) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f35.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f35 = _jspx_th_c_005fout_005f35.doStartTag();
    if (_jspx_th_c_005fout_005f35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f35);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f35);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f36(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f36 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f36.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(719,93) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f36.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f36 = _jspx_th_c_005fout_005f36.doStartTag();
    if (_jspx_th_c_005fout_005f36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f36);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f36);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f37(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f37 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f37.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(720,77) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f37.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.nickname}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f37 = _jspx_th_c_005fout_005f37.doStartTag();
    if (_jspx_th_c_005fout_005f37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f37);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f37);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f34 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f34.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(733,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f34.setVar("myEditPersonURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(733,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f34.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("editPerson${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f34 = _jspx_th_c_005fset_005f34.doStartTag();
    if (_jspx_th_c_005fset_005f34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f34);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f34);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f35(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f35 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f35.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(738,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f35.setVar("myOnVacationUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(738,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f35.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("onVacationResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f35 = _jspx_th_c_005fset_005f35.doStartTag();
    if (_jspx_th_c_005fset_005f35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f35);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f35);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f36(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f36 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f36.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(745,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f36.setVar("myDeactivateURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(745,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f36.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("deactivateResident${count}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f36 = _jspx_th_c_005fset_005f36.doStartTag();
    if (_jspx_th_c_005fset_005f36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f36);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f36);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f14 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(754,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f14.setVar("editPersonURL");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(754,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f14.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/progress/editPersonInformation?id=${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f14 = _jspx_th_c_005furl_005f14.doStartTag();
    if (_jspx_th_c_005furl_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f15 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(871,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f15.setVar("DeactivateUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(871,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f15.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/progress/deactivate?id=${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f15 = _jspx_th_c_005furl_005f15.doStartTag();
    if (_jspx_th_c_005furl_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f38(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f38 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f38.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(884,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f38.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f38 = _jspx_th_c_005fout_005f38.doStartTag();
    if (_jspx_th_c_005fout_005f38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f38);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f38);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f39(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f39 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f39.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(885,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f39.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f39 = _jspx_th_c_005fout_005f39.doStartTag();
    if (_jspx_th_c_005fout_005f39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f39);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f39);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f16 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f16.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(899,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f16.setVar("OnVacationUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(899,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f16.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("../administration/progress/onVacation?id=${project.key.project.projectID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f16 = _jspx_th_c_005furl_005f16.doStartTag();
    if (_jspx_th_c_005furl_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f40(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f40 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f40.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(912,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f40.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f40 = _jspx_th_c_005fout_005f40.doStartTag();
    if (_jspx_th_c_005fout_005f40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f40);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f40);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f41(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f41 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f41.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(913,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f41.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.person.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f41 = _jspx_th_c_005fout_005f41.doStartTag();
    if (_jspx_th_c_005fout_005f41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f41);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f41);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f3 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(929,24) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f3.setPattern("dd.MM.yyyy");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(929,24) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f3.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.startDate}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_005fformatDate_005f3 = _jspx_th_fmt_005fformatDate_005f3.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f42(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f42 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f42.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(930,61) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f42.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.duration}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f42 = _jspx_th_c_005fout_005f42.doStartTag();
    if (_jspx_th_c_005fout_005f42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f42);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f42);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f43(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f43 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f43.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(931,61) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f43.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.key.project.capacity}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f43 = _jspx_th_c_005fout_005f43.doStartTag();
    if (_jspx_th_c_005fout_005f43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f43);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f43);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f37(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f37 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f37.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(936,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f37.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(936,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f37.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f37 = _jspx_th_c_005fset_005f37.doStartTag();
    if (_jspx_th_c_005fset_005f37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f37);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f37);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f38(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f38 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f38.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(937,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f38.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(937,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f38.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f38 = _jspx_th_c_005fset_005f38.doStartTag();
    if (_jspx_th_c_005fset_005f38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f38);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f38);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f12 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(942,12) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f12.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(942,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f12.setVar("items");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(942,12) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f12.setBegin(0);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(942,12) name = step type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f12.setStep(2);
    int[] _jspx_push_body_count_c_005fforEach_005f12 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f12 = _jspx_th_c_005fforEach_005f12.doStartTag();
      if (_jspx_eval_c_005fforEach_005f12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t      <td style = \"padding-right:15px\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f44(_jspx_th_c_005fforEach_005f12, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f12))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f39(_jspx_th_c_005fforEach_005f12, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f12))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f40(_jspx_th_c_005fforEach_005f12, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f12))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t        <div class=\"progress horizontal wide\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div id=\"myProgress\" class=\"bar text-centered-1\" data-percentage=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t  </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f12.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f12[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f12.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f12.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.reuse(_jspx_th_c_005fforEach_005f12);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f44(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f12, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f12)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f44 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f44.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f12);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(944,10) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f44.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f44 = _jspx_th_c_005fout_005f44.doStartTag();
    if (_jspx_th_c_005fout_005f44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f44);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f44);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f39(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f12, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f12)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f39 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f39.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f12);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(945,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f39.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(945,10) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f39.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs + totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f39 = _jspx_th_c_005fset_005f39.doStartTag();
    if (_jspx_th_c_005fset_005f39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f39);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f39);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f40(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f12, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f12)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f40 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f40.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f12);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(946,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f40.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(946,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f40.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentShouldBe + expectedProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f40 = _jspx_th_c_005fset_005f40.doStartTag();
    if (_jspx_th_c_005fset_005f40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f40);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f40);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f13 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(956,12) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f13.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(956,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f13.setVar("items");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(956,12) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f13.setBegin(1);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(956,12) name = step type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f13.setStep(2);
    int[] _jspx_push_body_count_c_005fforEach_005f13 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f13 = _jspx_th_c_005fforEach_005f13.doStartTag();
      if (_jspx_eval_c_005fforEach_005f13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t      <td style = \"padding-right:15px\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f45(_jspx_th_c_005fforEach_005f13, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f13))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f41(_jspx_th_c_005fforEach_005f13, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f13))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t        ");
          if (_jspx_meth_c_005fset_005f42(_jspx_th_c_005fforEach_005f13, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f13))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t        <div class=\"progress horizontal wide\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div id=\"myProgress\" class=\"bar text-centered-1\" data-percentage=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<br>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t  </td>\r\n");
          out.write("\t\t\t\t\t\t\t\t    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f13.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f13[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f13.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f13.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fstep_005fitems_005fbegin.reuse(_jspx_th_c_005fforEach_005f13);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f45(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f13, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f13)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f45 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f45.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f13);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(958,10) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f45.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f45 = _jspx_th_c_005fout_005f45.doStartTag();
    if (_jspx_th_c_005fout_005f45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f45);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f45);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f41(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f13, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f13)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f41 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f41.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f13);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(959,19) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f41.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(959,19) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f41.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentIs + totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f41 = _jspx_th_c_005fset_005f41.doStartTag();
    if (_jspx_th_c_005fset_005f41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f41);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f41);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f42(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f13, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f13)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f42 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f42.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f13);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(960,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f42.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(960,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f42.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.progressPercentShouldBe + expectedProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f42 = _jspx_th_c_005fset_005f42.doStartTag();
    if (_jspx_th_c_005fset_005f42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f42);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f42);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f43(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f43 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f43.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(972,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f43.setVar("nrOfCatalogs");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(972,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f43.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:length(project.value)}", java.lang.Object.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
    int _jspx_eval_c_005fset_005f43 = _jspx_th_c_005fset_005f43.doStartTag();
    if (_jspx_th_c_005fset_005f43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f43);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f43);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f44(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f44 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f44.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(973,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f44.setVar("totalProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(973,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f44.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalProgressPercent / nrOfCatalogs}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f44 = _jspx_th_c_005fset_005f44.doStartTag();
    if (_jspx_th_c_005fset_005f44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f44);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f44);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f45(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f45 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f45.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(974,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f45.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(974,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f45.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${expectedProgressPercent / nrOfCatalogs}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f45 = _jspx_th_c_005fset_005f45.doStartTag();
    if (_jspx_th_c_005fset_005f45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f45);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f45);
    return false;
  }

  private boolean _jspx_meth_fmt_005fsetLocale_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_005fsetLocale_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_005fsetLocale_005f2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fsetLocale_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(975,7) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fsetLocale_005f2.setValue(new String("en_US"));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(975,7) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fsetLocale_005f2.setScope("session");
    int _jspx_eval_fmt_005fsetLocale_005f2 = _jspx_th_fmt_005fsetLocale_005f2.doStartTag();
    if (_jspx_th_fmt_005fsetLocale_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fscope_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f2);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f3 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(976,37) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(976,37) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f3.setPattern("0.0");
    int _jspx_eval_fmt_005fformatNumber_005f3 = _jspx_th_fmt_005fformatNumber_005f3.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f15 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(977,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f15.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${expectedProgressPercent > 100 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f15 = _jspx_th_c_005fif_005f15.doStartTag();
    if (_jspx_eval_c_005fif_005f15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f46(_jspx_th_c_005fif_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f11))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f15.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f46(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f46 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f46.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(978,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f46.setVar("expectedProgressPercent");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(978,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f46.setValue(new String("100"));
    int _jspx_eval_c_005fset_005f46 = _jspx_th_c_005fset_005f46.doStartTag();
    if (_jspx_th_c_005fset_005f46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f46);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f46);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f4 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(980,39) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${expectedProgressPercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(980,39) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f4.setPattern("0.0");
    int _jspx_eval_fmt_005fformatNumber_005f4 = _jspx_th_fmt_005fformatNumber_005f4.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f14 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(986,9) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f14.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${project.value}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(986,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f14.setVar("items");
    int[] _jspx_push_body_count_c_005fforEach_005f14 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f14 = _jspx_th_c_005fforEach_005f14.doStartTag();
      if (_jspx_eval_c_005fforEach_005f14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t \t");
          if (_jspx_meth_c_005fout_005f46(_jspx_th_c_005fforEach_005f14, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f14))
            return true;
          out.write(':');
          out.write(' ');
          if (_jspx_meth_c_005fout_005f47(_jspx_th_c_005fforEach_005f14, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f14))
            return true;
          out.write(" \r\n");
          out.write("\t\t\t\t\t\t\t\t \t / ");
          if (_jspx_meth_c_005fout_005f48(_jspx_th_c_005fforEach_005f14, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f14))
            return true;
          out.write(" <br>\r\n");
          out.write("\t\t\t\t\t\t\t\t ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f14.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f14[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f14.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f14.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f14);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f46(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f14, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f14)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f46 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f46.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f14);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(987,10) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f46.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.catalogueName}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f46 = _jspx_th_c_005fout_005f46.doStartTag();
    if (_jspx_th_c_005fout_005f46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f46);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f46);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f47(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f14, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f14)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f47 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f47.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f14);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(987,52) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f47.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.completedOpNumber}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f47 = _jspx_th_c_005fout_005f47.doStartTag();
    if (_jspx_th_c_005fout_005f47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f47);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f47);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f48(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f14, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f14)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f48 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f48.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f14);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(988,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f48.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${items.totalOpNumber}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f48 = _jspx_th_c_005fout_005f48.doStartTag();
    if (_jspx_th_c_005fout_005f48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f48);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f48);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f11, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f11)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f15 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f11);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1011,6) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f15.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperations}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1011,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f15.setVar("difficultOperation");
    int[] _jspx_push_body_count_c_005fforEach_005f15 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f15 = _jspx_th_c_005fforEach_005f15.doStartTag();
      if (_jspx_eval_c_005fforEach_005f15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t<!-- First decide even if we need to show this row, check : does the user actually contribute to the difficult opetation(opsco)? -->\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f47(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f16(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f17(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f18(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f19(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f20(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f21(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<!-- check end -->\r\n");
          out.write("\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f22(_jspx_th_c_005fforEach_005f15, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f15.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f15[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f15.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f15.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f15);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f47(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f47 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f47.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1014,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f47.setVar("noOfActualDiffOperationForThisUser");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1014,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f47.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f47 = _jspx_th_c_005fset_005f47.doStartTag();
    if (_jspx_th_c_005fset_005f47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f47);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f47);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f16 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f16.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1015,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f16.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f16 = _jspx_th_c_005fif_005f16.doStartTag();
    if (_jspx_eval_c_005fif_005f16 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f48(_jspx_th_c_005fif_005f16, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f16.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f48(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f16, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f48 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f48.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f16);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1016,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f48.setVar("noOfActualDiffOperationForThisUser");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1016,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f48.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noOfActualDiffOperationForThisUser + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f48 = _jspx_th_c_005fset_005f48.doStartTag();
    if (_jspx_th_c_005fset_005f48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f48);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f48);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f17 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f17.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1018,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f17.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f17 = _jspx_th_c_005fif_005f17.doStartTag();
    if (_jspx_eval_c_005fif_005f17 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f49(_jspx_th_c_005fif_005f17, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f17.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f49(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f17, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f49 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f49.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f17);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1019,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f49.setVar("noOfActualDiffOperationForThisUser");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1019,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f49.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noOfActualDiffOperationForThisUser + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f49 = _jspx_th_c_005fset_005f49.doStartTag();
    if (_jspx_th_c_005fset_005f49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f49);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f49);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f18 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f18.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1021,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f18.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f18 = _jspx_th_c_005fif_005f18.doStartTag();
    if (_jspx_eval_c_005fif_005f18 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f50(_jspx_th_c_005fif_005f18, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f18.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f18);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f50(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f18, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f50 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f50.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f18);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1022,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f50.setVar("noOfActualDiffOperationForThisUser");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1022,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f50.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noOfActualDiffOperationForThisUser + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f50 = _jspx_th_c_005fset_005f50.doStartTag();
    if (_jspx_th_c_005fset_005f50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f50);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f50);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f19 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f19.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1024,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f19.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f19 = _jspx_th_c_005fif_005f19.doStartTag();
    if (_jspx_eval_c_005fif_005f19 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f51(_jspx_th_c_005fif_005f19, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f19.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f19);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f51(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f19, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f51 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f51.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f19);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1025,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f51.setVar("noOfActualDiffOperationForThisUser");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1025,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f51.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noOfActualDiffOperationForThisUser + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f51 = _jspx_th_c_005fset_005f51.doStartTag();
    if (_jspx_th_c_005fset_005f51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f51);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f51);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f20 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f20.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1027,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f20.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f20 = _jspx_th_c_005fif_005f20.doStartTag();
    if (_jspx_eval_c_005fif_005f20 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f52(_jspx_th_c_005fif_005f20, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f20.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f20);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f20);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f52(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f20, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f52 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f52.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f20);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1028,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f52.setVar("noOfActualDiffOperationForThisUser");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1028,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f52.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noOfActualDiffOperationForThisUser + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f52 = _jspx_th_c_005fset_005f52.doStartTag();
    if (_jspx_th_c_005fset_005f52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f52);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f52);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f21 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f21.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1030,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f21.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f21 = _jspx_th_c_005fif_005f21.doStartTag();
    if (_jspx_eval_c_005fif_005f21 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f53(_jspx_th_c_005fif_005f21, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f21.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f21);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f21);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f53(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f21, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f53 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f53.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f21);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1031,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f53.setVar("noOfActualDiffOperationForThisUser");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1031,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f53.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noOfActualDiffOperationForThisUser + 1}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f53 = _jspx_th_c_005fset_005f53.doStartTag();
    if (_jspx_th_c_005fset_005f53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f53);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f53);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f15, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f22 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f22.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f15);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1035,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f22.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noOfActualDiffOperationForThisUser > 0 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f22 = _jspx_th_c_005fif_005f22.doStartTag();
    if (_jspx_eval_c_005fif_005f22 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005furl_005f17(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t    \t\t\t<form class=\"chooseDiffOpForm\" method=\"POST\" action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${chooseDiffOpUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">\r\n");
        out.write("\t\t\t\t    \t\t\t\r\n");
        out.write("\t\t\t\t    \t\t\t");
        if (_jspx_meth_c_005fset_005f54(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t    \t\t\t<input type=\"hidden\" name=\"diffSuppOpId\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.dSuppOpId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<!-- td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.dSuppOpId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td -->\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>");
        if (_jspx_meth_fmt_005fformatDate_005f4(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.opsc1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f23(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.opsc2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f24(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.ass1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f25(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write(" \r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f26(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write(" \r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f27(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f28(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f31(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f34(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f37(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f40(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f43(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<td>");
        if (_jspx_meth_c_005fif_005f46(_jspx_th_c_005fif_005f22, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t\t\t\t</form>\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f22.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f22);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f22);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f17 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f17.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1036,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f17.setVar("chooseDiffOpUrl");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1036,8) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f17.setValue("../administration/decisionsupport/updateChosenDiffOp");
    int _jspx_eval_c_005furl_005f17 = _jspx_th_c_005furl_005f17.doStartTag();
    if (_jspx_th_c_005furl_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f54(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f54 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f54.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1039,11) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f54.setVar("saveNeeded");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1039,11) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f54.setValue(new String("0"));
    int _jspx_eval_c_005fset_005f54 = _jspx_th_c_005fset_005f54.doStartTag();
    if (_jspx_th_c_005fset_005f54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f54);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f54);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f4 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1043,13) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f4.setPattern("dd-MM-yyyy");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1043,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f4.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.opDate}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_005fformatDate_005f4 = _jspx_th_fmt_005fformatDate_005f4.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f23 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f23.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1046,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f23.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.OPSC01Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f23 = _jspx_th_c_005fif_005f23.doStartTag();
    if (_jspx_eval_c_005fif_005f23 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t(Difficult)\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f23.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f23);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f23);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f24(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f24 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f24.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1052,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f24.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.OPSC02Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f24 = _jspx_th_c_005fif_005f24.doStartTag();
    if (_jspx_eval_c_005fif_005f24 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t(Difficult)\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f24.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f24);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f24);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f25(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f25 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f25.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1060,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f25.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op1 == nameUser}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f25 = _jspx_th_c_005fif_005f25.doStartTag();
    if (_jspx_eval_c_005fif_005f25 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tOp1<input type=\"hidden\" name=\"operatedAs\" value=\"Op1\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f25.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f25);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f25);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f26(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f26 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f26.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1063,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f26.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op2 == nameUser}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f26 = _jspx_th_c_005fif_005f26.doStartTag();
    if (_jspx_eval_c_005fif_005f26 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tOp2<input type=\"hidden\" name=\"operatedAs\" value=\"Op2\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f26.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f26);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f26);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f27(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f27 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f27.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1066,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f27.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.ass1 == nameUser}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f27 = _jspx_th_c_005fif_005f27.doStartTag();
    if (_jspx_eval_c_005fif_005f27 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tAss1<input type=\"hidden\" name=\"operatedAs\" value=\"Ass1\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f27.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f27);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f27);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f28(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f28 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f28.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1073,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f28.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f28 = _jspx_th_c_005fif_005f28.doStartTag();
    if (_jspx_eval_c_005fif_005f28 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f29(_jspx_th_c_005fif_005f28, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f30(_jspx_th_c_005fif_005f28, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f28.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f28);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f28);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f29(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f28, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f29 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f29.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f28);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1074,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f29.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(difficultOperation.OP1ChosenDifficult, 'OPSC01')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f29 = _jspx_th_c_005fif_005f29.doStartTag();
    if (_jspx_eval_c_005fif_005f29 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <span class=\"label label-info\" >OPSC01</span> ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f29.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f29);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f29);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f30(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f28, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f30 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f30.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f28);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1075,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f30.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not fn:contains(difficultOperation.OP1ChosenDifficult, 'OPSC01')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f30 = _jspx_th_c_005fif_005f30.doStartTag();
    if (_jspx_eval_c_005fif_005f30 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"checkbox\" name=\"opscToCount\" value=\"OPSC01\" > OPSC01 ");
        if (_jspx_meth_c_005fset_005f55(_jspx_th_c_005fif_005f30, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f30.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f30);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f30);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f55(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f30, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f55 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f55.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f30);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1075,158) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f55.setVar("saveNeeded");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1075,158) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f55.setValue(new String("1"));
    int _jspx_eval_c_005fset_005f55 = _jspx_th_c_005fset_005f55.doStartTag();
    if (_jspx_th_c_005fset_005f55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f55);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f55);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f31(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f31 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f31.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1077,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f31.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op1 == nameUser && fn:contains(difficultOperation.OP1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f31 = _jspx_th_c_005fif_005f31.doStartTag();
    if (_jspx_eval_c_005fif_005f31 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f32(_jspx_th_c_005fif_005f31, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f33(_jspx_th_c_005fif_005f31, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f31.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f31);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f31);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f32(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f31, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f32 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f32.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f31);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1078,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f32.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(difficultOperation.OP1ChosenDifficult, 'OPSC02')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f32 = _jspx_th_c_005fif_005f32.doStartTag();
    if (_jspx_eval_c_005fif_005f32 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <span class=\"label label-info\" >OPSC02</span> ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f32.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f32);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f32);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f33(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f31, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f33 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f33.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f31);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1079,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f33.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not fn:contains(difficultOperation.OP1ChosenDifficult, 'OPSC02')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f33 = _jspx_th_c_005fif_005f33.doStartTag();
    if (_jspx_eval_c_005fif_005f33 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"checkbox\" name=\"opscToCount\" value=\"OPSC02\" > OPSC02 ");
        if (_jspx_meth_c_005fset_005f56(_jspx_th_c_005fif_005f33, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f33.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f33);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f33);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f56(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f33, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f56 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f56.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f33);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1079,158) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f56.setVar("saveNeeded");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1079,158) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f56.setValue(new String("1"));
    int _jspx_eval_c_005fset_005f56 = _jspx_th_c_005fset_005f56.doStartTag();
    if (_jspx_th_c_005fset_005f56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f56);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f56);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f34(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f34 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f34.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1082,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f34.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f34 = _jspx_th_c_005fif_005f34.doStartTag();
    if (_jspx_eval_c_005fif_005f34 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f35(_jspx_th_c_005fif_005f34, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f36(_jspx_th_c_005fif_005f34, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f34.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f34);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f34);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f35(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f34, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f35 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f35.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f34);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1083,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f35.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(difficultOperation.OP2ChosenDifficult, 'OPSC01')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f35 = _jspx_th_c_005fif_005f35.doStartTag();
    if (_jspx_eval_c_005fif_005f35 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <span class=\"label label-info\" >OPSC01</span> ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f35.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f35);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f35);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f36(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f34, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f36 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f36.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f34);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1084,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f36.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not fn:contains(difficultOperation.OP2ChosenDifficult, 'OPSC01')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f36 = _jspx_th_c_005fif_005f36.doStartTag();
    if (_jspx_eval_c_005fif_005f36 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"checkbox\" name=\"opscToCount\" value=\"OPSC01\" > OPSC01 ");
        if (_jspx_meth_c_005fset_005f57(_jspx_th_c_005fif_005f36, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f36.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f36);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f36);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f57(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f36, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f57 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f57.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f36);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1084,158) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f57.setVar("saveNeeded");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1084,158) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f57.setValue(new String("1"));
    int _jspx_eval_c_005fset_005f57 = _jspx_th_c_005fset_005f57.doStartTag();
    if (_jspx_th_c_005fset_005f57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f57);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f57);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f37(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f37 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f37.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1086,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f37.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.op2 == nameUser && fn:contains(difficultOperation.OP2Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f37 = _jspx_th_c_005fif_005f37.doStartTag();
    if (_jspx_eval_c_005fif_005f37 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f38(_jspx_th_c_005fif_005f37, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f39(_jspx_th_c_005fif_005f37, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f37.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f37);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f37);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f38(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f37, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f38 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f38.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f37);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1087,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f38.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(difficultOperation.OP2ChosenDifficult, 'OPSC02')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f38 = _jspx_th_c_005fif_005f38.doStartTag();
    if (_jspx_eval_c_005fif_005f38 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <span class=\"label label-info\" >OPSC02</span> ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f38.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f38);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f38);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f39(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f37, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f39 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f39.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f37);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1088,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f39.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not fn:contains(difficultOperation.OP2ChosenDifficult, 'OPSC02')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f39 = _jspx_th_c_005fif_005f39.doStartTag();
    if (_jspx_eval_c_005fif_005f39 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"checkbox\" name=\"opscToCount\" value=\"OPSC02\" > OPSC02 ");
        if (_jspx_meth_c_005fset_005f58(_jspx_th_c_005fif_005f39, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f39.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f39);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f39);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f58(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f39, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f58 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f58.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f39);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1088,158) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f58.setVar("saveNeeded");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1088,158) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f58.setValue(new String("1"));
    int _jspx_eval_c_005fset_005f58 = _jspx_th_c_005fset_005f58.doStartTag();
    if (_jspx_th_c_005fset_005f58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f58);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f58);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f40(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f40 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f40.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1091,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f40.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC01') && difficultOperation.OPSC01Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f40 = _jspx_th_c_005fif_005f40.doStartTag();
    if (_jspx_eval_c_005fif_005f40 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f41(_jspx_th_c_005fif_005f40, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f42(_jspx_th_c_005fif_005f40, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f40.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f40);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f40);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f41(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f40, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f41 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f41.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f40);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1092,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f41.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(difficultOperation.ass1ChosenDifficult, 'OPSC01')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f41 = _jspx_th_c_005fif_005f41.doStartTag();
    if (_jspx_eval_c_005fif_005f41 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <span class=\"label label-info\" >OPSC01</span> ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f41.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f41);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f41);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f42(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f40, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f42 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f42.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f40);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1093,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f42.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not fn:contains(difficultOperation.ass1ChosenDifficult, 'OPSC01')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f42 = _jspx_th_c_005fif_005f42.doStartTag();
    if (_jspx_eval_c_005fif_005f42 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"checkbox\" name=\"opscToCount\" value=\"OPSC01\" > OPSC01 ");
        if (_jspx_meth_c_005fset_005f59(_jspx_th_c_005fif_005f42, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f42.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f42);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f42);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f59(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f42, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f59 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f59.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f42);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1093,159) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f59.setVar("saveNeeded");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1093,159) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f59.setValue(new String("1"));
    int _jspx_eval_c_005fset_005f59 = _jspx_th_c_005fset_005f59.doStartTag();
    if (_jspx_th_c_005fset_005f59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f59);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f59);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f43(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f43 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f43.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1096,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f43.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${difficultOperation.ass1 == nameUser && fn:contains(difficultOperation.ass1Credit, 'OPSC02') && difficultOperation.OPSC02Difficulty == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f43 = _jspx_th_c_005fif_005f43.doStartTag();
    if (_jspx_eval_c_005fif_005f43 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f44(_jspx_th_c_005fif_005f43, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_c_005fif_005f45(_jspx_th_c_005fif_005f43, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f43.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f43);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f43);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f44(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f43, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f44 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f44.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f43);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1097,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f44.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(difficultOperation.ass1ChosenDifficult, 'OPSC02')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f44 = _jspx_th_c_005fif_005f44.doStartTag();
    if (_jspx_eval_c_005fif_005f44 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <span class=\"label label-info\" >OPSC02</span> ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f44.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f44);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f44);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f45(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f43, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f45 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f45.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f43);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1098,11) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f45.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not fn:contains(difficultOperation.ass1ChosenDifficult, 'OPSC02')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false)).booleanValue());
    int _jspx_eval_c_005fif_005f45 = _jspx_th_c_005fif_005f45.doStartTag();
    if (_jspx_eval_c_005fif_005f45 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"checkbox\" name=\"opscToCount\" value=\"OPSC02\" > OPSC02 ");
        if (_jspx_meth_c_005fset_005f60(_jspx_th_c_005fif_005f45, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f15))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f45.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f45);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f45);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f60(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f45, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f60 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f60.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f45);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1098,159) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f60.setVar("saveNeeded");
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1098,159) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f60.setValue(new String("1"));
    int _jspx_eval_c_005fset_005f60 = _jspx_th_c_005fset_005f60.doStartTag();
    if (_jspx_th_c_005fset_005f60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f60);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f60);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f46(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f22, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f15)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f46 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f46.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f22);
    // /WEB-INF/jsp/admin/TrainingProgress.jsp(1101,13) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f46.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${saveNeeded == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f46 = _jspx_th_c_005fif_005f46.doStartTag();
    if (_jspx_eval_c_005fif_005f46 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"submit\" id=\"setAsDifficult\" value=\"Save\" class=\"btn btn-primary\">");
        int evalDoAfterBody = _jspx_th_c_005fif_005f46.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f46);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f46);
    return false;
  }
}
