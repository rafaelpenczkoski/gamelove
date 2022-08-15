package com.comeon.gamelove.controller;

import com.comeon.gamelove.model.Game;
import com.comeon.gamelove.model.Player;
import com.comeon.gamelove.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Game> lovedGames(@PathVariable Long id) {
        return service.getPlayerLovedGames(id);
    }

    @PutMapping("/{id}/loved-games")
    public List<Game> loveGame(@PathVariable Long id,
                               @RequestBody Game game) {
        return service.loveGame(id, game);
    }

}
