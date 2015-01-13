package org.s_mach.tylerlucas

/**
 * Created by RTylerLucas on 1/11/15.
 */
class Chapter8 {

}
class BankAccount(initialBalance: Double) {
  protected var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = {balance += amount; balance}
  def withdraw(amount: Double) = {balance -= amount; balance}
}
//Ex. 1
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = {balance -= 1; balance += amount; balance}
  override def withdraw(amount: Double): Double = {balance -= 1; balance -= amount; balance}
}
//Ex 2
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var freeTransactions = 3
  private val startDate = java.util.Calendar.getInstance().getTime()

  override def deposit(amount: Double): Double = {
    if(freeTransactions!=0) freeTransactions -= 1
    else balance -= 1
    balance += amount
    balance
  }

  override def withdraw(amount: Double): Double = {
    if(freeTransactions!=0) freeTransactions -= 1
    else balance -= 1
    balance -= amount
    balance
  }
  def earnMonthlyInterest = {
    balance = balance + (balance * 0.05)
    freeTransactions = 3
  }
}
//Ex 3
class Animal {

  def sleep = println("The Animal sleeps...")
  def eat = println("The Animal eats...")
}
class Dog extends Animal {
  override def sleep = println("The Dog sleeps...")
  override def eat = println("The Dog eats puppy chow...")
}
//Ex. 4
abstract class Item {
  def price: Double
  def description: String
}
class SimpleItem(override val price: Double, override val description: String) extends Item {

}
class Bundle(args: SimpleItem*) extends Item {
  var price: Double = 0.0
  var description = ""
  for(arg <- args) { price += arg.price; description += ", " + arg.description }
  def addItem(item: SimpleItem) = { price += item.price }
}

//Ex. 5
class Point(val x: Int, val y: Int) {}
class LabeledPoint(val label: String, override val x: Int, override val y: Int) extends Point(x,y){}

//Ex. 6
abstract class Shape{
  def centerPoint
}
class Circle(val radius: Int) extends Shape{
  val centerPoint = new Point(0,0)
}
class Rectangle(val width: Int, val height: Int) extends Shape {
  val centerPoint = new Point(0,0)
}