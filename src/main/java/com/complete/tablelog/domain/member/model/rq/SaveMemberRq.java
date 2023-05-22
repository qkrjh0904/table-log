package com.complete.tablelog.domain.member.model.rq;

import jakarta.validation.constraints.NotBlank;

public record SaveMemberRq(
        @NotBlank String name,
        @NotBlank String email
) {
}