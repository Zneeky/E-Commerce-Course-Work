package com.obuvki.rest.Controller;

import com.obuvki.rest.DTO.ProductDTOs.ExportProductDto;
import com.obuvki.rest.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class ProductController {

    private final ProductService productService;
    @GetMapping
    public List<ExportProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
}
