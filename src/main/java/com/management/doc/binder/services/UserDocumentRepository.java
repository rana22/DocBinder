/**
 * 
 */
package com.management.doc.binder.services;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.management.doc.binder.models.UsersDocument;

/**
 * @author ambarrana
 *
 */
public interface UserDocumentRepository extends JpaRepository<UsersDocument, Long>{
	
	List<UsersDocument> findAll();
}
