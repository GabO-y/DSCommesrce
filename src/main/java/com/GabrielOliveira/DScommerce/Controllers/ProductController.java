package com.GabrielOliveira.DScommerce.Controllers;

import com.GabrielOliveira.DScommerce.Services.ProductService;
import com.GabrielOliveira.DScommerce.dto.ProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable page) {
        return service.findAll(page);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {

        dto = service.insert(dto);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri()).body(dto);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {

        return ResponseEntity.ok(service.update(id, dto));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping(value = "/below /{price}")
    public List<ProductDTO> findByPriceLessThan(@PathVariable Double price) {
        return service.findByPriceLessThan(price);
    }

}
