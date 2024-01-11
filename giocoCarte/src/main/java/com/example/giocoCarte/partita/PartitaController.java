package com.example.giocoCarte.partita;

import com.example.giocoCarte.exceptions.BadRequestException;
import com.example.giocoCarte.payloads.entities.PartitaDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public long save(@RequestBody @Validated PartitaDTO partitaDTO, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }else {
           return partitaService.save(partitaDTO);
        }
    }

    @GetMapping("")
    public List<Partita> getAll(){
        return partitaService.findAll();
    }
    @GetMapping("/${id}")
    public List<Partita> getAllByUserId(@PathVariable long id){
        return partitaService.findByUserId(id);
    }
}
