package year2021

import org.scalatest.funsuite.AnyFunSuite

class day6Tests extends AnyFunSuite:
    test("Works on sample input") {
        val input = "3,4,3,1,2"
        assert(Day6.part1(input) == "5934")

        assert(Day6.part2(input) == "26984457539")
    }