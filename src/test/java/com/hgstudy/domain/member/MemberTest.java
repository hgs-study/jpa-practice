package com.hgstudy.domain.member;

import com.hgstudy.domain.league.entity.League;
import com.hgstudy.domain.league.repository.LeagueRepository;
import com.hgstudy.domain.member.entity.Member;
import com.hgstudy.domain.member.repository.MemberRepository;
import com.hgstudy.domain.member.service.MemberService;
import com.hgstudy.domain.team.entity.Team;
import com.hgstudy.domain.team.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional(readOnly = true)
    void 객체그래프_탐색시_트랜잭셔널_리드온리_테스트(){
        League league = new League("korea");
        Team team = new Team("기아",league);
        Member member = new Member("hyun",28,team);

        leagueRepository.save(league);
        teamRepository.save(team);
        memberRepository.save(member);

        Member findMember = memberService.findById(1L);
        Team findTeam = findMember.getTeam();
        League findLeague = findTeam.getLeague();

        assertEquals(team.getName(), findTeam.getName());
        assertEquals(league.getRegion(), findLeague.getRegion());
    }

    @Test
    void 프록시_테스트(){
        League league = new League("korea");
        League savedLeague = leagueRepository.save(league);

        League reference = entityManager.getReference(League.class, savedLeague.getId());

        entityManager.clear();

        League findLeague = entityManager.find(League.class, savedLeague.getId());

        System.out.println("reference.getClass() = " + reference.getClass()); //프록시 객체
        System.out.println("reference.getClass() = " + findLeague.getClass()); // 실제 엔티티

    }



}
