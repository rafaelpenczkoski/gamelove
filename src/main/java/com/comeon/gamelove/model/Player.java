package com.comeon.gamelove.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name is required")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "player_loved_games",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> lovedGames;

    public Player() {
    }

    public Player(Long id, String name, Set<Game> lovedGames) {
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

    public Set<Game> getLovedGames() {
        return lovedGames;
    }

    public void setLovedGames(Set<Game> lovedGames) {
        this.lovedGames = lovedGames;
    }
}
