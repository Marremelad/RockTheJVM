package lectures.part1basics

object CBVvsCBN extends App {

  def callByValue(x: Long): Unit = { // Evaluates the argument before passing it, showing the same results twice
    println(s"By value: $x")
    println(s"By value: $x")
  }

  def callByName(x: => Long): Unit = { // Passes the expression 'as is'. Expression will be evaluated each time it is used
    println(s"By name: $x")
    println(s"By name: $x")
  }

  callByValue(System.nanoTime()) // Will output the same result twice
  callByName(System.nanoTime()) // Will output two different results

  def printFirst(x: Int, y: => Int): Unit = {
    println(x)
  }

  def infinite(): Int = 1 + infinite()

//  printFirst(infinite(), 11) // Tries to evaluate the infinite recursive function, resulting in a stack overflow
  printFirst(11, infinite()) // Passes the expression 'as is' and will wait to execute it until it is used
}
