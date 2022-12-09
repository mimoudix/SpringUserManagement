package com.mimoudix.usermanagement.repositories;

import com.mimoudix.usermanagement.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    Page<User> findByNameContains(String kw, Pageable pageable);
}
