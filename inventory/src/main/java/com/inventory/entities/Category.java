package com.inventory.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString( callSuper = false)
@EqualsAndHashCode( callSuper = false)
@Table( uniqueConstraints={
		@UniqueConstraint(columnNames={"category_name"})
})
public class Category extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	
	@Column( name = "category_name")
	private String categoryName;
	
	private String shortDescription;
	private String longDescription;
	
	private String imageLocation;
}
