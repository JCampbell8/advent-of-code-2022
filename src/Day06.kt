fun main() {

    fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)

    fun detectPacketMarker(packet: String, distinct: Int): Int {
        val marker = packet.toList().windowed(distinct, 1).first {
            it.joinToString("").allUnique()
        }

        return packet.indexOf(marker.joinToString("")) + distinct
    }

    fun part1(input: List<String>): Int {
        return detectPacketMarker(input[0], 4)

    }

    fun part2(input: List<String>): Int {
        return detectPacketMarker(input[0], 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
