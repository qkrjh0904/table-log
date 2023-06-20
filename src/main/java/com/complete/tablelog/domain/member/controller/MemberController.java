package com.complete.tablelog.domain.member.controller;

import com.complete.tablelog.domain.member.model.rq.SaveMemberRq;
import com.complete.tablelog.domain.member.model.rs.FindAllMemberRs;
import com.complete.tablelog.domain.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/member")
    public void saveMember(@Validated @RequestBody SaveMemberRq rq) {
        memberService.saveMember(rq);
    }

    @GetMapping("/api/member/all")
    public FindAllMemberRs findAllMember() {
        return memberService.findAllMemberQuery();
    }

    @GetMapping("/api/test")
    public void test() {
        String traceId = UUID.randomUUID().toString();
        Long userId = 1L;
        log.info("{}", toJson(LogEntry.create(traceId, userId, "/api/test", "요청처리 시작")));
        try {
            memberService.test();
        } catch (IllegalArgumentException e) {
            log.error("{} | 에러 발생", traceId, e);
            throw e;
        }
        log.info("{}", toJson(LogEntry.create(traceId, userId, "/api/test", "요청처리 완료")));
    }

    @Component
    static class LogEntry {
        private String traceId;
        private Long userId;
        private String apiPath;
        private String message;

        public static LogEntry create(String traceId, Long userId, String apiPath, String message) {
            LogEntry logEntry = new LogEntry();
            logEntry.traceId = traceId;
            logEntry.userId = userId;
            logEntry.apiPath = apiPath;
            logEntry.message = message;
            return logEntry;
        }

        @Override
        public String toString() {
            return "{" +
                    "traceId='" + traceId + '\'' +
                    ", userId=" + userId +
                    ", apiPath='" + apiPath + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

    private String toJson(LogEntry logEntry) {
        return logEntry.toString();
    }


}
