package com.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.productmanagement.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
