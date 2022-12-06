import java.util.*

fun main() {

    data class CrateMovement(val numCrates: Int, val fromStack: Int, val toStack: Int)

    fun parseCrates(input: List<String>): MutableList<Deque<String>> {
        val crateChart = input.subList(0, input.indexOf(""))
        val numRows = crateChart[crateChart.size - 1].replace("\\s".toRegex(), "").length
        val crateList: MutableList<Deque<String>> = MutableList(numRows) { LinkedList() }

        crateChart.forEach {
            var index = it.indexOf("[")
            while (index != -1) {
                if (index >= 0) {
                    val crateStack = index / 4
                    crateList[crateStack].addLast(it[index + 1].toString())
                }
                index = it.indexOf("[", index + 1)
            }
        }

        return crateList
    }

    fun parseInstructions(input: List<String>): List<CrateMovement> {
        val instructions = input.subList(input.indexOf("") + 1, input.size)
        val regex = Regex("[^0-9 ]")
        return instructions.map { regex.replace(it, "") }.map { it.trim().split("  ") }.map { CrateMovement(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
    }

    fun moveCrates(instructionList: List<CrateMovement>, crateList: MutableList<Deque<String>>, is9001: Boolean) {
        instructionList.forEach { instruction ->
            val crateStack = LinkedList<String>()

            for(i in 1..instruction.numCrates) {
                if(!is9001) {
                    crateList[instruction.toStack - 1].addFirst(crateList[instruction.fromStack - 1].removeFirst())
                } else {
                    crateStack.addLast(crateList[instruction.fromStack - 1].removeFirst())
                }
            }

            if(is9001) {
                crateStack.reversed().forEach { crateList[instruction.toStack - 1].addFirst(it) }
            }
        }
    }


    fun part1(input: List<String>): String {
        val crateList = parseCrates(input)
        val instructionList = parseInstructions(input)
        moveCrates(instructionList, crateList, false)
        return crateList.joinToString("") { it.peekFirst() }
    }

    fun part2(input: List<String>): String {
        val crateList = parseCrates(input)
        val instructionList = parseInstructions(input)
        moveCrates(instructionList, crateList, true)
        return crateList.joinToString("") { it.peekFirst() }
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
