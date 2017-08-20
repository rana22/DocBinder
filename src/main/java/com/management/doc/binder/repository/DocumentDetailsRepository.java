/**
 * 
 */
package com.management.doc.binder.repository;
import com.management.doc.binder.models.DocumentDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author ambarrana
 *
 */
public interface DocumentDetailsRepository extends JpaRepository<DocumentDetails, Long>{
	List<DocumentDetails> findAll();
	DocumentDetails findById(long id);
}
