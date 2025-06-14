package lectures.part2oop

object AbstractDataTypes extends App{

  // Abstract
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("Crunch, crunch")
  }

  private trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "Fresh meat"
  }

  private trait ColdBlooded

  private class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Reptile"
    def eat: Unit = println("Nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a crocodile and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  private val crocodile = new Crocodile
  crocodile.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
}
