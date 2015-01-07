/*
 * Chapter 4 SFTI Practice [ Tyler Lucas ]
 */

import java.io.File
import java.util.Scanner
import scala.collection.JavaConversions.mapAsScalaMap


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

/*
 * Chp. 4 Exercises
 */
//1. Map of prices for # gizmos I covet. Next, produce second map with
//same keys but prices at 10% discount
val covetedGizmos = Map("Piano" -> 500, "German Shepherd" -> 400, "Groceries" -> 100)
val discountGizmos = for((gizmo, price) <- covetedGizmos) yield (gizmo -> price*.9)

//2. Read from file. map words to word count
val words = collection.mutable.Map[String, Int]()
val textFile = new File("/Users/RTylerLucas/learning_scala/sfti/src/main/scala/org.s_mach.tylerlucas/C4E2.txt")
val input = new Scanner(textFile)

while(input.hasNext()) {
  val key = input.next()
  val value = words.getOrElse(key,0)
  words(key) = value + 1
}
input.close()
print(words.toString())
//3. Preceding exercise with immutable map
var hardWords = Map[String, Int]()
val newInput = new Scanner(textFile)
while(newInput.hasNext()) {
  val key = newInput.next()
  hardWords = hardWords + (key -> (hardWords.getOrElse(key,0) + 1))
}
newInput.close()
print("Immutable: " + hardWords.toString())
//4. Preceding exercise with sorted map
var sortedWords = collection.immutable.SortedMap[String, Int]()
val sInput = new Scanner(textFile)

while(sInput.hasNext()) {
  val key = sInput.next()
  sortedWords = sortedWords + (key -> (sortedWords.getOrElse(key,0) + 1))
}
sInput.close()
print("sorted: " + sortedWords.toString())
//5. adapt java tree map to mutable scala map
var treeWords: collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
val treeInput = new Scanner(textFile)

while(treeInput.hasNext()) {
  val key = treeInput.next()
  treeWords = treeWords + (key -> (treeWords.getOrElse(key,0) + 1))
}
treeInput.close()
print("Tree: " + hardWords.toString())
//6. Create linked hashmap for days of week. demonstrate insertion order
val days = collection.mutable.LinkedHashMap(
  "Monday" -> java.util.Calendar.MONDAY,
  "Tuesday" -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thursday" -> java.util.Calendar.THURSDAY,
  "Friday" -> java.util.Calendar.FRIDAY,
  "Saturday" -> java.util.Calendar.SATURDAY,
  "Sunday" -> java.util.Calendar.SUNDAY)
for ((k, v) <- days) println(k)
//8. write a minMax func that returns pair of minMax
def minMax(arr: Array[Int]) = {
  (arr.max, arr.min)
}
minMax(Array(10,5,0,-100,3,7, 14))

//10. Give use case for "Hello".zip("World")?
"ABCD".zip("abcd")
