/**
 * 
 */
package com.management.doc.binder.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import com.management.doc.binder.models.DocumentDetails;
import com.management.doc.binder.services.DocumentServices;

/**
 * @author ambarrana
 *
 */
@Controller
@RequestMapping("/users/document")
@CrossOrigin(maxAge= 3600, origins= "*")
public class DocumentController {
	
	private final Logger logger= LoggerFactory.getLogger(getClass());
	
	@Inject
	private DocumentServices documentServices;
	
	@RequestMapping(value="/saveDocument", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<DocumentDetails> saveDocument (@RequestBody @RequestParam("file") MultipartFile file, 
			HttpServletRequest req) throws Exception{
		DocumentDetails document = new DocumentDetails();
		try{
			documentServices.saveDocument(file, req);
		}catch (RuntimeException e){
			logger.warn("Exception while saving document!!");
		}
		
		return null;
	}
	
}
