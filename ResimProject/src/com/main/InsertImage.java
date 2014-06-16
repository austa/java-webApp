package com.main;
import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/insert")
public class InsertImage extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
        
        PrintWriter pw = response.getWriter();
        /* 
        Database connection, database name is test
        */
        String connectionURL = "jdbc:mysql://localhost:3306/resim";
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* 
            Database connection, database id is root and password is blank
            */
            con = DriverManager.getConnection(connectionURL, "root", "aletbaba53");
            PreparedStatement ps = con.prepareStatement("INSERT INTO image(resim_url) VALUES(?)");
            /* 
            inserting image in  pictures table*/
            File file = new File("./image/pic.jpg");
            
            FileInputStream fs = new FileInputStream(file);
                        
            ps.setBinaryStream(1,fs,fs.available());
            int i = ps.executeUpdate();
            

            if(i!=0){
              pw.println("image inserted successfully");
            }
            else{
              pw.println("problem in image insertion");
            } 
        } 
        catch (Exception e){
        System.out.println(e);
        }
  }
}