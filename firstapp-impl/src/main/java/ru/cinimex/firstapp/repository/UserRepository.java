package ru.cinimex.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cinimex.firstapp.domain.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
