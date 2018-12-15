package com.inventory.entities;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

	private Date createdTs;
	
	private Date modifiedTs;
	
	@PrePersist
	void onCerate()
	{
		this.createdTs = new Date();
	}
	
	@PreUpdate
	void onUpdate()
	{
		this.modifiedTs = new Date();
	}
}
