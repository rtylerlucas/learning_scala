import org.s_mach.tylerlucas.Chapter1
import BigInt._
import util.Random
//REPL Exercises Tyler Lucas
println("hey world")
val a = 1+2
2+3
val text = Chapter1.question1()
val answer = 42
var counter = 0
counter += 1
counter+= 3
println (counter)
val hello = "Hello"
val res = hello.distinct
println(res)
hello(4)
/*
Chapter 1 Exercises
 */
//1. What methods can be applied to a typed 3?
//A: type converters (toDouble, toChar, etc),
// arithmetic ops, bit ops

//2. sqrt(3) then squaring res gives a value very close to 3,
// 2.9999999999999996

//3. res variables in REPL are of type val, *not* var

//4. Multiplying strings by int x repeats the string x times

//5. 10 max 2 returns the max between the two vals
//max is part of the math pkg

//6. BigInt(2).pow(1024)

//7. import BigInt._ and util.Random to process:
probablePrime(100, Random)

//8. produce rand BigInt and convert to base 36:
probablePrime(100, Random).toString(36)

//9.
"hello"(0)
//gives first char or "hello".take(1) using the apply method
"hello".takeRight(1)
//gives last char

//10. take, drop, takeRight, dropRight return n values of list object
//ex:
val list = Array(1,2,3,4)
list.take(2) //returns first 2 in list
list.drop(2)
list.takeRight(2)
list.dropRight(2)