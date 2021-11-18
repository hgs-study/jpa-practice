package com.hgstudy.domain.member.service;

import com.hgstudy.domain.member.entity.Member;
import com.hgstudy.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById(Long id){
        return memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("error"));
    }
}
