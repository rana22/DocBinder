package com.management.doc.binder.web.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import com.management.doc.binder.models.UsersDocument;
import com.management.doc.binder.service.impl.Category;
import com.management.doc.binder.service.impl.UserDocumentServices;

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
	UserDocumentServices usrDocService;
	
	
	@RequestMapping(value="/saveImg", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<List<UsersDocument>> saveDocument(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws Exception{
		
		logger.info("Original file Name ==== {}", file.getOriginalFilename());
		
		String fileName = req.getParameter("name");
		long contentLength = file.getSize();
		String contentType = file.getContentType();
		byte [] byteArr = file.getBytes();
		String category = req.getParameter("category");
		String shortDesc = req.getParameter("description");
		Category categoryType= Category.EDUCATION.BACHELOR;
		
		List<UsersDocument> docToAdd = new ArrayList<UsersDocument>();
		UsersDocument ursDoc = new UsersDocument();
		ursDoc.setDocId(123l);
		ursDoc.setDocName(fileName);
		ursDoc.setUserId(12L);
		ursDoc.setImage(byteArr);
		ursDoc.setDocType(contentType);
		ursDoc.setDocSize(contentLength);
		ursDoc.setDocCategory(categoryType.toString());
        ursDoc.setShortDesc(shortDesc);
        
		logger.info("inserting user document");
		
//		BufferedImage originalImage =
//                ImageIO.read(new File(imgPath));
//
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageIO.write(originalImage, "png", baos);
//		baos.flush();
//		byte[] imageInByte = baos.toByteArray();
//		baos.close();
		
//		ursDoc.setImage(imageInByte);
//		docToAdd.add(ursDoc);
		docToAdd.add(ursDoc);
		usrDocService.save(docToAdd);
		
		return new ResponseEntity<List<UsersDocument>>(docToAdd, HttpStatus.OK);
		}
	
	@RequestMapping(value="/getAllDoc", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<List<UsersDocument>> getDocument() throws Exception{
		logger.info("Getting Document for user");
		
		List<UsersDocument> getLastDoc =  new ArrayList<UsersDocument>(); 
		List<UsersDocument> getAllDoc = usrDocService.findAll();
		int arraySize = getAllDoc.size();
		
		UsersDocument ursLastDoc = new UsersDocument();
		ursLastDoc = getAllDoc.get(arraySize-1);
		
		InputStream in = new ByteArrayInputStream(ursLastDoc.getImage());
		
		logger.info("convert image {}", in);
		
		BufferedImage bImageFromConvert = ImageIO.read(in);
		ImageIO.write(bImageFromConvert, "jpg", new File(
				"C:/Users/Niraj/Pictures/images/Capture.PNG"));
		getLastDoc.add(ursLastDoc);
		
		return new ResponseEntity<List<UsersDocument>>(getLastDoc, HttpStatus.OK);
		}
}
