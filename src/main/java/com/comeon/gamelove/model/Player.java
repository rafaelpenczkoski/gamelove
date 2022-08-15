package com.comeon.gamelove.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "player_loved_games",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> lovedGames;

    public Player() {
    }

    public Player(Long id, String name, List<Game> lovedGames) {
        this.id = id;
        this.name = name;
        this.lovedGames = lovedGames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getLovedGames() {
        return lovedGames;
    }

    public void setLovedGames(List<Game> lovedGames) {
        this.lovedGames = lovedGames;
    }
}
