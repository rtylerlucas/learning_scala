package org.s_mach.tylerlucas

/**
 * Created by RTylerLucas on 1/16/15.
 */
class Chapter10 {

}
//Ex. 1
trait RectangleLike {
  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double
  def setFrame(x: Double, y: Double, width: Double, height: Double): Unit

  def translate(dx: Int, dy: Int) = {
    setFrame(getX+dx, getY+dy, getWidth, getHeight)
  }
  def grow(dHeight: Int, dWidth: Int) = {
    setFrame(getX,getY,getWidth+dWidth, getHeight+dHeight)

  }
}

//Ex. 2
class OrderedPoint extends java.awt.Point with scala.math.Ordered[OrderedPoint]{

  def compare(orderedPoint: OrderedPoint): Int = {
    if( getX < orderedPoint.getX  || (getX == orderedPoint.getX && getY < orderedPoint.getY)) -1
    else{
      if(orderedPoint.getX == getX && orderedPoint.getY == getY) 0
      else 1
    }
  }
  def this(dx: Int, dy: Int){
    this()
    x = dx
    y = dy
  }
}

//Ex. 4
trait Logged {
  def log(msg: String)
}
trait CryptoLogger extends Logged {
  private final val caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  private final val lower = "abcdefghijklmnopqrstuvwxyz"
  val shift = 3
  def encrypt(msg: String): String = {
    var encrypted: String = ""
    for(ch <- msg){
        val x = (Math.max(caps.indexOf(ch), lower.indexOf(ch)))
        encrypted += lower((x+shift) % 26)
    }
    encrypted
  }
  def decrypt(msg: String): String = {
    var decrypted: String = ""
    for(ch <- msg){
      val x = (Math.max(caps.indexOf(ch), lower.indexOf(ch)))
      decrypted += lower((x-shift) % 26)
    }
    decrypted
  }
  def log(msg: String) = {
    println(encrypt(msg))
  }
}

//Ex 5. working on it
trait PropertyChangeSupport  {

}
