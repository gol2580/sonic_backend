package com.sonic.sonic_backend.domain.Member.controller;

import com.sonic.sonic_backend.domain.Member.dto.common.SignUpRequestDto;
import com.sonic.sonic_backend.domain.Member.repository.MemberRepository;
import com.sonic.sonic_backend.domain.Member.service.MemberService;
import com.sonic.sonic_backend.domain.Profile.dto.UpdateProfileRequestDto;
import com.sonic.sonic_backend.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.sonic.sonic_backend.response.Message.*;
import static com.sonic.sonic_backend.response.Response.success;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Member")
@RestController
@AllArgsConstructor
@RequestMapping(value="/member")
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @Operation(summary = "회원 이름 불러오기")
    @ResponseStatus(OK)
    @GetMapping
    public Response getMember() {
        return success(GET_MEMBER_NAME_SUCCESS, memberService.getMemberName());
    }
    @Operation(summary = "회원 탈퇴하기")
    @ResponseStatus(OK)
    @DeleteMapping
    public Response deleteMember() {
        memberService.deleteMember();
        return success(DELETE_MEMBER_SUCCESS);
    }
/*
    @Operation(summary = "비밀번호 변경")
    @ResponseStatus(OK)
    @PatchMapping("/password")
    public Response updatePassword() {
        memberService.updatePassword();
        return success(DELETE_MEMBER_SUCCESS);
    }

    @Operation(summary = "닉네임 변경")
    @ResponseStatus(OK)
    @PatchMapping("/nickname")
    public Response updateNickname() {
        memberService.updateNickanme();
        return success(DELETE_MEMBER_SUCCESS);
    }

    @Operation(summary = "손 변경")
    @ResponseStatus(OK)
    @PatchMapping("/hand")
    public Response updateHand() {
        memberService.deleteMember();
        return success(DELETE_MEMBER_SUCCESS);
    }


 */
    @Operation(summary = "테스트용")
    @ResponseStatus(OK)
    @PatchMapping("/exp")
    public Response updateExp(@RequestBody UpdateProfileRequestDto updateProfileRequestDto) {
        return success("exp 수정 성공", memberService.updateExp(updateProfileRequestDto.getExp()));
    }

}
