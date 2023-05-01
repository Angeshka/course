package com.kursach.repo;

import com.kursach.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoIncome extends JpaRepository <Income, Long> {
    Income findByIdTrip(Long id);
}
