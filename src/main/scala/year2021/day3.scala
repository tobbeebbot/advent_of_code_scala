package year2021

object day3:
    def part1(input: String): String =
        def toDecimal(binary: IndexedSeq[Int]): Int = {
            binary
                .reverse
                .zipWithIndex
                .map((bit, index) => math.pow(2, index) * bit)
                .sum.toInt
        }

        val counts = input
            .linesIterator
            .map(s => s.map(_ match {
                case '0' => -1
                case '1' => 1
            }))
            .reduce((a, b) => (a, b).zipped.map((x, y) => x + y))
        
        val gammaRate = counts.map(c => if c > 0 then 1 else 0)
        val epsilonRate = counts.map(c => if c <= 0 then 1 else 0)

        (toDecimal(gammaRate) * toDecimal(epsilonRate)).toString()

def part2(input: String): String = input
    // val counts = input
    //         .linesIterator
    //         .map(s => s.map(_ match {
    //             case '0' => -1
    //             case '1' => 1
    //         }))
    //         .reduce((a, b) => (a, b).zipped.map((x, y) => x + y))
    
    // // searchbit is the most common bit in column. if equal pick 1
    // val searchBits = counts.map(c => if c >= 0 then '1' else '0')



