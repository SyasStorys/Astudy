package kr.astory.front.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	
	private static final String ABS_PATH = "D:\\Programing\\01.Dev\\eclipse\\workspace\\front\\src\\main\\webapp\\resources\\img\\";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		//get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/img/");
		
		logger.info(REAL_PATH);
		
		//to make sure all the directory exists
		//please create the directories
		if(!new File(ABS_PATH).exists()) {
			//create the directories
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			//create the directories
			new File(REAL_PATH).mkdirs();
		}
		
		try{
			//server upload
			file.transferTo(new File (REAL_PATH + code +  ".jpg"));
			//project directory upload
			file.transferTo(new File (ABS_PATH + code +  ".jpg"));
		}
		catch(IOException ex){
			
		}
		
		
	} 
	
	
	
	
			
}
