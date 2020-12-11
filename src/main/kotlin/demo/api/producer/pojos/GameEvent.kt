package demo.api.producer.pojos

import java.time.LocalDateTime

data class GameEvent(val game: Game, val createdAt : LocalDateTime)