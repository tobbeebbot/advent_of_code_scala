package year2021

import org.scalatest.funsuite.AnyFunSuite
import Day5.Point

class day5Tests extends AnyFunSuite:
    test("Completes task on example data") {
        val input = """0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2"""
        assert(Day5.part2(input) == "12")
    }

    test("can interpolate") {
        val p1 = Point.parse("9,4")
        val p2 = Point.parse("3,4")

        val pointsList = Day5.interpolate(p1,p2)

        assert(pointsList == List(Point(3,4),
                                  Point(4,4),
                                  Point(5,4),
                                  Point(6,4),
                                  Point(7,4),
                                  Point(8,4),
                                  Point(9,4)))
    }

    test("can interpolate diagonal") {
        val p1 = Point.parse("1,1")
        val p2 = Point.parse("3,3")

        val pointsList = Day5.interpolate(p1,p2)

        assert(pointsList == List(Point(1,1),
                                  Point(2,2),
                                  Point(3,3)))

        val p3 = Point.parse("9,7")
        val p4 = Point.parse("7,9")

        assert(Day5.interpolate(p3,p4) == List(Point(9,7), Point(8,8), Point(7,9)))
    }
     