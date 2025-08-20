package lectures.part1basics

object Expressions extends App {

  val x = 1 + 1 // EXPRESSION
  println(x) // 2

  println(2 + 3 * 4) // 14
  // Mathematical operators: +, -, *, /, &, ^, <<, >>, >>> (right shift with zero extension)

  println(1 == x) // false
  // Equality operators: ==, !=, >, >=, <, <=

  println(!(1 == x)) // true
  // Logical operators: !, &&, ||

  var aVariable = 2
  aVariable += 3 // Also works with -=, *=, /=

  // Instructions, (DO) vs Expressions (Value)

  // IF Expression.
  val aCondition = true
  var aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN!

  // Everything in Scala is an Expression!

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  // Side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello!" else "Goodbye!"
  }
}
