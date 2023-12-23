package com.obuvki.rest.repository;

import com.obuvki.rest.Models.AppOrder;
import com.obuvki.rest.Models.AppOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<AppOrderDetails, Long> {

}
