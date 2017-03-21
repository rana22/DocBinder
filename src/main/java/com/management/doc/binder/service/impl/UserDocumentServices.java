/**
 * 
 */
package com.management.doc.binder.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.management.doc.binder.models.UsersDocument;
import com.management.doc.binder.services.UserDocumentRepository;

/**
 * @author ambarrana
 *
 */
@Service
public class UserDocumentServices {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	UserDocumentRepository ursDocRepo;
	
//	@Scheduled(initialDelay = 10000, fixedDelay = 40000)
	public void insertDocument(){
		List<UsersDocument> docToAdd = new ArrayList<UsersDocument>();
		UsersDocument ursDoc = new UsersDocument();
		ursDoc.setDocId(123l);
		ursDoc.setDocName("some name");
		ursDoc.setUserId(12L);
		
		logger.info("inserting user document");
		
		File file = new File("/Users/ambarrana/Desktop/abc.png");
		
		byte[] bFile = new byte[(int) file.length()];
		
		try {
		     FileInputStream fileInputStream = new FileInputStream(file);
		     //convert file into array of bytes
		     fileInputStream.read(bFile);
		     fileInputStream.close();
	        } catch (Exception e) {
		     e.printStackTrace();
	        }
		ursDoc.setImage(bFile);
		docToAdd.add(ursDoc);
		
		ursDocRepo.save(docToAdd);
	}
}
