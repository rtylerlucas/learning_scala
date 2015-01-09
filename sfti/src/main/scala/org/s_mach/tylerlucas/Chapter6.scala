package org.s_mach.tylerlucas

/**
 * Created by RTylerLucas on 1/6/15.
 */
object Chapter6 {
  private val centimeterToInchRatio = 2.54
  private val gallonToLiterRatio = 3.7854
  private val mileToKMRatio = 1.61
//Ex. 1, 2
  object Conversions {
    def inchesToCentimeters(in: Double) = {
      in * centimeterToInchRatio
    }
    def gallonsToLiters(in: Double) = {
      in * gallonToLiterRatio
    }
    def milesToKilometers(in: Double) = {
      in * mileToKMRatio
    }
  }
  class Point(val x: Int = 0, val y: Int = 0) {

  }
  //Ex. 4
  object Point {
    def apply(x: Int, y: Int) = {
      new Point(x,y)
    }
  }
  //Ex. 5
  object Reverse extends App {
    var counter = 0
    var current = ""
    if(args.length>0){
      for(i<-args.length-1 to 0 by -1) {
       if(args(i)!=" "){
         counter+= 1
         current = args(i) + current
       }
        else{
         counter = 0
         print(current + " ")
         current = ""
       }
      }
      print(current)
    }
    else println("Empty Args!")

  }
  object PlayingCard extends Enumeration {
    type PlayingCard = Value
    val Heart = Value(0, "\u2665")
    val Spade = Value(1, "\u2660")
    val Diamond = Value(2, "\u2666")
    val Club = Value(3, "\u2663")
  }

}
