package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mzv
 */
public class Login extends HttpServlet {

    Connection con;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email=req.getParameter("email");
            String pwd=req.getParameter("pwd");
            
            
            PreparedStatement stmnt = con.prepareStatement("SELECT * FROM InventorySystem.user where email=? and password=?");
            stmnt.setString(1, email);
            stmnt.setString(2, pwd);
            ResultSet rs = stmnt.executeQuery();
            if(rs.next()){
                resp.sendRedirect("billing.jsp");
            }else{
                PrintWriter out=resp.getWriter();
                out.println("<h1 style=\"color:red; text-align: center;\">Email or password is incorrect. Please try again!</h1>");
                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                rd.include(req, resp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
