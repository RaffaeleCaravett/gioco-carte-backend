package com.example.giocoCarte.classifica;

import com.example.giocoCarte.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classifica")
public class ClassificaController {
    @Autowired
    ClassificaService classificaService;

    @PostMapping("")
    public long save(){
Classifica classifica= new Classifica();
        classificaService.save(classifica);
        return classifica.getId();
    }

    @GetMapping("/{id}")
    public List<User> getUsers(@PathVariable long id){
        return classificaService.getUsersByClassificaId(id);
    }

}
