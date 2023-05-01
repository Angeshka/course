package com.kursach.repo;

import com.kursach.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoReviews extends JpaRepository<Reviews, Long> {
}
