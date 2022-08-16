package com.comeon.gamelove.dto;

import com.comeon.gamelove.model.Game;

public class GameDTO {

    private Long id;
    private String name;
    private Long likeCount;

    public GameDTO() {
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

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public GameDTO(Long id, String name, Long likeCount) {
        this.id = id;
        this.name = name;
        this.likeCount = likeCount;
    }

    public static GameDTO convertToDTO(Game game) {
        return new GameDTO(game.getId(), game.getName(), (long) game.getPlayers().size());
    }
}
