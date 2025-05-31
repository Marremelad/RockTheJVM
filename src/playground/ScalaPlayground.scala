package playground

object ScalaPlayground extends App{
  println("Hello, Scala!")

  // Factorial
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  // Fibonacci
  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // IsPrime
  def isPrime(n: Int): Boolean  = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1) // Returns false if t or (t - 1) divides n evenly
    } // Returns true if the recursion reaches the base case of (t <= 1)
    if (n <= 1) false // Handles edge cases of n == 1 or n == 0
    else isPrimeUntil(n / 2)
  }

  // Greatest common divisor.
  def gcd(a: Int, b: Int): Int = { // Euclid's algorithm
    if (b == 0) a
    else gcd(b, a % b)
  }

  // Raise to the power of n
  def power(x: Int, n: Int): Int = {
    if (n < 1) 1
    else x * power(x, n - 1)
  }

  // Count from 0 to n
  def countUp(n: Int): Unit = {
    if (n >= 0) {
      countUp(n - 1)
      println(n)
    }
  }

  // Count from n to 1
  def countDown(n: Int): Unit = {
    if (n >= 0) {
      println(n)
      countDown(n - 1)
    }
  }

  def sumOfDigits(n: Int): Int = {
    if (n == 0) 0
    else (n % 10) + sumOfDigits(n / 10)
  }

  def countDigits(n: Int): Int = {
    if (n < 10) 1
    else 1 + countDigits(n / 10)
  }

  def reverseNumber(n: Int): Int = {
    if (n < 10) n
    else ((n % 10).toString + reverseNumber(n / 10).toString).toInt
  }

  println(reverseNumber(123))

//  println(countDigits(111))
}
