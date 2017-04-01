/**
 * 
 */
package com.management.doc.binder.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ambarrana
 *
 */
@Entity
@Table(name="users_document")
public class UsersDocument implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 198719119786339355L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
    private Long id;
	
	@Column(name="user_id")
	private long userId; 
	
	@Column(name ="doc_name")
	private String docName;
	
	@Column(name="doc_id")
	private long docId;
	
	@Column(name="doc_size")
	private long docSize;
	
	@Column(name="doc_type")
	private String docType;
	
	@Column(name="short_desc")
	private String shortDesc;
	
	@Column(name="create_date")
	private Timestamp createDate;
	
	@Column(name="update_date")
	private Timestamp updateDate;
	
	@Column(name="doc_category")
	private String docCategory;
	
	@Column(name="doc_categoryid")
	private int docCategoryId;
	
	@Column(name="image")
	private byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getDocCategory() {
		return docCategory;
	}

	public void setDocCategory(String docCategory) {
		this.docCategory = docCategory;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public int getDocCategoryId() {
		return docCategoryId;
	}

	public void setDocCategoryId(int docCategoryId) {
		this.docCategoryId = docCategoryId;
	}
	
	
}
