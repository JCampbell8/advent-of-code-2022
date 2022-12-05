fun main() {

    fun parsePairs(input: List<String>): List<List<IntRange>> {
        val map = input.map { it.split(",") }
            .map {
                it.map { it2 ->
                    val split = it2.split("-")
                    split[0].toInt()..split[1].toInt()
                }
            }
        return map
    }

    fun part1(input: List<String>): Int {
        return parsePairs(input)
            .filter {
                val intersect = it[0].intersect(it[1])
                intersect.containsAll(it[0].toList()) || intersect.containsAll(it[1].toList())
            }.size
    }

    fun part2(input: List<String>): Int {
        return parsePairs(input)
            .filter {
                it[0].intersect(it[1]).isNotEmpty()
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
