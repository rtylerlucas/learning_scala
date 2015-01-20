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
        var x = (Math.max(caps.indexOf(ch), lower.indexOf(ch)))
        x = (x+shift) % 26
        if (x>25) x -= 26
        encrypted += lower(x)
    }
    encrypted
  }
  def decrypt(msg: String): String = {
    var decrypted: String = ""
    for(ch <- msg){
      var x = (lower.indexOf(ch))
      x = (x-shift) % 26
      if (x<0) x += 26
      decrypted += lower(x)
    }
    decrypted
  }
  def log(msg: String) = {
    println(encrypt(msg))
  }
}

//Ex 5. working on it
import java.beans.{PropertyChangeListener, PropertyChangeEvent, PropertyChangeSupport}
trait PropertyChangeSupportLike  {
  val javaSupportObj = new PropertyChangeSupport

  def addPropertyChangeListener(listener: PropertyChangeListener): Unit ={
    javaSupportObj.addPropertyChangeListener(listener)
  }
  def addPropertyChangeListener(name: String, listener: PropertyChangeListener): Unit = {
    javaSupportObj.addPropertyChangeListener(name, listener)
  }
  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean): Unit = {
    javaSupportObj.fireIndexedPropertyChange(propertyName,index,oldValue,newValue)
  }
  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int): Unit = {
    javaSupportObj.fireIndexedPropertyChange(propertyName,index,oldValue,newValue)
  }
  def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Object, newValue: Object): Unit = {
    javaSupportObj.fireIndexedPropertyChange(propertyName,index,oldValue,newValue)
  }
  def firePropertyChange(event: PropertyChangeEvent): Unit ={
    javaSupportObj.firePropertyChange(event)
  }
  def firePropertyChange(name: String, oldValue: Boolean, newValue: Boolean): Unit ={
    javaSupportObj.firePropertyChange(name, oldValue, newValue)
  }
  def firePropertyChange(name: String, oldValue: Object, newValue: Object): Unit ={
    javaSupportObj.firePropertyChange(name, oldValue, newValue)
  }
  def getPropertyChangeListeners(): Array[PropertyChangeListener]  = {
    javaSupportObj.getPropertyChangeListeners
  }
  def getPropertyChangeListeners(name: String): Array[PropertyChangeListener]  = {
    javaSupportObj.getPropertyChangeListeners(name)
  }
  def hasListeners(name: String): Boolean = {
    javaSupportObj.hasListeners(name)
  }
  def removePropertyChangeListener(listener: PropertyChangeListener): Unit = {
    javaSupportObj.removePropertyChangeListener(listener)
  }
  def removePropertyChangeListener(name: String, listener: PropertyChangeListener): Unit = {
    javaSupportObj.removePropertyChangeListener(name, listener)
  }
}
//Ex. 8
import java.io.{BufferedInputStream, InputStream}
trait BufferedInputStreamLike {
  val inputStream: InputStream
  val bufferHelperObj = new BufferedInputStream(inputStream)

  def available(): Int = {
    bufferHelperObj.available
  }
  def close(): Unit = {
    bufferHelperObj.close()
  }
  def mark(readLimit: Int): Unit ={
    bufferHelperObj.mark(readLimit)
  }
  def markSupported(): Boolean ={
   bufferHelperObj.markSupported
  }
  def read(b: Array[Byte], off: Int, len: Int): Unit ={
    bufferHelperObj.read(b,off,len)
  }
  def reset(): Unit ={
    bufferHelperObj.reset()
  }
}
