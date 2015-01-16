package org.s_mach.tylerlucas

import java.io.{PrintWriter, File}

import scala.io.Source
/**
 * Created by RTylerLucas on 1/15/15.
 */
object Chapter9 {
  //Ex. 2
  def replaceTabs(filename: String): Unit ={
    val source = Source.fromFile(filename)
    val content: Array[String] = source.mkString.split("\\t+")
    val output = new PrintWriter(filename)
    for(item <- content) output.println(item + " ")
    output.close
    source.close
  }
  //Ex. 4
  def numAttributes(filename: String): Unit = {
    val s4 = Source.fromFile(filename)
    var sum: Double = 0
    var avg: Double = 0
    var count: Int = 0
    var max: Double = 0
    var min: Double = 0
    for(w <- s4.mkString.split("\\s+")) {
      if(w.nonEmpty) {
        sum += w.toDouble
        count += 1
        max = Math.max(max, w.toDouble)
        min = Math.min(min, w.toDouble)
      }
    }
    println("Sum: " + sum)
    println("Avg: " + (sum/count))
    println("Max: " + max)
    println("Min: " + min)
    s4.close
  }
  //Ex. 5
  def powersOfTwo(filename: String): Unit ={
    val out = new PrintWriter(filename)
    for(i <- 0 to 20) out.println("%8.0f    %f".format(Math.pow(2,i), Math.pow(2,-i)))
    out.flush
    out.close
  }

  //Ex. 6
  def findQuotes(filename: String): Unit ={
    val source = Source.fromFile(filename)
    val content: Array[String] = source.mkString.split("\"")
    for(w <- content) println(w)
  }
}
