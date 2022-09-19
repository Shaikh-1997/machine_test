package com.api.machine_test.Service;

import com.api.machine_test.model.Categories_Model;
import com.api.machine_test.model.Products_Model;

import java.sql.*;

public class Prod_Service {
    public boolean checklCategories(Categories_Model categories_model, Products_Model products_model) throws SQLException {
       boolean a=true;
       int check_id= products_model.getCategory_id();
        Connection con = null;


        Statement stmnt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn", "root", "lenovo");
            stmnt = con.createStatement();
            ResultSet rs;
            String query_result = "  SELECT category_id categories from  where category_id='"+check_id+"';";
            rs = stmnt.executeQuery(query_result);
            while(rs.next()){
                if(rs.getInt("category_id")==check_id){
                    String insert_query = "insert into products (category_id,product_name,amount)value ('" +products_model.getCategory_id() + "','" + products_model.getProduct_name()+ "','" + products_model.getAmount() + "');";

                    stmnt = con.prepareStatement(insert_query);
                  int   i = stmnt.executeUpdate(insert_query);
                    return a;

                }
                else {
                   return a=false;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {

            con.close();
             stmnt.close();


        }
        return a;
    }
}

