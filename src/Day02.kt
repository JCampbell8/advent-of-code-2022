fun main() {
    val ROCK_SCORE = 1
    val PAPER_SCORE = 2
    val SCISSORS_SCORE = 3

    val ROCK = "AX"
    val PAPER = "BY"
    val SCISSORS = "CZ"

    val LOSS = 0
    val DRAW = 3
    val WIN = 6

    fun didIWin(me: String, them: String): Int {
        return if (ROCK.contains(me) && PAPER.contains(them) || PAPER.contains(me) && SCISSORS.contains(them) ||
            SCISSORS.contains(me) && ROCK.contains(them)
        ) {
            //we lost
            -1
        } else if (ROCK.contains(me) && SCISSORS.contains(them) || PAPER.contains(me) && ROCK.contains(them) ||
            SCISSORS.contains(me) && PAPER.contains(them)
        ) {
            //we win!
            1
        } else {
            //we draw
            0
        }
    }

    fun part1(input: List<String>): Int {
        val totals = input.map { it.split(" ") }.map {
            val myRPSScore = when (it[1]) {
                "X" -> ROCK_SCORE
                "Y" -> PAPER_SCORE
                "Z" -> SCISSORS_SCORE
                else -> {
                    0
                }
            }

            val winScore = when (didIWin(it[1], it[0])) {
                1 -> WIN
                0 -> DRAW
                -1 -> LOSS
                else -> {
                    0
                }
            }

            myRPSScore + winScore
        }

        return totals.sum()
    }

    fun part2(input: List<String>): Int {
        val totals = input.map { it.split(" ") }.map {
            val myRPSScore = when (it[1]) {
                "X" -> when (it[0]) {
                    "A" -> SCISSORS_SCORE
                    "B" -> ROCK_SCORE
                    "C" -> PAPER_SCORE
                    else -> {0}
                }
                "Y" -> when (it[0]) {
                    "A" -> ROCK_SCORE
                    "B" -> PAPER_SCORE
                    "C" -> SCISSORS_SCORE
                    else -> {0}
                }
                "Z" -> when (it[0]) {
                    "A" -> PAPER_SCORE
                    "B" -> SCISSORS_SCORE
                    "C" -> ROCK_SCORE
                    else -> {0}
                }
                else -> {
                    0
                }
            }

            val winScore = when (it[1]) {
                "X" -> LOSS
                "Y" -> DRAW
                "Z" -> WIN
                else -> {
                    0
                }
            }

            myRPSScore + winScore
        }

        return totals.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    //check(part2(testInput) == 45000)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
