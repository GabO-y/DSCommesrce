package com.GabrielOliveira.DScommerce.dto;

import com.GabrielOliveira.DScommerce.entities.Category;
import com.GabrielOliveira.DScommerce.entities.Product;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Set<Category> categories = new HashSet<>();

    public ProductDTO(){}

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categories = categories;
    }

    public ProductDTO(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.price = p.getPrice();
        this.imgUrl = p.getImgUrl();
        this.categories = p.getCategories();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
