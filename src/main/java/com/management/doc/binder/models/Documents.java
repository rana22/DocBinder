/**
 * 
 */
package com.management.doc.binder.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name="id")
    private Long id;
	
	@Column(name="image")
	private byte[] image;
	
	@Column(name="parts")
	private Integer parts;
	
	@Column(name="delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getParts() {
		return parts;
	}

	public void setParts(Integer parts) {
		this.parts = parts;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
