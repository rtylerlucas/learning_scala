package org.s_mach.tylerlucas

/**
 * Created by RTylerLucas on 1/6/15.
 */
class Chapter6 {
  private val centimeterToInchRatio = 2.54
  private val gallonToLiterRatio = 3.7854
  private val mileToKMRatio = 1.61

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
  object Point {
    def apply(x: Int, y: Int) = {
      new Point(x,y)
    }
  }


}
