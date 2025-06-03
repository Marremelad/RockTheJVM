package lectures.part2oop

object OOBasics extends App {

  // Constructor
  class Person(name: String = "Some name", val age: Int = 0) { // Constructor parameters only become fields if declared with val or var
    // Class body

    val x = 2 // Fields can also be defined inside the class

    println(1 + 3) // Every time an object of a class is instantiated, the code inside the class is evaluated. Any functions that are called will be run

    // Method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!") // Use the 'this' keyword to reference the constructor parameter instead of the method one

    // Overloading
    def greet(): Unit = println(s"Hi, I am $name!") // If a method has no parameters and no naming conflicts occur,
    // 'name' will be resolved to the constructor parameter without the explicit use of 'this'

    // Multiple constructors (Constructor overloading/ Auxiliary constructors)
    def this(name: String) = this(name, 0) // Sets a default value for the age parameter
    def this() = this("John Doe") // This will override the default argument 'Some name'
  }

  val person = new Person()
  person.greet()
  person.greet("Bob")
}
