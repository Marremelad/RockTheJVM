package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person (val name: String, val age: Int, favoriteMovie: String) {
    def unary_+ : Person = new Person(name, age + 1, favoriteMovie)

    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"$name is hanging out with ${person.name}."

    def +(nickName: String): Person = new Person(s"$name ($nickName)", age, favoriteMovie)

    def learns(subject: String): String = s"$name learns $subject."

    def learnsScala = this.learns("Scala")
    def apply(n: Int): String = s"$name watched $favoriteMovie $n ${if (n != 1) "times" else "time"}."
  }

  val mary = new Person("Mary", 20, "Inception")
  val tom = new Person("Tom", 30, "Fight Club")

  println(mary.likes("Inception"))
  println(mary + tom)
  println(mary.+("The Rockstar").name)
  println(mary.age)
  println((+mary).age)
  println(mary learns "Programming")
  println(mary learnsScala)
  println(mary(2))
  println(mary(1))
}
