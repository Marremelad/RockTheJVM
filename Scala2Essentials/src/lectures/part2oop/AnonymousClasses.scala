package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class
  val funnyAnimal: Animal = new Animal {

    // If abstract class does not have a method implementation, override is not needed
    def eat: Unit = println("I'm a funny animal, hahaha!")
  }
  /*
    equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
      def eat: Unit = println("I'm a funny animal, hahaha!")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val john = new Person("Jim") {
    override def sayHi: Unit = println("Hi, my name is John, how can i be of service?")
  }

  println("The funny animals class is" + funnyAnimal.getClass)
  println("John's class is" + john.getClass)
}
