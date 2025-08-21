package com.gameslist.dslist.controllers;

import com.gameslist.dslist.dto.GameMinDTO;
import com.gameslist.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.findById(id).getTitle());
    }
}
