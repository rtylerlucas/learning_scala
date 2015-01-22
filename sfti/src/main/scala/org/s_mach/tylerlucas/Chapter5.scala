package org.s_mach.tylerlucas

import javax.print.attribute.standard.PrinterMoreInfoManufacturer

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
//Exercise 3 & 4
  class Time {
    private var hours = 0
    private var minutes = 0
    private var totalMinutes = 0

    def this(hours: Int, minutes: Int) = {
      this()
      if(hours < 24 && hours >= 0){ this.hours = hours }
      if(minutes < 60 && hours >= 0){ this.minutes = minutes }
      update
    }
    def before(other: Time): Boolean = {
      if((other.hours + (other.minutes/60.0)) > (hours + (minutes/60.0))) true
      else false
    }
    def set(hours: Int, minutes: Int) = {
      if(hours < 24 && hours >= 0){ this.hours = hours }
      if(minutes < 60 && hours >= 0){ this.minutes = minutes }
      update
    }
    def current: (Int, Int) = (hours, minutes)
    def update = {
      totalMinutes = minutes+(hours*60)
    }
  }
//Exercise 5 , 6 , 7
  class Student(@BeanProperty var name: String = "", @BeanProperty var id: Long = 0L) {}

//6. person class that turns neg ages to 0
  class Person(val name: String, var age: Int){
    if(age<0){
      age = 0
    }
    val firstName = name.split(" ")(0)
    val lastName = name.split(" ")(1)
  }
  //Exercise 8,9
  class Car(val manufacturer: String, val model: String) {
    private var year = -1
    private var license = ""

    def this(manufacturer: String, model: String, year: Int, license: String) {
      this(manufacturer, model)
      this.year = year
      this.license = license

    }
    def this(manufacturer: String, model: String, year: Int) {
      this(manufacturer, model)
      this.year = year
    }
    def this(manufacturer: String, model: String, license: String) {
      this(manufacturer, model)
      this.license = license
    }
  }

  //Ex. 10
  class Employee(val name: String, var salary: Double){
    def this() { this("John Q. Public", 0.0) }
  }
  //TechEmployee is shorter, and cleaner IMO
  class TechEmployee(val name: String = "John Q. Public", var salary: Int = 0.0){}
}

