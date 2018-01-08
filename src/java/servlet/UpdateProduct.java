/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class UpdateProduct extends HttpServlet {

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

            int productId = Integer.parseInt(req.getParameter("productId"));
            float count = Float.valueOf(req.getParameter("count"));
            float minCount = Float.valueOf(req.getParameter("minCount"));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("UPDATE `InventorySystem`.`product` SET `count`=`count`+?, `minCount`=?, `originalCount`=`originalCount`+? WHERE `id`=?");
            String str = "";

            pstmt.setFloat(1, count);
            pstmt.setFloat(2, minCount);
            pstmt.setFloat(3, count);
            pstmt.setInt(4, productId);
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
