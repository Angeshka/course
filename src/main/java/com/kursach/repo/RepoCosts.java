package com.kursach.repo;

import com.kursach.models.Costs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCosts extends JpaRepository<Costs,Long> {
    Costs findByIdTrip(Long id);
}
