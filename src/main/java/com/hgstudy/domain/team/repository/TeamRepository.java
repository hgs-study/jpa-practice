package com.hgstudy.domain.team.repository;

import com.hgstudy.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long> {

    @Query("select distinct t from Team t left join fetch t.members")
    List<Team> findAllJoinFetch();
}
