package com.example.account.repo;

import com.example.account.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByFio(String fio);
}
