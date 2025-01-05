package lk.hesh.org.example.hotelbokingmanegement.repo;

import lk.hesh.org.example.hotelbokingmanegement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
