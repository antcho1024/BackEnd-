package com.example.finalproject.controller;

import com.example.finalproject.domain.GameMessage;
import com.example.finalproject.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class GameController {

    private final GameService gameService;

    // /pub 사용 게임 시작 (라이어 선언 / 키워드 공개)
    @MessageMapping("/lier/game/{gameroomid}/start")
    public ResponseEntity<?> gameStart(
            GameMessage gameMessage,
            @DestinationVariable Long gameroomid) {

        log.info("게임 시작 - 게임 메세지 : {} , 게임방 아이디 : {} ", gameMessage, gameroomid);
        return gameService.gameStart(gameMessage, gameroomid);
    }

    // /pub 사용 게임 준비
    @MessageMapping("/lier/game/{gameroomid}/ready")
    public ResponseEntity<?> gameReady(
            GameMessage gameMessage, // 게임 메세지 안에 sender에 닉네임을 전달받는데 그걸 이용
            @DestinationVariable Long gameroomid) {

        log.info("게임 준비 - 게임 메세지 : {} , 게임방 아이디 : {}", gameMessage, gameroomid);
        return gameService.gameReady(gameMessage, gameroomid);
    }

    // pub 사용 스포트라이트
    @MessageMapping("/lier/game/{gameroomid}/spotlight")
    public void spotlight(
            @DestinationVariable Long gameroomid) {

        log.info("스포트라이트 - 게임방 아이디 : {}", gameroomid);
        gameService.spotlight(gameroomid);
    }

}