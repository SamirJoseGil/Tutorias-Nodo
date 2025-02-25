package nodo.aztro.Repositories;

import nodo.aztro.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(int id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByCity(String city);
    Optional<User> findByRole(String role);
}