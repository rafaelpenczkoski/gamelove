package com.comeon.gamelove.controller;

import com.comeon.gamelove.model.Game;
import com.comeon.gamelove.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public Game one(@PathVariable Long id) {
        return service.getGameById(id);
    }

}
