package com.hgstudy.domain.league.service;


import com.hgstudy.domain.league.entity.League;
import com.hgstudy.domain.league.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeagueService {

    private final LeagueRepository leagueRepository;



}
