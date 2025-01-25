package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping("/{id}/games")
    public List<GameMinDTO> findByList(@PathVariable Long id) {
        return gameService.findByList(id);
    }

    @PostMapping("/{id}/replacement")
    public void move(@PathVariable Long id, @RequestBody ReplacementDTO body) {
        gameListService.move(id, body.getSourceIndex(), body.getDestinationIndex());
    }

}
