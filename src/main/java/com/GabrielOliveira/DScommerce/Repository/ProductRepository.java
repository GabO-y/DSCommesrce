package com.GabrielOliveira.DScommerce.Repository;

import com.GabrielOliveira.DScommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
