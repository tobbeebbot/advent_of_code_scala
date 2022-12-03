import scala.io.Source
import year2021._

@main def entry = {
    
    val path = "inputs/2021/day2/part1.txt"
    val input = Source.fromFile(path).mkString
    
    println(s"last entry check: ${input.lines().toArray().last}")

    println(day2.part2(input))
}