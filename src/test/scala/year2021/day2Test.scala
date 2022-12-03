package year2021

import org.scalatest.funsuite.AnyFunSuite

class day2Tests extends AnyFunSuite:
    test("Part1: Example from web works") {
        val input = """forward 5
down 5
forward 8
up 3
down 8
forward 2"""
        assert(day2.part1(input) == "150")
    }

    test("Part2: Example from web works") {
        val input = """forward 5
down 5
forward 8
up 3
down 8
forward 2"""
        assert(day2.part2(input) == "900")
    }