import org.s_mach.tylerlucas.Chapter9

import scala.io.Source
import org.s_mach.tylerlucas
//Chapter 9 Exercises

//Ex. 1 Reverse lines in file (used a cool poem with double meaning frwd vs. bckwrd)
val source = Source.fromFile("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E1.txt")
val lines: Array[String] = source.getLines.toArray
for(i<- lines.length-1 to 0 by -1)
  println(lines(i))
source.close
//Ex 2.
val chp9 = Chapter9
chp9.replaceTabs("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E2.txt")

//Ex. 3
val s3 = Source.fromFile("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E1.txt")
for(w<- s3.mkString.split("\\s+")) if(w.length > 6) println(w)
s3.close

//Ex. 4
val s4 = Source.fromFile("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E4.txt")
var sum: Double = 0
var avg: Double = 0
var count: Int = 0
var max: Double = 0
var min: Double = 0
for(w <- s4.mkString.split("\\n+")) {
  sum+= w.toDouble
  count += 1
  max = Math.max(max, w.toDouble)
  min = Math.min(min, w.toDouble)
}
println("Sum: " + sum)
println("Avg: " + (sum/count))
println("Max: " + max)
println("Min: " + min)

s4.close