fun main() {

    fun parsePairs(input: List<String>): List<List<Int>> {
        val map = input.map { it.split(",") }
            .map {
                it.flatMap { it2 ->
                    it2.split("-")
                }.map { it3 -> it3.toInt() }
            }
        return map
    }

    fun part1(input: List<String>): Int {
        return parsePairs(input)
            .filter {
                it[0] >= it[2] && it[1] <= it[3] || it[2] >= it[0] && it[3] <= it[1]
            }.size
    }

    fun part2(input: List<String>): Int {
        return parsePairs(input)
            .filter {
                it[0] >= it[2] && it[0] <= it[3] || it[1] >= it[2] && it[1] <= it[3] || it[2] >= it[0] && it[2] <= it[1]
            }.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
