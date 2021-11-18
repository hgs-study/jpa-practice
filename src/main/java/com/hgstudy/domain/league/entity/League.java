package com.hgstudy.domain.league.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "league")
public class League {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id")
    private Long id;

    @Column(name = "region")
    private String region;

    public League(String region) {
        this.region = region;
    }
}
