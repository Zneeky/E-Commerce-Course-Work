package com.obuvki.rest.repository;

import com.obuvki.rest.Models.AppCart;
import com.obuvki.rest.Models.AppCartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CartDetailsRepository extends JpaRepository<AppCartDetails, Long> {
    List<AppCartDetails> findByCartId(long cartId);

    AppCartDetails findByProductIdAndCartId(long productId, long cartId);
    void deleteByProductIdAndCartId(long productId, long cartId);

    void deleteByCartId(long cartId);
}
