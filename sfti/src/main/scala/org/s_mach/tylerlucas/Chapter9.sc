import java.io.PrintWriter

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
chp9.numAttributes("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E4.txt")
//Ex. 5
chp9.powersOfTwo("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E5.txt")
//Ex. 6
val s6 = Source.fromFile("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E6.txt")
val content = s6.mkString
print(content)
val pattern = """\s"[a-z\s]+"\s+""".r
val res = pattern.findAllIn(content).toArray
s6.close
//Ex. 7 (not quite done)
//val s7 = Source.fromFile("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org/s_mach/tylerlucas/C9E4.txt")
//val floatPattern = "[0-9]+\\.[0-9]+".r
//print(floatPattern.findAllIn(s7.mkString.split("\\n").toString).toString())
//s7.close
