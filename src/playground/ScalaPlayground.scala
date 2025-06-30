package playground

object ScalaPlayground extends App {
  val forComprehension = for {
    x <- List(1, 2, 3)
    y <- List(10, 20)
    if x > 1
  } yield x * y

  println(forComprehension)

  println(List(1).init.length)
}
