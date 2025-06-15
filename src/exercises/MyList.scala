package exercises

abstract class MyList {

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String

  // Polymorphic call
  override def toString: String = s"[$printElements]"
}
object MyList {

  def apply(): Empty.type = Empty
  def apply(element: Int): MyList = new Cons(element, Empty)
  def apply(elements: Int*): MyList = {
    apply(elements.toList)
  }
  def apply(elements: List[Int], result: MyList = Empty): MyList = {
    if (elements.length <= 0) result
    else {
      apply(elements.init, new Cons(elements.last, result))
    }
  }
}

object Empty extends MyList {

  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList = Empty) extends MyList {

  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String =
    if (tail.isEmpty) s"$head"
    else s"$h, ${t.printElements}"
}

object testList extends App {
  val myList = MyList(1, 2, 3)
  println(myList.add(4))
}
