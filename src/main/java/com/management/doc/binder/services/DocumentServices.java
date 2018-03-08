/**
 * 
 */
package com.management.doc.binder.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.management.doc.binder.models.DocumentDetails;
import com.management.doc.binder.repository.DocumentDetailsRepository;
import com.management.doc.binder.services.util.CategoryUtil;
import com.management.doc.binder.services.util.ImageUtilService;

/**
 * @author ambarrana
 *
 */
@Service
public class DocumentServices {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	private DocumentDetailsRepository documentDetailsRepository;
	
	ImageUtilService imgService = new ImageUtilService();
	
	public DocumentDetails saveDocument(MultipartFile file, HttpServletRequest req){
		DocumentDetails docDetails = new DocumentDetails();
		try{
			docDetails.setTitle(req.getParameter("title"));
			docDetails.setDeleted(false);
			docDetails.setDescription(req.getParameter("description"));
			docDetails.setDocSize(file.getSize());
			docDetails.setDocId(UUID.randomUUID().toString());
			docDetails.setCategory(CategoryUtil.getCategoryType(req.getParameter("category")).toString());
			docDetails.getDocuments().setDocId(docDetails.getDocId());
			docDetails.getDocuments().setImage(file.getBytes());
			docDetails.setThumbnail(imgService.getThumbnail(file.getBytes()));
			documentDetailsRepository.saveAndFlush(docDetails);
			
			logger.info("Document is inserted successfully!!");
			
		}catch(RuntimeException | IOException e){
			logger.warn("Error saving the documents {}", e);
		}
		
		return docDetails;
	}
	
	
	public List<DocumentDetails> returnAllDocuments() {
		List<DocumentDetails> allDocuments = new ArrayList<DocumentDetails>();
		
		try{
			 allDocuments = documentDetailsRepository.findAll();
		}catch (RuntimeException e){
			logger.warn("Exception while saving document!!");
		}
		
		return allDocuments;
	}
	
	public List<DocumentDetails> getDocumentByQuery(String query){
	
		logger.info("Query param to search string is {}", query);
		
		List<DocumentDetails> documents = new ArrayList<DocumentDetails>();
		try{
				documents= documentDetailsRepository.findDocumentByQuery(query);
		}catch (RuntimeException e){
			logger.warn(e.toString());
			logger.warn("Exception while retriving document!!");
		}
		
		return documents;
	}
}
