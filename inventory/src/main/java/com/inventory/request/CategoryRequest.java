package com.inventory.request;

import java.util.HashMap;

import javax.annotation.Nonnegative;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@ApiModel(description="This is Request for Creating as well as updating property ")
public class CategoryRequest {
	
	@Nonnegative
	private Long categoryId;
	
	@ApiModelProperty(required = true, value="This is unique column name of ")
	private String categoryName;
	private String shortDescription;
	private String longDescription;
	private String imageLocation;
	private HashMap<String,String> specs;
}
