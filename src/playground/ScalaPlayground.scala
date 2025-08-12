package playground


object ScalaPlayground extends App {
  def nTimes(f: Int => Int, n: Int): Int => Int =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes(f, n - 1)(f(x))

  // (x: Int) => ((x: Int) => ((x: Int) => x)(f(x)))(f(x))

}