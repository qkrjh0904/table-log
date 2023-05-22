package com.complete.tablelog.domain.member.service;

import com.complete.tablelog.db.entity.Member;
import com.complete.tablelog.domain.member.model.dto.FindAllMemberDto;
import com.complete.tablelog.domain.member.model.rq.SaveMemberRq;
import com.complete.tablelog.domain.member.model.rs.FindAllMemberRs;
import com.complete.tablelog.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(SaveMemberRq rq) {
        Member member = Member.create(rq.name(), rq.email());
        memberRepository.save(member);
    }


    public FindAllMemberRs findAllMember() {
        List<FindAllMemberDto> list = memberRepository.findAll().stream()
                .map(FindAllMemberDto::create)
                .collect(Collectors.toList());
        return FindAllMemberRs.create(list);
    }

    public FindAllMemberRs findAllMemberQuery() {
        List<FindAllMemberDto> list = memberRepository.findAllQuery().stream()
                .map(FindAllMemberDto::create)
                .collect(Collectors.toList());
        return FindAllMemberRs.create(list);
    }
}
