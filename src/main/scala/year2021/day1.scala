package year2021

object day1 {
    def part1(input: String) :String = input
        .linesIterator
        .map(_.toInt)
        .sliding(2)
        .filter(_.size == 2)
        .filter(pair => pair(1) > pair(0))
        .size
        .toString()

    def part2(input: String) :String = input
        .linesIterator
        .map(_.toInt)
        .sliding(3,1)
        .map(_.sum)
        .sliding(2)
        .filter(_.size == 2)
        .filter(pair => pair(1) > pair(0))
        .size
        .toString()
}
