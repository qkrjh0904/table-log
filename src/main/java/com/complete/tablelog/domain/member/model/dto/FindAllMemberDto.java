package com.complete.tablelog.domain.member.model.dto;


import com.complete.tablelog.db.entity.Member;

public record FindAllMemberDto(
        Long id,
        String name,
        String email
) {

    public static FindAllMemberDto create(Member member) {
        return new FindAllMemberDto(
                member.getId(),
                member.getName(),
                member.getEmail()
        );
    }
}
