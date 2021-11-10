package com.fsse.ecommerce.domain.dto.response.product;

import com.fsse.ecommerce.domain.Product;

import java.math.BigDecimal;

public class ProductListItemResponseDto {
    private Long pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Boolean hasStock;

    public ProductListItemResponseDto(Product product) {
        this.pid = product.getPid();
        this.name = product.getName();
        this.imageUrl = product.getImageUrl();
        this.price = product.getPrice();
        this.hasStock = product.getStock() > 0;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getHasStock() {
        return hasStock;
    }

    public void setHasStock(Boolean hasStock) {
        this.hasStock = hasStock;
    }

    @Override
    public String toString() {
        return "ProductListItemResponseDto{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", hasStock=" + hasStock +
                '}';
    }
}
