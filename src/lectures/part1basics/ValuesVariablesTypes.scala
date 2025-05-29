package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  // x = 2 Error
  // VALS ARE IMMUTABLE.

  val y = 42 // Compiler can infer types.

  println(x)

  val aString: String = "Hello!";
  val anotherString: String = "Goodbye!"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 5273985273895237L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // Variables
  // In functional programing, a variable (var) is used for side effects.
  var aVariable: Int = 4
  aVaraible = 5
}
