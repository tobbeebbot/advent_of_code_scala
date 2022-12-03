package year2021

import org.scalatest.funsuite.AnyFunSuite

class day3Tests extends AnyFunSuite:
    test("toDecimal returns decimal representation of binary") {
        assert(day3.toDecimal(List(1,0,1)) == 5)
    }

    test("count bits in sequence of binary numbers") {
        val input = """1001
1111
0000
1100"""
        assert(day3.countBits(input.linesIterator) == List(2,0,-2,0))
    }

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

    test("Part2: Example from web works") {
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
        assert(day3.part2(input) == "230")
    }