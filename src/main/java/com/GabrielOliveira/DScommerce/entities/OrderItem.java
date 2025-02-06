package com.GabrielOliveira.DScommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_orderItem")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private double price;

    public OrderItem(){}

    public OrderItem(double price, Integer quantity, Order order, Product product) {
        this.price = price;
        this.quantity = quantity;
        id.setOrder(order);
        id.setProduct(product);
    }
    
    public Order getOrder(){
        return id.getOrder();
    }
    
    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    


}
