package com.fsse.ecommerce.api;

import com.fsse.ecommerce.domain.Product;
import com.fsse.ecommerce.domain.dto.response.product.ProductDetailResponseDto;
import com.fsse.ecommerce.domain.dto.response.product.ProductListItemResponseDto;
import com.fsse.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/product")
public class ProductPublicApi {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductListItemResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductListItemResponseDto> dtos = new ArrayList<>();
        for (Product product : products) {
            dtos.add(new ProductListItemResponseDto(product));
        }

        return dtos;
    }

    @GetMapping("/id/{pid}")
    public ProductDetailResponseDto getProductDetailByPid(@PathVariable("pid") Long pid) {
        Product product = productService.getProductByPid(pid);
        if (product != null) {
            return new ProductDetailResponseDto(product);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


}
