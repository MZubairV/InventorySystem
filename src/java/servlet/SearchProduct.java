package servlet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mzv
 */
public class SearchProduct extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strSearchText = req.getParameter("searchText");
        String searchFrom=req.getParameter("searchFrom");
//        System.out.println("MZV" + strSearchText+"  "+searchFrom);

        try {
            resp.setContentType("text/text;charset=UTF-8");
            JsonObject jsonResponse = new JsonObject();
            JsonArray data = new JsonArray();
            JsonArray row = new JsonArray();
            PrintWriter out = resp.getWriter();

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            Statement pstmt = con.createStatement();
            
            String query="";
            if (searchFrom.equals("PurchaseSection")) {
                query="SELECT * FROM product WHERE name LIKE '%" + strSearchText + "%'";
            }else{//From Billing Section
                query="SELECT * FROM product WHERE name LIKE '%" + strSearchText + "%'" + "and count > 0";
            }
            
            ResultSet rs = pstmt.executeQuery(query);
            System.out.println("SELECT * FROM product WHERE name LIKE '%" + strSearchText + "%'");

            StringBuilder str = new StringBuilder();
            str.append("[ ");
            while (rs.next()) {
                str.append("{");
                str.append("\"id\":" + rs.getString("id") + ",");
                str.append("\"name\":\"" + rs.getString("name") + "\",");
                str.append("\"category\":\"" + rs.getString("category") + "\",");
                str.append("\"costPrice\":" + rs.getString("costPrice") + ",");
                str.append("\"profitPercentage\":" + rs.getString("profitPercentage") + ",");
                str.append("\"sellingPrice\":" + rs.getString("sellingPrice") + ",");
                str.append("\"profit\":" + rs.getString("profit") + ",");
                str.append("\"count\":" + rs.getString("count") + ",");
                str.append("\"minCount\":" + rs.getString("minCount") + ",");
                str.append("\"minCount\":" + rs.getString("minCount"));
                str.append("},");

            }
            str.setLength(str.length() - 1);
            str.append("]");
            System.out.println(str + "***********************************");

            out.print(str);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
