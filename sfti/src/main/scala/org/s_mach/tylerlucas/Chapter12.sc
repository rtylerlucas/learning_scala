//High Order Functions
/*
Functions are "first class citizens"

You can create annonymous functions, usually to give them to other funcs.

A func. argument specifies behavior that should be specified later.

Many collection methods take func. parameters, applying a func. to
all values of collection.

There are syntax shortcuts to express function parameters short & easy.

You can create functions that operate on blocks of code and look much
like built-in control statements.
 */

//Closure Example
def mulBy(factor: Double) = (x: Double) => factor * x
val triple = mulBy(3)
val half = mulBy(.5)
println(triple(5) + " " + half(5))
//notice how triple and half store their own 'factor'

//Ex. 1 Write func that yields a collection of func. inputs and
//outputs in given range. Ex. values(x => x * x, -5, 5) produces
//(-5, 25), (-4, 16), (-3, 9), ... (5,25)
def values(func: (Int) => Int, low: Int, high: Int) = {
  for(c <- low to high) yield (c, func(c))
}
values(x => x * x, -5, 5)
//Ex. 2 How to get largest elm of array using reduceLeft?
val arrMax = Array(3,4,6,11,4).reduceLeft(_ max _)
//Ex. 3 Implement factorial function using to and reduceLeft,
//without loop or recursion.
def factorial(x: Int) = {
  if(x<0){
    (-1 to x by -1).reduceLeft(_ * _)
  }
  else (1 to x).reduceLeft(_ * _)
}
factorial(5)
5*4*3*2*1
factorial(-5)
//Ex. 4 foldLeft factorial implementation
//not sure on this one for negative : \
def facFoldLeft(x: Int) = {
  (1 to x).foldLeft(1)(_ * _)
}
facFoldLeft(5)
//Ex. 5 func that yields the largest of a func with given seqs. of input
//no loop or recursion
//Example: largest(x => 10 * x- x * x, 1 to 10) should return 25
def largest(fun: (Int) => Int, inputs: Seq[Int]) ={
  inputs.map(fun(_)).max
}

largest(x => 10 * x- x * x, 1 to 10)
//Ex. 6 Modify #5 to return input value
def largestInput(fun: (Int) => Int, inputs: Seq[Int]) ={
  inputs(inputs.map(fun(_)).indexOf(largest(fun, inputs)))
}
largestInput(x => 10 * x- x * x, 1 to 10)
//Ex. 7 High Order! Returning a function that applies to pairs
val pairs = (1 to 10) zip (11 to 20)
val t = (6 , 7)
def adjustToPair(fun: (Int, Int) => Int) = (t: (Int,Int)) => {
  fun(t._1, t._2)
}

adjustToPair(_*_)(6,7)
pairs.map(adjustToPair(_+_))
//Ex. 8 Currying
val a = Array("lngth6","length7","ln3")
val b = Array(6,7,3)
a.corresponds(b)(_.length == _)
//Ex. 9
//Currying allows for more flexibility by
//returning a high order function

//Ex. 10 Control abstraction for 'if' inverted
//Does infact use currying, curries the block to execute
def unless(condition: => Boolean)(block: => Unit): Unit ={
  if(!condition){
    block
  }
}

unless(false == true){
  println("keep running")
}

