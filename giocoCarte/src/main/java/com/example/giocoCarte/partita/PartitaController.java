package com.example.giocoCarte.partita;

import com.example.giocoCarte.exceptions.BadRequestException;
import com.example.giocoCarte.payloads.entities.PartitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partita")
public class PartitaController {
    @Autowired
    PartitaService partitaService;


    @PostMapping("")
    @PreAuthorize("hasAuthority('USER')")
    public long save(@RequestBody @Validated PartitaDTO partitaDTO, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else {
           return partitaService.save(partitaDTO);
        }
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('USER')")
    public List<Partita> getAll(){
        return partitaService.findAll();
    }
    @GetMapping("/{id}")
    public List<Partita> getAllByUserId(@PathVariable long id){
        return partitaService.findByUserId(id);
    }
}
