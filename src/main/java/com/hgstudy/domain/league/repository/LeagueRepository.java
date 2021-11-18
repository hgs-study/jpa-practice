package com.hgstudy.domain.league.repository;

import com.hgstudy.domain.league.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League,Long> {
}
