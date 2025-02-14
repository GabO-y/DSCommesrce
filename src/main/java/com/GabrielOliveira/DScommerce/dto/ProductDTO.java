package com.GabrielOliveira.DScommerce.dto;

import com.GabrielOliveira.DScommerce.entities.Category;
import com.GabrielOliveira.DScommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {

    private Long id;
    @NotBlank
    @Size(min = 3, max = 80)
    private String name;
    @NotBlank()
    @Size(min = 10)
    private String description;
    @Positive()
    private Double price;
    private String imgUrl;
    private Set<Category> categories = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;

    }

    public ProductDTO(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.price = p.getPrice();
        this.imgUrl = p.getImgUrl();
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
