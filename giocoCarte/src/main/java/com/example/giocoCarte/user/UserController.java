package com.example.giocoCarte.user;

import com.example.giocoCarte.exceptions.NotFoundException;
import com.example.giocoCarte.payloads.entities.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService utenteService;

    @GetMapping("/me")
    public UserDetails getProfile(@AuthenticationPrincipal UserDetails currentUser){
        return currentUser;
    };

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void getProfile(@AuthenticationPrincipal User currentUser){
        utenteService.findByIdAndDelete(currentUser.getId());
    };
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User findById(@PathVariable int id)  {
        return utenteService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User findByIdAndUpdate(@PathVariable int id, @RequestBody UserRegistrationDTO body) throws NotFoundException {
        return utenteService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) throws NotFoundException {
        utenteService.findByIdAndDelete(id);
    }

}