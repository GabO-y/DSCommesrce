package com.GabrielOliveira.DScommerce.Services;

import com.GabrielOliveira.DScommerce.Repository.ProductRepository;
import com.GabrielOliveira.DScommerce.Services.Exception.DataBaseException;
import com.GabrielOliveira.DScommerce.Services.Exception.ResourceNotFoundException;
import com.GabrielOliveira.DScommerce.dto.ProductDTO;
import com.GabrielOliveira.DScommerce.entities.Product;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {

        return new ProductDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado")));
    }


    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable page) {
        return repository.findAll(page).map(x -> new ProductDTO(x));
    }

    public ProductDTO insert(ProductDTO dto) {
        return new ProductDTO(repository.save(new Product(dto)));
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {


        try {

            Product entity = repository.getReferenceById(id);

            dtoToEntity(dto, entity);

            repository.save(entity);

            return new ProductDTO(entity);

        } catch (ResourceNotFoundException e) {

            throw new ResourceNotFoundException("Recurso nao encontrado");

        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso nao entrado");
        }

        try {

            repository.deleteById(id);

        } catch (Exception e) {

            throw new DataBaseException("Falha de integridade referencial");

        }

    }

    @Transactional
    public List<ProductDTO> findByPriceLessThan(Double price) {
        return repository.findByPriceLessThan(price).stream().map(x -> new ProductDTO(x)).toList();
    }

    private void dtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }


}
