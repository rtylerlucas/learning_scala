package org.s_mach.tylerlucas

/**
 * Created by RTylerLucas on 1/16/15.
 */
class Chapter10 {

}
trait RectangleLike {
  def x: Double
  def y: Double
  def width: Double
  def height: Double

   def translate(dx: Int, dy: Int) = {
    x += dx
    y += dy
  }
   def grow(x: Int, y: Int) = {
    height += y
    width += x
  }
}
