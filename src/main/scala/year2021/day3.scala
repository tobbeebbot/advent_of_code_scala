package year2021

object day3:
    def toDecimal(binary: List[Int]): Int =
        binary
            .reverse
            .zipWithIndex
            .map((bit, index) => math.pow(2, index) * bit)
            .sum.toInt
    
    def countBits(strings: Iterator[String]): List[Int] =
        strings
            .map(s => s.map(_ match {
                case '0' => -1
                case '1' => 1
            }))
            .reduce((a, b) => (a, b).zipped.map((x, y) => x + y))
            .toList

    def part1(input: String): String =
        val counts = countBits(input.linesIterator)
            
        val gammaRate = counts.map(c => if c > 0 then 1 else 0)
        val epsilonRate = counts.map(c => if c <= 0 then 1 else 0)

        (toDecimal(gammaRate) * toDecimal(epsilonRate)).toString()

    def part2(input: String): String =

        var bitsListCo2 = input
            .linesIterator
            .map( line => line.toVector)
            .toList
        
        var bitsListOxygen = bitsListCo2
        
        for i <- 0 until bitsListOxygen.head.size do {
            val groups = bitsListOxygen.groupBy(_(i))
            if groups.size == 1 then
                bitsListOxygen = groups.values.head
            else if groups('1').length >= groups('0').length then
                bitsListOxygen = groups('1')
            else
                bitsListOxygen = groups('0')
        }

        for i <- 0 until bitsListCo2.head.size do {
            val groups = bitsListCo2.groupBy(_(i))
            if groups.size == 1 then
                bitsListCo2 = groups.values.head
            else if groups('0').length <= groups('1').length then
                bitsListCo2 = groups('0')
            else
                bitsListCo2 = groups('1')
        }

        val bitsCo2 = bitsListCo2.head.map(_ match {
            case '1' => 1
            case '0' => 0
        }).toList
        val decimalCo2 = toDecimal(bitsCo2)
        val decimalOx = toDecimal(bitsListOxygen.head.map(_ match {
            case '1' => 1
            case '0' => 0
        }).toList)

        (decimalOx * decimalCo2).toString()




