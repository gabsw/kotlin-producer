package demo.api.producer.services

import demo.api.producer.pojos.Game
import demo.api.producer.pojos.GameEvent
import demo.api.producer.pojos.GameFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GamesService(val rabbitMqSender: RabbitMqSender) {
    fun createRealGame(game: Game) : Game {
        println("Real game was created... $game")
        rabbitMqSender.send(GameEvent(game, LocalDateTime.now()))
        return game
    }

    fun createRandomGame() : Game {
        val game = GameFactory.fetchRandomGame()
        println("Random game was created... $game")
        rabbitMqSender.send(GameEvent(game, LocalDateTime.now()))
        return game
    }
}