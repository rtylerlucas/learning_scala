package org.s_mach.tylerlucas
import math.BigInt
import scala.beans.BeanProperty
/**
 * Created by RTylerLucas on 1/5/15.
 */
object Chapter5 {
//Exercise 1
  class Counter {
    private var value: BigInt = 0
    def increment() { value += 1 }
    def add(amount: Int) {value += amount}
    def current() = value
  }
//Exercise 2
  class BankAccount {
    private var balance = 0
    def deposit(amount: Int) = { balance += amount }
    def withdraw (amount: Int) = {
      if(amount<=balance){
        balance -= amount
        amount
      }
      else { 0 }
    }
    def current = balance
  }
//Exercise 3
  class Time {
    private var hours = 0
    private var minutes = 0

    def this(hours: Int, minutes: Int) = {
      this()
      if(hours < 24 && hours >= 0){ this.hours = hours }
      if(minutes < 60 && hours >= 0){ this.minutes = minutes }
    }
    def before(other: Time): Boolean = {
      if((other.hours + (other.minutes/60.0)) > (hours + (minutes/60.0))) true
      else false
    }
    def set(hours: Int, minutes: Int) = {
      if(hours < 24 && hours >= 0){ this.hours = hours }
      if(minutes < 60 && hours >= 0){ this.minutes = minutes }
    }
    def current: (Int, Int) = (hours, minutes)
  }
//Exercise 5
  class Student(@BeanProperty var name: String = "", @BeanProperty var id: Long = 0L) {}
}
