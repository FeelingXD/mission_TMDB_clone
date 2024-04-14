package com.example.mission.repository;

import com.example.mission.model.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}
