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
}
