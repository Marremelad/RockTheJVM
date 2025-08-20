package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: Use functions as first class elements
  // PROBLEM: OOP

  trait MyFunction[-A, +B] {
    def apply(element: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2)) // doubler can be called like a regular function vy leveraging the apply method of MyFunction

  // Instead of creating our own function like structures we can use the built-in function types. Function[A, B]
  val stringToIntConverter = new Function1[String, Int] { // A function that takes a String and returns an Int
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] { // The last type is the result type
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Syntactic sugar for function types: Function[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTION ARE OBJECTS

  // Exercises:
  /*
    1.  a function which takes 2 strings and concatenates them
    2.  transform the MyPredicate and MyTransformer into function types
    3.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  // A function that takes an Int and returns a function that takes an Int and returns an Int
  val superAdder = (x: Int) => (y: Int) => x + y

  print(stringConcatenator("Sca", "la!"))
  println(superAdder(3)(4)) // Curried function
}
