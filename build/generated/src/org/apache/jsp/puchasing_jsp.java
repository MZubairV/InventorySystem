package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;

public final class puchasing_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Purchasing</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script src=\"modules/angular.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"modules/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"modules/jquery-3.2.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <script src=\"js/purchaseController.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/page.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/searchProduct.css\">\n");
      out.write("    </head>\n");
      out.write("    <body  ng-app=\"invoice\" ng-controller=\"purchaseController\">\n");
      out.write("        <!--connect to database-->\n");
      out.write("        ");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            String sql = "SELECT * FROM InventorySystem.product order by(id) desc";
//            SELECT * FROM   sales WHERE  date > (NOW() - INTERVAL 1 MONTH)
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(sql);
        
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Navbar -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/menu.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Navbar -->\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container\" id=\"menu\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>                        \n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"billing.jsp\" style=\"font-size: 25px\">Andrew Departmental Store</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"billing.jsp\">Billing</a></li>\n");
      out.write("                        <li><a href=\"puchasing.jsp\">Purchasing</a></li>\n");
      out.write("                        <li><a href=\"reportCompletely.jsp\">Reports</a></li>\n");
      out.write("                        <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid bg-2\">\n");
      out.write("            <div class=\"container\"> \n");
      out.write("                <table class=\"table bg-info\">\n");
      out.write("                    <thead>   \n");
      out.write("                        <tr>                  \n");
      out.write("                            <td> <form action=\"SendMail\" method=\"post\">\n");
      out.write("                                    <input type=\"submit\"  class=\"form-control btn btn-success\" value=\"Send purchase order\">\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr> \n");
      out.write("                    </thead>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <h1>Add new product</h1>\n");
      out.write("            <table class=\"table bg-info\">\n");
      out.write("                <thead>   \n");
      out.write("                    <tr>                  \n");
      out.write("                        <td>Product name</td>\n");
      out.write("                        <td>Category</td>\n");
      out.write("                        <td>Cost price</td>\n");
      out.write("                        <td>Profit percentage</td>\n");
      out.write("                        <td>Count</td>\n");
      out.write("                        <td>Min. Count</td>         \n");
      out.write("                    </tr> </thead>\n");
      out.write("                <tbody>\n");
      out.write("                <form action=\"AddProduct\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"text\" class=\"form-control\" placeholder=\"Product name\" name=\"product\"></td>\n");
      out.write("                        <td><input type=\"text\" class=\"form-control\" placeholder=\"category\" name=\"category\"></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"cost price\" name=\"costPrice\" min=\"0\"></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"profit percentage\" name=\"profitPercentage\"></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"Count\" name=\"count\"></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"Min. Count\" name=\"minCount\"></td>                        \n");
      out.write("                        <td><input type=\"submit\" class=\"form-control btn btn-success\" value=\"Add\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </form>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <h1>Update product</h1>\n");
      out.write("            <table class=\"table bg-info\">\n");
      out.write("                <thead>   \n");
      out.write("                    <tr>                  \n");
      out.write("                        <td>Product name</td>\n");
      out.write("                        <td>Category</td>\n");
      out.write("                        <td>Cost price</td>\n");
      out.write("                        <td>Profit percentage</td>\n");
      out.write("                        <td>Available Count</td>\n");
      out.write("                        <td>Count</td>\n");
      out.write("                        <td>Min. Count</td>         \n");
      out.write("                    </tr> \n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                <form action=\"UpdateProduct\">\n");
      out.write("                    <tr>\n");
      out.write("                        <!--<td><input type=\"text\" class=\"form-control\" placeholder=\"Product name\" name=\"product\"></td>-->\n");
      out.write("                        <td>            \n");
      out.write("                            <input type=\"hidden\" name=\"productId\" value={{items.id}} />\n");
      out.write("                            <input type='text' ng-keyup='fetchProducts(items.name)' placeholder=\"Product name\"  ng-model='items.name' class=\"form-control\" name=\"product\"><br>\n");
      out.write("                            <ul id='searchResult' ng-show=\"listView\" >\n");
      out.write("                                <li ng-click='setValue(result)' ng-repeat=\"result in searchResult\" style=\"font-size: 15px\">{{ result.name}}</li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </td>\n");
      out.write("                        <td><input type=\"text\" class=\"form-control\" placeholder=\"category\" name=\"category\" ng-model=\"items.category\" readonly></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"cost price\" name=\"costPrice\" min=\"0\" ng-model=\"items.costPrice\" readonly></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"profit percentage\" name=\"profitPercentage\" ng-model=\"items.profitPercentage\" readonly></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"Count\" ng-model=\"items.remainingCount\" readonly></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"Count\" name=\"count\" ng-model=\"items.count\"></td>\n");
      out.write("                        <td><input type=\"number\" class=\"form-control\" placeholder=\"Min. Count\" name=\"minCount\" ng-model=\"items.minCount\"></td>      \n");
      out.write("                        <td><input type=\"submit\" class=\"form-control btn btn-success\" value=\"Update\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </form>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <table class=\"table able-striped bg-3 \">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Product</th>\n");
      out.write("                        <th>Category</th>\n");
      out.write("                        <th>Cost Price</th>                        \n");
      out.write("                        <th>Profit Percentage</th>                        \n");
      out.write("                        <th>Selling Price</th>                                                \n");
      out.write("                        <th>Profit</th>                        \n");
      out.write("                        <th>Count</th>                        \n");
      out.write("                        <th>Min. Count</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        while (rs.next()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(rs.getString(1));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(4));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(5));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(6));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(7));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(8));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(9));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tr>                    \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Footer -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Footer -->\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <p align=\"center\">muhammedzubairv@gmail.com</a></p>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
