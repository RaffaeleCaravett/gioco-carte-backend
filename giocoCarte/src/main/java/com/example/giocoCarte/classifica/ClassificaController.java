package com.example.giocoCarte.classifica;

import com.example.giocoCarte.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classifica")
public class ClassificaController {
    @Autowired
    ClassificaService classificaService;

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public long save(){
Classifica classifica= new Classifica();
        classificaService.save(classifica);
        return classifica.getId();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public List<User> getUsers(@PathVariable long id){
        return classificaService.getUsersByClassificaId(id);
    }

}
