//Ex. 1 Function given string produces map
//of indices per character.
//Ex. indexes("Mississippi") has a map with 'M'set {0},
// 'i' set {1,4,7,10} and so on

import java.util
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
List('a','b','c').zipWithIndex

//Ex 2
def immutIndexes(string: String) = {
  val chars = Map.empty[Char, Set[Int]]
  string.zipWithIndex.foldLeft(chars){ case (acc,(c,i)) =>
//    val (c,i) = tuple
//    val c = tuple._1
//    val i = tuple._2
    if(acc.contains(c)){
      val currentSet = acc(c)
      acc + (c -> (currentSet + i))
    }
    else{
      val newSet = Set(i)
      acc + (c -> newSet)
    }
  }

}
immutIndexes("Mississippi")


//Ex. 3 Remove all 0s from LinkedList
def removeZeros(list: java.util.LinkedList[Int]): Unit = {
  val iterator = list.iterator

  while(iterator.hasNext){
    if(iterator.next == 0){
      iterator.remove()
    }
  }
}
val llist = new util.LinkedList[Int]()
llist.add(0)
llist.add(1)
llist.add(0)
llist
removeZeros(llist)
llist

List(0,1,0).filter(_ != 0)
import scala.collection.JavaConverters._
val llist2 = new util.LinkedList[Int]()
llist2.add(0)
llist2.add(1)
llist2.add(0)
llist2.asScala.filter(_ != 0) //returns new mutated list
llist2
//Ex. 4 write func that receives collection strings and map string <- Int
//return collection of ints that are values of map
// corresponding to string in collection
//Ex: Array("Tom", "Fred", "Harry") and Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
//return Array(3,5)
//use flatmap to combine Option values returned by get

List(List(1,2,3),List(4,5,6)).flatten
List(Vector(1,2,3),Vector(4,5,6)).flatten
List(Array(1,2,3),Array(4,5,6)).flatten
List(Some(1),Some(2),Some(3),None).flatten
List(1,2,3).flatMap { i=>
  if(i % 2 == 0) {
    Some(i)
  } else {
    None
  }
}
List(1,2,3).flatMap { i =>
  List.fill(i)(i) // List(1), List(2,2), List(3,3,3)
}

def mapVals(strArr: Array[String], map: Map[String, Int]) = {
  strArr.flatMap(map.get)
}
mapVals(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5))
//Ex. 5 Implement mkString using reduceLeft
def mkNewString[A](arr: Array[A]) = {
  val newArr = arr.map(_.toString)
  newArr.reduceLeft(_+_)
}
mkNewString(Array("hi","Lance"))
1 :: 2 :: 3 :: Nil
1 :: (2 :: (3 :: Nil))
val lst = List(1,2,3)

//Ex. 6 given list of ints lst, what is
// (lst :\ List[Int]())(_ :: _)? (List[Int]() /: lst)(_ :+ _)?
val lstRev = lst.foldRight(List[Int]())(_ :: _)
val lstRev2 = lst.foldLeft(List[Int]())(_ :+ _)

//Ex. 7
//expression (prices zip quantities) map{p => p._1 * p._2} is a bit inelegant
//can't do (prices zip quantities) map {_ * _} bc _ * _ is a func with two args,
//and we ned func with one arg that is a tuple.
//the tupled method of Function obj changes func with two args to one that accepts tuple
//Apply tupled to func so you can map it over list of pairs

val prices = Array(5,10,15)
val qty = Array(1,2,3)

val a:Array[(Int,Int)] = prices.zip(qty)
a.map { p => p._1 * p._2 }
val f = { p:(Int,Int) => p._1 * p._2 }
val f2 : (Int,Int) => Int = { (i1:Int,i2:Int) => i1 * i2 }
val f3 : ((Int,Int)) => Int = f2.tupled
a.map(f3)
(prices zip qty) map { (i1:Int,i2:Int) => i1*i2}.tupled

//Ex. 8 Write func that turns array of Double vals into 2D Array
//Pass num of columns as param.
//Ex. Array(1,2,3,4,5,6) and three cols, return Array(Array(1,2,3),Array(4,5,6))
//use the grouped method
def twoDim[A](arr: Iterable[A], col: Int) ={
  arr.grouped(col).toArray
}
val a1 = Array(1,2,3,4,5,6)
twoDim(a1, 3)

//val mathhw = Array(88.5, 98.8, 94.7, 88.3, 84.3, 90.4, 90.1, 91.2, 89.0, 90.6, 89.8, 92.2, 91.6, 87.7, 90.3, 91.1, 90.0, 86.7, 91.5, 93.4, 89.9, 96.1,
//89.6, 92.2, 90.4, 83.4, 91.6, 91.0, 90.7, 88.2, 88.6, 88.5, 88.3, 93.3, 94.2, 87.4, 85.3, 91.1, 90.1, 90.5, 89.3, 100.3, 91.1, 87.6, 92.7, 88.4, 87.9, 92.6, 93.0, 93.7, 94.4, 96.5, 90.4, 84.3, 91.2, 93.2, 86.7, 88.6, 94.2, 88.7, 90.8, 92.7, 90.1, 89.3, 91.8, 91.0, 87.5, 90.9, 87.8, 89.9, 88.3, 91.8, 89.2, 89.7, 92.3, 92.2, 88.9, 89.8, 92.7, 93.3, 86.7, 91.0)
//val sortedhw = mathhw.sorted
//sortedhw.length
//val top = sortedhw.slice(0,30)
//val md = sortedhw.slice(30,55)
//val btm = sortedhw.slice(55,82)
//for(x<-top)println(x)
//for(y<-md)println(y)
//for(y<-btm)println(y)

//Ex. 9
//concurrently mutating the collection is not safe and
//can lead to errors in code. It is suggested to use java.util.concurrent collections
//instead.





