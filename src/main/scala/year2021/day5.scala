package year2021

import scala.collection.mutable

object Day5 {
    case class Point(x: Int, y: Int)
    object Point {
        def parse(spoint: String) : Point = {
            val sl = spoint.split(",")
            val x = sl(0).toInt
            val y = sl(1).toInt

            Point(x, y)
        }
    }

    def interpolate(p1: Point, p2: Point): List[Point] = {
        val isXAxis = p1.y == p2.y
        val isYAxis = p1.x == p2.x
        val x1 = math.min(p1.x, p2.x)
        val x2 = math.max(p1.x, p2.x)
        val y1 = math.min(p1.y, p2.y)
        val y2 = math.max(p1.y, p2.y)

        val xstep = if x1 == p1.x then 1 else -1
        val ystep = if y1 == p1.y then 1 else -1

        val res =
            if isXAxis then
                (x1 to x2).map(Point(_, p1.y))
            else if isYAxis then
                (y1 to y2).map(Point(p1.x, _))
            else
                for (x,y) <- (p1.x to p2.x by xstep) zip (p1.y to p2.y by ystep) yield
                        Point(x,y)
        res.toList
    }

    def part2(input: String): String = {
        //parse input into list of line ends
        val lines = input.split("\n")
                         .map{ sline =>
                            sline.split(" -> ")
                                 .map(Point.parse(_))
                             }
        
        // convert into list of lists of points
        val allPoints = lines.flatMap(linePoints =>
            interpolate(linePoints(0), linePoints(1)))

        // map points into numbers
        val pointMap : mutable.Map[Point, Int] = mutable.Map.empty

        allPoints.foreach(p => pointMap.updateWith(p)(_ match
            case Some(i) => Some(i + 1)
            case None => Some(1)
        ))
        
        pointMap.values.filter(_ > 1).size.toString()
    }
}