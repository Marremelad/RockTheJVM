package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. Sensible toString method
  // println(instance) == println(instance.toString) // Syntactic sugar
  println(jim)

  // 3. Methods equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case classes have a handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Case classes are serializable
  // Akka

  // 7. Case classes have extractor patterns = Case classes can be used in PATTERN MATCHING

  // There are also case objects
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}


