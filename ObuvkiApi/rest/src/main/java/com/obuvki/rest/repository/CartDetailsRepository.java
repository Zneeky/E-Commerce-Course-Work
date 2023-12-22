package com.obuvki.rest.repository;

import com.obuvki.rest.Models.AppCartDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailsRepository extends JpaRepository<AppCartDetails, Long> {

}
