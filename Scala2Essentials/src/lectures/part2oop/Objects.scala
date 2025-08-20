package lectures.part2oop

object Objects{

  def main(args: Array[String]): Unit = {
    // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
    object Person { // type + its only instance
      // "static"/"class" - level functionality
      val N_EYES = 2
      def canFly: Boolean = false

      // factory method
      def apply(name: String) = new Person(name)
    }
    class Person(val name: String) {
      // Instance level functionality
    }
    // COMPANIONS

    println(Person.N_EYES)
    println(Person.canFly)

    val mary = Person
    val tom = Person
    println(mary == tom) // The Person object is a singleton instance. This equality check is therefore true

    // Create instances through the Person class
    val bob = new Person("Bob")
    val james = new Person("James")
    println(bob == james) // Class instances are not equal because they point to different things in memory
  }
}
