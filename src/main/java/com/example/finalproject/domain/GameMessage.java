package com.example.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameMessage {

    private String roomId;
    private String senderId;
    private String sender;
    private String content;
    private String content2;
    private String content3;
    private MessageType type;

    public enum MessageType {
        JOIN, READY, UNREADY, ALLREADY, SPOTLIGHT, LEAVE, START, LIAR, TRUER, COMPLETE, ALLCOMPLETE, DRAW, ENDDRAW, SELECT, TURNCHECK, ENDGAME, ENDTURN, UPDATE, SWITCHING, WAIT, RESULT
    }
}