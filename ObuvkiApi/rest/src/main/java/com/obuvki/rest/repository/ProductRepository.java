package com.obuvki.rest.repository;

import com.obuvki.rest.DTO.ProductDTOs.ExportProductDto;
import com.obuvki.rest.Models.AppProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<AppProduct, Long> {

}
