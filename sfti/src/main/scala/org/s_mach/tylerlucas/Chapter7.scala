package org.s_mach.tylerlucas

/**
 * Created by RTylerLucas on 1/9/15.
 */
package com {
  package horstmann {
    package impatient {
        class Chapter7 {

        }
    }
  }
}
/* Ex. 1
 package com.horstmann.impatient
      !=
 package com
 package horstmann
 package impatient
 #1 would write to specific nested pkg,
 while #2 would write to all three, non-nested, individual
 pkgs
 */
// Ex. 3
package  random {

}
package object random {
  var previous: Int = 0
  val a = 1664525
  val b = 10139043223.0
  val n = 32
  def nextInt(): Int = {
    ( (previous * a + b) % Math.pow(2,n)).toInt
  }
  def nextDouble(): Double = {
    ( (previous * a + b) % Math.pow(2,n)).toDouble
  }
  def setSeed(seed: Int): Int = {
    previous = seed
    previous
  }
}
/* Ex. 4
Pkg objects allow for a more organized way to
place functions and variables that apply to entire pkg
 */

/* Ex. 5
private[com] def giveRaise(rate: Double) gives visibility of to com pkg
of the giveRaise function. Can be useful to allow nested funcs to be visible
in parent pkgs
 */
/* Ex. 8
import java._ and import javax._
imports all packages within both respected parents.
Not a good idea as namespaces can collide and it is unlikely all pkgs will be used.
 */