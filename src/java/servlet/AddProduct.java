package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author mzv
 */
public class AddProduct extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {

        } catch (Exception e) {
            printStackTrace(e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            String name = req.getParameter("product");
            String category = req.getParameter("category");
            float costPrice = Float.valueOf(req.getParameter("costPrice"));
            float profitPercentage = Float.valueOf(req.getParameter("profitPercentage"));
            float profit = (profitPercentage * costPrice) / 100;
            float sellingPrice = costPrice + profit;
            float count = Float.valueOf(req.getParameter("count"));
            float minCount = Float.valueOf(req.getParameter("minCount"));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `InventorySystem`.`product` VALUES (null,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, category);
            pstmt.setFloat(3, costPrice);
            pstmt.setFloat(4, profitPercentage);
            pstmt.setFloat(5, sellingPrice);
            pstmt.setFloat(6, profit);
            pstmt.setFloat(7, count);
            pstmt.setFloat(8, minCount);
            pstmt.setFloat(9, count);
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            resp.sendRedirect("puchasing.jsp");

        } catch (Exception e) {
            printStackTrace(e);
        }
    }

    @Override
    public void destroy() {
    }

}
