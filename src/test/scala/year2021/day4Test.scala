package year2021

import org.scalatest.funsuite.AnyFunSuite

class day4Tests extends AnyFunSuite:
    test("Completes task on example data") {
        val input = """7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7"""

        assert(day4.part1(input) == "4512")
    }

    test("Completes task on example data part 2") {
        val input = """7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7"""

        assert(day4.part2(input) == "1924")
    }

    test("BingoBoard can parse test") {
      val input = """14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7"""
        val bb = BingoBoard.parse(input)
        assert(bb.rows.exists(_ == Set(14, 21, 17, 24, 4)))
        assert(bb.columns.exists(_ == Set(24, 9, 26, 6, 3)))
        assert(bb.rows.length == 5)
        assert(bb.columns.length == 5)
    }

    test("BingoBoard keeps track of unchecked numbers") {
        val bb = BingoBoard(
            Vector(Set(1,2,3), Set(4,6,7)),
            Vector(Set(3,4,5)))
        
        val nextBb = bb.applyNumber(3)

        assert(nextBb.columns.head == Set(4,5))
        assert(nextBb.rows.head == Set(1,2))
        assert(nextBb.rows.last == Set(4,6,7))

        val anotherBb = nextBb.applyNumber(7)

        assert(anotherBb.columns.head == Set(4,5))
        assert(anotherBb.rows.head == Set(1,2))
        assert(anotherBb.rows.last == Set(4,6))
    }

    test("Empty BingoBoard row or col has Bingo") {
        val bb = BingoBoard(
            Vector(Set(1), Set(4)),
            Vector(Set(3)))

        assert(bb.checkBingo() == false)

        val bb1 = bb.applyNumber(3)
        assert(bb1.checkBingo() == true)
    }