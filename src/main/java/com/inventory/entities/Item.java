package com.inventory.entities;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.Mapping;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode( callSuper = false)
@NoArgsConstructor
public class Item extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	
	@Column( name = "item_name")
	private String itemName;
	
	private String shortDescription;
	private String longDescription;
	
	private String imageLocation;

	
	private HashMap<String,String> specs;

	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
}
