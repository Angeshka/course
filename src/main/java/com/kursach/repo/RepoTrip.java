package com.kursach.repo;

import com.kursach.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoTrip extends JpaRepository <Trip, Long> {
}
