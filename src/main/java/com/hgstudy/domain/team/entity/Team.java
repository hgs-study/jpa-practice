package com.hgstudy.domain.team.entity;

import com.hgstudy.domain.league.entity.League;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "league_id")
    private League league;

    public Team(String name, League league) {
        this.name = name;
        this.league = league;
    }
}
