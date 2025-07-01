package exercises

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  def map[B](transformer: A => B): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  // Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def reverse(): MyList[A]

  // Polymorphic call
  override def toString: String = s"MyList($printElements)"

  def traverse(): Unit = {
    if (isEmpty) {
      println("End of list")
    } else {
      println(s"Visiting: $head")
      tail.traverse()
    }
  }

  // Hofs
  def foreach(f: A => Unit): Unit

  def sort (f: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B

//  def fold[B](start: B, operator: (B, A) => B): B
}
object MyList {
  def apply[A](): MyList[A] = Empty

  def apply[A](element: A): MyList[A] = Cons(element)

  def apply[A](elements: A*): MyList[A] = {
    apply(elements.toList, Empty)
  }

  def apply[A](elements: List[A], result: MyList[A] = Empty): MyList[A] = {
    if (elements.length <= 0) result
    else {
      apply(elements.init, Cons(elements.last, result))
    }
  }
}

//trait MyTransformer[-A, B] {
//  def transform(element: A): B
//}
//
//trait MyPredicate[-T] {
//  def test(element: T): Boolean
//}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = Cons(element, Empty)

  def printElements: String = ""

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def reverse(): MyList[Nothing] = Empty

  // Hofs
  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int): Empty.type = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  }

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start

//  def fold[B](start: B, operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A] = Empty) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = Cons(element, this)

  def printElements: String = {
    if (tail.isEmpty) s"$head"
    else s"$h, ${t.printElements}"
  }

  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: A => B): MyList[B] = {
    Cons(transformer(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def reverse(): MyList[A] = {
    if (tail.isEmpty) Cons(head)
    else tail.reverse() ++ Cons(head)
  }

  // Hofs
  def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Cons(zip(head, list.head), tail.zipWith(list.tail, zip))
  }

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }

//  def fold[B](start: B, operator: (B, A) => B): B = {
//    t.fold(operator(start, h), operator)
//  }
}

object ListTest extends App {
  val listOfIntegers = MyList(1, 2, 3)
  val cloneListOfIntegers = MyList(1, 2, 3)
  val anotherListOfIntegers = MyList(4, 5)
  val listOfStrings = MyList("Hello", "Scala")

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(_ * 2).toString)

  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(elem => Cons(elem, Cons(elem + 1, Empty))).toString)

  println(cloneListOfIntegers == listOfIntegers)

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x, y) => y - x))
  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))
  println(listOfIntegers.fold(0)(_ + _))

  // for comprehensions
  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield s"$n-$string"
  println(combinations)
}
