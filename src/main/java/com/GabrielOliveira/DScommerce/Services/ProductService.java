package com.GabrielOliveira.DScommerce.Services;

import com.GabrielOliveira.DScommerce.Repository.ProductRepository;
import com.GabrielOliveira.DScommerce.dto.ProductDTO;
import com.GabrielOliveira.DScommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){

        return new ProductDTO(repository.findById(id).orElseThrow());
    }


    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable page){
        return repository.findAll(page).map(x -> new ProductDTO(x));
    }

    public ProductDTO insert(ProductDTO dto){
        return new ProductDTO(repository.save(new Product(dto)));
    }

}
