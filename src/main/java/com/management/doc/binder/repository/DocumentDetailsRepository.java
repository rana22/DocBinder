/**
 * 
 */
package com.management.doc.binder.repository;
import com.management.doc.binder.models.DocumentDetails;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * @author ambarrana
 *
 */
public interface DocumentDetailsRepository extends JpaRepository<DocumentDetails, Long>{
	List<DocumentDetails> findAll();
	DocumentDetails findById(long id);
	
	@Query(value = "SELECT * FROM document_details where to_tsvector(document_details.title) @@ to_tsquery(:query)", nativeQuery = true)
	List <DocumentDetails> findDocumentByQuery(@Param("query") String query);
	
}
