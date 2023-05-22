package com.complete.tablelog.domain.member.controller;

import com.complete.tablelog.domain.member.model.rq.SaveMemberRq;
import com.complete.tablelog.domain.member.model.rs.FindAllMemberRs;
import com.complete.tablelog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/member")
    public void saveMember(@Validated @RequestBody SaveMemberRq rq){
        memberService.saveMember(rq);
    }

    @GetMapping("/api/member/all")
    public FindAllMemberRs findAllMember(){
        return memberService.findAllMemberQuery();
    }
}
