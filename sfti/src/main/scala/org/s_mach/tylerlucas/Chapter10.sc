import java.awt.geom.Ellipse2D.Double

import org.s_mach.tylerlucas._

//Ex. 1 Testing
val egg = new Double(5,10,20,30) with RectangleLike
egg.getFrame
egg.translate(5,5)
egg.getX
egg.getY

//Ex. 2 Testing
val orderedPt = new OrderedPoint
//val oPt2 = new OrderedPoint(5,5)
//orderedPt.compare(oPt2)


//Ex. 4
val ex4 = new Chapter10 with CryptoLogger
ex4.encrypt("tyler")

//Ex. 5
//val pt = new java.awt.Point with PropertyChangeSupport
