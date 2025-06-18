package lectures.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length)
// this ^^ will crash with a Null pointer exception

  // 1. Throwing exception
//  val aWeirdValue: String = throw new NullPointerException()

  // Throwable classes extend the Throwable class
  // Exception and Error are the major throwable subtypes

  // 2. How to catch exceptions

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else  42
  }

  val potentialFail = try {
    // Code that might throw
    getInt(false)
  }
  catch {
    case e: RuntimeException => 43
  }
  finally {
    // Code that will get executed NO MATTER WHAT
    // Optional
    // Does not influence the return type of this expression
    // Use finally only for side effects
    println("Finally")
  }

  // 3. How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  //    2147483648

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y

      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.add(-5, -2))
//  println(PocketCalculator.subtract(1, -2147483648))
  println(PocketCalculator.divide(2, 1))
}
