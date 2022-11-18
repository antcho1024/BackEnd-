package com.example.finalproject.controller;


import com.example.finalproject.service.GameHTTPService;
import lombok.RequiredArgsConstructor;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class GameHTTPController {

    private final GameHTTPService gameHTTPService;

//    @MessageMapping("/lier/manager/{gameroomid}/isLier/{name}")
//    public void isLier(@DestinationVariable("gameroomid") Long gameroomid,@DestinationVariable("name") String name) {
//        gameHTTPService.isLier(gameroomid, name);
//    }

    // 투표
    @MessageMapping("/lier/manager/{gameroomid}/vote/{name}")
    public void vote(@DestinationVariable("gameroomid") Long gameroomid, @DestinationVariable("name") String name) {
        gameHTTPService.vote(gameroomid, name);
    }

    // 라이어 정답 맞추기
    @MessageMapping("/lier/manager/{gameroomid}/isAnswer/{answer}")
    public void isAnswer(@DestinationVariable("gameroomid") Long gameroomid, @DestinationVariable("answer") String answer) {
        gameHTTPService.isAnswer(gameroomid, answer);
    }

    // 한바퀴 더
    @MessageMapping("/lier/manager/{gameroomid}/oneMoerRound")
    public void oneMoerRound(@DestinationVariable("gameroomid") Long gameroomid) {
        gameHTTPService.oneMoerRound(gameroomid);
    }

    // winner, loser 전달 & 전적 업이트
    @MessageMapping("/lier/manager/{gameroomid}/victory")
    public void victory(@DestinationVariable("gameroomid") Long gameroomid) {
        gameHTTPService.victory(gameroomid);
    }
}