/*
 * Chapter 3 Practice [Tyler Lucas]
 */
import scala.collection.mutable.ArrayBuffer
import util.Random

val nums = new Array[Int](10)
nums(5) = 11
nums
val b = ArrayBuffer[Int]()
b += 50
b += (1,2,30,50)
b.trimEnd(2) //remove last 2
b
b.insert(2,11) //insert at index 2 val 11
b
b.remove(1) //remove val at index 1
b
b.remove(1,2)  // removes 2 starting from index 1
b
10.until(0,-1)
val a = Array(2,3,4,7,12)
val res = for( elm <- a if elm % 2 == 0 ) yield 2 * elm
//the more functional route ::
a.filter(_ % 2 == 0).map(2 * _)
a.min; a.max
a.sorted

/*
Chapter 3 Exercises
 */
//1.
def randomArray(n: Int) = {
  val a = new Array[Int](n)
  for(elm <- a) yield Random.nextInt(n)
}
val w = randomArray(30)
//2. swap adjacent elms of array
def swapAdj(a: Array[Int]) = {
  for (i <- 0 until (a.length - 1) by 2) {
    val first = a(i)
    a(i) = a(i + 1)
    a(i + 1) = first
  }
}
swapAdj(a)
a

//3. same problem as 2, this time yield new array

def newAdj(a: Array[Int]) = {
  for (i <- 0 until a.length) yield {
    if(i % 2 == 0 && a(i) != a.last) a(i+1)
    else
      if(a.last==a(i) && i % 2 == 0) a(i)
      else a(i-1)
  }
}
val c = newAdj(Array(3,2,7,4,12,14))
//4. array of ints, return new arr with all pos vals, then 0 vals, then negs,
//in original order

def posNegArray(arr: Array[Int])= {

  val zeroIndices = new ArrayBuffer[Int]
  val negIndices = new ArrayBuffer[Int]
  val res = new ArrayBuffer[Int]
  for(i <- 0 until arr.length) {
    if(arr(i) > 0 ) res.append(arr(i))
    else
      if(arr(i) == 0) zeroIndices.append(i)
      else negIndices.append(i)
  }
  for(i <- zeroIndices) res.append((arr(i)))
  for(i <- negIndices) res.append((arr(i)))
  res
}
val newArr = posNegArray(Array[Int](-1,0,0,10,5,4,2,-3,-6,0,9,8))
//5. Compute avg of Array[Double]?
val doubArray = Array(1.0, 5.0, 6.3, 4.5)
val avg = doubArray.sum / doubArray.length
//6. reverse sort Array[Int]
a.sortWith(_ > _)
//7. remove dubs of array
a.distinct


