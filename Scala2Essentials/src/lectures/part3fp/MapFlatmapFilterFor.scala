package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
//  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2)
  val chars = List('a','b','c')
  val colors = List("black", "white")

  // List("a1", "a2"... "d4")

  // "iterating"
  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => s"$n$c-$color")))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombination = for {
    n <- numbers // if n % 2 == 0
    c <- chars
    color <- colors
  } yield s"$n$c-$color"
  println(forCombination)

  for {
    n <- numbers
  } println(n)

  // Syntax overload
  list.map { x =>
    x * 2
  }
}
