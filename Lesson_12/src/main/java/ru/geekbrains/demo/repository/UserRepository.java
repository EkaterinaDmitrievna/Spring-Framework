package ru.geekbrains.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.demo.model.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByName(String name);
}
