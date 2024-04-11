package com.example.mission.repository;

import com.example.mission.model.entity.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrailerRepository extends JpaRepository<Trailer,Long>,TrailerRepositoryCustom {

}
