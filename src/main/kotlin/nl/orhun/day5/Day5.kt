package nl.orhun.day5

import nl.orhun.Puzzle

fun main() {
    Day5.partOne()
    Day5.partTwo()
}
object Day5 : Puzzle() {
    private val lines = readLines(2020, 5)
    private val allSeats = 0..0b1111111111;

    override fun partOne() {
        println(createSeats().maxOf { it.seatId })
    }

    override fun partTwo() {
        val seatIds = createSeats().map { it.seatId }
        val seatId = (allSeats - seatIds)
            .first { seatIds.contains(it - 1) and seatIds.contains(it + 1) }
        println(seatId)
    }

    private fun createSeats() = lines.map {
        val row = it.substring(0, 7)
            .replace('B', '1')
            .replace('F', '0')
            .toInt(2)

        val column = it.substring(it.length - 3, it.length)
            .replace('R', '1')
            .replace('L', '0')
            .toInt(2)

        val seatId = row * 8 + column;
        Seat(row, column, seatId);
    }

    data class Seat(val row: Int, val column: Int, val seatId: Int)
}