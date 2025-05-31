package lectures.part1basics

import scala.annotation.tailrec

// Tail recursive functions
object Recursion extends App {

  def factorial(n: Int): Int = {
    @tailrec
    def factAux(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else factAux(x - 1, x * acc)
    }
    factAux(n, 1)
  }

  @tailrec
  def countUp(n: Int, acc: Int = 0): Unit = {
    if (n >= 0) {
      println(acc)
      countUp(n - 1, acc + 1)
    }
  }

  def power(x: Int, n: Int): Int = {
    @tailrec
    def powerAux(n: Int, acc: Int): Int = {
      if (n < 1) acc
      else powerAux(n - 1, x * acc)
    }
    powerAux(n, 1)
  }

  def concat(s: String, n: Int): String = {
    @tailrec
    def concatAux(n: Int, acc: String = ""): String = {
      if (n == 0) acc
      else concatAux(n - 1, acc + s)
    }
    concatAux(n)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeAux(t: Int): Boolean = {
      if (t <= 1) true
      else (t % n != 0) && isPrimeAux(t - 1)
    }
    isPrimeAux(n / 2)
  }

  def fibonacci(n: Int) : Int = {
    @tailrec
    def fibonacciAux(n: Int, prev: Int = 0, curr: Int = 1): Int = {
      if (n == 0) prev
      else fibonacciAux(n - 1, curr, prev + curr)
    }
    fibonacciAux(n)
  }

  println(fibonacci(5))
}
