package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javaFiles.SendMailTo;

/**
 *
 * @author mzv
 */
public class SendMail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String to = "mailTo@gmail.com";
            String subject = "Purchase notification";
            String user = "userMail@gmail.com";
            String pass = "userPassword";

            String message = "AvailableCount        MinimumCount          ProductName\n";

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from product where count< minCount;");
            while (rs.next()) {
                message = message.concat("\n");
                message = message.concat(rs.getString("count")+"\t\t\t\t"+rs.getString("minCount")+"\t\t\t\t"+rs.getString("name"));
                message = message.concat("\n");
            }

            SendMailTo.send(to, subject, message, user, pass);
//            out.println("Mail send successfully");
            response.sendRedirect("puchasing.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
