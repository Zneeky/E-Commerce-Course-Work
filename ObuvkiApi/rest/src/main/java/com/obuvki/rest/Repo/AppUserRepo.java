package com.obuvki.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.obuvki.rest.Models.AppUser;
public interface AppUserRepo extends JpaRepository<AppUser, Long> {
}
