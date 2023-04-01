package com.kursach.repo;

import com.kursach.models.Zatraty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoZatraty extends JpaRepository<Zatraty,Long> {
    Zatraty findByIdTrip(Long id);
}
