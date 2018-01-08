package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mzv
 */
public class SaveSales extends HttpServlet {

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
        String strInvoiceItem = req.getParameter("invoiceItem");
        String strTotalBillAmount = req.getParameter("total");
        String totalProfit = req.getParameter("totalProfit");
        String strCustomer = req.getParameter("customer");
//        System.out.println("strInvoiceItem:" + strInvoiceItem);
//        System.out.println("strTotalBillAmount:" + strTotalBillAmount);
//        System.out.println("strCustomer:" + strCustomer);
//        System.out.println("totalProfit:" + totalProfit);

        JSONParser parser = new JSONParser();
        try {

//Insert invoice data into sales table
            Object objCustomer = parser.parse(strCustomer);
            JSONArray customerJsonArray = (JSONArray) objCustomer;
            JSONObject customer = (JSONObject) customerJsonArray.get(0);

            String custName = (String) customer.get("name");
            String place = (String) customer.get("place");
            String mobile = (String) customer.get("mobile");
            String email = (String) customer.get("email");

            con.setAutoCommit(false);

            PreparedStatement querySales = con.prepareStatement("INSERT INTO `InventorySystem`.`sales` VALUES (null,?, ?, ?, ?, ?,now(),?)");
            querySales.setString(1, custName);
            querySales.setString(2, place);
            querySales.setString(3, mobile);
            querySales.setString(4, email);
            querySales.setString(5, strTotalBillAmount);
            querySales.setString(6, totalProfit);
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + querySales);
            int n = querySales.executeUpdate();
            if (n == 1) {
                Statement stmnt = con.createStatement();
                ResultSet rs = stmnt.executeQuery("select last_insert_id() as last_id from sales");
                rs.next();
                String saleId = rs.getString("last_id");

//Insert invoice row details to sales_details table
                Object obj = parser.parse(strInvoiceItem);
                JSONArray invoiceItem = (JSONArray) obj;
//                System.out.println("Number of item" + invoiceItem.size());

                for (int i = 0; i < invoiceItem.size(); i++) {
//                    System.out.println("row " + (i + 1) + invoiceItem.get(i));
//                    System.out.println(i + 1 + " Details");
                    JSONObject item = (JSONObject) invoiceItem.get(i);

                    String productName = (String) item.get("name");
                    long quantity = (long) item.get("quantity");
                    Object price = item.get("sellingPrice");
                    Object sub_total =  item.get("sub_total");
                    long prodId = (long) item.get("id");
                    Object profit = item.get("sub_profit");
                    long remainingCount = (long) item.get("remainingCount");
                    long prodID = (long) item.get("id");

//                    System.out.println(productName);
//                    System.out.println(quantity);
//                    System.out.println(price);
//                    System.out.println(sub_total);
//Updating sales_details table
                    PreparedStatement pstmntSalesDetails = con.prepareStatement("INSERT INTO `InventorySystem`.`sales_details` VALUES (null,?,?,?,?,?,?,?)");
                    pstmntSalesDetails.setString(1, saleId);
                    pstmntSalesDetails.setLong(2, prodId);
                    pstmntSalesDetails.setString(3, productName);
                    pstmntSalesDetails.setObject(4, price);
                    pstmntSalesDetails.setFloat(5, quantity);
                    pstmntSalesDetails.setObject(6, sub_total);
                    pstmntSalesDetails.setObject(7, profit);
                    pstmntSalesDetails.executeUpdate();

//Updating products table
                    long updatedCount = remainingCount - quantity;
                    PreparedStatement pstmntProducts = con.prepareStatement("UPDATE `InventorySystem`.`product` SET `count`=" + updatedCount + " WHERE `id`=" + prodID + ";");
//                    System.out.println("pstmntProducts:"+pstmntProducts);
                    pstmntProducts.executeUpdate();

                }
            }
            con.commit();

            resp.sendRedirect("billing.jsp");
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(UpdateSles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
