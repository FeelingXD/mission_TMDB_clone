package com.example.mission.repository;

import com.example.mission.model.entity.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendRepository extends JpaRepository<Trend, Long>, TrendRepositoryCustom {
}

