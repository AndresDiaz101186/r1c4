package com.cuatroa.retouno.service;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * aca se establecen los metodos con que el crud devuelbe los datos
 * @author Andres Diaz
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    /**
     * lista todos los elementos de la tabla
     * @return 
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
/**
 * este metodo requere del id para buscarlo en la tabla
 * @param id
 * @return 
 */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
/**
 * este metodo registra un usuario verificando que el mail sea unico y no este registrado ya en la tabla
 * @param user
 * @return 
 */
    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
/**
 * retorna un true en caso de que el mail ya exista en la tabla
 * @param email
 * @return 
 */
    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }
/**
 * verifiaca que los datos de usuario y pasword correspondan al mismo usuario
 * @param email
 * @param password
 * @return 
 */
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
