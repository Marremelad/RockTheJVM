package lectures.part2oop

import java.time.LocalDate

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

  class Author(name: String, surname: String, dateOfBirth: LocalDate) {
    def fullName = s"$name $surname"

    def age(): Int = {
      val today = LocalDate.now()
      today.getYear - dateOfBirth.getYear - {
        if (today.getDayOfYear < dateOfBirth.getDayOfYear) 1
        else 0
      }
    }
  }

  class Novel(name: String, dateOfRelease: LocalDate, author: Author) {
    def authorAge() = s"The author of '$name' is ${author.age} years old."

    def isWrittenBy() = s"'$name' is written by ${author.fullName}."

    def wasReleased() = s"This copy of '$name' was released in ${dateOfRelease.getYear}."

    def copy(newYearOfRelease: LocalDate): Novel =
      new Novel(name, newYearOfRelease, author)
  }

  class Counter(val value: Int = 0) {
    def currentCount() = s"This counter has a value of $value."

    def increment(): Counter = {
      println("Incrementing")
      new Counter(value + 1)
    }
    def increment(n: Int): Counter = {
      if (n <= 0) {
        println(s"This counter has a value of $value.")
        this
      }
      else increment().increment(n - 1)
    }

    def decrement(): Counter = {
      println(value)
      new Counter(value - 1)
    }
    def decrement(n: Int): Counter = {
      if (n <= 0) this
      else decrement().decrement(n - 1)
    }

  }

  val person = new Person()
  person.greet()
  person.greet("Bob")

  val someAuthor = new Author("Bob", "Boberson", LocalDate.of(1990, 10, 15))
  val someNovel = new Novel("The best Novel", LocalDate.of(2021, 10, 10), someAuthor)
  val novelCopy = someNovel.copy(LocalDate.now())

  println(someNovel.authorAge())
  println(someNovel.isWrittenBy())
  println(someNovel.wasReleased())
  println(novelCopy.wasReleased())

  val counter = new Counter()
  println(counter.currentCount())
  counter.increment(10)
}
