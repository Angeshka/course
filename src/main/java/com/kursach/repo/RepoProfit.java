package com.kursach.repo;

import com.kursach.models.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProfit extends JpaRepository <Profit,Long> {
    Profit findByIdTrip(Long id);
}
