package com.complete.tablelog.db.entity;

import com.complete.tablelog.db.entity.common.BaseTimeEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Audited
@AuditOverride(forClass = BaseTimeEntity.class)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Book> bookList = new ArrayList<>();

    public static Member create(String name, String email) {
        Member member = new Member();
        member.name = name;
        member.email = email;
        return member;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
