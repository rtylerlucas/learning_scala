//Ex. 1 Function given string produces map
//of indices per character.
//Ex. indexes("Mississippi") has a map with 'M'set {0},
// 'i' set {1,4,7,10} and so on

import java.util.TreeSet
def indexes(string: String) = {
  val chars = new scala.collection.mutable.LinkedHashMap[Char, TreeSet[Int]]()
  for(c<-0 until string.length) {
    if (!chars.contains(string(c))) {
      chars.put(string(c), new TreeSet[Int])
    }
    chars.get(string(c)) match  {
      case Some(treeSet) => treeSet.add(c)
      case None => println("no tree set found")
    }
  }
  chars
}
val test = indexes("Mississippi")

