package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  // EXERCISES

  // Greeting function.
  def aGreeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old!"
  }

//  println(aGreeting("John", 30))

  def factorial(n: Int): Long = {
    if (n <= 1) 1
    else
    n * factorial(n - 1) // n times the return value of the function.
  }

  def fibonacci(n: Int): Long = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean  = {
      if (t <= 1) true
      else (n % t != 0) && isPrimeUntil(t - 1)
    }
    if (n <= 1) false
    else isPrimeUntil(n / 2)
  }

//  println(factorial(5))
//  println(fibonacci(3))
//  println(isPrime(0))
}