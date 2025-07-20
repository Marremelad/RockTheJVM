package playground

object ScalaPlayground extends App {

  val list = List(1, 2, 3)
  println(list.map(n => n + 1))
  println(list.flatMap(n => List(n, n + 1, n + 2)))

//  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
//    transformer(h) ++ t.flatMap(transformer)
//  }
}