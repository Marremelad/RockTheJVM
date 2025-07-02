package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq (Sequence)
  val aSequence = Seq(1, 2, 3, 4)
  val unorderedSequence = Seq(1, 3, 2)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(unorderedSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)
  (1 to 10).foreach(x => println("Hello Scala!"))

  // Lists
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList
  val appended = aList :+ 42
  val applesFive = List.fill(5)("Apple")
  println(aList.mkString("-|-"))
  println(prepended)
  println(appended)
  println(applesFive)

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)

  // Mutation
  numbers(2) = 0
  println(numbers.mkString(" "))

  // Arrays and Seq
  val numbersSeq: Seq[Int] = numbers // Implicit conversion
  println(numbersSeq)

  // Vectors
  val aVector: Vector[Int] = Vector(1, 2, 3)
  println(aVector)

  // Vector vs List, performance test
  val maxIterations = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
//    val r = new Random
//    val times = for {
//      iterations <- 1 to maxIterations
//    } yield {
//      val currentTime = System.nanoTime()
//      collection.updated(r.nextInt(maxCapacity), 0)
//      System.nanoTime() - currentTime
//    }
//    times.sum.toDouble / maxIterations
    val r = new Random
    (1 to maxIterations).map{_ =>
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), 0)
      (System.nanoTime() - currentTime).toDouble
    }.sum / maxIterations
  }

  val numberList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numberList))
  println(getWriteTime(numbersVector))
}
