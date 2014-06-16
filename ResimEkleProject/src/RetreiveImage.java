import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RetreiveImage extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
    /* 
    Database connection, database name is test
    */
    String connectionURL = "jdbc:mysql://localhost:3306/test";
    Connection con=null;
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        /* 
        Database connection, database id is root and password is blank
        */
        con=DriverManager.getConnection(connectionURL,"root","");
        Statement st1=con.createStatement();
        /* 
        select the image from the picture table    .
        */
        ResultSet rs1 = st1.executeQuery("select image from picture where id=1");
        String imgLen="";
        if(rs1.next()){
            imgLen = rs1.getString(1);
        } 
        rs1 = st1.executeQuery("select image from picture where id=1");
        
        if(rs1.next()){
            int len = imgLen.length();
            byte [] rb = new byte[len];
            
            /* retrieving image in binery format*/
            
            InputStream readImg = rs1.getBinaryStream(1);
            int index=readImg.read(rb, 0, len); 
            
            System.out.println("index"+index);
            st1.close();
            
            response.reset();
            response.setContentType("image/jpg");
            response.getOutputStream().write(rb,0,len);
            response.getOutputStream().flush(); 
        }
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}