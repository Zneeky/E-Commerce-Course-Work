package com.obuvki.rest.repository;

import com.obuvki.rest.Models.AppCart;
import com.obuvki.rest.Models.AppProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface CartRepository extends JpaRepository<AppCart, Long> {
    AppCart findByUserId(long userId);
}
