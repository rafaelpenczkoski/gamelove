package com.comeon.gamelove.controller;

import com.comeon.gamelove.dto.GameDTO;
import com.comeon.gamelove.model.Game;
import com.comeon.gamelove.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/games")
public class GameController {

    private GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> all() {
        return service.getAllGames();
    }

    @PostMapping
    public Game create(@RequestBody Game game) {
        return service.insertGame(game);
    }

    @GetMapping("/{id}")
    public Game one(@PathVariable Long id) {
        return service.getGameById(id);
    }

    @GetMapping("/top-games/{limit}")
    public List<GameDTO> getTopGames(@PathVariable Long limit) {
        return service.getTopGames(limit);
    }

}
