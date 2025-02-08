package com.GabrielOliveira.DScommerce.Services;

import com.GabrielOliveira.DScommerce.Repository.CategoryRepository;
import com.GabrielOliveira.DScommerce.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryDTO findById(Long id){
        return new CategoryDTO(repository.findById(id).orElseThrow());
    }

}
