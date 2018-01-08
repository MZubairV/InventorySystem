package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class reportMonthly_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Monthly Report</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js\"></script>  \n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/page.css\">\n");
      out.write("    </head>\n");
      out.write("    <body ng-app=\"invoice\" ng-controller=\"reportController\">\n");
      out.write("\n");
      out.write("        <!--connect to database-->\n");
      out.write("        ");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            Statement stmnt = con.createStatement();
        
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
      out.write("\n");
      out.write("        <div class=\"container-fluid bg-2\">\n");
      out.write("            <div class=\"bg-primary \" align=\"center\">\n");
      out.write("                <h1>Monthly Report</h1>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <button class=\"btn btn-success dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Report\n");
      out.write("                    <span class=\"caret\"></span>\n");
      out.write("                </button>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"reportDaily.jsp\">Daily</a></li>\n");
      out.write("                    <li><a href=\"reportWeekly.jsp\">Weekly</a></li>\n");
      out.write("                    <li><a href=\"reportMonthly.jsp\">Monthly</a></li>\n");
      out.write("                    <li><a href=\"reportCompletely.jsp\">Completely</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div> \n");
      out.write("\n");
      out.write("            <!--Total sales-->\n");
      out.write("            <div class=\"container\">          \n");
      out.write("                <table class=\"table bg-info\">\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

//                            String sqlTotal = "SELECT sum(total),sum(totalProfit),count(id) FROM sales where date(date)>curdate()-30";
                            String sqlTotal = "SELECT sum(total),sum(totalProfit),count(id) FROM sales WHERE MONTH(date) = MONTH(NOW()) AND YEAR(date) = YEAR(NOW())";
                            ResultSet rsReports = stmnt.executeQuery(sqlTotal);
                            while (rsReports.next()) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h2>Total Sale</h2></td>\n");
      out.write("                            <td><h2>");
      out.print("₹ " + rsReports.getString(1));
      out.write("</h2></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h2>Total Profit</h2></td>\n");
      out.write("                            <td><h2>");
      out.print("₹ " + rsReports.getString(2));
      out.write("</h2></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h2>No of customer</h2></td>\n");
      out.write("                            <td><h2>");
      out.print(rsReports.getString(3));
      out.write("</h2></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("                        \n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Sales group by date-->\n");
      out.write("            <div class=\"container\">          \n");
      out.write("                <table class=\"table bg-info\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Day</th>\n");
      out.write("                            <th>Month</th>\n");
      out.write("                            <th>Year</th>\n");
      out.write("                            <th>Total Sale</th>                        \n");
      out.write("                            <th>Total Profit</th>                        \n");
      out.write("                            <th>No. of Customer</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

//                            String sqlGroupByDay = "select day(date),month(date),year(date) ,sum(total),sum(totalProfit),count(id) from sales where date(date)> curdate()-30 group by day(date),month(date),year(date) ";
                            String sqlGroupByDay = "select day(date),month(date),year(date) ,sum(total),sum(totalProfit),count(id) from sales WHERE MONTH(date) = MONTH(NOW()) AND YEAR(date) = YEAR(NOW()) group by day(date),month(date),year(date) ";
                            ResultSet rsGroupByDay = stmnt.executeQuery(sqlGroupByDay);
                            while (rsGroupByDay.next()) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td><h2>");
      out.print(rsGroupByDay.getString(1));
      out.write("</h2></td>\n");
      out.write("                            <td><h2>");
      out.print(rsGroupByDay.getString(2));
      out.write("</h2></td>\n");
      out.write("                            <td><h2>");
      out.print(rsGroupByDay.getString(3));
      out.write("</h2></td>\n");
      out.write("                            <td><h2>");
      out.print("₹ " + rsGroupByDay.getString(4));
      out.write("</h2></td>\n");
      out.write("                            <td><h2>");
      out.print("₹ " + rsGroupByDay.getString(5));
      out.write("</h2></td>\n");
      out.write("                            <td><h2>");
      out.print(rsGroupByDay.getString(6));
      out.write("</h2></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("                        \n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--Weekly sales report-->\n");
      out.write("            <table class=\"table able-striped bg-3 \">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>Customer</th>\n");
      out.write("                        <th>Place</th>\n");
      out.write("                        <th>Mobile</th>                        \n");
      out.write("                        <th>Email</th>                        \n");
      out.write("                        <th>Total</th>                                                \n");
      out.write("                        <th>Date of Purchase</th>                        \n");
      out.write("                        <th>Total Profit</th>  \n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

//                        String sqlSales = "SELECT * FROM sales WHERE DATE(date) > CURDATE()-30";
                        String sqlSales = "SELECT * FROM sales WHERE MONTH(date) = MONTH(NOW()) AND YEAR(date) = YEAR(NOW())";
                        ResultSet rsSales = stmnt.executeQuery(sqlSales);
                        while (rsSales.next()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(rsSales.getString(1));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rsSales.getString(2));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rsSales.getString(3));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rsSales.getString(4));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rsSales.getString(5));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print("₹ " + rsSales.getString(6));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rsSales.getString(7));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print("₹ " + rsSales.getString(8));
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
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
