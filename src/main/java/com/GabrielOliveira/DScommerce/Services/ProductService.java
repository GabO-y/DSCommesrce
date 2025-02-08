package com.GabrielOliveira.DScommerce.Services;

import com.GabrielOliveira.DScommerce.Repository.ProductRepository;
import com.GabrielOliveira.DScommerce.dto.ProductDTO;
import com.GabrielOliveira.DScommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){

        return new ProductDTO(repository.findById(id).orElseThrow());
    }

}
