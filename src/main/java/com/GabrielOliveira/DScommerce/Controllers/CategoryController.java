package com.GabrielOliveira.DScommerce.Controllers;

import com.GabrielOliveira.DScommerce.Services.CategoryService;
import com.GabrielOliveira.DScommerce.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{id}")
    public CategoryDTO findById(@PathVariable Long id){
        return service.findById(id);
    }


}
