package exercises

abstract class MyList[+A] {
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  // Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  // Polymorphic call
  override def toString: String = s"MyList[$printElements]"

  def traverse(): Unit = {
    if (isEmpty) {
      println("End of list")
    } else {
      println(s"Visiting: $head")
      tail.traverse()
    }
  }
}
object MyList {
  def apply[A](): MyList[A] = Empty

  def apply[A](element: A): MyList[A] = new Cons(element)

  def apply[A](elements: A*): MyList[A] = {
    apply(elements.toList, Empty)
  }

  def apply[A](elements: List[A], result: MyList[A] = Empty): MyList[A] = {
    if (elements.length <= 0) result
    else {
      apply(elements.init, new Cons(elements.last, result))
    }
  }
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
}

class Cons[+A](h: A, t: MyList[A] = Empty) extends MyList[A] {
  def head = h

  def tail = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String = {
    if (tail.isEmpty) s"$head"
    else s"$h, ${t.printElements}"
  }

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}

object testList extends App {
  val myList = MyList(1, 2, 3)
  val anotherMyList = MyList(4, 5)


//  println(myList.filter((element: Int) => element % 2 == 0))
  println(myList.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }))

//  println(myList.map((element: Int) => element * 2))
  println(myList.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }))

//  println(myList.flatMap((element: Int) => new Cons(element, new Cons(element + 1))))
  println(myList ++ anotherMyList)
  println(myList.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1))
  }))
}
