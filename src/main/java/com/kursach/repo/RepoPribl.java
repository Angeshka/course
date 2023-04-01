package com.kursach.repo;

import com.kursach.models.Pribl;
import com.kursach.models.Zatraty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPribl extends JpaRepository <Pribl,Long> {
    Pribl findByIdTrip(Long id);
}
