/*
 * Chapter 4 SFTI Practice [ Tyler Lucas ]
 */

val scores = Map("Tyler" -> 10, "Justin" -> 9)  //immutable
val dynamicScores = scala.collection.mutable.Map("Tyler" -> 11, "Justin" -> 4)
scores("Tyler")
dynamicScores("Tyler") = 100
val newScores = scores + ("Tucker" -> 7, "Jane" -> 8) //build new map from immutable map
def reset(map: Map[String, Int]) = {
  for ((k, v) <- map) yield {
    (k, 0)
  }
}
reset(scores)

//T u p l e s

val t = (1, 3.14, "Ty") //components of tuples start at 1, not zero
val valAtT2 = t._2   //3.14
//Usually better to use pattern matching
val (first, second, third) = t
val (firstZ, secondZ, _) = t //use _ to ignore sections of tuple in ptrn match
//tuples useful for funcs with more than one return val. ex :
"New York".partition(_.isUpper)
//Z i p p i n g
val symbols = Array("^", "_", "^")
val counts = Array(1,4,1)
val pairs = symbols.zip(counts)
for ((s,c) <- pairs) print(s*c)

