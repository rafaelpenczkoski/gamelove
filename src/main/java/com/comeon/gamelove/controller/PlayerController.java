package com.comeon.gamelove.controller;

import com.comeon.gamelove.model.Game;
import com.comeon.gamelove.model.Player;
import com.comeon.gamelove.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> all() {
        return service.getAllPlayers();
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return service.insertPlayer(player);
    }

    @GetMapping("/{id}")
    public Player one(@PathVariable Long id) {
        return service.getPlayerById(id);
    }

    @GetMapping("/{id}/loved-games")
    public Set<Game> lovedGames(@PathVariable Long id) {
        return service.getPlayerLovedGames(id);
    }

    @PutMapping("/{playerId}/loved-games/{gameId}")
    public Set<Game> loveGame(@PathVariable Long playerId,
                              @PathVariable Long gameId) {
        return service.loveGame(playerId, gameId);
    }

    @DeleteMapping("/{playerId}/loved-games/{gameId}")
    public Set<Game> unloveGame(@PathVariable Long playerId,
                                @PathVariable Long gameId) {
        return service.unloveGame(playerId, gameId);
    }

}
