package com.admin;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DuyuruDatabase;
import com.database.HaberDatabase;

/**
 * Servlet implementation class DuyuruServlet
 */
@WebServlet("/admin/duyuruekleservlet")
public class DuyuruEkleServlet extends HttpServlet implements ServletContextListener{
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "images";
    private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baslik = null;
		String icerik = null;
		String imageName = null;
	    if (!ServletFileUpload.isMultipartContent(request)) {
	            PrintWriter writer = response.getWriter();
	            writer.println("Request does not contain upload data");
	            writer.flush();
	            return;
	        }
	         
	        // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(THRESHOLD_SIZE);
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	         
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	         
	        // constructs the directory path to store upload file
	        @SuppressWarnings("deprecation")
			String uploadPath = "/home/alaattin/webworkapp/DernekSitesi/images";
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	         
	        try {
	            // parses the request's content to extract file data
	            List formItems = upload.parseRequest(request);
	            Iterator iter = formItems.iterator();
	             
	            // iterates over form's fields
	            while (iter.hasNext()) {
	            	FileItem item = (FileItem) iter.next();
	                // processes only fields that are not form fields
	                if (!item.isFormField()) {
	                	if(item.getSize() != 0){
		                	imageName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		                    String filePath = uploadPath + File.separator + imageName;
		                	File storeFile = new File(filePath);
		                    // saves the file on disk
	                        item.write(storeFile);
	                	}
	                }
	                else {
	                	if(item.getFieldName().equals("baslik")){
	                		baslik = item.getString();
	                	}
	                	else if(item.getFieldName().equals("icerik")){
	                		icerik = item.getString();
	                	}
	                }
	            }
	            DuyuruDatabase db= new DuyuruDatabase();
	    		try {
	    			db.duyuruEkleme(baslik, icerik,imageName);
	    		    request.setAttribute("message", "Duyuru basariyla eklendi.");
	    	    } catch (ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    	    	request.setAttribute("message", "Duyuru eklemede hata.");
		        	e.printStackTrace();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
		        	e.printStackTrace();
	    		}
	    		
	        } catch (Exception ex) {
	            request.setAttribute("message", "Hata bulundu: " + ex.getMessage());
	        }
	        request.getRequestDispatcher("/admin/duyuru/ekle.jsp").forward(request, response);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}