package year2021

object day2:
    def part1(input: String) :String = {
        def dist(search: String) : Int = input
            .linesIterator
            .filter(_.contains(search))
            .map(_.split(" ")(1))
            .map(_.toInt)
            .sum

        val forward = dist("forward")

        val up = dist("up")

        val down = dist("down")
        
        (forward * (down - up)).toString()
    }

    def part2(input: String) :String = {
        var horiz, aim, depth = 0;

        input.linesIterator.foreach{ line =>
            val command = line.split(" ")
            val identifier = command(0)
            val amount = command(1).toInt

            identifier match {
                case "forward" => {
                    horiz += amount
                    depth += aim * amount
                }
                case "up" => aim -= amount
                case "down" => aim += amount
            }
        }

        (horiz * depth).toString()
    }
