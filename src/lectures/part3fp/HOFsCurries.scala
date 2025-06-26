package lectures.part3fp

object HOFsCurries extends App{

  val superFunction: (Int, (String, Int => Boolean) => Int) => Int => Int = null
  // Higher order function (HOF). A function that takes another function as an argument
  // or has a function as its result value

  // mpa, flatmap and filter are examples of HOFs

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1)) // Result value = 11

  def nTimesBetter(f: Int => Int, n: Int): Int => Int = { // Function composition
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  val plusTen = nTimesBetter(plusOne, 10)
  println(plusTen(1))

  // Curried functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) =>  x + y
  val addOne = superAdder(1)
  println(addOne(10))
  println(superAdder(1)(10))

  // Functions with multiple parameter lists

//  val curriedFormatter: String => Double => String =
//    (format: String) => (double: Double) => format.format(double)

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormater: Double => String = curriedFormatter("%4.2f")
  val preciseFormater: Double => String = curriedFormatter("%10.8f")

  println(standardFormater(Math.PI))
  println(preciseFormater(Math.PI))

  def toCurry(f: (Int, Int) => Int): Int => Int => Int = {
    x => y => f(x, y)
  }

  def fromCurry(f: Int => Int => Int): (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }

  def compose[A, B, C](f: A => B, g: C => A): C => B = {
    x => f(g(x))
  }

  def andThen[A, B, C](f: A => B, g: B => C): A => C = {
    x => g(f(x))
  }

  def ultraAdder: Int => Int => Int = toCurry(_ + _)
  def addFour = ultraAdder(4)
  println(addFour(17))

  val addTwo = (x: Int) => x + 2
  val timesThree = (x: Int) => x * 3

  val composed = compose(addTwo, timesThree)
  val ordered = andThen(addTwo, timesThree)

  println(composed(4))
  println(ordered(4))
}
