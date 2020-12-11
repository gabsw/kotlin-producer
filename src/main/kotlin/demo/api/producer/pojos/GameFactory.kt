package demo.api.producer.pojos

import java.time.LocalDateTime

class GameFactory {
    companion object {
        private val teams: List<String> = listOf(
                "Atlanta Hawks",
                "Boston Celtics",
                "Brooklyn Nets",
                "Charlotte Hornets",
                "Chicago Bulls",
                "Cleveland Cavaliers",
                "Dallas Mavericks",
                "Denver Nuggets",
                "Detroit Pistons",
                "Golden State Warriors",
                "Houston Rockets",
                "Indiana Pacers",
                "Los Angeles Clippers",
                "Los Angeles Lakers",
                "Memphis Grizzlies",
                "Miami Heat",
                "Milwaukee Bucks",
                "Minnesota Timberwolves",
                "New Orleans Pelicans",
                "New York Knicks",
                "Oklahoma City Thunder",
                "Orlando Magic",
                "Philadelphia 76ers",
                "Phoenix Suns",
                "Portland Trail Blazers",
                "Sacramento Kings",
                "San Antonio Spurs",
                "Toronto Raptors",
                "Utah Jazz",
                "Washington Wizards"
        )

        fun fetchRandomGame(): Game {
            var awayTeamName: String
            val homeTeamName = fetchRandomTeam()

            do {
                awayTeamName = fetchRandomTeam()
            } while (awayTeamName == homeTeamName)

            var awayTeamPoints: Int
            val homeTeamPoints = fetchRandomPoints()

            do {
                awayTeamPoints = fetchRandomPoints()
            } while (awayTeamPoints == homeTeamPoints)

            return Game(homeTeamName, awayTeamName, homeTeamPoints, awayTeamPoints, fetchRandomDateTime())
        }

        private fun fetchRandomTeam() = teams[fetchRandomInt(0, teams.size - 1)]

        private fun fetchRandomPoints() = fetchRandomInt(60, 120)

        private fun fetchRandomDateTime() : LocalDateTime {
            val second = fetchRandomInt(0, 59)
            val min = fetchRandomInt(0, 59)
            val hour = fetchRandomInt(12, 23)
            val day = fetchRandomInt(1, 28)
            val month = fetchRandomInt(1, 12)
            val year = fetchRandomInt(2010, 2020)

            return LocalDateTime.of(year, month, day, hour, min, second)
        }

        private fun fetchRandomInt(start: Int, end : Int) : Int {
            require(start <= end) { "Illegal Argument" }
            return (start..end).shuffled().first()
        }
    }
}