package com.GabrielOliveira.DScommerce.dto;

import com.GabrielOliveira.DScommerce.entities.Category;


public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(){}

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
