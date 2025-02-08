package com.GabrielOliveira.DScommerce.Controllers;

import com.GabrielOliveira.DScommerce.Repository.ProductRepository;
import com.GabrielOliveira.DScommerce.Services.ProductService;
import com.GabrielOliveira.DScommerce.dto.ProductDTO;
import com.GabrielOliveira.DScommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController{

    @Autowired
   private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

}
