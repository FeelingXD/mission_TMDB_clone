package com.example.mission.repository;

import com.example.mission.model.entity.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailerRepository extends JpaRepository<Trailer, Long>, TrailerRepositoryCustom {

}
