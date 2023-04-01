package com.kursach.repo;

import com.kursach.models.Docs;
import com.kursach.models.Dohod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDocs extends JpaRepository <Docs, Long> {
    Docs findByIdTrip(Long id);
}
