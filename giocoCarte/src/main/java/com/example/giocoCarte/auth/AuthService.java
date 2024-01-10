package com.example.giocoCarte.auth;



import com.example.giocoCarte.classifica.ClassificaRepository;
import com.example.giocoCarte.exceptions.BadRequestException;
import com.example.giocoCarte.exceptions.UnauthorizedException;
import com.example.giocoCarte.payloads.entities.Token;
import com.example.giocoCarte.payloads.entities.UserLoginDTO;
import com.example.giocoCarte.payloads.entities.UserRegistrationDTO;
import com.example.giocoCarte.security.JWTTools;
import com.example.giocoCarte.user.User;
import com.example.giocoCarte.user.UserRepository;
import com.example.giocoCarte.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class AuthService {
    @Autowired
    private UserService usersService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ClassificaRepository classificaRepository;
    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;


    public Token authenticateUser(UserLoginDTO body) throws Exception {
        // 1. Verifichiamo che l'email dell'utente sia nel db
        User user = usersService.findByEmail(body.email());
        // 2. In caso affermativo, verifichiamo se la password corrisponde a quella trovata nel db
        if(bcrypt.matches(body.password(), user.getPassword()))  {
            // 3. Se le credenziali sono OK --> Genero un JWT e lo restituisco
            return jwtTools.createToken(user);
        } else {
            // 4. Se le credenziali NON sono OK --> 401
            throw new UnauthorizedException("Credenziali non valide!");
        }
    }


    public User registerUser(UserRegistrationDTO body) throws IOException {

        // verifico se l'email è già utilizzata
        userRepository.findByEmail(body.email()).ifPresent( user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già utilizzata!");
        });
        User newUser = new User();
        newUser.setPassword(bcrypt.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setNome(body.nome());
        newUser.setUsername(body.username());
        newUser.setClassifica(classificaRepository.findById(1L).get());
        userRepository.save(newUser);

        return newUser;
    }

}