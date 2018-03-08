/**
 * 
 */
package com.management.doc.binder.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import com.management.doc.binder.models.DocumentDetails;
import com.management.doc.binder.models.Documents;
import com.management.doc.binder.repository.DocumentDetailsRepository;
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
	
	@Inject
	private DocumentDetailsRepository documentDetailsRepository;
	
	@RequestMapping(value="/saveDocument", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<DocumentDetails> saveDocument (@RequestBody @RequestParam("file") MultipartFile file, 
			HttpServletRequest req) throws Exception{
//		DocumentDetails document = new DocumentDetails();
		try{
			documentServices.saveDocument(file, req);
		}catch (RuntimeException e){
			logger.warn("Exception while saving document!!");
		}
		
		return null;
	}
	
	@RequestMapping(value="/getAllDoc", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<List<DocumentDetails>> getUserDocuments () throws Exception{
		
		List<DocumentDetails> documentList = documentServices.returnAllDocuments();
		
		return ResponseEntity.accepted().body(documentList);
	}
	
	
	@RequestMapping(value="/query/getDocuments", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<List<DocumentDetails>> getDocumentsByQuery (@QueryParam("query") String query) throws Exception{
		List<DocumentDetails> documentList = documentServices.getDocumentByQuery(query);
		
		return ResponseEntity.accepted().body(documentList);
	}
	
	
	
	
}
