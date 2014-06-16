import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/uploadServlet")
public class InsertImage extends HttpServlet{
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
    	InputStream inputStream = null;
    	Part filePart = request.getPart("photo");
    	response.getWriter().write("aa");
    	if (filePart != null) {
    		
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
    	
        PrintWriter pw = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost:3306/resim";
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* 
            Database connection, database id is root and password is blank
            */
            con = DriverManager.getConnection(connectionURL, "root", "aletbaba53");
            PreparedStatement ps = con.prepareStatement("INSERT INTO image(image) VALUES(?)");
            /* 
            inserting image in  pictures table*/
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
            	ps.setBlob(3, inputStream);
            }
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