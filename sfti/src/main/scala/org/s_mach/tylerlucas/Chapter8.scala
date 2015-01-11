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
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = {balance -= 1; balance += amount; balance}
  override def withdraw(amount: Double): Double = {balance -= 1; balance -= amount; balance}
}