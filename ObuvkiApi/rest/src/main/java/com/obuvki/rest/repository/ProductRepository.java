package com.obuvki.rest.repository;

import com.obuvki.rest.Models.AppProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<AppProduct, Long> {
    List<AppProduct> findAppProductByIdIn(List<Long> ids);
}
