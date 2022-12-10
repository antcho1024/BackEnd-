package com.example.finalproject.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class GameStartSet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long gamestartsetId;

    @Column
    private String lier;

    @Column
    private String category;

    @Column
    private String keyword;

    @Column
    private Long roomId;

    @Column
    private Integer round;

    @Column(nullable = false)
    private Integer spotnum = 0;

    @Column(nullable = false)
    private GameStartSet.Winner winner;

    public enum Winner {
        DEFAULT, CITIZEN, LIER
    }

    public Integer oneMoerRound(){
        this.round++;
        return this.round;
    }

    public Winner getWinner() {
        return this.winner;
    }

    public void setWinner(GameStartSet.Winner winner){
        this.winner = winner;
    }
}
