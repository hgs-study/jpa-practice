package com.hgstudy.domain.team.entity;

import com.hgstudy.domain.league.entity.League;
import com.hgstudy.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, List<Member> members) {
        this.name = name;
        this.members = members;
    }

    public Team(String name, League league) {
        this.name = name;
        this.league = league;
    }
}
