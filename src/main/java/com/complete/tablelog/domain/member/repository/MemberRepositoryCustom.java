package com.complete.tablelog.domain.member.repository;


import com.complete.tablelog.db.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findAllQuery();
}
