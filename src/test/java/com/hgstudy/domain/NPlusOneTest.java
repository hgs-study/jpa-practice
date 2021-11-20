package com.hgstudy.domain;

import com.hgstudy.domain.member.entity.Member;
import com.hgstudy.domain.member.repository.MemberRepository;
import com.hgstudy.domain.team.entity.Team;
import com.hgstudy.domain.team.repository.TeamRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class NPlusOneTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

//    @BeforeEach
    void beforeEach(){
        Team team1 = new Team("KIA");
        Team team2 = new Team("LG");
        Member member1 = new Member("hyun", 28, team1);
        Member member2 = new Member("kim", 27, team1);
        Member member3 = new Member("lee", 30, team2);
        Member member4 = new Member("choi", 25, team2);
        Member member5 = new Member("park", 26, team2);
        List<Member> members1 = Lists.list(member1,member2);
        List<Member> members2 = Lists.list(member3,member4,member5);

        team1.getMembers().addAll(members1);
        team2.getMembers().addAll(members2);

        teamRepository.save(team1);
        teamRepository.save(team2);
        memberRepository.saveAll(members1);
        memberRepository.saveAll(members2);
    }

    @Test
    @Transactional(readOnly = true)
    void 지연로딩_N_PLUS_1(){
        List<Team> teams = teamRepository.findAll();

        for (Team team1 : teams) {
            System.out.println("team1.getMembers().size() = " + team1.getMembers().size());
        }
    }

    @Test
    void FETCH_JOIN(){
        List<Team> teams = teamRepository.findAllJoinFetch();

        for (Team team1 : teams) {
            System.out.println("team1.getMembers().size() = " + team1.getMembers().size());
        }
    }


}
