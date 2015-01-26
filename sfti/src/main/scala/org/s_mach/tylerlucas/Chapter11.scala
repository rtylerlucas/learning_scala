package org.s_mach.tylerlucas
import java.lang.Long

/**
 * Created by RTylerLucas on 1/23/15.
 */
class Fraction (n: Int, d: Int){
  private val num: Int = if(d==0) 1 else n * sign(d) / gcd(n,d)
  private val den: Int = if (d==0) 0 else d * sign(d) / gcd(n,d)
  def sign(a: Int) = if(a > 0) 1 else if(a < 0) -1 else 0
  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
  def abs(a: Int) = if (a > 0) a else -a
  def getNum: Int = num
  def getDen: Int = den

  def + (fraction: Fraction): Fraction = {
    if (den == fraction.getDen) new Fraction(num + fraction.getNum, den)
    else {
      val newDen = den * fraction.getDen
      val leftNum = num * fraction.getDen
      val rightNum = fraction.getNum * den
      new Fraction(leftNum + rightNum, newDen)
    }
  }

  def - (fraction: Fraction): Fraction = {
    if (den == fraction.getDen) new Fraction(num - fraction.getNum, den)
    else {
      val newDen = den * fraction.getDen
      val leftNum = num * fraction.getDen
      val rightNum = fraction.getNum * den
      new Fraction(leftNum - rightNum, newDen)
    }
  }

  def * (fraction: Fraction): Fraction = {
    val newDen = den * fraction.getDen
    new Fraction(num * fraction.getNum, newDen)
  }
  def / (fraction: Fraction): Fraction = {
    new Fraction(num * fraction.getDen, den * fraction.getNum)
  }

  override def toString: String = num + " / " + den
}
