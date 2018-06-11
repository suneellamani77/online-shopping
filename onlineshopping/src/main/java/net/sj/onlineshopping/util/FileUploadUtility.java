package net.sj.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH="E:/Online/online-shopping/onlineshopping/src/main/webapp/assets/images/";
	private static String REAL_PATH="";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		
		//to make sure all directories should exist
		//create new directory
		
		if(! new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();
		}
		
		if(! new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			//server upload
			file.transferTo(new File(REAL_PATH +code+".jpg"));
			
			//directory upload
			file.transferTo(new File(ABS_PATH +code+".jpg"));
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
