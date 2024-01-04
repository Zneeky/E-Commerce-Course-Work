package com.obuvki.rest.repository;

import com.obuvki.rest.Models.AppProduct;
import com.obuvki.rest.Models.AppSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<AppSupplier, Long> {

}
