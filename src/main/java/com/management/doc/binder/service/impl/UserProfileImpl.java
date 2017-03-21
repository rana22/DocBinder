/**
 * 
 */
package com.management.doc.binder.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.management.doc.binder.models.UserProfiles;
import com.management.doc.binder.services.UserProfileRepository;


/**
 * @author ambarrana
 *
 */
@Service
public class UserProfileImpl {
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	UserProfileRepository userProfileRepository;
	
	//
	
	List<UserProfiles> usrList = new ArrayList<UserProfiles>();
	
//	@Scheduled(initialDelay = 10000, fixedDelay = 40000)
	public void getAllUser(){
		log.debug("getting all the users = ===" );
		
		List<UserProfiles> userProfile = userProfileRepository.findAll();
		
//		userProfile.stream().forEach(s->log.info("name of the users = " + s.getFirstName()));
		
//		userProfileRepository.deleteAllInBatch();
		
		log.info("total no of user = " + userProfile.size());
		
		UserProfiles urs = new UserProfiles();
		urs.setFirstName("ambar");
		urs.setLastName("Rana");
		usrList.add(urs);
		userProfileRepository.save(usrList);
		
		long userId = 1;
		UserProfiles ursProfile = userProfileRepository.findById(userId);
		
//		log.info("the user is = " + ursProfile.getFirstName());
			
	}
	}
	