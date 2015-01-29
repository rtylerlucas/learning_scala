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
def values(func: (Int) => Int, low: Int, high: Int){

}

//Ex. 2 How to get largest elm of array using reduceLeft?


//Ex. 3 Implement factorial function using to and reduceLeft,
//without loop or recursion.