import java.awt.geom.Ellipse2D.Double

import org.s_mach.tylerlucas._

//Ex. 1 Testing
val egg = new Double(5,10,20,30) with RectangleLike
egg.getFrame
egg.translate(5,5)
egg.getX
egg.getY

//Ex. 2 Testing
val orderedPt = new OrderedPoint
val oPt2 = new OrderedPoint(5,5)
orderedPt.compare(oPt2)


//Ex. 4
val ex4 = new Chapter10 with CryptoLogger
val msg = ex4.encrypt("tyler")
ex4.decrypt(msg)
//Ex. 5
val pt = new java.awt.Point with PropertyChangeSupportLike
//Ex.6
/*
JComponent cannot extend Container in Java due to enforcement
of single parent class for all subclasses. This could be fixed
in scala by using traits.
 */

/*Ex. 7:
Demonstrate layered traits,
abstract methods, and concrete & abstract fields
 */
class Person(val name: String) {
  val toughness = 100
  println("A person was born...")
}
class SuperHero(override val name: String, val heroName: String) extends Person(name) {
  println("A hero was born...")
}
trait PhysicalPower {
  println("With great physical power...")
  val muscleSize = "H U G E"
  def physicalAbility: String
}
trait SuperStrength extends PhysicalPower{
  println("with insurmountable strength...")
  override def physicalAbility: String = "I can lift buildings!"
}
trait SuperSpeed extends PhysicalPower{
  println("with unbeatable speed...")
  override def physicalAbility: String = "I'm faster than a speeding bullet!"
}
trait xRayVision {
  println("with X-Ray Vision...")
   val range: Int
   def specialAbility: String = "I can see through walls!"
}

val superman = new {override val toughness = 200; override val range = 50 }
  with SuperHero("Clark", "Superman") with SuperStrength with xRayVision
superman.toughness
superman.physicalAbility
superman.specialAbility
superman.range
superman.muscleSize
