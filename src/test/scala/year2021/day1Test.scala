package year2021

import org.scalatest.funsuite.AnyFunSuite

class day1Tests extends AnyFunSuite:
    test("Part1 example from website should yield 7") {
        val input = """199
200
208
210
200
207
240
269
260
263"""
        val result = day1.part1(input)
        assert(result == "7")
    }

    test("Part1: Only one line should yield 0") {
        val input = """199"""
        val result = day1.part1(input)
        assert(result == "0")
    }

    test("Part1: Zero lines should yield 0") {
        val input = """"""
        val result = day1.part1(input)
        assert(result == "0")
    }

    test("Part 2 example from web should yeild 5") {
        val input = """199
200
208
210
200
207
240
269
260
263"""
        val result = day1.part2(input)
        assert(result == "5")
    }
    