package lectures.part3fp

object AnonymousFunctions extends App {

//  val doubler = new Function[Int, Int] {
//    override def apply(x: Int): Int = x * 2
//  }

  // Anonymous function (LAMBDA) All functions below are equivalent
//  val doubler: Int => Int = (a: Int) => a * 2
//  val doubler = (x: Int) => x * 2
  val doubler: Int => Int = _ * 2

//  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
//  val adder = (a: Int, b: Int) => a + b
  val adder: (Int, Int) => Int = _ + _


  // Lambda with no parameters
//  val doSomething: () => Int = () => 3
  val doSomething = () => 3

  // Be careful when calling a lambda with no parameters
  println(doSomething) // The function itself
  println(doSomething()) // Calling the function

  // Curly braces with lambdas
  val stringToInt = { (string: String) =>
    string.toInt
  }

//  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val superAdder = (x: Int) => (y: Int) => (z: Int) => x + y + z

  println(superAdder(1)(2)(3))
}
