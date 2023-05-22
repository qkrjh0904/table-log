package com.complete.tablelog.domain.member.model.rs;

import com.complete.tablelog.domain.member.model.dto.FindAllMemberDto;

import java.util.List;

public record FindAllMemberRs(
        List<FindAllMemberDto> memberList
) {
    public static FindAllMemberRs create(List<FindAllMemberDto> list) {
        return new FindAllMemberRs(list);
    }
}
