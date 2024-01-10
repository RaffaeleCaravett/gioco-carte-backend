package com.example.giocoCarte.user;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    @Autowired
    private UserRepository utenteRepository;


    public User findById(long id) throws NotFoundException {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User findByIdAndUpdate(long id, UserRegistrationDTO body) throws NotFoundException {
        User found = utenteRepository.findById(id).get();
        found.setNome(body.nome());
        found.setUsername(body.username());
        found.setEmail(body.email());
        return utenteRepository.save(found);
    }

    public void findByIdAndDelete(long id) throws NotFoundException {
        User found = this.findById(id);
        utenteRepository.delete(found);
    }

    public User findByEmail(String email) throws NotFoundException {
        return utenteRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utente con email "+ email + " non trovato"));
    }

}