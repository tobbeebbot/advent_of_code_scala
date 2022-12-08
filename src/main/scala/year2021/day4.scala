package year2021

import scala.annotation.tailrec

case class BingoBoard(
        val rows: Vector[Set[Int]],
        val columns: Vector[Set[Int]])
{
    def applyNumber(value: Int): BingoBoard = {
        val newRows = for row <- rows yield
            row - value
        
        val newColumns = for col <- columns yield
            col - value

        BingoBoard(newRows, newColumns)
    }

    def checkBingo(): Boolean = {
        rows.exists(_.isEmpty) ||
        columns.exists(_.isEmpty)
    }

    def sum(): Int = {
        rows.map(_.sum).sum
    }
}

object BingoBoard {
    def parse(input: String) : BingoBoard = {
        val lines = input.replaceAllLiterally("  ", " ")
                         .split("\n")
                         .map{_.trim()
                         .split(" ")
                         .map(_.toInt)}
        val rows = lines.map(_.toSet)
                        .toVector
        val cols = lines.indices
                        .map{i =>
                            lines.map(_(i)).toSet
                        }
                        .toVector
        BingoBoard(rows, cols)
    }
}

object day4:
    

    def part1(input: String): String = {
        val inputStrings = input.split("\n\n")
        val numbers = inputStrings.head.split(",").map(_.toInt)

        val bingoBoards = inputStrings.tail.map(BingoBoard.parse(_))
        
        // Array[BingoBoard] -> Index, Sum
        @tailrec
        def findBingo(bbs: Seq[BingoBoard], numbers: Seq[Int]) : (Int, Int) = {
            if numbers.isEmpty then
                (-1,0)
            else {
                val num = numbers.head
                val newBoards = bbs.map(_ applyNumber num)
                val maybeBingo = newBoards.find(_.checkBingo())

                maybeBingo match
                    case Some(board) => (num, board.sum())
                    case None        => findBingo(newBoards, numbers.tail)
                
            }
        }

        val (num, sum) = findBingo(bingoBoards, numbers)
        val result = num * sum
        result.toString()
    }

    def part2(input: String): String = {
        val inputStrings = input.split("\n\n")
        val numbers = inputStrings.head.split(",").map(_.toInt)

        val bingoBoards = inputStrings.tail.map(BingoBoard.parse(_))
        
        // Array[BingoBoard] -> Index, Sum
        @tailrec
        def findLastBingo(bbs: Seq[BingoBoard], numbers: Seq[Int]) : (Int, Int) = {
            if numbers.isEmpty then
                (-1,0)
            else if bbs.size > 1 then {
                val num = numbers.head
                val newBoards = bbs.map(_ applyNumber num).filterNot(_.checkBingo())
                findLastBingo(newBoards, numbers.tail)
            } else {
                val num = numbers.head
                val newBoards = bbs.map(_ applyNumber num)
                newBoards.find(_.checkBingo()) match {
                    case Some(board) => (num, board.sum())
                    case None        => findLastBingo(newBoards, numbers.tail)
                }
            }
        }

        val (num, sum) = findLastBingo(bingoBoards, numbers)
        val result = num * sum
        result.toString()
    }