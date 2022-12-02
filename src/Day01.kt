fun main() {
    fun getCalorieList(input: List<String>):List<Int> {
        val sums:MutableList<Int> = mutableListOf()

        var sum = 0
        input.forEach {
            if (it == "") {
                sums.add(sum)
                sum = 0
            } else {
                sum += it.toInt()
            }
        }

        if(sum > 0) {
            sums.add(sum)
        }

        return sums
    }

    fun part1(input: List<String>): Int {
        return getCalorieList(input).maxOrNull() ?: 0
    }

    fun part2(input: List<String>): Int {
        return getCalorieList(input).sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
