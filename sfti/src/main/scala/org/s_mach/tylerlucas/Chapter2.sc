import org.s_mach.tylerlucas.Chapter2
import math.sqrt
/*
Chapter 2 Practice
 */


val x, y = 5
val x0, y0 = 0
val distance = {
  val dx = x - x0
  val dy = y - y0
  sqrt(dx*dx + dy*dy)
}
var z = 0
for(j <- 1 to 5) {
  z += j
}
println(z)
for (i <- 1 to 3; j <- 1 to 3 if i != j){print(i+""+j+" ")}
def abs(x: Double) = {
  if (x >= 0) x else -x
}
def fac(n: Int) = {
  var r = 1
  for(i <- 1 to n) r = r * i
  r
}
def sum(args: Int*) = {
  var res = 0
  for(arg <- args) res += arg
  res
}

/*
Chapter 2 Exercises
 */
//1. Signum
Chapter2.signum(-43)
Chapter2.signum(100)
Chapter2.signum(0)
fac(5)
sum(3,3,3,3)
abs(-5)
//2. empty block exp is type Unit with value ()
//3.when in scala is x = y = 1 valid?
var d: Unit = Unit
var f = 0
d = f = 1
println(d + " " + f)
//4.
for(i<-10 to 0 by -1){
  println(i)
}

//5.
def countdown(n: Int)= {
  val count = if(n >= 0) -1 else 1
  for(i <- n to 0 by count) println(i)
}
countdown(-5)
//6. & 8 //same thing basically
def product(str: String) = {
  var product = 1L
  for(ch<-str) product = product * ch.toLong
  product
}
product("Hello")
//7. Foldleft is this awesome function that can simplify sequential
//calculations on collections. In this example, it runs through each
//value in 'Hello' and multiplies the uni vals.
"Hello".foldLeft(1L) (_*_)
 //9. recursive version
 def productRec(str: String): Long = {
   if(str=="") 1L
   else
     str.head.toInt * productRec(str.drop(1))
 }
productRec("Hello")
//10. compute x^n where n is integer using given recursive func.
def powerFunc(x: Double, n: Int): Double = {
  if(n==0) 1
  else{
    if(n>0){
      if(n%2==0 & n > 2){
        //even & pos
        powerFunc(powerFunc(x, n / 2), 2)
      }
      else {
        //odd & positive
        x * powerFunc(x,n-1)
      }
    }
    else{ //negative
       1 / powerFunc(x,-n)
    }
  }
}

powerFunc(1,2)