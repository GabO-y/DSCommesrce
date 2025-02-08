package com.GabrielOliveira.DScommerce.Repository;

import com.GabrielOliveira.DScommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
