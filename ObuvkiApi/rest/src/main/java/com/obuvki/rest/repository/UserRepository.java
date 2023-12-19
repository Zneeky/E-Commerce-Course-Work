package com.obuvki.rest.repository;



import com.obuvki.rest.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

}
