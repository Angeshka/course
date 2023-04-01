package com.kursach.repo;

import com.kursach.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsers extends JpaRepository <Users, Long> {
    Users findByUsername(String username);
}
