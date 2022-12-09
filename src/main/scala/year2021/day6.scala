package year2021

object Day6 {
    def part1(input: String): String = {
        def nextDay(fish: List[Int]): List[Int] = {
            val newBorns = fish.filter(_ == 0).map(_ => 8)
            val agedFish = fish.map(_ match {
                case 0 => 6
                case a => a - 1
            })
            agedFish ++ newBorns
        }
        var fish = input.split(",").map(_.toInt).toList
        for _ <- 0 until 80 do
            fish = nextDay(fish)
        
        fish.size.toString()
    }

    def part2(input: String): String = {
        def simulate(generations: Long,
                     fish: IndexedSeq[Long]): IndexedSeq[Long] = {
            if generations == 0 then
                fish
            else
                val numParents, numChildren = fish.head
                val nextGen = fish.tail :+ numChildren
                val nextGen2 = nextGen.updated(6, nextGen(6) + numParents)
                simulate(generations - 1, nextGen2)
        }

        val fishInput = input.split(",").map(_.toInt)
        val fishByAge = fishInput.groupBy(i => i).mapValues(_.size.toLong)
        
        // Indexed Seq with num of fish at each age at respective index
        val fishCompact = (0 to 8).map(i => fishByAge.getOrElse(i, 0l))

        val newFish = simulate(256, fishCompact)
        newFish.sum.toString()
    }
}