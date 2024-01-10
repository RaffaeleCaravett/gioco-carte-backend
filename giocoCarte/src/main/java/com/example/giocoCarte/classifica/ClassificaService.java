package com.example.giocoCarte.classifica;

import com.example.giocoCarte.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificaService {
    @Autowired
    ClassificaRepository classificaRepository;

    public long save(Classifica classifica){
        classificaRepository.save(classifica);
    return classifica.getId();
    }

    public List<User> getUsersByClassificaId(long id){
        Classifica classifica= classificaRepository.findById(id).get();
        return classifica.getUser();
    }
}
