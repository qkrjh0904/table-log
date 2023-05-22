package com.complete.tablelog.domain.member.repository;

import com.complete.tablelog.db.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.complete.tablelog.db.entity.QMember.member;


@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Member> findAllQuery() {
        return jpaQueryFactory
                .selectFrom(member)
                .fetch();
    }
}
