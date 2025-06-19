package playground

object ScalaPlayground extends App {

  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  val getIntReturner = (a: Int) => new Function[Int, Int] {
    override def apply(b: Int = a): Int = a * b
  }

 println(getIntReturner(2))

  print(stringConcatenator("Sca", "la!"))
}
