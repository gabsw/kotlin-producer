package demo.api.producer.controllers

import demo.api.producer.pojos.Game
import demo.api.producer.services.GamesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/games")
class GameController(val gamesService : GamesService) {

    @PostMapping("/")
    fun create(@RequestBody game: Game): ResponseEntity<Game> =
            ResponseEntity(gamesService.createRealGame(game), HttpStatus.CREATED)

    @PostMapping("/random")
    fun createRandom(@RequestBody game: Game): ResponseEntity<Game> =
            ResponseEntity(gamesService.createRandomGame(), HttpStatus.CREATED)
}