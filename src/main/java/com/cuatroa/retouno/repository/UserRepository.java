package com.cuatroa.retouno.repository;

import com.cuatroa.retouno.repository.crud.UserCrudRepository;
import com.cuatroa.retouno.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * clase repositorio contiene los metodos que puedo implementar gracias a crud.
 * @author Andres Diaz
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;
/**
 * llama todos los elementos contenidos en la tabla.
 * @return 
 */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
/**
 * en cuentra un elemento de la tabla ubicandolo por id
 * @param id
 * @return 
 */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
/**
 * guarda un elemento en la tabla 
 * @param user
 * @return 
 */
    public User save(User user) {
        return userCrudRepository.save(user);
    }
/**
 * retorna true si el elemento ya existe en la tabla.
 * @param email
 * @return 
 */
    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
/**
 * retorna  usuario y pasword para verificar que coincidan.
 * @param email
 * @param password
 * @return 
 */
    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
