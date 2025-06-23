package playground

object ScalaPlayground extends App {

  val plusOne = (x: Int) => x + 1

  def nTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes(f, n - 1)(f(x))
  }

  // (x: Int) => (

  def incrementN(x: Int, n: Int): Int = {
    if (n <= 5) x
    else x + incrementN(x, n - 1)
  }

  def curriedFormater(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormater("%4.2f")
  println(standardFormat(Math.PI))

  def superAdder(x: Int)(y: Int): Int = x + y

  val sugarSuperAdder = (x: Int) => (y: Int) => x + y
}
