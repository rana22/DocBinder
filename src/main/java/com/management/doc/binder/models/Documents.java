/**
 * 
 */
package com.management.doc.binder.models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author ambarrana
 *
 */
@Entity
@Table(name="documents")
public class Documents implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7828494267105408313L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	private String docId;
	
	private byte[] image;
	
	@OneToOne(fetch = FetchType.LAZY)
	private DocumentDetails documentdetails;
	
	public Documents(){}
	public Documents(byte[] img,String docId){
		this.image = img;
		this.docId = docId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public DocumentDetails getDocumentdetails() {
		return documentdetails;
	}
	public void setDocumentdetails(DocumentDetails documentdetails) {
		this.documentdetails = documentdetails;
	}
	
}
