/**
 * 
 */
package com.management.doc.binder.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * @author ambarrana
 *
 */
@Entity
public class DocumentDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4665420373371745526L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="uploaded_date")
	private Date uploadedDate;
	
	@Column(name="doc_size")
	private long docSize;
	
	@Column(name="doc_type")
	private String docType;
	
	@Column(name="doc_id")
	private String docId;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@Column(name="category")
	private String category;
	
	@Column(name="thumbnail")
	private byte[] thumbnail;
	
	@OneToOne(mappedBy ="documentdetails", optional= false, cascade = CascadeType.ALL)
	private Documents documents;
	
	public DocumentDetails (){
		this.documents = new Documents();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUploadDate() {
		return uploadedDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadedDate = uploadDate;
	}

	public long getDocSize() {
		return docSize;
	}

	public void setDocSize(long docSize) {
		this.docSize = docSize;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Documents getDocuments() {
		return documents;
	}

	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
}
