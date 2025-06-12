package lectures.part2oop

object Inheritance extends App {

  sealed class Animal {
    val creatureType = "Wild"
    protected def eat = println("The animal is eating")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("Crunch, crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // also works with 'Person(name)' because of aux constructor

  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "Domestic"
    override def eat =  {
      super.eat // Calls the method implementation from the inherited class
      println("Crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat // Can be accessed, even though the method is protected in the super class, because of overriding
  println(dog.creatureType)

  // Type substitution
  val unknownAnimal: Animal = new Dog("K9")
//  unknownAnimal.eat -- Would call the eat method from the Dog class, even though the variable was declared as an Animal

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files
}
