/**
 * 
 */
package com.management.doc.binder.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.doc.binder.models.UserProfiles;

/**
 * @author ambarrana
 *
 */
public interface UserProfileRepository extends JpaRepository<UserProfiles, Long>{
	
	//get all the rows from table 
	List<UserProfiles> findAll();
	
	//find the user by id
	UserProfiles findById(Long Id);
	
	List<UserProfiles> findByUserName(String userName);
	
}
