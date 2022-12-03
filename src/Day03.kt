fun main() {
    val lowerCaseLettersSet: Set<Char> = "abcdefghijklmnopqrstuvwxyz".toSet()
    val upperCaseLettersSet: Set<Char> = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toSet()

    fun convertLetterToNumber(letter: Char): Int {
        var number = lowerCaseLettersSet.indexOf(letter)
        if (number != -1)
            number += 1
        else {
            number = upperCaseLettersSet.indexOf(letter)
            number += 27
        }

        return number
    }

    fun part1(input: List<String>): Int {
        return input.map { it.chunked(it.length / 2) }
            .map { it[0].first { it2 -> it[1].contains(it2) } }
            .map(::convertLetterToNumber)
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3, 3)
            .map { it[0].first { it2 -> it[1].contains(it2) && it[2].contains(it2) } }
            .map(::convertLetterToNumber)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
