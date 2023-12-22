package com.obuvki.rest.services;

import com.obuvki.rest.DTO.ProductDTOs.ExportProductDto;
import com.obuvki.rest.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    List<ExportProductDto> getAllProducts();
}
