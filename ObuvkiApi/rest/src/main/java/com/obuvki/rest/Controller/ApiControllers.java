package com.obuvki.rest.Controller;

import com.obuvki.rest.Models.AppUser;
import org.springframework.web.bind.annotation.*;
import com.obuvki.rest.Repo.AppUserRepo;



import java.util.List;

@RestController
public class ApiControllers {

    private final AppUserRepo _appUserRepo;

    public ApiControllers(AppUserRepo appUserRepo) {
        this._appUserRepo = appUserRepo;
    }

    @GetMapping(value="/")
    public String getPage(){
        return  "Welcome";
    }

    @GetMapping(value = "/users")
    public List<AppUser> getUsers(){
        return _appUserRepo.findAll();
    }

    @PostMapping(value = "/users")
    public String saveUser(@RequestBody AppUser user){
        _appUserRepo.save(user);
        return "Saved...";
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        _appUserRepo.deleteById(id);
        return String.format("User with ID %d deleted successfully", id);
    }
}
