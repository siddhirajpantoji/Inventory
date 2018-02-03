package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.constants.MessageConstants;
import com.inventory.constants.RESTEndPointMapper;
import com.inventory.entities.Category;
import com.inventory.repository.CategoryRepository;
import com.inventory.request.CategoryRequest;
import com.inventory.response.CategoryResponse;

@RestController
@RequestMapping(produces = "application/json", value = RESTEndPointMapper.CATEGORY)
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
		if (categoryRepo.getCountByCategoryName(categoryRequest.getCategoryName()) > 0) {
			return new ResponseEntity<CategoryResponse>(
					new CategoryResponse(HttpStatus.BAD_REQUEST, MessageConstants.CATEGORY_ALREADY_EXISTS),
					HttpStatus.BAD_REQUEST);
		}
		// Proceed here to create Record
		Category category = new Category();
		BeanUtils.copyProperties(categoryRequest, category);
		category = categoryRepo.save(category);
		return new ResponseEntity<CategoryResponse>(new CategoryResponse(category), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<CategoryResponse> getAllCategories() {
		List<Category> categories = categoryRepo.findAll();
		return new ResponseEntity<CategoryResponse>(new CategoryResponse(categories), HttpStatus.OK);
	}

	@RequestMapping(value = RESTEndPointMapper.SINGLE_CATEGORY, method = RequestMethod.GET)
	public ResponseEntity<CategoryResponse> getAllCategory(@PathVariable @NotNull(message="") Long categoryId) {
		List<Category> categories = categoryRepo.findAll();
		return new ResponseEntity<CategoryResponse>(new CategoryResponse(categories), HttpStatus.OK);
	}
}
