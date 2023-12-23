package com.obuvki.rest.repository;

import com.obuvki.rest.Models.AppOrder;
import com.obuvki.rest.Models.AppProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<AppOrder, Long> {
    List<AppOrder> findByUserId(long userId);
}
