package year2021

import org.scalatest.funsuite.AnyFunSuite

class day3Tests extends AnyFunSuite:
    test("Part1: Example from web works") {
        val input = """00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010"""
        assert(day3.part1(input) == "198")
    }

    // test("Part2: Example from web works") {
    //     val input = """temp"""
    //     assert(day3.part2(input) == "900")
    // }