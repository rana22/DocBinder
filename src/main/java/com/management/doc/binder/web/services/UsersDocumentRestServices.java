package com.management.doc.binder.web.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.management.doc.binder.models.UsersDocument;
import com.management.doc.binder.services.UserDocumentRepository;

/**
 * @author ambarrana
 *
 */
@Controller
@RequestMapping("/users/document")
@CrossOrigin(maxAge= 3600, origins= "*")
public class UsersDocumentRestServices {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	UserDocumentRepository ursDocRepo;
	
	@RequestMapping(value="/saveImg", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<List<UsersDocument>> saveDocument(@RequestParam("id") String imgPath){
		logger.info("REST call TO Document ServicesimgPat "+ imgPath);
		
		List<UsersDocument> docToAdd = new ArrayList<UsersDocument>();
		UsersDocument ursDoc = new UsersDocument();
		ursDoc.setDocId(123l);
		ursDoc.setDocName("some name");
		ursDoc.setUserId(12L);	
		
		logger.info("inserting user document");
		
		File file = new File(imgPath);
		byte[] bFile = new byte[(int) file.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				//convert file into array of bytes
				fileInputStream.read(bFile);
				fileInputStream.close();
	        } catch (Exception e) {
	        	logger.debug("Exception is due to {}", e);
	        }
		ursDoc.setImage(bFile);
		docToAdd.add(ursDoc);
		ursDocRepo.save(docToAdd);
		
		return new ResponseEntity<List<UsersDocument>>(docToAdd, HttpStatus.OK);
		}
	
	@RequestMapping(value="/getAllDoc", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<List<UsersDocument>> getDocument() throws Exception{
		logger.info("Getting Document for user");
		
		List<UsersDocument> getAllDoc = new ArrayList<UsersDocument>();
		List<UsersDocument> getLastDoc =  new ArrayList<UsersDocument>(); 
		getAllDoc = ursDocRepo.findAll();
		int arraySize = getAllDoc.size();
		
//		getAllDoc.clear();
		UsersDocument ursLastDoc = new UsersDocument();
		ursLastDoc = getAllDoc.get(arraySize-1);
		
		InputStream in = new ByteArrayInputStream(ursLastDoc.getImage());
		BufferedImage bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "jpg", new File(
				"/Users/ambarrana/Desktop/test123.jpg"));

		getLastDoc.add(ursLastDoc);
		
		
		return new ResponseEntity<List<UsersDocument>>(getLastDoc, HttpStatus.OK);
		}
}
