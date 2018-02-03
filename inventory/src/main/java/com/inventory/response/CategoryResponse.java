package com.inventory.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.inventory.entities.Category;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode( callSuper= false)
@ToString( callSuper = false)
@JsonInclude(value=Include.NON_NULL)
public class CategoryResponse extends BaseResponse {

	private Category category;
	private List<Category> categories;
	public CategoryResponse(HttpStatus status, String message) {
		super(status, message);
	}	
}
