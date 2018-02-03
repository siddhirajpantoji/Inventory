package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(nativeQuery = true, value = "Select count(*) from category where category_name=:categoryName")
	Long getCountByCategoryName(@Param("categoryName") String categoryName);
}
